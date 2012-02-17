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
package org.nabucco.business.project.impl.service.search;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import org.nabucco.business.project.facade.message.ProjectCharacteristicListMsg;
import org.nabucco.business.project.facade.message.ProjectPositionAssigneeSearchMsg;
import org.nabucco.business.project.facade.message.ProjectSpecificationListMsg;
import org.nabucco.business.project.facade.message.ResolvedProjectPositionAssigneeMsg;
import org.nabucco.business.project.facade.message.search.ProjectPositionAssignmentIdsSearchRq;
import org.nabucco.business.project.facade.message.search.ProjectPositionAssignmentSearchRq;
import org.nabucco.business.project.facade.message.search.ProjectSearchRq;
import org.nabucco.business.project.facade.message.search.ProjectSpecificationSearchRq;
import org.nabucco.business.project.facade.service.search.SearchProject;
import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.injection.InjectionException;
import org.nabucco.framework.base.facade.service.injection.InjectionProvider;
import org.nabucco.framework.base.impl.service.ServiceSupport;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManager;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManagerFactory;

/**
 * SearchProjectImpl<p/>Search Service for Project<p/>
 *
 * @version 1.0
 * @author Nicolas Moser, PRODYNA AG, 2011-09-26
 */
public class SearchProjectImpl extends ServiceSupport implements SearchProject {

    private static final long serialVersionUID = 1L;

    private static final String ID = "SearchProject";

    private static Map<String, String[]> ASPECTS;

    private SearchProjectCharacteristicServiceHandler searchProjectCharacteristicServiceHandler;

    private SearchProjectSpecificationServiceHandler searchProjectSpecificationServiceHandler;

    private SearchProjectPositionAssignmentsServiceHandler searchProjectPositionAssignmentsServiceHandler;

    private SearchForAssigneeRelatedElementsServiceHandler searchForAssigneeRelatedElementsServiceHandler;

    private EntityManager entityManager;

    /** Constructs a new SearchProjectImpl instance. */
    public SearchProjectImpl() {
        super();
    }

    @Override
    public void postConstruct() {
        super.postConstruct();
        InjectionProvider injector = InjectionProvider.getInstance(ID);
        PersistenceManager persistenceManager = PersistenceManagerFactory.getInstance().createPersistenceManager(
                this.entityManager, super.getLogger());
        this.searchProjectCharacteristicServiceHandler = injector.inject(SearchProjectCharacteristicServiceHandler
                .getId());
        if ((this.searchProjectCharacteristicServiceHandler != null)) {
            this.searchProjectCharacteristicServiceHandler.setPersistenceManager(persistenceManager);
            this.searchProjectCharacteristicServiceHandler.setLogger(super.getLogger());
        }
        this.searchProjectSpecificationServiceHandler = injector.inject(SearchProjectSpecificationServiceHandler
                .getId());
        if ((this.searchProjectSpecificationServiceHandler != null)) {
            this.searchProjectSpecificationServiceHandler.setPersistenceManager(persistenceManager);
            this.searchProjectSpecificationServiceHandler.setLogger(super.getLogger());
        }
        this.searchProjectPositionAssignmentsServiceHandler = injector
                .inject(SearchProjectPositionAssignmentsServiceHandler.getId());
        if ((this.searchProjectPositionAssignmentsServiceHandler != null)) {
            this.searchProjectPositionAssignmentsServiceHandler.setPersistenceManager(persistenceManager);
            this.searchProjectPositionAssignmentsServiceHandler.setLogger(super.getLogger());
        }
        this.searchForAssigneeRelatedElementsServiceHandler = injector
                .inject(SearchForAssigneeRelatedElementsServiceHandler.getId());
        if ((this.searchForAssigneeRelatedElementsServiceHandler != null)) {
            this.searchForAssigneeRelatedElementsServiceHandler.setPersistenceManager(persistenceManager);
            this.searchForAssigneeRelatedElementsServiceHandler.setLogger(super.getLogger());
        }
    }

    @Override
    public void preDestroy() {
        super.preDestroy();
    }

    @Override
    public String[] getAspects(String operationName) {
        if ((ASPECTS == null)) {
            ASPECTS = new HashMap<String, String[]>();
            ASPECTS.put("searchProjectCharacteristic", new String[] { "org.nabucco.aspect.resolving" });
            ASPECTS.put("searchProjectSpecification", new String[] { "org.nabucco.aspect.resolving" });
            ASPECTS.put("searchProjectPositionAssignments", new String[] { "org.nabucco.aspect.resolving" });
            ASPECTS.put("searchForAssigneeRelatedElements", new String[] { "org.nabucco.aspect.resolving" });
        }
        String[] aspects = ASPECTS.get(operationName);
        if ((aspects == null)) {
            return ServiceSupport.NO_ASPECTS;
        }
        return Arrays.copyOf(aspects, aspects.length);
    }

    @Override
    public ServiceResponse<ProjectCharacteristicListMsg> searchProjectCharacteristic(ServiceRequest<ProjectSearchRq> rq)
            throws SearchException {
        if ((this.searchProjectCharacteristicServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for searchProjectCharacteristic().");
            throw new InjectionException("No service implementation configured for searchProjectCharacteristic().");
        }
        ServiceResponse<ProjectCharacteristicListMsg> rs;
        this.searchProjectCharacteristicServiceHandler.init();
        rs = this.searchProjectCharacteristicServiceHandler.invoke(rq);
        this.searchProjectCharacteristicServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<ProjectSpecificationListMsg> searchProjectSpecification(
            ServiceRequest<ProjectSpecificationSearchRq> rq) throws SearchException {
        if ((this.searchProjectSpecificationServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for searchProjectSpecification().");
            throw new InjectionException("No service implementation configured for searchProjectSpecification().");
        }
        ServiceResponse<ProjectSpecificationListMsg> rs;
        this.searchProjectSpecificationServiceHandler.init();
        rs = this.searchProjectSpecificationServiceHandler.invoke(rq);
        this.searchProjectSpecificationServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<ProjectPositionAssigneeSearchMsg> searchProjectPositionAssignments(
            ServiceRequest<ProjectPositionAssignmentSearchRq> rq) throws SearchException {
        if ((this.searchProjectPositionAssignmentsServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for searchProjectPositionAssignments().");
            throw new InjectionException("No service implementation configured for searchProjectPositionAssignments().");
        }
        ServiceResponse<ProjectPositionAssigneeSearchMsg> rs;
        this.searchProjectPositionAssignmentsServiceHandler.init();
        rs = this.searchProjectPositionAssignmentsServiceHandler.invoke(rq);
        this.searchProjectPositionAssignmentsServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<ResolvedProjectPositionAssigneeMsg> searchForAssigneeRelatedElements(
            ServiceRequest<ProjectPositionAssignmentIdsSearchRq> rq) throws SearchException {
        if ((this.searchForAssigneeRelatedElementsServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for searchForAssigneeRelatedElements().");
            throw new InjectionException("No service implementation configured for searchForAssigneeRelatedElements().");
        }
        ServiceResponse<ResolvedProjectPositionAssigneeMsg> rs;
        this.searchForAssigneeRelatedElementsServiceHandler.init();
        rs = this.searchForAssigneeRelatedElementsServiceHandler.invoke(rq);
        this.searchForAssigneeRelatedElementsServiceHandler.finish();
        return rs;
    }
}
