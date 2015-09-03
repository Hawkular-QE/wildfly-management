package org.hawkular.qe.wildfly.management.model;

import org.hawkular.qe.wildfly.management.Client;
import org.jboss.as.controller.client.ModelControllerClient;
import org.jboss.as.controller.descriptions.ModelDescriptionConstants;
import org.jboss.dmr.ModelNode;

/**
 * @author jkandasa@redhat.com (Jeeva Kandasamy)
 */
public class ModelUtils {
    private ModelUtils() {

    }

    public static String getValue(ModelControllerClient client, String key) {
        ModelNode op = new ModelNode();
        op.get(ModelDescriptionConstants.OP).set(ModelDescriptionConstants.READ_ATTRIBUTE_OPERATION);
        op.get(ModelDescriptionConstants.NAME).set(key);
        ModelNode result = Client.execute(client, op);
        if (result != null) {
            return result.get(ModelDescriptionConstants.RESULT).asString();
        } else {
            return null;
        }
    }

    public static String getValue(ModelNode result, String key) {
        return result.get(key).asString();
    }
    
    public static Boolean getBooleanValue(ModelNode result, String key) {
        return result.get(key).asBoolean();
    }
    
    public static Long getLongValue(ModelNode result, String key) {
        return result.get(key).asLong();
    }

}
