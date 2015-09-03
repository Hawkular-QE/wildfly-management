package org.hawkular.qe.wildfly.management;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.sasl.RealmCallback;

import org.hawkular.qe.wildfly.management.model.Deployment;
import org.hawkular.qe.wildfly.management.model.ServerInfo;
import org.jboss.as.controller.client.ModelControllerClient;
import org.jboss.as.controller.descriptions.ModelDescriptionConstants;
import org.jboss.dmr.ModelNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author jkandasa@redhat.com (Jeeva Kandasamy)
 */
public class Client {
    private static final Logger _logger = LoggerFactory.getLogger(Client.class.getName());
    public static final String MANAGEMENT_REALM = "ManagementRealm";

    private static ModelControllerClient modelControllerClient = null;

    public Client(String host, int port, String userid, String password) throws UnknownHostException {
        this(host, port, userid, password, MANAGEMENT_REALM);
    }

    public Client(String host, int port, String userid, String password, String Realm) throws UnknownHostException {
        modelControllerClient = createClient(InetAddress.getByName(host), port, userid, password, Realm);
    }

    public void close() {
        try {
            modelControllerClient.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public ModelNode execute(ModelNode operation) {
        return execute(modelControllerClient, operation);
    }

    public static ModelNode execute(ModelControllerClient client, ModelNode operation) {
        try {
            final ModelNode result = client.execute(operation);
            if (result.hasDefined(ModelDescriptionConstants.OUTCOME)) {
                if (result.get(ModelDescriptionConstants.OUTCOME).asString().equals(ModelDescriptionConstants.SUCCESS)) {
                    return result;
                } else if (result.get(ModelDescriptionConstants.OUTCOME).asString()
                        .equals(ModelDescriptionConstants.FAILED)) {
                    throw new IllegalStateException(String.format(
                            "A failure occurred when checking existing deployments. Error: %s",
                            (result.hasDefined(ModelDescriptionConstants.FAILURE_DESCRIPTION) ? result.get(
                                    ModelDescriptionConstants.FAILURE_DESCRIPTION).asString() : "Unknown")));
                }
            } else {
                _logger.error("An unexpected response was found checking the deployment. Result: {}", result);
                throw new IllegalStateException(String.format(
                        "An unexpected response was found checking the deployment. Result: %s", result));
            }
            return result;
        } catch (IOException ex) {
            _logger.error("Error while executing an operation, Operation:[{}]", operation.toString(), ex);
            return null;
        }
    }

    private ModelControllerClient createClient(final InetAddress host, final int port, final String username,
            final String password, final String securityRealmName) {
        final CallbackHandler callbackHandler = new CallbackHandler() {
            public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
                for (Callback current : callbacks) {
                    if (current instanceof NameCallback) {
                        NameCallback ncb = (NameCallback) current;
                        ncb.setName(new String(username));
                    } else if (current instanceof PasswordCallback) {
                        PasswordCallback pcb = (PasswordCallback) current;
                        pcb.setPassword(password.toCharArray());
                    } else if (current instanceof RealmCallback) {
                        RealmCallback rcb = (RealmCallback) current;
                        rcb.setText(securityRealmName);
                    } else {
                        throw new UnsupportedCallbackException(current);
                    }
                }
            }
        };
        return ModelControllerClient.Factory.create(host, port, callbackHandler);
    }

    public ModelControllerClient getModelControllerClient() {
        return modelControllerClient;
    }

    //Operations

    //Get Server Information
    public ServerInfo getServerInfo() {
        return new ServerInfo(modelControllerClient);
    }

    //Get Deployments List
    public List<Deployment> getDeployments() {
        return new Deployment().getDeployments(modelControllerClient);
    }

    //Get Deployment
    public Deployment getDeployment(String name) {
        return new Deployment(modelControllerClient, name);
    }

}
