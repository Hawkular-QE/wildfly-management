package org.hawkular.qe.wildfly.management.json.serialzier;

import java.io.IOException;

import org.hawkular.qe.wildfly.management.model.subsystem.datasources.ConnectionUrl;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * @author jkandasa@redhat.com (Jeeva Kandasamy)
 */
public class ConnectionUrlSerialzier extends JsonSerializer<ConnectionUrl> {

    @Override
    public void serialize(ConnectionUrl connectionUrl, JsonGenerator generator, SerializerProvider provider)
            throws IOException, JsonProcessingException {
        generator.writeString(connectionUrl.getUrl());
    }

}
