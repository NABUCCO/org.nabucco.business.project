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

import org.nabucco.business.project.facade.service.maintain.MaintainProject;
import org.nabucco.business.project.facade.service.produce.ProduceProject;
import org.nabucco.business.project.facade.service.resolve.ResolveProject;
import org.nabucco.business.project.facade.service.search.SearchProject;
import org.nabucco.framework.base.facade.component.Component;
import org.nabucco.framework.base.facade.exception.service.ServiceException;

/**
 * ProjectComponent<p/>Component for Project Management.<p/>
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2010-11-30
 */
public interface ProjectComponent extends Component {

    final String COMPONENT_NAME = "org.nabucco.business.project";

    final String COMPONENT_PREFIX = "proj";

    final String JNDI_NAME = ((((JNDI_PREFIX + "/") + COMPONENT_NAME) + "/") + "org.nabucco.business.project.facade.component.ProjectComponent");

    /**
     * Getter for the MaintainProject.
     *
     * @return the MaintainProject.
     * @throws ServiceException
     */
    MaintainProject getMaintainProject() throws ServiceException;

    /**
     * Getter for the ProduceProject.
     *
     * @return the ProduceProject.
     * @throws ServiceException
     */
    ProduceProject getProduceProject() throws ServiceException;

    /**
     * Getter for the ResolveProject.
     *
     * @return the ResolveProject.
     * @throws ServiceException
     */
    ResolveProject getResolveProject() throws ServiceException;

    /**
     * Getter for the SearchProject.
     *
     * @return the SearchProject.
     * @throws ServiceException
     */
    SearchProject getSearchProject() throws ServiceException;
}
