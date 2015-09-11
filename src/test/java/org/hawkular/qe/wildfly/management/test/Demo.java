package org.hawkular.qe.wildfly.management.test;

import java.io.File;
import java.net.UnknownHostException;
import java.util.List;

import org.hawkular.qe.wildfly.management.client.StandaloneMgmtClient;
import org.hawkular.qe.wildfly.management.deployment.DeploymentExecutionStatus;
import org.hawkular.qe.wildfly.management.model.Deployment;
import org.hawkular.qe.wildfly.management.model.ServerInfo;

/**
 * @author jkandasa@redhat.com (Jeeva Kandasamy)
 */
public class Demo {

    public static void main(String[] args) throws UnknownHostException {
        String host = "haw-src-auto.bc.jonqe.lab.eng.bos.redhat.com";
        int port = 9990;
        String userid = "jboss";
        String password = "Jboss@123";
        StandaloneMgmtClient standaloneMgmtClient = null;
        standaloneMgmtClient = new StandaloneMgmtClient(host, port, userid, password);

        //Display Server information
        //displayServerDetails(standaloneMgmtClient.getServerInfo());

        //Display Available deployments
        // displayDeploymentsName(standaloneMgmtClient.getDeployments());

        //Display example.war deployment details
        displayDeploymentDetails(standaloneMgmtClient, "example.war");
        /*
        //Deploy example.war application
        deployApplication(standaloneMgmtClient);

        //Display example.war deployment details
        displayDeploymentDetails(standaloneMgmtClient, "example.war");

        //Undeploy example.war application
        undeployApplication(standaloneMgmtClient);

        //Display example.war deployment details
        displayDeploymentDetails(standaloneMgmtClient, "example.war");

        //Enable example.war application
        enableApplication(standaloneMgmtClient);

        //Display example.war deployment details
        displayDeploymentDetails(standaloneMgmtClient, "example.war");

        //Remove Application
        removeApplication(standaloneMgmtClient);

        //Display example.war deployment details
        displayDeploymentDetails(standaloneMgmtClient, "example.war");
        */
        standaloneMgmtClient.close();
    }

    public static void displayDeploymentsName(List<Deployment> deployments) {
        System.out.println("=======================================================");
        System.out.println("Number of Deployments: " + deployments.size());
        int counter = 1;
        for (Deployment deployment : deployments) {
            System.out.println(counter + "  : " + deployment.getName());
            counter++;
        }
        System.out.println("=======================================================");
    }

    public static void displayDeploymentDetails(StandaloneMgmtClient standaloneMgmtClient, String applicationName) {
        try {
            System.out.println("=======================================================");
            Deployment deployment = standaloneMgmtClient.getDeployment("example.war");
            System.out.println("Name                : " + deployment.getName());
            System.out.println("Runtime Name        : " + deployment.getRuntimeName());
            System.out.println("Is Enabled?         : " + deployment.isEnabled());
            System.out.println("Enabled Timestamp   : " + deployment.getEnabledTimestamp());
            System.out.println("Enabled Time        : " + deployment.getEnabledTime());
            System.out.println("Content             : " + deployment.getContent());
            System.out.println("Owner               : " + deployment.getOwner());
            System.out.println("Subdeployment       : " + deployment.getSubdeployment());
            System.out.println("Persistent          : " + deployment.getPersistent());
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        System.out.println("=======================================================");
    }

    public static void displayServerDetails(ServerInfo serverInfo) {
        System.out.println("=======================================================");
        System.out.println("Name                    : " + serverInfo.getName());
        System.out.println("RunningMode             : " + serverInfo.getRunningMode());
        System.out.println("ReleaseVersion          : " + serverInfo.getReleaseVersion());
        System.out.println("ReleaseCodename         : " + serverInfo.getReleaseCodename());
        System.out.println("ProcessType             : " + serverInfo.getProcessType());
        System.out.println("ProductName             : " + serverInfo.getProductName());
        System.out.println("ProductVersion          : " + serverInfo.getProductVersion());
        System.out.println("ProfileName             : " + serverInfo.getProfileName());
        System.out.println("LaunchType              : " + serverInfo.getLaunchType());
        System.out.println("ManagementMajorVersion  : " + serverInfo.getManagementMajorVersion());
        System.out.println("ManagementMicroVersion  : " + serverInfo.getManagementMicroVersion());
        System.out.println("ManagementMinorVersion  : " + serverInfo.getManagementMinorVersion());
        System.out.println("Namespaces              : " + serverInfo.getNamespaces());
        System.out.println("SchemaLocations         : " + serverInfo.getSchemaLocations());
        System.out.println("ServerState             : " + serverInfo.getServerState());
        System.out.println("SuspendState            : " + serverInfo.getSuspendState());
        System.out.println("=======================================================");
    }

    public static void deployApplication(StandaloneMgmtClient standaloneMgmtClient) {
        System.out.println("=======================================================");
        System.out.println("Deploying Application...");
        DeploymentExecutionStatus status = null;
        try {
            status = standaloneMgmtClient.deploy(new File("/home/jkandasa/Documents/example.war"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (status != null) {
            System.out.println("Deployment status: " + status);
        }
        System.out.println("=======================================================");
    }

    public static void undeployApplication(StandaloneMgmtClient standaloneMgmtClient) {
        System.out.println("=======================================================");
        System.out.println("undeploying Application...");
        DeploymentExecutionStatus status = null;
        try {
            status = standaloneMgmtClient.undeploy("example.war");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (status != null) {
            System.out.println("Undeploy status: " + status);
        }
        System.out.println("=======================================================");
    }

    public static void enableApplication(StandaloneMgmtClient standaloneMgmtClient) {
        System.out.println("=======================================================");
        System.out.println("Enabling Application...");
        DeploymentExecutionStatus status = null;
        try {
            status = standaloneMgmtClient.enable("example.war");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (status != null) {
            System.out.println("Enable status: " + status);
        }
        System.out.println("=======================================================");
    }

    public static void removeApplication(StandaloneMgmtClient standaloneMgmtClient) {
        System.out.println("=======================================================");
        System.out.println("Remove Application...");
        DeploymentExecutionStatus status = null;
        try {
            status = standaloneMgmtClient.remove("example.war");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (status != null) {
            System.out.println("Remove status: " + status);
        }
        System.out.println("=======================================================");
    }
}
