package org.hawkular.qe.wildfly.management.deployment;

import java.util.UUID;

import org.hawkular.qe.wildfly.management.deployment.Utils.Status;

/**
 * @author jkandasa@redhat.com (Jeeva Kandasamy)
 */
public class DeploymentExecutionStatus {
    private Status status;
    private UUID uuid;
    private Throwable throwable;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

    public UUID getUUID() {
        return uuid;
    }

    public void setUUID(UUID uuid) {
        this.uuid = uuid;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Status:").append(this.status.toString());
        builder.append(", UUID:").append(this.uuid);
        builder.append(", Error: ").append(this.throwable != null ? this.throwable.getMessage() : null);
        return builder.toString();
    }

}
