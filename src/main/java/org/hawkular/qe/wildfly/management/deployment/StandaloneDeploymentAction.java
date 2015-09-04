package org.hawkular.qe.wildfly.management.deployment;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.apache.commons.io.FilenameUtils;
import org.hawkular.qe.wildfly.management.deployment.Utils.Action;
import org.hawkular.qe.wildfly.management.deployment.Utils.Status;
import org.jboss.as.controller.client.ModelControllerClient;
import org.jboss.as.controller.client.helpers.standalone.DeploymentAction;
import org.jboss.as.controller.client.helpers.standalone.DeploymentPlan;
import org.jboss.as.controller.client.helpers.standalone.DeploymentPlanBuilder;
import org.jboss.as.controller.client.helpers.standalone.ServerDeploymentActionResult;
import org.jboss.as.controller.client.helpers.standalone.ServerDeploymentManager;
import org.jboss.as.controller.client.helpers.standalone.ServerDeploymentPlanResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author jkandasa@redhat.com (Jeeva Kandasamy)
 */
public class StandaloneDeploymentAction {
    private static final Logger _logger = LoggerFactory.getLogger(StandaloneDeploymentAction.class.getName());

    private Action action;
    private ModelControllerClient modelControllerClient = null;
    private File file;
    private String archiveName;
    private URL url;

    public StandaloneDeploymentAction(ModelControllerClient modelControllerClient, Action action, File file) {
        this.modelControllerClient = modelControllerClient;
        this.action = action;
        this.file = file;
        this.archiveName = file.getName();
    }

    public StandaloneDeploymentAction(ModelControllerClient modelControllerClient, Action action, URL url) {
        this.modelControllerClient = modelControllerClient;
        this.action = action;
        this.url = url;
        this.archiveName = FilenameUtils.getName(url.toString());
    }

    public StandaloneDeploymentAction(ModelControllerClient modelControllerClient, Action action, String archiveName) {
        this.modelControllerClient = modelControllerClient;
        this.action = action;
        this.archiveName = archiveName;
    }

    public DeploymentExecutionStatus execute() throws IOException, InterruptedException, ExecutionException {
        ServerDeploymentManager manager = ServerDeploymentManager.Factory.create(modelControllerClient);
        DeploymentPlanBuilder builder = manager.newDeploymentPlan();
        DeploymentPlan plan = null;
        _logger.debug("Archive Name:{}, Requested Action:{}", this.archiveName, action.toString());

        switch (this.action) {
            case DEPLOY:
                if (this.url != null) {
                    plan = builder.add(this.url).deploy(this.archiveName).build();
                } else {
                    plan = builder.add(this.file).deploy(this.archiveName).build();
                }
                break;
            case DISABLE:
            case UNDEPLOY:
                plan = builder.undeploy(this.archiveName).build();
                break;
            case ENABLE:
                plan = builder.deploy(this.archiveName).build();
                break;
            case REDEPLOY:
                if (this.url != null) {
                    plan = builder.add(this.url).redeploy(this.archiveName).build();
                } else {
                    plan = builder.add(this.file).redeploy(this.archiveName).build();
                }
                break;
            case REMOVE:
                plan = builder.remove(this.archiveName).build();
            case ADD:
                if (this.url != null) {
                    plan = builder.add(this.url).build();
                } else {
                    plan = builder.add(this.file).build();
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
