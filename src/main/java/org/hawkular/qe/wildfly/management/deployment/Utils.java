package org.hawkular.qe.wildfly.management.deployment;

/**
 * @author jkandasa@redhat.com (Jeeva Kandasamy)
 */
public class Utils {
    private Utils() {

    }

    public enum Status {
        NOT_EXECUTED,
        FAILED,
        ROLLED_BACK,
        CONFIGURATION_MODIFIED_REQUIRES_RESTART,
        EXECUTED,
        UNKNOWN;
    }

    public enum Action {
        DEPLOY,
        REDEPLOY,
        UNDEPLOY,
        REMOVE,
        ADD,
        ENABLE,
        DISABLE;
    }

}
