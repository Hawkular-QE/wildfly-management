package org.hawkular.qe.wildfly.management.model.subsystem.datasources;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author jkandasa@redhat.com (Jeeva Kandasamy)
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Statistics {
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
