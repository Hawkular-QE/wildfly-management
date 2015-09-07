package org.hawkular.qe.wildfly.management.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.hawkular.qe.wildfly.management.client.StandaloneMgmtClient;
import org.jboss.as.controller.client.ModelControllerClient;
import org.jboss.as.controller.descriptions.ModelDescriptionConstants;
import org.jboss.dmr.ModelNode;

/**
 * @author jkandasa@redhat.com (Jeeva Kandasamy)
 */
public class Deployment {
    private String name;
    private String content;
    private boolean enabled;
    private Long enabledTime;
    private String enabledTimestamp;
    private String owner;
    private Boolean persistent;
    private String runtimeName;
    private String subdeployment;

    public Deployment() {

    }

    public Deployment(ModelControllerClient modelControllerClient, String name) {
        ModelNode op = new ModelNode();
        op.get(ModelDescriptionConstants.OP).set(ModelDescriptionConstants.READ_RESOURCE_OPERATION);
        ModelNode address = op.get(ModelDescriptionConstants.ADDRESS);
        address.add(ModelDescriptionConstants.DEPLOYMENT, name);
        ModelNode result = null;
        try{
            result = StandaloneMgmtClient.execute(modelControllerClient, op);
        }catch(IllegalStateException ex){
            throw ex;
        }
        
        ModelNode data = result.get(ModelDescriptionConstants.RESULT);
        this.setName(name);
        this.setContent(ModelUtils.getValue(data, ModelDescriptionConstants.CONTENT));
        this.setEnabled(ModelUtils.getBooleanValue(data, ModelDescriptionConstants.ENABLED));
        this.setEnabledTime(ModelUtils.getLongValue(data, ModelDescriptionConstants.ENABLED_TIME));
        this.setEnabledTimestamp(ModelUtils.getValue(data, ModelDescriptionConstants.ENABLED_TIMESTAMP));
        this.setOwner(ModelUtils.getValue(data, ModelDescriptionConstants.OWNER));
        this.setPersistent(ModelUtils.getBooleanValue(data, ModelDescriptionConstants.PERSISTENT));
        this.setRuntimeName(ModelUtils.getValue(data, ModelDescriptionConstants.RUNTIME_NAME));
        this.setSubdeployment(ModelUtils.getValue(data, ModelDescriptionConstants.SUBDEPLOYMENT));
    }

    public List<Deployment> getDeployments(ModelControllerClient modelControllerClient) {
        ModelNode op = new ModelNode();
        op.get(ModelDescriptionConstants.OP).set(ModelDescriptionConstants.READ_CHILDREN_NAMES_OPERATION);
        op.get(ModelDescriptionConstants.CHILD_TYPE).set(ModelDescriptionConstants.DEPLOYMENT);
        ModelNode result = StandaloneMgmtClient.execute(modelControllerClient, op);
        final List<ModelNode> deploymentsModelNode = (result.hasDefined(ModelDescriptionConstants.RESULT) ? result
                .get(ModelDescriptionConstants.RESULT).asList() : Collections.<ModelNode> emptyList());
        List<Deployment> deployments = new ArrayList<Deployment>();
        for (ModelNode n : deploymentsModelNode) {
            deployments.add(new Deployment(n.asString()));
        }
        return deployments;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public Deployment(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Long getEnabledTime() {
        return enabledTime;
    }

    public void setEnabledTime(Long enabledTime) {
        this.enabledTime = enabledTime;
    }

    public String getEnabledTimestamp() {
        return enabledTimestamp;
    }

    public void setEnabledTimestamp(String enabledTimestamp) {
        this.enabledTimestamp = enabledTimestamp;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Boolean getPersistent() {
        return persistent;
    }

    public void setPersistent(Boolean persistent) {
        this.persistent = persistent;
    }

    public String getRuntimeName() {
        return runtimeName;
    }

    public void setRuntimeName(String runtimeName) {
        this.runtimeName = runtimeName;
    }

    public String getSubdeployment() {
        return subdeployment;
    }

    public void setSubdeployment(String subdeployment) {
        this.subdeployment = subdeployment;
    }
}
