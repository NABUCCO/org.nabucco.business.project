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
package org.nabucco.business.project.impl.component;

import org.nabucco.business.project.facade.component.ProjectComponentLocal;
import org.nabucco.business.project.facade.component.ProjectComponentRemote;
import org.nabucco.business.project.facade.service.maintain.MaintainProject;
import org.nabucco.business.project.facade.service.produce.ProduceProject;
import org.nabucco.business.project.facade.service.resolve.ResolveProject;
import org.nabucco.business.project.facade.service.search.SearchProject;
import org.nabucco.framework.base.facade.component.handler.PostConstructHandler;
import org.nabucco.framework.base.facade.component.handler.PreDestroyHandler;
import org.nabucco.framework.base.facade.exception.service.ServiceException;
import org.nabucco.framework.base.facade.service.componentrelation.ComponentRelationService;
import org.nabucco.framework.base.facade.service.injection.InjectionProvider;
import org.nabucco.framework.base.facade.service.queryfilter.QueryFilterService;
import org.nabucco.framework.base.impl.component.ComponentSupport;

/**
 * ProjectComponentImpl<p/>Component for Project Management.<p/>
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2010-11-30
 */
public class ProjectComponentImpl extends ComponentSupport implements ProjectComponentLocal, ProjectComponentRemote {

    private static final long serialVersionUID = 1L;

    private static final String ID = "ProjectComponent";

    /** Constructs a new ProjectComponentImpl instance. */
    public ProjectComponentImpl() {
        super();
    }

    @Override
    public void postConstruct() {
        super.postConstruct();
        InjectionProvider injector = InjectionProvider.getInstance(ID);
        PostConstructHandler handler = injector.inject(PostConstructHandler.getId());
        if ((handler == null)) {
            if (super.getLogger().isDebugEnabled()) {
                super.getLogger().debug("No post construct handler configured for \'", ID, "\'.");
            }
            return;
        }
        handler.setLocatable(this);
        handler.setLogger(super.getLogger());
        handler.invoke();
    }

    @Override
    public void preDestroy() {
        super.preDestroy();
        InjectionProvider injector = InjectionProvider.getInstance(ID);
        PreDestroyHandler handler = injector.inject(PreDestroyHandler.getId());
        if ((handler == null)) {
            if (super.getLogger().isDebugEnabled()) {
                super.getLogger().debug("No pre destroy handler configured for \'", ID, "\'.");
            }
            return;
        }
        handler.setLocatable(this);
        handler.setLogger(super.getLogger());
        handler.invoke();
    }

    @Override
    public String getId() {
        return ID;
    }

    @Override
    public String getName() {
        return COMPONENT_NAME;
    }

    @Override
    public String getJndiName() {
        return JNDI_NAME;
    }

    @Override
    public ComponentRelationService getComponentRelationService() throws ServiceException {
        return super
                .lookup(ProjectComponentJndiNames.COMPONENT_RELATION_SERVICE_REMOTE, ComponentRelationService.class);
    }

    @Override
    public ComponentRelationService getComponentRelationServiceLocal() throws ServiceException {
        return super.lookup(ProjectComponentJndiNames.COMPONENT_RELATION_SERVICE_LOCAL, ComponentRelationService.class);
    }

    @Override
    public QueryFilterService getQueryFilterService() throws ServiceException {
        return super.lookup(ProjectComponentJndiNames.QUERY_FILTER_SERVICE_REMOTE, QueryFilterService.class);
    }

    @Override
    public QueryFilterService getQueryFilterServiceLocal() throws ServiceException {
        return super.lookup(ProjectComponentJndiNames.QUERY_FILTER_SERVICE_LOCAL, QueryFilterService.class);
    }

    @Override
    public MaintainProject getMaintainProjectLocal() throws ServiceException {
        return super.lookup(ProjectComponentJndiNames.MAINTAIN_PROJECT_LOCAL, MaintainProject.class);
    }

    @Override
    public MaintainProject getMaintainProject() throws ServiceException {
        return super.lookup(ProjectComponentJndiNames.MAINTAIN_PROJECT_REMOTE, MaintainProject.class);
    }

    @Override
    public ProduceProject getProduceProjectLocal() throws ServiceException {
        return super.lookup(ProjectComponentJndiNames.PRODUCE_PROJECT_LOCAL, ProduceProject.class);
    }

    @Override
    public ProduceProject getProduceProject() throws ServiceException {
        return super.lookup(ProjectComponentJndiNames.PRODUCE_PROJECT_REMOTE, ProduceProject.class);
    }

    @Override
    public ResolveProject getResolveProjectLocal() throws ServiceException {
        return super.lookup(ProjectComponentJndiNames.RESOLVE_PROJECT_LOCAL, ResolveProject.class);
    }

    @Override
    public ResolveProject getResolveProject() throws ServiceException {
        return super.lookup(ProjectComponentJndiNames.RESOLVE_PROJECT_REMOTE, ResolveProject.class);
    }

    @Override
    public SearchProject getSearchProjectLocal() throws ServiceException {
        return super.lookup(ProjectComponentJndiNames.SEARCH_PROJECT_LOCAL, SearchProject.class);
    }

    @Override
    public SearchProject getSearchProject() throws ServiceException {
        return super.lookup(ProjectComponentJndiNames.SEARCH_PROJECT_REMOTE, SearchProject.class);
    }
}
