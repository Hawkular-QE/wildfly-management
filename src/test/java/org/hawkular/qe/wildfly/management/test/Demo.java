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
package org.hawkular.qe.wildfly.management.test;

import java.io.File;
import java.net.UnknownHostException;
import java.util.List;

import org.hawkular.qe.wildfly.management.client.StandaloneMgmtClient;
import org.hawkular.qe.wildfly.management.deployment.DeploymentExecutionStatus;
import org.hawkular.qe.wildfly.management.model.Deployment;
import org.hawkular.qe.wildfly.management.model.ServerInfo;
import org.hawkular.qe.wildfly.management.subsystem.Datasources;

public class Demo {

    public static void main(String[] args) throws UnknownHostException {
        String host = "localhost";
        int port = 9990;
        String userid = "admin";
        String password = "admin";
        StandaloneMgmtClient standaloneMgmtClient = null;
        standaloneMgmtClient = new StandaloneMgmtClient(host, port, userid, password);

        //Get Datasources
        Datasources datasources = standaloneMgmtClient.getDatasources();

        //Display data-sources
        List<String> dataSourceList = datasources.getDataSourceList();
        displayStringList("Number of DataSource", dataSourceList);

        //Display Data Source
        for (String dataSourceName : dataSourceList) {
            displayString(datasources.getDataSource(dataSourceName).toString());
        }

        //Display xa-data-sources
        List<String> xaDataSourceList = datasources.getXaDataSourceList();
        displayStringList("Number of XA DataSource", xaDataSourceList);

        //Display XA Data Source
        for (String name : xaDataSourceList) {
            displayString(datasources.getXaDataSource(name).toString());
        }

        //JDBC Drivers
        List<String> jdbcDriverList = datasources.getJdbcDriverList();
        displayStringList("JDBC Drivers", jdbcDriverList);

        //Display Jdbc Drivers
        for (String name : jdbcDriverList) {
            displayString(datasources.getJdbcDriver(name).toString());
        }

        //Display Server information
        displayServerDetails(standaloneMgmtClient.getServerInfo());

        //Display Available deployments
        displayDeploymentsName(standaloneMgmtClient.getDeployments());

        //Display example.war deployment details
        displayDeploymentDetails(standaloneMgmtClient, "example.war");

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

    public static void displayStringList(String listName, List<String> stringList) {
        System.out.println("=======================================================");
        System.out.println(listName + ": " + stringList.size());
        int counter = 1;
        for (String string : stringList) {
            System.out.println(counter + "  : " + string);
            counter++;
        }
        System.out.println("=======================================================");
    }

    public static void displayString(String string) {
        System.out.println("=======================================================");
        System.out.println(string);
        System.out.println("=======================================================");
    }
}
