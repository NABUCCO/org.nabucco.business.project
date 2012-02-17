/*
 * Copyright 2012 PRODYNA AG
 *
 * Licensed under the Eclipse Public License (EPL), Version 1.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.opensource.org/licenses/eclipse-1.0.php or
 * http://www.nabucco.org/License.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.nabucco.business.project.facade.component;

import org.nabucco.business.project.facade.service.maintain.MaintainProject;
import org.nabucco.business.project.facade.service.produce.ProduceProject;
import org.nabucco.business.project.facade.service.resolve.ResolveProject;
import org.nabucco.business.project.facade.service.search.SearchProject;
import org.nabucco.framework.base.facade.exception.service.ServiceException;
import org.nabucco.framework.base.facade.service.componentrelation.ComponentRelationService;
import org.nabucco.framework.base.facade.service.queryfilter.QueryFilterService;

/**
 * ProjectComponentLocal<p/>Component for Project Management.<p/>
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2010-11-30
 */
public interface ProjectComponentLocal extends ProjectComponent {

    /**
     * Getter for the ComponentRelationServiceLocal.
     *
     * @return the ComponentRelationService.
     * @throws ServiceException
     */
    ComponentRelationService getComponentRelationServiceLocal() throws ServiceException;

    /**
     * Getter for the QueryFilterServiceLocal.
     *
     * @return the QueryFilterService.
     * @throws ServiceException
     */
    QueryFilterService getQueryFilterServiceLocal() throws ServiceException;

    /**
     * Getter for the MaintainProjectLocal.
     *
     * @return the MaintainProject.
     * @throws ServiceException
     */
    MaintainProject getMaintainProjectLocal() throws ServiceException;

    /**
     * Getter for the ProduceProjectLocal.
     *
     * @return the ProduceProject.
     * @throws ServiceException
     */
    ProduceProject getProduceProjectLocal() throws ServiceException;

    /**
     * Getter for the ResolveProjectLocal.
     *
     * @return the ResolveProject.
     * @throws ServiceException
     */
    ResolveProject getResolveProjectLocal() throws ServiceException;

    /**
     * Getter for the SearchProjectLocal.
     *
     * @return the SearchProject.
     * @throws ServiceException
     */
    SearchProject getSearchProjectLocal() throws ServiceException;
}
