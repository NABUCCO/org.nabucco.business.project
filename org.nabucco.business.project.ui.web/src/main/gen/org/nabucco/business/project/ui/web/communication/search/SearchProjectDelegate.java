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
package org.nabucco.business.project.ui.web.communication.search;

import org.nabucco.business.project.facade.message.ProjectCharacteristicListMsg;
import org.nabucco.business.project.facade.message.ProjectPositionAssigneeSearchMsg;
import org.nabucco.business.project.facade.message.ProjectSpecificationListMsg;
import org.nabucco.business.project.facade.message.ResolvedProjectPositionAssigneeMsg;
import org.nabucco.business.project.facade.message.search.ProjectPositionAssignmentIdsSearchRq;
import org.nabucco.business.project.facade.message.search.ProjectPositionAssignmentSearchRq;
import org.nabucco.business.project.facade.message.search.ProjectSearchRq;
import org.nabucco.business.project.facade.message.search.ProjectSpecificationSearchRq;
import org.nabucco.business.project.facade.service.search.SearchProject;
import org.nabucco.framework.base.facade.datatype.NabuccoSystem;
import org.nabucco.framework.base.facade.datatype.context.ServiceSubContext;
import org.nabucco.framework.base.facade.datatype.session.NabuccoSession;
import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.ui.web.communication.ServiceDelegateSupport;

/**
 * SearchProjectDelegate<p/>Search Service for Project<p/>
 *
 * @version 1.0
 * @author Nicolas Moser, PRODYNA AG, 2011-09-26
 */
public class SearchProjectDelegate extends ServiceDelegateSupport {

    private SearchProject service;

    /**
     * Constructs a new SearchProjectDelegate instance.
     *
     * @param service the SearchProject.
     */
    public SearchProjectDelegate(SearchProject service) {
        super();
        this.service = service;
    }

    /**
     * SearchProjectCharacteristic.
     *
     * @param subContexts the ServiceSubContext....
     * @param session the NabuccoSession.
     * @param message the ProjectSearchRq.
     * @return the ProjectCharacteristicListMsg.
     * @throws SearchException
     */
    public ProjectCharacteristicListMsg searchProjectCharacteristic(ProjectSearchRq message, NabuccoSession session,
            ServiceSubContext... subContexts) throws SearchException {
        ServiceRequest<ProjectSearchRq> request = new ServiceRequest<ProjectSearchRq>(super.createServiceContext(
                session, subContexts));
        request.setRequestMessage(message);
        ServiceResponse<ProjectCharacteristicListMsg> response = null;
        Exception exception = null;
        if ((this.service != null)) {
            super.handleRequest(request, session);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.searchProjectCharacteristic(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(SearchProject.class, "searchProjectCharacteristic", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response, session);
                return response.getResponseMessage();
            }
        }
        throw new SearchException("Cannot execute service operation: SearchProject.searchProjectCharacteristic");
    }

    /**
     * SearchProjectSpecification.
     *
     * @param subContexts the ServiceSubContext....
     * @param session the NabuccoSession.
     * @param message the ProjectSpecificationSearchRq.
     * @return the ProjectSpecificationListMsg.
     * @throws SearchException
     */
    public ProjectSpecificationListMsg searchProjectSpecification(ProjectSpecificationSearchRq message,
            NabuccoSession session, ServiceSubContext... subContexts) throws SearchException {
        ServiceRequest<ProjectSpecificationSearchRq> request = new ServiceRequest<ProjectSpecificationSearchRq>(
                super.createServiceContext(session, subContexts));
        request.setRequestMessage(message);
        ServiceResponse<ProjectSpecificationListMsg> response = null;
        Exception exception = null;
        if ((this.service != null)) {
            super.handleRequest(request, session);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.searchProjectSpecification(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(SearchProject.class, "searchProjectSpecification", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response, session);
                return response.getResponseMessage();
            }
        }
        throw new SearchException("Cannot execute service operation: SearchProject.searchProjectSpecification");
    }

    /**
     * SearchProjectPositionAssignments.
     *
     * @param subContexts the ServiceSubContext....
     * @param session the NabuccoSession.
     * @param message the ProjectPositionAssignmentSearchRq.
     * @return the ProjectPositionAssigneeSearchMsg.
     * @throws SearchException
     */
    public ProjectPositionAssigneeSearchMsg searchProjectPositionAssignments(ProjectPositionAssignmentSearchRq message,
            NabuccoSession session, ServiceSubContext... subContexts) throws SearchException {
        ServiceRequest<ProjectPositionAssignmentSearchRq> request = new ServiceRequest<ProjectPositionAssignmentSearchRq>(
                super.createServiceContext(session, subContexts));
        request.setRequestMessage(message);
        ServiceResponse<ProjectPositionAssigneeSearchMsg> response = null;
        Exception exception = null;
        if ((this.service != null)) {
            super.handleRequest(request, session);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.searchProjectPositionAssignments(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(SearchProject.class, "searchProjectPositionAssignments", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response, session);
                return response.getResponseMessage();
            }
        }
        throw new SearchException("Cannot execute service operation: SearchProject.searchProjectPositionAssignments");
    }

    /**
     * SearchForAssigneeRelatedElements.
     *
     * @param subContexts the ServiceSubContext....
     * @param session the NabuccoSession.
     * @param message the ProjectPositionAssignmentIdsSearchRq.
     * @return the ResolvedProjectPositionAssigneeMsg.
     * @throws SearchException
     */
    public ResolvedProjectPositionAssigneeMsg searchForAssigneeRelatedElements(
            ProjectPositionAssignmentIdsSearchRq message, NabuccoSession session, ServiceSubContext... subContexts)
            throws SearchException {
        ServiceRequest<ProjectPositionAssignmentIdsSearchRq> request = new ServiceRequest<ProjectPositionAssignmentIdsSearchRq>(
                super.createServiceContext(session, subContexts));
        request.setRequestMessage(message);
        ServiceResponse<ResolvedProjectPositionAssigneeMsg> response = null;
        Exception exception = null;
        if ((this.service != null)) {
            super.handleRequest(request, session);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.searchForAssigneeRelatedElements(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(SearchProject.class, "searchForAssigneeRelatedElements", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response, session);
                return response.getResponseMessage();
            }
        }
        throw new SearchException("Cannot execute service operation: SearchProject.searchForAssigneeRelatedElements");
    }
}
