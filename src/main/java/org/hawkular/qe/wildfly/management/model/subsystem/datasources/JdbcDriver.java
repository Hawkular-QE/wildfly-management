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
package org.hawkular.qe.wildfly.management.model.subsystem.datasources;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author jkandasa@redhat.com (Jeeva Kandasamy)
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class JdbcDriver {

    @JsonProperty("deployment-name")
    private String deploymentName;

    @JsonProperty("driver-class-name")
    private String driverClassName;

    @JsonProperty("driver-datasource-class-name")
    private String driverDatasourceClassName;

    @JsonProperty("driver-major-version")
    private String driverMajorVersion;

    @JsonProperty("driver-minor-version")
    private String driverMinorVersion;

    @JsonProperty("driver-module-name")
    private String driverModuleName;

    @JsonProperty("driver-name")
    private String driverName;

    @JsonProperty("driver-xa-datasource-class-name")
    private String driverXaDatasourceClassName;

    @JsonProperty("jdbc-compliant")
    private String jdbcCompliant;

    @JsonProperty("module-slot")
    private String moduleSlot;

    @JsonProperty("profile")
    private String profile;

    @JsonProperty("xa-datasource-class")
    private String xaDatasourceClass;

    private String name;

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public String getDeploymentName() {
        return deploymentName;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public String getDriverDatasourceClassName() {
        return driverDatasourceClassName;
    }

    public String getDriverMajorVersion() {
        return driverMajorVersion;
    }

    public String getDriverMinorVersion() {
        return driverMinorVersion;
    }

    public String getDriverModuleName() {
        return driverModuleName;
    }

    public String getDriverName() {
        return driverName;
    }

    public String getDriverXaDatasourceClassName() {
        return driverXaDatasourceClassName;
    }

    public String getJdbcCompliant() {
        return jdbcCompliant;
    }

    public String getModuleSlot() {
        return moduleSlot;
    }

    public String getProfile() {
        return profile;
    }

    public String getXaDatasourceClass() {
        return xaDatasourceClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
