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
package org.hawkular.qe.wildfly.management.model;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.hawkular.qe.wildfly.management.client.StandaloneMgmtClient;
import org.jboss.as.controller.client.ModelControllerClient;
import org.jboss.as.controller.descriptions.ModelDescriptionConstants;
import org.jboss.dmr.ModelNode;

/**
 * @author jkandasa@redhat.com (Jeeva Kandasamy)
 */
public class ServerInfo {
    private String productVersion;
    private String launchType;
    private String name;
    private String runningMode;
    private String managementMajorVersion;
    private String namespaces;
    private String profileName;
    private String schemaLocations;
    private String managementMicroVersion;
    private String processType;
    private String releaseCodename;
    private String serverState;
    private String managementMinorVersion;
    private String productName;
    private String releaseVersion;
    private String suspendState;

    public ServerInfo() {

    }

    public ServerInfo(ModelControllerClient modelControllerClient) {
        ModelNode op = new ModelNode();
        op.get(ModelDescriptionConstants.OP).set(ModelDescriptionConstants.READ_RESOURCE_OPERATION);
        ModelNode result = StandaloneMgmtClient.execute(modelControllerClient, op);
        result = result.get(ModelDescriptionConstants.RESULT);

        this.setManagementMajorVersion(ModelUtils.getValue(result, ModelDescriptionConstants.MANAGEMENT_MAJOR_VERSION));
        this.setManagementMicroVersion(ModelUtils.getValue(result, ModelDescriptionConstants.MANAGEMENT_MICRO_VERSION));
        this.setManagementMinorVersion(ModelUtils.getValue(result, ModelDescriptionConstants.MANAGEMENT_MINOR_VERSION));
        this.setName(ModelUtils.getValue(result, ModelDescriptionConstants.NAME));
        this.setNamespaces(ModelUtils.getValue(result, ModelDescriptionConstants.NAMESPACES));
        this.setProductName(ModelUtils.getValue(result, ModelDescriptionConstants.PRODUCT_NAME));
        this.setProductVersion(ModelUtils.getValue(result, ModelDescriptionConstants.PRODUCT_VERSION));
        this.setProfileName(ModelUtils.getValue(result, ModelDescriptionConstants.PROFILE_NAME));
        this.setReleaseCodename(ModelUtils.getValue(result, ModelDescriptionConstants.RELEASE_CODENAME));
        this.setReleaseVersion(ModelUtils.getValue(result, ModelDescriptionConstants.RELEASE_VERSION));
        this.setSchemaLocations(ModelUtils.getValue(result, ModelDescriptionConstants.SCHEMA_LOCATIONS));

        this.setLaunchType(ModelUtils.getValue(modelControllerClient, "launch-type"));
        this.setRunningMode(ModelUtils.getValue(modelControllerClient, ModelDescriptionConstants.RUNNING_MODE));
        this.setServerState(ModelUtils.getValue(modelControllerClient, "server-state"));
        this.setProcessType(ModelUtils.getValue(modelControllerClient, ModelDescriptionConstants.PROCESS_TYPE));
        this.setSuspendState(ModelUtils.getValue(modelControllerClient, ModelDescriptionConstants.SUSPEND_STATE));

    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public String getProductVersion() {
        return productVersion;
    }

    public void setProductVersion(String productVersion) {
        this.productVersion = productVersion;
    }

    public String getLaunchType() {
        return launchType;
    }

    public void setLaunchType(String launchType) {
        this.launchType = launchType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRunningMode() {
        return runningMode;
    }

    public void setRunningMode(String runningMode) {
        this.runningMode = runningMode;
    }

    public String getManagementMajorVersion() {
        return managementMajorVersion;
    }

    public void setManagementMajorVersion(String managementMajorVersion) {
        this.managementMajorVersion = managementMajorVersion;
    }

    public String getNamespaces() {
        return namespaces;
    }

    public void setNamespaces(String namespaces) {
        this.namespaces = namespaces;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getSchemaLocations() {
        return schemaLocations;
    }

    public void setSchemaLocations(String schemaLocations) {
        this.schemaLocations = schemaLocations;
    }

    public String getManagementMicroVersion() {
        return managementMicroVersion;
    }

    public void setManagementMicroVersion(String managementMicroVersion) {
        this.managementMicroVersion = managementMicroVersion;
    }

    public String getProcessType() {
        return processType;
    }

    public void setProcessType(String processType) {
        this.processType = processType;
    }

    public String getReleaseCodename() {
        return releaseCodename;
    }

    public void setReleaseCodename(String releaseCodename) {
        this.releaseCodename = releaseCodename;
    }

    public String getServerState() {
        return serverState;
    }

    public void setServerState(String serverState) {
        this.serverState = serverState;
    }

    public String getManagementMinorVersion() {
        return managementMinorVersion;
    }

    public void setManagementMinorVersion(String managementMinorVersion) {
        this.managementMinorVersion = managementMinorVersion;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getReleaseVersion() {
        return releaseVersion;
    }

    public void setReleaseVersion(String releaseVersion) {
        this.releaseVersion = releaseVersion;
    }

    public String getSuspendState() {
        return suspendState;
    }

    public void setSuspendState(String suspendState) {
        this.suspendState = suspendState;
    }

}
