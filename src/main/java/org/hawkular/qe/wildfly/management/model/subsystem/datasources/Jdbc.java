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
