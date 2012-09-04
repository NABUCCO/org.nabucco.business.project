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
package org.nabucco.business.project.ui.rcp.communication.maintain;

import org.nabucco.business.project.facade.message.ProjectCharacteristicMsg;
import org.nabucco.business.project.facade.message.ProjectPositionAssigneeMsg;
import org.nabucco.business.project.facade.message.ProjectPositionMsg;
import org.nabucco.business.project.facade.message.ProjectSpecificationMsg;
import org.nabucco.business.project.facade.message.ProjectTaskMsg;
import org.nabucco.business.project.facade.service.maintain.MaintainProject;
import org.nabucco.framework.base.facade.datatype.NabuccoSystem;
import org.nabucco.framework.base.facade.datatype.context.ServiceSubContext;
import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.plugin.base.component.communication.ServiceDelegateSupport;

/**
 * MaintainProjectDelegate<p/>Maintain Service for Project<p/>
 *
 * @version 1.0
 * @author Nicolas Moser, PRODYNA AG, 2011-09-26
 */
public class MaintainProjectDelegate extends ServiceDelegateSupport {

    private MaintainProject service;

    /**
     * Constructs a new MaintainProjectDelegate instance.
     *
     * @param service the MaintainProject.
     */
    public MaintainProjectDelegate(MaintainProject service) {
        super();
        this.service = service;
    }

    /**
     * MaintainProjectCharacteristic.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the ProjectCharacteristicMsg.
     * @return the ProjectCharacteristicMsg.
     * @throws ClientException
     */
    public ProjectCharacteristicMsg maintainProjectCharacteristic(ProjectCharacteristicMsg message,
            ServiceSubContext... subContexts) throws ClientException {
        ServiceRequest<ProjectCharacteristicMsg> request = new ServiceRequest<ProjectCharacteristicMsg>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<ProjectCharacteristicMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.maintainProjectCharacteristic(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(MaintainProject.class, "maintainProjectCharacteristic", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: MaintainProject.maintainProjectCharacteristic");
    }

    /**
     * MaintainProjectPosition.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the ProjectPositionMsg.
     * @return the ProjectPositionMsg.
     * @throws ClientException
     */
    public ProjectPositionMsg maintainProjectPosition(ProjectPositionMsg message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<ProjectPositionMsg> request = new ServiceRequest<ProjectPositionMsg>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<ProjectPositionMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.maintainProjectPosition(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(MaintainProject.class, "maintainProjectPosition", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: MaintainProject.maintainProjectPosition");
    }

    /**
     * MaintainProjectPositionAssignee.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the ProjectPositionAssigneeMsg.
     * @return the ProjectPositionAssigneeMsg.
     * @throws ClientException
     */
    public ProjectPositionAssigneeMsg maintainProjectPositionAssignee(ProjectPositionAssigneeMsg message,
            ServiceSubContext... subContexts) throws ClientException {
        ServiceRequest<ProjectPositionAssigneeMsg> request = new ServiceRequest<ProjectPositionAssigneeMsg>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<ProjectPositionAssigneeMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.maintainProjectPositionAssignee(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(MaintainProject.class, "maintainProjectPositionAssignee", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: MaintainProject.maintainProjectPositionAssignee");
    }

    /**
     * MaintainProjectTask.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the ProjectTaskMsg.
     * @return the ProjectTaskMsg.
     * @throws ClientException
     */
    public ProjectTaskMsg maintainProjectTask(ProjectTaskMsg message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<ProjectTaskMsg> request = new ServiceRequest<ProjectTaskMsg>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<ProjectTaskMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.maintainProjectTask(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(MaintainProject.class, "maintainProjectTask", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: MaintainProject.maintainProjectTask");
    }

    /**
     * MaintainProjectSpecification.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the ProjectSpecificationMsg.
     * @return the ProjectSpecificationMsg.
     * @throws ClientException
     */
    public ProjectSpecificationMsg maintainProjectSpecification(ProjectSpecificationMsg message,
            ServiceSubContext... subContexts) throws ClientException {
        ServiceRequest<ProjectSpecificationMsg> request = new ServiceRequest<ProjectSpecificationMsg>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<ProjectSpecificationMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.maintainProjectSpecification(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(MaintainProject.class, "maintainProjectSpecification", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: MaintainProject.maintainProjectSpecification");
    }
}
