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
