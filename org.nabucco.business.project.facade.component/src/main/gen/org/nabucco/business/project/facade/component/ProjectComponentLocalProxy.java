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

import org.nabucco.business.project.facade.component.ProjectComponent;
import org.nabucco.business.project.facade.service.maintain.MaintainProject;
import org.nabucco.business.project.facade.service.produce.ProduceProject;
import org.nabucco.business.project.facade.service.resolve.ResolveProject;
import org.nabucco.business.project.facade.service.search.SearchProject;
import org.nabucco.framework.base.facade.exception.service.ServiceException;
import org.nabucco.framework.base.facade.service.componentrelation.ComponentRelationService;
import org.nabucco.framework.base.facade.service.queryfilter.QueryFilterService;

/**
 * ProjectComponentLocalProxy<p/>Component for Project Management.<p/>
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2010-11-30
 */
public class ProjectComponentLocalProxy implements ProjectComponent {

    private static final long serialVersionUID = 1L;

    private final ProjectComponentLocal delegate;

    /**
     * Constructs a new ProjectComponentLocalProxy instance.
     *
     * @param delegate the ProjectComponentLocal.
     */
    public ProjectComponentLocalProxy(ProjectComponentLocal delegate) {
        super();
        if ((delegate == null)) {
            throw new IllegalArgumentException("Cannot create local proxy for component [null].");
        }
        this.delegate = delegate;
    }

    @Override
    public String getId() {
        return this.delegate.getId();
    }

    @Override
    public String getName() {
        return this.delegate.getName();
    }

    @Override
    public String getJndiName() {
        return this.delegate.getJndiName();
    }

    @Override
    public ComponentRelationService getComponentRelationService() throws ServiceException {
        return this.delegate.getComponentRelationServiceLocal();
    }

    @Override
    public QueryFilterService getQueryFilterService() throws ServiceException {
        return this.delegate.getQueryFilterServiceLocal();
    }

    @Override
    public String toString() {
        return this.delegate.toString();
    }

    @Override
    public MaintainProject getMaintainProject() throws ServiceException {
        return this.delegate.getMaintainProjectLocal();
    }

    @Override
    public ProduceProject getProduceProject() throws ServiceException {
        return this.delegate.getProduceProjectLocal();
    }

    @Override
    public ResolveProject getResolveProject() throws ServiceException {
        return this.delegate.getResolveProjectLocal();
    }

    @Override
    public SearchProject getSearchProject() throws ServiceException {
        return this.delegate.getSearchProjectLocal();
    }
}
