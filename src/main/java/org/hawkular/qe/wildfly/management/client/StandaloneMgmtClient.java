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
package org.hawkular.qe.wildfly.management.client;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.hawkular.qe.wildfly.management.deployment.DeploymentExecutionStatus;
import org.hawkular.qe.wildfly.management.deployment.StandaloneDeploymentAction;
import org.hawkular.qe.wildfly.management.deployment.Utils.Action;
import org.hawkular.qe.wildfly.management.model.Deployment;
import org.hawkular.qe.wildfly.management.subsystem.Datasources;

/**
 * @author jkandasa@redhat.com (Jeeva Kandasamy)
 */
public class StandaloneMgmtClient extends ClientCommon {
    public StandaloneMgmtClient(String host, int port, String userid, String password) throws UnknownHostException {
        super(host, port, userid, password, MANAGEMENT_REALM);
    }

    public StandaloneMgmtClient(String host, int port, String userid, String password, String Realm)
            throws UnknownHostException {
        super(host, port, userid, password, Realm);
    }

    //Operations

    //Get Deployments List
    public List<Deployment> getDeployments() {
        return new Deployment().getDeployments(getModelControllerClient());
    }

    //Get Deployment
    public Deployment getDeployment(String name) {
        return new Deployment(getModelControllerClient(), name);
    }

    //Get Datasources object
    public Datasources getDatasources() {
        return new Datasources(getModelControllerClient());
    }

    public DeploymentExecutionStatus deploy(File file) throws IOException, InterruptedException, ExecutionException {
        StandaloneDeploymentAction deploymentAction = new StandaloneDeploymentAction(getModelControllerClient(),
                Action.DEPLOY, file);
        return deploymentAction.execute();
    }

    public DeploymentExecutionStatus deploy(URL url) throws IOException, InterruptedException, ExecutionException {
        StandaloneDeploymentAction deploymentAction = new StandaloneDeploymentAction(getModelControllerClient(),
                Action.DEPLOY, url);
        return deploymentAction.execute();
    }

    public DeploymentExecutionStatus add(File file) throws IOException, InterruptedException, ExecutionException {
        StandaloneDeploymentAction deploymentAction = new StandaloneDeploymentAction(getModelControllerClient(),
                Action.ADD, file);
        return deploymentAction.execute();
    }

    public DeploymentExecutionStatus add(URL url) throws IOException, InterruptedException, ExecutionException {
        StandaloneDeploymentAction deploymentAction = new StandaloneDeploymentAction(getModelControllerClient(),
                Action.ADD, url);
        return deploymentAction.execute();
    }

    public DeploymentExecutionStatus undeploy(String archiveName) throws IOException, InterruptedException,
            ExecutionException {
        StandaloneDeploymentAction deploymentAction = new StandaloneDeploymentAction(getModelControllerClient(),
                Action.UNDEPLOY, archiveName);
        return deploymentAction.execute();
    }

    public DeploymentExecutionStatus disable(String archiveName) throws IOException, InterruptedException,
            ExecutionException {
        StandaloneDeploymentAction deploymentAction = new StandaloneDeploymentAction(getModelControllerClient(),
                Action.DISABLE, archiveName);
        return deploymentAction.execute();
    }

    public DeploymentExecutionStatus enable(String archiveName) throws IOException, InterruptedException,
            ExecutionException {
        StandaloneDeploymentAction deploymentAction = new StandaloneDeploymentAction(getModelControllerClient(),
                Action.ENABLE, archiveName);
        return deploymentAction.execute();
    }

    public DeploymentExecutionStatus remove(String archiveName) throws IOException, InterruptedException,
            ExecutionException {
        StandaloneDeploymentAction deploymentAction = new StandaloneDeploymentAction(getModelControllerClient(),
                Action.REMOVE, archiveName);
        return deploymentAction.execute();
    }

}
