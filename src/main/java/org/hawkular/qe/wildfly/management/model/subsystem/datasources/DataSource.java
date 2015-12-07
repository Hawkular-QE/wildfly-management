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
import org.hawkular.qe.wildfly.management.json.serialzier.ConnectionUrlSerialzier;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

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
    @JsonSerialize(using = ConnectionUrlSerialzier.class)
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

    public void setAllocationRetry(Integer allocationRetry) {
        this.allocationRetry = allocationRetry;
    }

    public void setAllocationRetryWaitMillis(Long allocationRetryWaitMillis) {
        this.allocationRetryWaitMillis = allocationRetryWaitMillis;
    }

    public void setAllowMultipleUsers(Boolean allowMultipleUsers) {
        this.allowMultipleUsers = allowMultipleUsers;
    }

    public void setBackgroundValidation(Boolean backgroundValidation) {
        this.backgroundValidation = backgroundValidation;
    }

    public void setBackgroundValidationMillis(Long backgroundValidationMillis) {
        this.backgroundValidationMillis = backgroundValidationMillis;
    }

    public void setBlockingTimeoutWaitMillis(Long blockingTimeoutWaitMillis) {
        this.blockingTimeoutWaitMillis = blockingTimeoutWaitMillis;
    }

    public void setCapacityDecrementerClass(String capacityDecrementerClass) {
        this.capacityDecrementerClass = capacityDecrementerClass;
    }

    public void setCapacityDecrementerProperties(String capacityDecrementerProperties) {
        this.capacityDecrementerProperties = capacityDecrementerProperties;
    }

    public void setCapacityIncrementerClass(String capacityIncrementerClass) {
        this.capacityIncrementerClass = capacityIncrementerClass;
    }

    public void setCapacityIncrementerProperties(String capacityIncrementerProperties) {
        this.capacityIncrementerProperties = capacityIncrementerProperties;
    }

    public void setCheckValidConnectionSql(String checkValidConnectionSql) {
        this.checkValidConnectionSql = checkValidConnectionSql;
    }

    public void setConnectable(Boolean connectable) {
        this.connectable = connectable;
    }

    public void setConnectionListenerClass(String connectionListenerClass) {
        this.connectionListenerClass = connectionListenerClass;
    }

    public void setConnectionListenerProperty(String connectionListenerProperty) {
        this.connectionListenerProperty = connectionListenerProperty;
    }

    public void setConnectionProperties(String connectionProperties) {
        this.connectionProperties = connectionProperties;
    }

    @JsonSetter
    public void setConnectionUrl(ConnectionUrl connectionUrl) {
        this.connectionUrl = connectionUrl;
    }

    public void setConnectionUrl(String connectionUrl) {
        this.connectionUrl = new ConnectionUrl(connectionUrl);
    }

    public void setDatasourceClass(String datasourceClass) {
        this.datasourceClass = datasourceClass;
    }

    public void setDriverClass(String driverClass) {
        this.driverClass = driverClass;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public void setExceptionSorterClassName(String exceptionSorterClassName) {
        this.exceptionSorterClassName = exceptionSorterClassName;
    }

    public void setExceptionSorterProperties(String exceptionSorterProperties) {
        this.exceptionSorterProperties = exceptionSorterProperties;
    }

    public void setFlushStrategy(String flushStrategy) {
        this.flushStrategy = flushStrategy;
    }

    public void setIdleTimeoutMinutes(Long idleTimeoutMinutes) {
        this.idleTimeoutMinutes = idleTimeoutMinutes;
    }

    public void setInitialPoolSize(Integer initialPoolSize) {
        this.initialPoolSize = initialPoolSize;
    }

    public void setJndiName(String jndiName) {
        this.jndiName = jndiName;
    }

    public void setJta(Boolean jta) {
        this.jta = jta;
    }

    public void setMaxPoolSize(Integer maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
    }

    public void setMinPoolSize(Integer minPoolSize) {
        this.minPoolSize = minPoolSize;
    }

    public void setNewConnectionSql(String newConnectionSql) {
        this.newConnectionSql = newConnectionSql;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPoolPrefill(String poolPrefill) {
        this.poolPrefill = poolPrefill;
    }

    public void setPoolUseStrictMin(String poolUseStrictMin) {
        this.poolUseStrictMin = poolUseStrictMin;
    }

    public void setPreparedStatementsCacheSize(String preparedStatementsCacheSize) {
        this.preparedStatementsCacheSize = preparedStatementsCacheSize;
    }

    public void setQueryTimeout(Long queryTimeout) {
        this.queryTimeout = queryTimeout;
    }

    public void setReauthPluginClassName(String reauthPluginClassName) {
        this.reauthPluginClassName = reauthPluginClassName;
    }

    public void setReauthPluginProperties(String reauthPluginProperties) {
        this.reauthPluginProperties = reauthPluginProperties;
    }

    public void setSecurityDomain(String securityDomain) {
        this.securityDomain = securityDomain;
    }

    public void setSetTxQueryTimeout(Boolean setTxQueryTimeout) {
        this.setTxQueryTimeout = setTxQueryTimeout;
    }

    public void setSharePreparedStatements(Boolean sharePreparedStatements) {
        this.sharePreparedStatements = sharePreparedStatements;
    }

    public void setSpy(Boolean spy) {
        this.spy = spy;
    }

    public void setStaleConnectionCheckerClassName(String staleConnectionCheckerClassName) {
        this.staleConnectionCheckerClassName = staleConnectionCheckerClassName;
    }

    public void setStaleConnectionCheckerProperties(String staleConnectionCheckerProperties) {
        this.staleConnectionCheckerProperties = staleConnectionCheckerProperties;
    }

    public void setStatisticsEnabled(String statisticsEnabled) {
        this.statisticsEnabled = statisticsEnabled;
    }

    public void setTrackStatements(String trackStatements) {
        this.trackStatements = trackStatements;
    }

    public void setTracking(Boolean tracking) {
        this.tracking = tracking;
    }

    public void setTransactionIsolation(String transactionIsolation) {
        this.transactionIsolation = transactionIsolation;
    }

    public void setUrlDelimiter(String urlDelimiter) {
        this.urlDelimiter = urlDelimiter;
    }

    public void setUrlSelectorStrategyClassName(String urlSelectorStrategyClassName) {
        this.urlSelectorStrategyClassName = urlSelectorStrategyClassName;
    }

    public void setUseCcm(Boolean useCcm) {
        this.useCcm = useCcm;
    }

    public void setUseFastFail(Boolean useFastFail) {
        this.useFastFail = useFastFail;
    }

    public void setUseJavaContext(Boolean useJavaContext) {
        this.useJavaContext = useJavaContext;
    }

    public void setUseTryLock(Long useTryLock) {
        this.useTryLock = useTryLock;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setValidConnectionCheckerClassName(String validConnectionCheckerClassName) {
        this.validConnectionCheckerClassName = validConnectionCheckerClassName;
    }

    public void setValidConnectionCheckerProperties(String validConnectionCheckerProperties) {
        this.validConnectionCheckerProperties = validConnectionCheckerProperties;
    }

    public void setValidateOnMatch(Boolean validateOnMatch) {
        this.validateOnMatch = validateOnMatch;
    }

    public void setStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

}