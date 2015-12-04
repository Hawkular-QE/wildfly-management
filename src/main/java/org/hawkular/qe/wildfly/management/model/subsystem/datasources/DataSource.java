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
public class DataSource {

    @JsonProperty("allocation-retry")
    private Integer allocationRetry;

    @JsonProperty("allocation-retry-wait-millis")
    private Long allocationRetryWaitMillis;

    @JsonProperty("allow-multiple-users")
    private Boolean allowMultipleUsers;

    @JsonProperty("background-validation")
    private Boolean backgroundValidation;

    @JsonProperty("background-validation-millis")
    private Long backgroundValidationMillis;

    @JsonProperty("blocking-timeout-wait-millis")
    private Long blockingTimeoutWaitMillis;

    @JsonProperty("capacity-decrementer-class")
    private String capacityDecrementerClass;

    @JsonProperty("capacity-decrementer-properties")
    private String capacityDecrementerProperties;

    @JsonProperty("capacity-incrementer-class")
    private String capacityIncrementerClass;

    @JsonProperty("capacity-incrementer-properties")
    private String capacityIncrementerProperties;

    @JsonProperty("check-valid-connection-sql")
    private String checkValidConnectionSql;

    @JsonProperty("connectable")
    private Boolean connectable;

    @JsonProperty("connection-listener-class")
    private String connectionListenerClass;

    @JsonProperty("connection-listener-property")
    private String connectionListenerProperty;

    @JsonProperty("connection-properties")
    private String connectionProperties;

    @JsonProperty("connection-url")
    private ConnectionUrl connectionUrl;

    @JsonProperty("datasource-class")
    private String datasourceClass;

    @JsonProperty("driver-class")
    private String driverClass;

    @JsonProperty("driver-name")
    private String driverName;

    @JsonProperty("enabled")
    private Boolean enabled;

    @JsonProperty("exception-sorter-class-name")
    private String exceptionSorterClassName;

    @JsonProperty("exception-sorter-properties")
    private String exceptionSorterProperties;

    @JsonProperty("flush-strategy")
    private String flushStrategy;

    @JsonProperty("idle-timeout-minutes")
    private Long idleTimeoutMinutes;

    @JsonProperty("initial-pool-size")
    private Integer initialPoolSize;

    @JsonProperty("jndi-name")
    private String jndiName;

    @JsonProperty("jta")
    private Boolean jta;

    @JsonProperty("max-pool-size")
    private Integer maxPoolSize;

    @JsonProperty("min-pool-size")
    private Integer minPoolSize;

    @JsonProperty("new-connection-sql")
    private String newConnectionSql;

    @JsonProperty("password")
    private String password;

    @JsonProperty("pool-prefill")
    private String poolPrefill;

    @JsonProperty("pool-use-strict-min")
    private String poolUseStrictMin;

    @JsonProperty("prepared-statements-cache-size")
    private String preparedStatementsCacheSize;

    @JsonProperty("query-timeout")
    private Long queryTimeout;

    @JsonProperty("reauth-plugin-class-name")
    private String reauthPluginClassName;

    @JsonProperty("reauth-plugin-properties")
    private String reauthPluginProperties;

    @JsonProperty("security-domain")
    private String securityDomain;

    @JsonProperty("set-tx-query-timeout")
    private Boolean setTxQueryTimeout;

    @JsonProperty("share-prepared-statements")
    private Boolean sharePreparedStatements;

    @JsonProperty("spy")
    private Boolean spy;

    @JsonProperty("stale-connection-checker-class-name")
    private String staleConnectionCheckerClassName;

    @JsonProperty("stale-connection-checker-properties")
    private String staleConnectionCheckerProperties;

    @JsonProperty("statistics-enabled")
    private String statisticsEnabled;

    @JsonProperty("track-statements")
    private String trackStatements;

    @JsonProperty("tracking")
    private Boolean tracking;

    @JsonProperty("transaction-isolation")
    private String transactionIsolation;

    @JsonProperty("url-delimiter")
    private String urlDelimiter;

    @JsonProperty("url-selector-strategy-class-name")
    private String urlSelectorStrategyClassName;

    @JsonProperty("use-ccm")
    private Boolean useCcm;

    @JsonProperty("use-fast-fail")
    private Boolean useFastFail;

    @JsonProperty("use-java-context")
    private Boolean useJavaContext;

    @JsonProperty("use-try-lock")
    private Long useTryLock;

    @JsonProperty("user-name")
    private String userName;

    @JsonProperty("valid-connection-checker-class-name")
    private String validConnectionCheckerClassName;

    @JsonProperty("valid-connection-checker-properties")
    private String validConnectionCheckerProperties;

    @JsonProperty("validate-on-match")
    private Boolean validateOnMatch;

    private String name;

    @JsonProperty("statistics")
    private Statistics statistics;

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAllocationRetry() {
        return allocationRetry;
    }

    public Long getAllocationRetryWaitMillis() {
        return allocationRetryWaitMillis;
    }

    public Boolean getAllowMultipleUsers() {
        return allowMultipleUsers;
    }

    public Boolean getBackgroundValidation() {
        return backgroundValidation;
    }

    public Long getBackgroundValidationMillis() {
        return backgroundValidationMillis;
    }

    public Long getBlockingTimeoutWaitMillis() {
        return blockingTimeoutWaitMillis;
    }

    public String getCapacityDecrementerClass() {
        return capacityDecrementerClass;
    }

    public String getCapacityDecrementerProperties() {
        return capacityDecrementerProperties;
    }

    public String getCapacityIncrementerClass() {
        return capacityIncrementerClass;
    }

    public String getCapacityIncrementerProperties() {
        return capacityIncrementerProperties;
    }

    public String getCheckValidConnectionSql() {
        return checkValidConnectionSql;
    }

    public Boolean getConnectable() {
        return connectable;
    }

    public String getConnectionListenerClass() {
        return connectionListenerClass;
    }

    public String getConnectionListenerProperty() {
        return connectionListenerProperty;
    }

    public String getConnectionProperties() {
        return connectionProperties;
    }

    public ConnectionUrl getConnectionUrl() {
        return connectionUrl;
    }

    public String getDatasourceClass() {
        return datasourceClass;
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

    public String getExceptionSorterClassName() {
        return exceptionSorterClassName;
    }

    public String getExceptionSorterProperties() {
        return exceptionSorterProperties;
    }

    public String getFlushStrategy() {
        return flushStrategy;
    }

    public Long getIdleTimeoutMinutes() {
        return idleTimeoutMinutes;
    }

    public Integer getInitialPoolSize() {
        return initialPoolSize;
    }

    public String getJndiName() {
        return jndiName;
    }

    public Boolean getJta() {
        return jta;
    }

    public Integer getMaxPoolSize() {
        return maxPoolSize;
    }

    public Integer getMinPoolSize() {
        return minPoolSize;
    }

    public String getNewConnectionSql() {
        return newConnectionSql;
    }

    public String getPassword() {
        return password;
    }

    public String getPoolPrefill() {
        return poolPrefill;
    }

    public String getPoolUseStrictMin() {
        return poolUseStrictMin;
    }

    public String getPreparedStatementsCacheSize() {
        return preparedStatementsCacheSize;
    }

    public Long getQueryTimeout() {
        return queryTimeout;
    }

    public String getReauthPluginClassName() {
        return reauthPluginClassName;
    }

    public String getReauthPluginProperties() {
        return reauthPluginProperties;
    }

    public String getSecurityDomain() {
        return securityDomain;
    }

    public Boolean getSetTxQueryTimeout() {
        return setTxQueryTimeout;
    }

    public Boolean getSharePreparedStatements() {
        return sharePreparedStatements;
    }

    public Boolean getSpy() {
        return spy;
    }

    public String getStaleConnectionCheckerClassName() {
        return staleConnectionCheckerClassName;
    }

    public String getStaleConnectionCheckerProperties() {
        return staleConnectionCheckerProperties;
    }

    public String getStatisticsEnabled() {
        return statisticsEnabled;
    }

    public String getTrackStatements() {
        return trackStatements;
    }

    public Boolean getTracking() {
        return tracking;
    }

    public String getTransactionIsolation() {
        return transactionIsolation;
    }

    public String getUrlDelimiter() {
        return urlDelimiter;
    }

    public String getUrlSelectorStrategyClassName() {
        return urlSelectorStrategyClassName;
    }

    public Boolean getUseCcm() {
        return useCcm;
    }

    public Boolean getUseFastFail() {
        return useFastFail;
    }

    public Boolean getUseJavaContext() {
        return useJavaContext;
    }

    public Long getUseTryLock() {
        return useTryLock;
    }

    public String getUserName() {
        return userName;
    }

    public String getValidConnectionCheckerClassName() {
        return validConnectionCheckerClassName;
    }

    public String getValidConnectionCheckerProperties() {
        return validConnectionCheckerProperties;
    }

    public Boolean getValidateOnMatch() {
        return validateOnMatch;
    }

    public Statistics getStatistics() {
        return statistics;
    }

}

@JsonIgnoreProperties(ignoreUnknown = true)
class ConnectionUrl {
    @JsonProperty("EXPRESSION_VALUE")
    private String expressionValue;

    public String getExpressionValue() {
        return expressionValue;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}

@JsonIgnoreProperties(ignoreUnknown = true)
class Statistics {
    @JsonProperty("pool")
    private Pool pool;

    @JsonProperty("jdbc")
    private Jdbc jdbc;

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

@JsonIgnoreProperties(ignoreUnknown = true)
class Pool {

    @JsonProperty("ActiveCount")
    private Integer activeCount;

    @JsonProperty("AvailableCount")
    private Integer availableCount;

    @JsonProperty("AverageBlockingTime")
    private Long averageBlockingTime;

    @JsonProperty("AverageCreationTime")
    private Long averageCreationTime;

    @JsonProperty("AverageGetTime")
    private Long averageGetTime;

    @JsonProperty("AveragePoolTime")
    private Long averagePoolTime;

    @JsonProperty("AverageUsageTime")
    private Long averageUsageTime;

    @JsonProperty("BlockingFailureCount")
    private Integer blockingFailureCount;

    @JsonProperty("CreatedCount")
    private Integer createdCount;

    @JsonProperty("DestroyedCount")
    private Integer destroyedCount;

    @JsonProperty("IdleCount")
    private Integer idleCount;

    @JsonProperty("InUseCount")
    private Integer inUseCount;

    @JsonProperty("MaxCreationTime")
    private Long maxCreationTime;

    @JsonProperty("MaxGetTime")
    private Long maxGetTime;

    @JsonProperty("MaxPoolTime")
    private Long maxPoolTime;

    @JsonProperty("MaxUsageTime")
    private Long maxUsageTime;

    @JsonProperty("MaxUsedCount")
    private Long maxUsedCount;

    @JsonProperty("MaxWaitCount")
    private Long maxWaitCount;

    @JsonProperty("MaxWaitTime")
    private Long maxWaitTime;

    @JsonProperty("TimedOut")
    private Integer timedOut;

    @JsonProperty("TotalBlockingTime")
    private Long totalBlockingTime;

    @JsonProperty("TotalCreationTime")
    private Long totalCreationTime;

    @JsonProperty("TotalGetTime")
    private Long totalGetTime;

    @JsonProperty("TotalPoolTime")
    private Long totalPoolTime;

    @JsonProperty("TotalUsageTime")
    private Long totalUsageTime;

    @JsonProperty("WaitCount")
    private Integer waitCount;

    @JsonProperty("XACommitAverageTime")
    private Long xACommitAverageTime;

    @JsonProperty("XACommitCount")
    private Long xACommitCount;

    @JsonProperty("XACommitMaxTime")
    private Long xACommitMaxTime;

    @JsonProperty("XACommitTotalTime")
    private Long xACommitTotalTime;

    @JsonProperty("XAEndAverageTime")
    private Long xAEndAverageTime;

    @JsonProperty("XAEndCount")
    private Long xAEndCount;

    @JsonProperty("XAEndMaxTime")
    private Long xAEndMaxTime;

    @JsonProperty("XAEndTotalTime")
    private Long xAEndTotalTime;

    @JsonProperty("XAForgetAverageTime")
    private Long xAForgetAverageTime;

    @JsonProperty("XAForgetCount")
    private Long xAForgetCount;

    @JsonProperty("XAForgetMaxTime")
    private Long xAForgetMaxTime;

    @JsonProperty("XAForgetTotalTime")
    private Long xAForgetTotalTime;

    @JsonProperty("XAPrepareAverageTime")
    private Long xAPrepareAverageTime;

    @JsonProperty("XAPrepareCount")
    private Long xAPrepareCount;

    @JsonProperty("XAPrepareMaxTime")
    private Long xAPrepareMaxTime;

    @JsonProperty("XAPrepareTotalTime")
    private Long xAPrepareTotalTime;

    @JsonProperty("XARecoverAverageTime")
    private Long xARecoverAverageTime;

    @JsonProperty("XARecoverCount")
    private Long xARecoverCount;

    @JsonProperty("XARecoverMaxTime")
    private Long xARecoverMaxTime;

    @JsonProperty("XARecoverTotalTime")
    private Long xARecoverTotalTime;

    @JsonProperty("XARollbackAverageTime")
    private Long xARollbackAverageTime;

    @JsonProperty("XARollbackCount")
    private Long xARollbackCount;

    @JsonProperty("XARollbackMaxTime")
    private Long xARollbackMaxTime;

    @JsonProperty("XARollbackTotalTime")
    private Long xARollbackTotalTime;

    @JsonProperty("XAStartAverageTime")
    private Long xAStartAverageTime;

    @JsonProperty("XAStartCount")
    private Long xAStartCount;

    @JsonProperty("XAStartMaxTime")
    private Long xAStartMaxTime;

    @JsonProperty("XAStartTotalTime")
    private Long xAStartTotalTime;

    @JsonProperty("statistics-enabled")
    private Boolean statisticsEnabled;

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

@JsonIgnoreProperties(ignoreUnknown = true)
class Jdbc {
    @JsonProperty("PreparedStatementCacheAccessCount")
    private Long preparedStatementCacheAccessCount;

    @JsonProperty("PreparedStatementCacheAddCount")
    private Long preparedStatementCacheAddCount;

    @JsonProperty("PreparedStatementCacheCurrentSize")
    private Long preparedStatementCacheCurrentSize;

    @JsonProperty("PreparedStatementCacheDeleteCount")
    private Long preparedStatementCacheDeleteCount;

    @JsonProperty("PreparedStatementCacheHitCount")
    private Long preparedStatementCacheHitCount;

    @JsonProperty("PreparedStatementCacheMissCount")
    private Long preparedStatementCacheMissCount;

    @JsonProperty("statistics-enabled")
    private Boolean statisticsEnabled;

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