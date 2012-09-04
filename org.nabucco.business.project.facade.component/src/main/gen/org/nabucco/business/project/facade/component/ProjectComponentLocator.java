/*
 * Copyright 2012 PRODYNA AG
 * 
 * Licensed under the Eclipse Public License (EPL), Version 1.0 (the "License"); you may not use
 * this file except in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.opensource.org/licenses/eclipse-1.0.php or
 * http://www.nabucco.org/License.html
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */
package org.nabucco.business.project.facade.component;

import org.nabucco.framework.base.facade.component.connection.ConnectionException;
import org.nabucco.framework.base.facade.component.locator.ComponentLocator;
import org.nabucco.framework.base.facade.component.locator.ComponentLocatorSupport;

/**
 * Locator for ProjectComponent.
 *
 * @author NABUCCO Generator, PRODYNA AG
 */
public class ProjectComponentLocator extends ComponentLocatorSupport<ProjectComponent> implements
        ComponentLocator<ProjectComponent> {

    private static ProjectComponentLocator instance;

    /**
     * Constructs a new ProjectComponentLocator instance.
     *
     * @param component the Class<ProjectComponent>.
     * @param jndiName the String.
     */
    private ProjectComponentLocator(String jndiName, Class<ProjectComponent> component) {
        super(jndiName, component);
    }

    @Override
    public ProjectComponent getComponent() throws ConnectionException {
        ProjectComponent component = super.getComponent();
        if ((component instanceof ProjectComponentLocal)) {
            return new ProjectComponentLocalProxy(((ProjectComponentLocal) component));
        }
        return component;
    }

    /**
     * Getter for the Instance.
     *
     * @return the ProjectComponentLocator.
     */
    public static ProjectComponentLocator getInstance() {
        if ((instance == null)) {
            instance = new ProjectComponentLocator(ProjectComponent.JNDI_NAME, ProjectComponent.class);
        }
        return instance;
    }
}
