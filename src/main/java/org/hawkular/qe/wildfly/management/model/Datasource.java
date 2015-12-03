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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.hawkular.qe.wildfly.management.client.StandaloneMgmtClient;
import org.jboss.as.controller.client.ModelControllerClient;
import org.jboss.as.controller.descriptions.ModelDescriptionConstants;
import org.jboss.dmr.ModelNode;

/**
 * @author jkandasa@redhat.com (Jeeva Kandasamy)
 */
public class Datasource {
    public static final String DATASOURCES = "datasources";
    public static final String DATA_SOURCE = "data-source";
    public static final String STATISTICS = "statistics";

    private String name;
    private String connectionUrl;
    private String driverClass;
    private String driverName;
    private Boolean enabled;
    private String jndiName;
    private String userName;
    private String password;
    private Boolean statisticsEnabled;
    private Statistics statistics;

    public Datasource() {

    }

    public Datasource(String name) {
        this.name = name;
    }

    public Datasource(ModelControllerClient modelControllerClient, String name) {
        //Query used in CLI:
        // /subsystem=datasources/data-source=HawkularDS:read-resource(include-runtime=true,recursive=true)
        this.name = name;

        ModelNode op = new ModelNode();
        op.get(ModelDescriptionConstants.OP).set(ModelDescriptionConstants.READ_RESOURCE_OPERATION);
        op.get(ModelDescriptionConstants.INCLUDE_RUNTIME).set(true);
        op.get(ModelDescriptionConstants.RECURSIVE).set(true);
        ModelNode address = op.get(ModelDescriptionConstants.ADDRESS);
        address.add(ModelDescriptionConstants.SUBSYSTEM, DATASOURCES);
        address.add(DATA_SOURCE, this.name);
        ModelNode result = null;
        try {
            result = StandaloneMgmtClient.execute(modelControllerClient, op);
        } catch (IllegalStateException ex) {
            throw ex;
        }

        ModelNode data = result.get(ModelDescriptionConstants.RESULT);

        this.statisticsEnabled = ModelUtils.getBooleanValue(data, "statistics-enabled");
        this.enabled = ModelUtils.getBooleanValue(data, "enabled");
        this.connectionUrl = ModelUtils.getValue(data, "connection-url");
        this.driverClass = ModelUtils.getValue(data, "driver-class");
        this.driverName = ModelUtils.getValue(data, "driver-name");
        this.jndiName = ModelUtils.getValue(data, "jndi-name");
        this.userName = ModelUtils.getValue(data, "user-name");
        this.password = ModelUtils.getValue(data, "password");

        if (this.statisticsEnabled != null && this.statisticsEnabled == true) {
            this.statistics = new Statistics(data.get(STATISTICS));
        }

    }

    public List<Datasource> getDatasources(ModelControllerClient modelControllerClient) {
        ModelNode op = new ModelNode();
        op.get(ModelDescriptionConstants.OP).set(ModelDescriptionConstants.READ_CHILDREN_NAMES_OPERATION);
        op.get(ModelDescriptionConstants.CHILD_TYPE).set(DATA_SOURCE);
        op.get(ModelDescriptionConstants.RECURSIVE).set(false);
        op.get(ModelDescriptionConstants.OP_ADDR).add(ModelDescriptionConstants.SUBSYSTEM, DATASOURCES);

        ModelNode result = StandaloneMgmtClient.execute(modelControllerClient, op);
        final List<ModelNode> modelNodes = (result.hasDefined(ModelDescriptionConstants.RESULT) ? result
                .get(ModelDescriptionConstants.RESULT).asList() : Collections.<ModelNode> emptyList());
        List<Datasource> datasources = new ArrayList<Datasource>();
        for (ModelNode modelNode : modelNodes) {
            datasources.add(new Datasource(modelNode.asString()));
        }
        return datasources;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public String getConnectionUrl() {
        return connectionUrl;
    }

    public String getDriverClass() {
        return driverClass;
    }

    public String getDriverName() {
        return driverName;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public String getJndiName() {
        return jndiName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getStatisticsEnabled() {
        return statisticsEnabled;
    }

    public Statistics getStatistics() {
        return statistics;
    }
}

class Statistics {
    public static final String POOL = "pool";
    public static final String JDBC = "jdbc";

    private Pool pool;
    private Jdbc jdbc;

    public Statistics(ModelNode data) {
        this.pool = new Pool(data.get(POOL));
        this.jdbc = new Jdbc(data.get(JDBC));
    }

    public Jdbc getJdbc() {
        return jdbc;
    }

    public Pool getPool() {
        return pool;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}

class Pool {
    private Integer activeCount;
    private Integer availableCount;
    private Long averageBlockingTime;
    private Long averageCreationTime;
    private Long averageGetTime;
    private Long averagePoolTime;
    private Long averageUsageTime;
    private Integer blockingFailureCount;
    private Integer createdCount;
    private Integer destroyedCount;
    private Integer idleCount;
    private Integer inUseCount;
    private Long maxCreationTime;
    private Long maxGetTime;
    private Long maxPoolTime;
    private Long maxUsageTime;
    private Long maxUsedCount;
    private Long maxWaitCount;
    private Long maxWaitTime;
    private Integer timedOut;
    private Long totalBlockingTime;
    private Long totalCreationTime;
    private Long totalGetTime;
    private Long totalPoolTime;
    private Long totalUsageTime;
    private Integer waitCount;
    private Long xACommitAverageTime;
    private Long xACommitCount;
    private Long xACommitMaxTime;
    private Long xACommitTotalTime;
    private Long xAEndAverageTime;
    private Long xAEndCount;
    private Long xAEndMaxTime;
    private Long xAEndTotalTime;
    private Long xAForgetAverageTime;
    private Long xAForgetCount;
    private Long xAForgetMaxTime;
    private Long xAForgetTotalTime;
    private Long xAPrepareAverageTime;
    private Long xAPrepareCount;
    private Long xAPrepareMaxTime;
    private Long xAPrepareTotalTime;
    private Long xARecoverAverageTime;
    private Long xARecoverCount;
    private Long xARecoverMaxTime;
    private Long xARecoverTotalTime;
    private Long xARollbackAverageTime;
    private Long xARollbackCount;
    private Long xARollbackMaxTime;
    private Long xARollbackTotalTime;
    private Long xAStartAverageTime;
    private Long xAStartCount;
    private Long xAStartMaxTime;
    private Long xAStartTotalTime;
    private Boolean statisticsEnabled;

    public Pool(ModelNode data) {
        this.activeCount = ModelUtils.getIntegerValue(data, "ActiveCount");
        this.availableCount = ModelUtils.getIntegerValue(data, "AvailableCount");
        this.averageBlockingTime = ModelUtils.getLongValue(data, "AverageBlockingTime");
        this.averageCreationTime = ModelUtils.getLongValue(data, "AverageCreationTime");
        this.averageGetTime = ModelUtils.getLongValue(data, "AverageGetTime");
        this.averagePoolTime = ModelUtils.getLongValue(data, "AveragePoolTime");
        this.averageUsageTime = ModelUtils.getLongValue(data, "AverageUsageTime");
        this.blockingFailureCount = ModelUtils.getIntegerValue(data, "BlockingFailureCount");
        this.createdCount = ModelUtils.getIntegerValue(data, "CreatedCount");
        this.destroyedCount = ModelUtils.getIntegerValue(data, "DestroyedCount");
        this.idleCount = ModelUtils.getIntegerValue(data, "IdleCount");
        this.inUseCount = ModelUtils.getIntegerValue(data, "InUseCount");
        this.maxCreationTime = ModelUtils.getLongValue(data, "MaxCreationTime");
        this.maxGetTime = ModelUtils.getLongValue(data, "MaxGetTime");
        this.maxPoolTime = ModelUtils.getLongValue(data, "MaxPoolTime");
        this.maxUsageTime = ModelUtils.getLongValue(data, "MaxUsageTime");
        this.maxUsedCount = ModelUtils.getLongValue(data, "MaxUsedCount");
        this.maxWaitCount = ModelUtils.getLongValue(data, "MaxWaitCount");
        this.maxWaitTime = ModelUtils.getLongValue(data, "MaxWaitTime");
        this.timedOut = ModelUtils.getIntegerValue(data, "TimedOut");
        this.totalBlockingTime = ModelUtils.getLongValue(data, "TotalBlockingTime");
        this.totalCreationTime = ModelUtils.getLongValue(data, "TotalCreationTime");
        this.totalGetTime = ModelUtils.getLongValue(data, "TotalGetTime");
        this.totalPoolTime = ModelUtils.getLongValue(data, "TotalPoolTime");
        this.totalUsageTime = ModelUtils.getLongValue(data, "TotalUsageTime");
        this.waitCount = ModelUtils.getIntegerValue(data, "WaitCount");
        this.xACommitAverageTime = ModelUtils.getLongValue(data, "XACommitAverageTime");
        this.xACommitCount = ModelUtils.getLongValue(data, "XACommitCount");
        this.xACommitMaxTime = ModelUtils.getLongValue(data, "XACommitMaxTime");
        this.xACommitTotalTime = ModelUtils.getLongValue(data, "XACommitTotalTime");
        this.xAEndAverageTime = ModelUtils.getLongValue(data, "XAEndAverageTime");
        this.xAEndCount = ModelUtils.getLongValue(data, "XAEndCount");
        this.xAEndMaxTime = ModelUtils.getLongValue(data, "XAEndMaxTime");
        this.xAEndTotalTime = ModelUtils.getLongValue(data, "XAEndTotalTime");
        this.xAForgetAverageTime = ModelUtils.getLongValue(data, "XAForgetAverageTime");
        this.xAForgetCount = ModelUtils.getLongValue(data, "XAForgetCount");
        this.xAForgetMaxTime = ModelUtils.getLongValue(data, "XAForgetMaxTime");
        this.xAForgetTotalTime = ModelUtils.getLongValue(data, "XAForgetTotalTime");
        this.xAPrepareAverageTime = ModelUtils.getLongValue(data, "XAPrepareAverageTime");
        this.xAPrepareCount = ModelUtils.getLongValue(data, "XAPrepareCount");
        this.xAPrepareMaxTime = ModelUtils.getLongValue(data, "XAPrepareMaxTime");
        this.xAPrepareTotalTime = ModelUtils.getLongValue(data, "XAPrepareTotalTime");
        this.xARecoverAverageTime = ModelUtils.getLongValue(data, "XARecoverAverageTime");
        this.xARecoverCount = ModelUtils.getLongValue(data, "XARecoverCount");
        this.xARecoverMaxTime = ModelUtils.getLongValue(data, "XARecoverMaxTime");
        this.xARecoverTotalTime = ModelUtils.getLongValue(data, "XARecoverTotalTime");
        this.xARollbackAverageTime = ModelUtils.getLongValue(data, "XARollbackAverageTime");
        this.xARollbackCount = ModelUtils.getLongValue(data, "XARollbackCount");
        this.xARollbackMaxTime = ModelUtils.getLongValue(data, "XARollbackMaxTime");
        this.xARollbackTotalTime = ModelUtils.getLongValue(data, "XARollbackTotalTime");
        this.xAStartAverageTime = ModelUtils.getLongValue(data, "XAStartAverageTime");
        this.xAStartCount = ModelUtils.getLongValue(data, "XAStartCount");
        this.xAStartMaxTime = ModelUtils.getLongValue(data, "XAStartMaxTime");
        this.xAStartTotalTime = ModelUtils.getLongValue(data, "XAStartTotalTime");
        this.statisticsEnabled = ModelUtils.getBooleanValue(data, "statistics-enabled");

    }

    public Integer getActiveCount() {
        return activeCount;
    }

    public Integer getAvailableCount() {
        return availableCount;
    }

    public Long getAverageBlockingTime() {
        return averageBlockingTime;
    }

    public Long getAverageCreationTime() {
        return averageCreationTime;
    }

    public Long getAverageGetTime() {
        return averageGetTime;
    }

    public Long getAveragePoolTime() {
        return averagePoolTime;
    }

    public Long getAverageUsageTime() {
        return averageUsageTime;
    }

    public Integer getBlockingFailureCount() {
        return blockingFailureCount;
    }

    public Integer getCreatedCount() {
        return createdCount;
    }

    public Integer getDestroyedCount() {
        return destroyedCount;
    }

    public Integer getIdleCount() {
        return idleCount;
    }

    public Integer getInUseCount() {
        return inUseCount;
    }

    public Long getMaxCreationTime() {
        return maxCreationTime;
    }

    public Long getMaxGetTime() {
        return maxGetTime;
    }

    public Long getMaxPoolTime() {
        return maxPoolTime;
    }

    public Long getMaxUsageTime() {
        return maxUsageTime;
    }

    public Long getMaxUsedCount() {
        return maxUsedCount;
    }

    public Long getMaxWaitCount() {
        return maxWaitCount;
    }

    public Long getMaxWaitTime() {
        return maxWaitTime;
    }

    public Integer getTimedOut() {
        return timedOut;
    }

    public Long getTotalBlockingTime() {
        return totalBlockingTime;
    }

    public Long getTotalCreationTime() {
        return totalCreationTime;
    }

    public Long getTotalGetTime() {
        return totalGetTime;
    }

    public Long getTotalPoolTime() {
        return totalPoolTime;
    }

    public Long getTotalUsageTime() {
        return totalUsageTime;
    }

    public Integer getWaitCount() {
        return waitCount;
    }

    public Long getxACommitAverageTime() {
        return xACommitAverageTime;
    }

    public Long getxACommitCount() {
        return xACommitCount;
    }

    public Long getxACommitMaxTime() {
        return xACommitMaxTime;
    }

    public Long getxACommitTotalTime() {
        return xACommitTotalTime;
    }

    public Long getxAEndAverageTime() {
        return xAEndAverageTime;
    }

    public Long getxAEndCount() {
        return xAEndCount;
    }

    public Long getxAEndMaxTime() {
        return xAEndMaxTime;
    }

    public Long getxAEndTotalTime() {
        return xAEndTotalTime;
    }

    public Long getxAForgetAverageTime() {
        return xAForgetAverageTime;
    }

    public Long getxAForgetCount() {
        return xAForgetCount;
    }

    public Long getxAForgetMaxTime() {
        return xAForgetMaxTime;
    }

    public Long getxAForgetTotalTime() {
        return xAForgetTotalTime;
    }

    public Long getxAPrepareAverageTime() {
        return xAPrepareAverageTime;
    }

    public Long getxAPrepareCount() {
        return xAPrepareCount;
    }

    public Long getxAPrepareMaxTime() {
        return xAPrepareMaxTime;
    }

    public Long getxAPrepareTotalTime() {
        return xAPrepareTotalTime;
    }

    public Long getxARecoverAverageTime() {
        return xARecoverAverageTime;
    }

    public Long getxARecoverCount() {
        return xARecoverCount;
    }

    public Long getxARecoverMaxTime() {
        return xARecoverMaxTime;
    }

    public Long getxARecoverTotalTime() {
        return xARecoverTotalTime;
    }

    public Long getxARollbackAverageTime() {
        return xARollbackAverageTime;
    }

    public Long getxARollbackCount() {
        return xARollbackCount;
    }

    public Long getxARollbackMaxTime() {
        return xARollbackMaxTime;
    }

    public Long getxARollbackTotalTime() {
        return xARollbackTotalTime;
    }

    public Long getxAStartAverageTime() {
        return xAStartAverageTime;
    }

    public Long getxAStartCount() {
        return xAStartCount;
    }

    public Long getxAStartMaxTime() {
        return xAStartMaxTime;
    }

    public Long getxAStartTotalTime() {
        return xAStartTotalTime;
    }

    public Boolean getStatisticsEnabled() {
        return statisticsEnabled;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}

class Jdbc {
    private Long preparedStatementCacheAccessCount;
    private Long preparedStatementCacheAddCount;
    private Long preparedStatementCacheCurrentSize;
    private Long preparedStatementCacheDeleteCount;
    private Long preparedStatementCacheHitCount;
    private Long preparedStatementCacheMissCount;
    private Boolean statisticsEnabled;

    public Jdbc(ModelNode data) {
        this.preparedStatementCacheAccessCount = ModelUtils.getLongValue(data, "PreparedStatementCacheAccessCount");
        this.preparedStatementCacheAddCount = ModelUtils.getLongValue(data, "PreparedStatementCacheAddCount");
        this.preparedStatementCacheCurrentSize = ModelUtils.getLongValue(data, "PreparedStatementCacheCurrentSize");
        this.preparedStatementCacheDeleteCount = ModelUtils.getLongValue(data, "PreparedStatementCacheDeleteCount");
        this.preparedStatementCacheHitCount = ModelUtils.getLongValue(data, "PreparedStatementCacheHitCount");
        this.preparedStatementCacheMissCount = ModelUtils.getLongValue(data, "PreparedStatementCacheMissCount");
        this.statisticsEnabled = ModelUtils.getBooleanValue(data, "statistics-enabled");
    }

    public Long getPreparedStatementCacheAccessCount() {
        return preparedStatementCacheAccessCount;
    }

    public Long getPreparedStatementCacheAddCount() {
        return preparedStatementCacheAddCount;
    }

    public Long getPreparedStatementCacheCurrentSize() {
        return preparedStatementCacheCurrentSize;
    }

    public Long getPreparedStatementCacheDeleteCount() {
        return preparedStatementCacheDeleteCount;
    }

    public Long getPreparedStatementCacheHitCount() {
        return preparedStatementCacheHitCount;
    }

    public Long getPreparedStatementCacheMissCount() {
        return preparedStatementCacheMissCount;
    }

    public Boolean getStatisticsEnabled() {
        return statisticsEnabled;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}