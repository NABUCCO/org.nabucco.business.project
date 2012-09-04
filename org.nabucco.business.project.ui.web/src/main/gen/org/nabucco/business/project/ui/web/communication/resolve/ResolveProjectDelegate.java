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
package org.nabucco.business.project.ui.web.communication.resolve;

import org.nabucco.business.project.facade.message.ProjectCharacteristicMsg;
import org.nabucco.business.project.facade.message.ProjectPositionAssigneeMsg;
import org.nabucco.business.project.facade.message.ProjectPositionMsg;
import org.nabucco.business.project.facade.message.ProjectSpecificationMsg;
import org.nabucco.business.project.facade.message.ProjectTaskMsg;
import org.nabucco.business.project.facade.service.resolve.ResolveProject;
import org.nabucco.framework.base.facade.datatype.NabuccoSystem;
import org.nabucco.framework.base.facade.datatype.context.ServiceSubContext;
import org.nabucco.framework.base.facade.datatype.session.NabuccoSession;
import org.nabucco.framework.base.facade.exception.service.ResolveException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.ui.web.communication.ServiceDelegateSupport;

/**
 * ResolveProjectDelegate<p/>Resolve Service for Project<p/>
 *
 * @version 1.0
 * @author Nicolas Moser, PRODYNA AG, 2011-09-26
 */
public class ResolveProjectDelegate extends ServiceDelegateSupport {

    private ResolveProject service;

    /**
     * Constructs a new ResolveProjectDelegate instance.
     *
     * @param service the ResolveProject.
     */
    public ResolveProjectDelegate(ResolveProject service) {
        super();
        this.service = service;
    }

    /**
     * ResolveProjectCharacteristic.
     *
     * @param subContexts the ServiceSubContext....
     * @param session the NabuccoSession.
     * @param message the ProjectCharacteristicMsg.
     * @return the ProjectCharacteristicMsg.
     * @throws ResolveException
     */
    public ProjectCharacteristicMsg resolveProjectCharacteristic(ProjectCharacteristicMsg message,
            NabuccoSession session, ServiceSubContext... subContexts) throws ResolveException {
        ServiceRequest<ProjectCharacteristicMsg> request = new ServiceRequest<ProjectCharacteristicMsg>(
                super.createServiceContext(session, subContexts));
        request.setRequestMessage(message);
        ServiceResponse<ProjectCharacteristicMsg> response = null;
        Exception exception = null;
        if ((this.service != null)) {
            super.handleRequest(request, session);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.resolveProjectCharacteristic(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ResolveProject.class, "resolveProjectCharacteristic", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response, session);
                return response.getResponseMessage();
            }
        }
        throw new ResolveException("Cannot execute service operation: ResolveProject.resolveProjectCharacteristic");
    }

    /**
     * ResolveProjectPosition.
     *
     * @param subContexts the ServiceSubContext....
     * @param session the NabuccoSession.
     * @param message the ProjectPositionMsg.
     * @return the ProjectPositionMsg.
     * @throws ResolveException
     */
    public ProjectPositionMsg resolveProjectPosition(ProjectPositionMsg message, NabuccoSession session,
            ServiceSubContext... subContexts) throws ResolveException {
        ServiceRequest<ProjectPositionMsg> request = new ServiceRequest<ProjectPositionMsg>(super.createServiceContext(
                session, subContexts));
        request.setRequestMessage(message);
        ServiceResponse<ProjectPositionMsg> response = null;
        Exception exception = null;
        if ((this.service != null)) {
            super.handleRequest(request, session);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.resolveProjectPosition(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ResolveProject.class, "resolveProjectPosition", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response, session);
                return response.getResponseMessage();
            }
        }
        throw new ResolveException("Cannot execute service operation: ResolveProject.resolveProjectPosition");
    }

    /**
     * ResolveProjectPositionAssignee.
     *
     * @param subContexts the ServiceSubContext....
     * @param session the NabuccoSession.
     * @param message the ProjectPositionAssigneeMsg.
     * @return the ProjectPositionAssigneeMsg.
     * @throws ResolveException
     */
    public ProjectPositionAssigneeMsg resolveProjectPositionAssignee(ProjectPositionAssigneeMsg message,
            NabuccoSession session, ServiceSubContext... subContexts) throws ResolveException {
        ServiceRequest<ProjectPositionAssigneeMsg> request = new ServiceRequest<ProjectPositionAssigneeMsg>(
                super.createServiceContext(session, subContexts));
        request.setRequestMessage(message);
        ServiceResponse<ProjectPositionAssigneeMsg> response = null;
        Exception exception = null;
        if ((this.service != null)) {
            super.handleRequest(request, session);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.resolveProjectPositionAssignee(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ResolveProject.class, "resolveProjectPositionAssignee", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response, session);
                return response.getResponseMessage();
            }
        }
        throw new ResolveException("Cannot execute service operation: ResolveProject.resolveProjectPositionAssignee");
    }

    /**
     * ResolveProjectTask.
     *
     * @param subContexts the ServiceSubContext....
     * @param session the NabuccoSession.
     * @param message the ProjectTaskMsg.
     * @return the ProjectTaskMsg.
     * @throws ResolveException
     */
    public ProjectTaskMsg resolveProjectTask(ProjectTaskMsg message, NabuccoSession session,
            ServiceSubContext... subContexts) throws ResolveException {
        ServiceRequest<ProjectTaskMsg> request = new ServiceRequest<ProjectTaskMsg>(super.createServiceContext(session,
                subContexts));
        request.setRequestMessage(message);
        ServiceResponse<ProjectTaskMsg> response = null;
        Exception exception = null;
        if ((this.service != null)) {
            super.handleRequest(request, session);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.resolveProjectTask(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ResolveProject.class, "resolveProjectTask", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response, session);
                return response.getResponseMessage();
            }
        }
        throw new ResolveException("Cannot execute service operation: ResolveProject.resolveProjectTask");
    }

    /**
     * ResolveProjectSpecification.
     *
     * @param subContexts the ServiceSubContext....
     * @param session the NabuccoSession.
     * @param message the ProjectSpecificationMsg.
     * @return the ProjectSpecificationMsg.
     * @throws ResolveException
     */
    public ProjectSpecificationMsg resolveProjectSpecification(ProjectSpecificationMsg message, NabuccoSession session,
            ServiceSubContext... subContexts) throws ResolveException {
        ServiceRequest<ProjectSpecificationMsg> request = new ServiceRequest<ProjectSpecificationMsg>(
                super.createServiceContext(session, subContexts));
        request.setRequestMessage(message);
        ServiceResponse<ProjectSpecificationMsg> response = null;
        Exception exception = null;
        if ((this.service != null)) {
            super.handleRequest(request, session);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.resolveProjectSpecification(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ResolveProject.class, "resolveProjectSpecification", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response, session);
                return response.getResponseMessage();
            }
        }
        throw new ResolveException("Cannot execute service operation: ResolveProject.resolveProjectSpecification");
    }
}
