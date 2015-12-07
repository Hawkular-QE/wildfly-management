package org.hawkular.qe.wildfly.management.model.subsystem.datasources;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author jkandasa@redhat.com (Jeeva Kandasamy)
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConnectionUrl {
    @JsonProperty("EXPRESSION_VALUE")
    private String expressionValue;

    private String url;

    public ConnectionUrl() {

    }

    public ConnectionUrl(String url) {
        this.url = url;
    }

    public String getExpressionValue() {
        return expressionValue;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
