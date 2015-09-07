package org.hawkular.qe.wildfly.management.client;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.hawkular.qe.wildfly.management.deployment.DeploymentExecutionStatus;
import org.hawkular.qe.wildfly.management.deployment.Utils.Action;
import org.hawkular.qe.wildfly.management.deployment.StandaloneDeploymentAction;
import org.hawkular.qe.wildfly.management.model.Deployment;

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