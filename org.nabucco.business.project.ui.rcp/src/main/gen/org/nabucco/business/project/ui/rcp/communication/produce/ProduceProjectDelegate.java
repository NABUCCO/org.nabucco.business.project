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
package org.nabucco.business.project.ui.rcp.communication.produce;

import org.nabucco.business.project.facade.message.ProjectCharacteristicMsg;
import org.nabucco.business.project.facade.message.ProjectPositionAssigneeMsg;
import org.nabucco.business.project.facade.message.ProjectPositionMsg;
import org.nabucco.business.project.facade.message.ProjectRelationMsg;
import org.nabucco.business.project.facade.message.ProjectSpecificationMsg;
import org.nabucco.business.project.facade.message.ProjectTaskMsg;
import org.nabucco.business.project.facade.message.produce.ProjectCharacteristicPrototypeRq;
import org.nabucco.business.project.facade.message.produce.ProjectRelationPrototypeRq;
import org.nabucco.business.project.facade.service.produce.ProduceProject;
import org.nabucco.framework.base.facade.datatype.NabuccoSystem;
import org.nabucco.framework.base.facade.datatype.context.ServiceSubContext;
import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.base.facade.message.EmptyServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.plugin.base.component.communication.ServiceDelegateSupport;

/**
 * ProduceProjectDelegate<p/>Produce Service for the Project Component<p/>
 *
 * @version 1.0
 * @author Nicolas Moser, PRODYNA AG, 2011-09-26
 */
public class ProduceProjectDelegate extends ServiceDelegateSupport {

    private ProduceProject service;

    /**
     * Constructs a new ProduceProjectDelegate instance.
     *
     * @param service the ProduceProject.
     */
    public ProduceProjectDelegate(ProduceProject service) {
        super();
        this.service = service;
    }

    /**
     * ProduceProjectCharacteristic.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the ProjectCharacteristicPrototypeRq.
     * @return the ProjectCharacteristicMsg.
     * @throws ClientException
     */
    public ProjectCharacteristicMsg produceProjectCharacteristic(ProjectCharacteristicPrototypeRq message,
            ServiceSubContext... subContexts) throws ClientException {
        ServiceRequest<ProjectCharacteristicPrototypeRq> request = new ServiceRequest<ProjectCharacteristicPrototypeRq>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<ProjectCharacteristicMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.produceProjectCharacteristic(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ProduceProject.class, "produceProjectCharacteristic", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ProduceProject.produceProjectCharacteristic");
    }

    /**
     * ProduceProjectRelation.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the ProjectRelationPrototypeRq.
     * @return the ProjectRelationMsg.
     * @throws ClientException
     */
    public ProjectRelationMsg produceProjectRelation(ProjectRelationPrototypeRq message,
            ServiceSubContext... subContexts) throws ClientException {
        ServiceRequest<ProjectRelationPrototypeRq> request = new ServiceRequest<ProjectRelationPrototypeRq>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<ProjectRelationMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.produceProjectRelation(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ProduceProject.class, "produceProjectRelation", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ProduceProject.produceProjectRelation");
    }

    /**
     * ProduceProjectPosition.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the EmptyServiceMessage.
     * @return the ProjectPositionMsg.
     * @throws ClientException
     */
    public ProjectPositionMsg produceProjectPosition(EmptyServiceMessage message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<EmptyServiceMessage> request = new ServiceRequest<EmptyServiceMessage>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<ProjectPositionMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.produceProjectPosition(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ProduceProject.class, "produceProjectPosition", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ProduceProject.produceProjectPosition");
    }

    /**
     * ProduceProjectPositionAssignee.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the EmptyServiceMessage.
     * @return the ProjectPositionAssigneeMsg.
     * @throws ClientException
     */
    public ProjectPositionAssigneeMsg produceProjectPositionAssignee(EmptyServiceMessage message,
            ServiceSubContext... subContexts) throws ClientException {
        ServiceRequest<EmptyServiceMessage> request = new ServiceRequest<EmptyServiceMessage>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<ProjectPositionAssigneeMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.produceProjectPositionAssignee(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ProduceProject.class, "produceProjectPositionAssignee", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ProduceProject.produceProjectPositionAssignee");
    }

    /**
     * ProduceProjectTask.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the EmptyServiceMessage.
     * @return the ProjectTaskMsg.
     * @throws ClientException
     */
    public ProjectTaskMsg produceProjectTask(EmptyServiceMessage message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<EmptyServiceMessage> request = new ServiceRequest<EmptyServiceMessage>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<ProjectTaskMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.produceProjectTask(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ProduceProject.class, "produceProjectTask", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ProduceProject.produceProjectTask");
    }

    /**
     * ProduceProjectSpecification.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the EmptyServiceMessage.
     * @return the ProjectSpecificationMsg.
     * @throws ClientException
     */
    public ProjectSpecificationMsg produceProjectSpecification(EmptyServiceMessage message,
            ServiceSubContext... subContexts) throws ClientException {
        ServiceRequest<EmptyServiceMessage> request = new ServiceRequest<EmptyServiceMessage>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<ProjectSpecificationMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.produceProjectSpecification(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(ProduceProject.class, "produceProjectSpecification", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: ProduceProject.produceProjectSpecification");
    }
}
