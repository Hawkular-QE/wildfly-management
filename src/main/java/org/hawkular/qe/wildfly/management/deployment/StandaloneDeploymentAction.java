/*
 * Copyright 2015 Red Hat, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.hawkular.qe.wildfly.management.deployment;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.hawkular.qe.wildfly.management.deployment.Utils.Action;
import org.hawkular.qe.wildfly.management.deployment.Utils.Status;
import org.jboss.as.controller.client.ModelControllerClient;
import org.jboss.as.controller.client.helpers.standalone.DeploymentAction;
import org.jboss.as.controller.client.helpers.standalone.DeploymentPlan;
import org.jboss.as.controller.client.helpers.standalone.DeploymentPlanBuilder;
import org.jboss.as.controller.client.helpers.standalone.ServerDeploymentActionResult;
import org.jboss.as.controller.client.helpers.standalone.ServerDeploymentManager;
import org.jboss.as.controller.client.helpers.standalone.ServerDeploymentPlanResult;

/**
 * @author jkandasa@redhat.com (Jeeva Kandasamy)
 */
public class StandaloneDeploymentAction extends DeploymentActionCommon {

    public StandaloneDeploymentAction(ModelControllerClient modelControllerClient, Action action, File file) {
        super(modelControllerClient, action, file);
    }

    public StandaloneDeploymentAction(ModelControllerClient modelControllerClient, Action action, URL url) {
        super(modelControllerClient, action, url);
    }

    public StandaloneDeploymentAction(ModelControllerClient modelControllerClient, Action action, String archiveName) {
        super(modelControllerClient, action, archiveName);
    }

    public DeploymentExecutionStatus execute() throws IOException, InterruptedException, ExecutionException {
        ServerDeploymentManager manager = ServerDeploymentManager.Factory.create(getModelControllerClient());
        DeploymentPlanBuilder builder = manager.newDeploymentPlan();
        DeploymentPlan plan = null;
        _logger.debug("Archive Name:{}, Requested Action:{}", getArchiveName(), getAction().toString());

        switch (getAction()) {
            case DEPLOY:
                if (getUrl() != null) {
                    plan = builder.add(getUrl()).deploy(getArchiveName()).build();
                } else {
                    plan = builder.add(getFile()).deploy(getArchiveName()).build();
                }
                break;
            case DISABLE:
            case UNDEPLOY:
                plan = builder.undeploy(getArchiveName()).build();
                break;
            case ENABLE:
                plan = builder.deploy(getArchiveName()).build();
                break;
            case REDEPLOY:
                if (getUrl() != null) {
                    plan = builder.add(getUrl()).redeploy(getArchiveName()).build();
                } else {
                    plan = builder.add(getFile()).redeploy(getArchiveName()).build();
                }
                break;
            case REMOVE:
                plan = builder.remove(getArchiveName()).build();
                break;
            case ADD:
                if (getUrl() != null) {
                    plan = builder.add(getUrl()).build();
                } else {
                    plan = builder.add(getFile()).build();
                }
                break;
            default:
                break;
        }

        Future<ServerDeploymentPlanResult> executionResult = manager.execute(plan);
        DeploymentExecutionStatus executionStatus = new DeploymentExecutionStatus();
        for (DeploymentAction deploymentAction : plan.getDeploymentActions()) {
            System.out.println("Deployment: " + deploymentAction.getId());
            ServerDeploymentActionResult result = executionResult.get().getDeploymentActionResult(
                    deploymentAction.getId());
            System.out.println("Result: " + result.getResult());
            System.out.println("RollBackResult: " + result.getDeploymentException());
            System.out.println("Type: " + deploymentAction.getType());
            _logger.debug("DeploymentAction UUID:{}, Type:{}, Result:{}, UpdateActionId:{}, Error:{}",
                    deploymentAction.getId(), deploymentAction.getType(), result.getResult(),
                    result.getUpdateActionId(),
                    result.getDeploymentException() != null ? result.getDeploymentException().getMessage() : null);

            switch (result.getResult()) {
                case NOT_EXECUTED:
                    if (executionStatus.getStatus() == null) {
                        executionStatus.setStatus(Status.NOT_EXECUTED);
                    }
                    break;
                case FAILED:
                    executionStatus.setStatus(Status.NOT_EXECUTED);
                    executionStatus.setUUID(plan.getId());
                    break;
                case ROLLED_BACK:
                    executionStatus.setStatus(Status.ROLLED_BACK);
                    executionStatus.setUUID(plan.getId());
                    break;
                case CONFIGURATION_MODIFIED_REQUIRES_RESTART:
                    executionStatus.setStatus(Status.CONFIGURATION_MODIFIED_REQUIRES_RESTART);
                    executionStatus.setUUID(plan.getId());
                    break;
                case EXECUTED:
                    executionStatus.setStatus(Status.EXECUTED);
                    executionStatus.setUUID(plan.getId());
                    break;
                default:
                    executionStatus.setStatus(Status.UNKNOWN);
                    executionStatus.setUUID(plan.getId());
                    break;
            }
            if (executionStatus.getThrowable() == null) {
                executionStatus.setThrowable(result.getDeploymentException());
            }
            if (executionStatus.getUUID() == null) {
                executionStatus.setUUID(plan.getId());
            }
        }
        return executionStatus;
    }
}
