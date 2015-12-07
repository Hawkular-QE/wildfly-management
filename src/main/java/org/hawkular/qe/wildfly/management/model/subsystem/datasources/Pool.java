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
public class Pool {

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
