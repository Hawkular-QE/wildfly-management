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
package org.hawkular.qe.wildfly.management.subsystem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hawkular.qe.wildfly.management.client.StandaloneMgmtClient;
import org.hawkular.qe.wildfly.management.model.subsystem.datasources.DataSource;
import org.hawkular.qe.wildfly.management.model.subsystem.datasources.JdbcDriver;
import org.hawkular.qe.wildfly.management.model.subsystem.datasources.XaDataSource;
import org.jboss.as.controller.client.ModelControllerClient;
import org.jboss.as.controller.descriptions.ModelDescriptionConstants;
import org.jboss.dmr.ModelNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author jkandasa@redhat.com (Jeeva Kandasamy)
 */
public class Datasources {
    protected static final Logger _logger = LoggerFactory.getLogger(Datasources.class.getName());
    public static final String DATASOURCES = "datasources";
    public static final String DATA_SOURCE = "data-source";
    public static final String JDBC_DRIVER = "jdbc-driver";
    public static final String XA_DATA_SOURCE = "xa-data-source";

    private ModelControllerClient modelControllerClient;

    public Datasources(ModelControllerClient modelControllerClient) {
        this.modelControllerClient = modelControllerClient;
    }

    private List<String> getResultAsStringList(ModelNode result) {
        final List<ModelNode> modelNodes = (result.hasDefined(ModelDescriptionConstants.RESULT) ? result
                .get(ModelDescriptionConstants.RESULT).asList() : Collections.<ModelNode> emptyList());
        List<String> stringList = new ArrayList<String>();
        for (ModelNode modelNode : modelNodes) {
            stringList.add(modelNode.asString());
        }
        return stringList;
    }

    public List<String> getChildrenTypes() {
        ///subsystem=datasources:read-children-types()
        ModelNode op = new ModelNode();
        op.get(ModelDescriptionConstants.OP).set(ModelDescriptionConstants.READ_CHILDREN_TYPES_OPERATION);
        op.get(ModelDescriptionConstants.OP_ADDR).add(ModelDescriptionConstants.SUBSYSTEM, DATASOURCES);

        ModelNode result = StandaloneMgmtClient.execute(modelControllerClient, op);
        return getResultAsStringList(result);
    }

    public List<String> getChildrenNames(String childrenName) {
        ModelNode op = new ModelNode();
        op.get(ModelDescriptionConstants.OP).set(ModelDescriptionConstants.READ_CHILDREN_NAMES_OPERATION);
        op.get(ModelDescriptionConstants.CHILD_TYPE).set(childrenName);
        op.get(ModelDescriptionConstants.RECURSIVE).set(false);
        op.get(ModelDescriptionConstants.OP_ADDR).add(ModelDescriptionConstants.SUBSYSTEM, DATASOURCES);

        ModelNode result = StandaloneMgmtClient.execute(modelControllerClient, op);
        return getResultAsStringList(result);
    }

    public List<String> getDataSourceList() {
        return getChildrenNames(DATA_SOURCE);
    }

    public List<String> getXaDataSourceList() {
        return getChildrenNames(XA_DATA_SOURCE);
    }

    public List<String> getJdbcDriverList() {
        return getChildrenNames(JDBC_DRIVER);
    }

    public DataSource getDataSource(String dataSourceName) {
        //Query used in CLI:
        // /subsystem=datasources/data-source=HawkularDS:read-resource(include-runtime=true,recursive=true)
        DataSource dataSource = getChildrenDetail(DATA_SOURCE, dataSourceName, DataSource.class);
        if (dataSource == null) {
            dataSource = new DataSource();
        }
        dataSource.setName(dataSourceName);
        return dataSource;
    }

    public XaDataSource getXaDataSource(String name) {
        //Query used in CLI:
        // /subsystem=datasources/data-source=HawkularDS:read-resource(include-runtime=true,recursive=true)
        XaDataSource xaDataSource = getChildrenDetail(XA_DATA_SOURCE, name, XaDataSource.class);
        if (xaDataSource == null) {
            xaDataSource = new XaDataSource();
        }
        xaDataSource.setName(name);
        return xaDataSource;
    }

    public JdbcDriver getJdbcDriver(String jdbcDriverName) {
        //Query used in CLI:
        // /subsystem=datasources/jdbc-driver=h2:read-resource(include-runtime=true,recursive=true)
        JdbcDriver jdbcDriver = getChildrenDetail(JDBC_DRIVER, jdbcDriverName, JdbcDriver.class);
        if (jdbcDriver == null) {
            jdbcDriver = new JdbcDriver();
        }
        jdbcDriver.setName(jdbcDriverName);
        return jdbcDriver;
    }

    public <T> T getChildrenDetail(String childrenType, String childrenName, Class<T> clazz) {
        ModelNode op = new ModelNode();
        op.get(ModelDescriptionConstants.OP).set(ModelDescriptionConstants.READ_RESOURCE_OPERATION);
        op.get(ModelDescriptionConstants.INCLUDE_RUNTIME).set(true);
        op.get(ModelDescriptionConstants.RECURSIVE).set(true);
        ModelNode address = op.get(ModelDescriptionConstants.ADDRESS);
        address.add(ModelDescriptionConstants.SUBSYSTEM, Datasources.DATASOURCES);
        address.add(childrenType, childrenName);
        ModelNode result = null;
        try {
            result = StandaloneMgmtClient.execute(modelControllerClient, op);
            ModelNode data = result.get(ModelDescriptionConstants.RESULT);
            ObjectMapper mapper = new ObjectMapper();
            String jsonString = data.toJSONString(true);
            _logger.debug("JsonString for '{}:{}':[{}]", childrenType, childrenName, jsonString);
            return (T) mapper.readValue(jsonString, clazz);
        } catch (IllegalStateException | IOException ex) {
            _logger.error("Exception,", ex);
        }
        return null;
    }

    public boolean addDataSource(DataSource dataSource) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            ModelNode op = ModelNode.fromJSONString(mapper.writeValueAsString(dataSource));
            op.get(ModelDescriptionConstants.OP).set(ModelDescriptionConstants.ADD);
            ModelNode address = op.get(ModelDescriptionConstants.ADDRESS);
            address.add(ModelDescriptionConstants.SUBSYSTEM, Datasources.DATASOURCES);
            address.add(DATA_SOURCE, dataSource.getName());
            ModelNode result = StandaloneMgmtClient.execute(modelControllerClient, op);
            return result.get(ModelDescriptionConstants.OUTCOME).asString().equalsIgnoreCase("success");
        } catch (JsonProcessingException ex) {
            _logger.error("Error, ", ex);
        }
        return false;
    }
}
