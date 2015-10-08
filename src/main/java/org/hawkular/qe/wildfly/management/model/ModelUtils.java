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

import org.hawkular.qe.wildfly.management.client.StandaloneMgmtClient;
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
        ModelNode result = StandaloneMgmtClient.execute(client, op);
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
