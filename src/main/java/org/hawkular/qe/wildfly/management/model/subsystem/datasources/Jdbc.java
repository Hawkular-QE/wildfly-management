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
public class Jdbc {
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
