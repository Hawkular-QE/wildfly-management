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

import java.io.File;
import java.net.URL;

import org.apache.commons.io.FilenameUtils;
import org.hawkular.qe.wildfly.management.deployment.Utils.Action;
import org.jboss.as.controller.client.ModelControllerClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author jkandasa@redhat.com (Jeeva Kandasamy)
 */
public class DeploymentActionCommon {

    protected static final Logger _logger = LoggerFactory.getLogger(DeploymentActionCommon.class.getName());

    private Action action;
    private ModelControllerClient modelControllerClient = null;
    private File file;
    private String archiveName;
    private URL url;

    public DeploymentActionCommon(ModelControllerClient modelControllerClient, Action action, File file) {
        this.modelControllerClient = modelControllerClient;
        this.action = action;
        this.file = file;
        this.archiveName = file.getName();
    }

    public DeploymentActionCommon(ModelControllerClient modelControllerClient, Action action, URL url) {
        this.modelControllerClient = modelControllerClient;
        this.action = action;
        this.url = url;
        this.archiveName = FilenameUtils.getName(url.toString());
    }

    public DeploymentActionCommon(ModelControllerClient modelControllerClient, Action action, String archiveName) {
        this.modelControllerClient = modelControllerClient;
        this.action = action;
        this.archiveName = archiveName;
    }

    public Action getAction() {
        return action;
    }

    public ModelControllerClient getModelControllerClient() {
        return modelControllerClient;
    }

    public File getFile() {
        return file;
    }

    public String getArchiveName() {
        return archiveName;
    }

    public URL getUrl() {
        return url;
    }
}
