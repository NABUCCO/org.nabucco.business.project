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
package org.nabucco.business.project.facade.service.produce;

import org.nabucco.business.project.facade.message.ProjectCharacteristicMsg;
import org.nabucco.business.project.facade.message.ProjectPositionAssigneeMsg;
import org.nabucco.business.project.facade.message.ProjectPositionMsg;
import org.nabucco.business.project.facade.message.ProjectRelationMsg;
import org.nabucco.business.project.facade.message.ProjectSpecificationMsg;
import org.nabucco.business.project.facade.message.ProjectTaskMsg;
import org.nabucco.business.project.facade.message.produce.ProjectCharacteristicPrototypeRq;
import org.nabucco.business.project.facade.message.produce.ProjectRelationPrototypeRq;
import org.nabucco.framework.base.facade.exception.service.ProduceException;
import org.nabucco.framework.base.facade.message.EmptyServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.Service;

/**
 * ProduceProject<p/>Produce Service for the Project Component<p/>
 *
 * @version 1.0
 * @author Nicolas Moser, PRODYNA AG, 2011-09-26
 */
public interface ProduceProject extends Service {

    /**
     * Produce a new Project Characteristic.
     *
     * @param rq the ServiceRequest<ProjectCharacteristicPrototypeRq>.
     * @return the ServiceResponse<ProjectCharacteristicMsg>.
     * @throws ProduceException
     */
    ServiceResponse<ProjectCharacteristicMsg> produceProjectCharacteristic(
            ServiceRequest<ProjectCharacteristicPrototypeRq> rq) throws ProduceException;

    /**
     * Produce a new Project Relation.
     *
     * @param rq the ServiceRequest<ProjectRelationPrototypeRq>.
     * @return the ServiceResponse<ProjectRelationMsg>.
     * @throws ProduceException
     */
    ServiceResponse<ProjectRelationMsg> produceProjectRelation(ServiceRequest<ProjectRelationPrototypeRq> rq)
            throws ProduceException;

    /**
     * Produce a new Project Position.
     *
     * @param rq the ServiceRequest<EmptyServiceMessage>.
     * @return the ServiceResponse<ProjectPositionMsg>.
     * @throws ProduceException
     */
    ServiceResponse<ProjectPositionMsg> produceProjectPosition(ServiceRequest<EmptyServiceMessage> rq)
            throws ProduceException;

    /**
     * Produce a new Project Position Assignee.
     *
     * @param rq the ServiceRequest<EmptyServiceMessage>.
     * @return the ServiceResponse<ProjectPositionAssigneeMsg>.
     * @throws ProduceException
     */
    ServiceResponse<ProjectPositionAssigneeMsg> produceProjectPositionAssignee(ServiceRequest<EmptyServiceMessage> rq)
            throws ProduceException;

    /**
     * Produce the task
     *
     * @param rq the ServiceRequest<EmptyServiceMessage>.
     * @return the ServiceResponse<ProjectTaskMsg>.
     * @throws ProduceException
     */
    ServiceResponse<ProjectTaskMsg> produceProjectTask(ServiceRequest<EmptyServiceMessage> rq) throws ProduceException;

    /**
     * Produce a new Project Specification.
     *
     * @param rq the ServiceRequest<EmptyServiceMessage>.
     * @return the ServiceResponse<ProjectSpecificationMsg>.
     * @throws ProduceException
     */
    ServiceResponse<ProjectSpecificationMsg> produceProjectSpecification(ServiceRequest<EmptyServiceMessage> rq)
            throws ProduceException;
}
