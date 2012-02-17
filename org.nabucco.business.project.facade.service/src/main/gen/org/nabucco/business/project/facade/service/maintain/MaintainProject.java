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
package org.nabucco.business.project.facade.service.maintain;

import org.nabucco.business.project.facade.message.ProjectCharacteristicMsg;
import org.nabucco.business.project.facade.message.ProjectPositionAssigneeMsg;
import org.nabucco.business.project.facade.message.ProjectPositionMsg;
import org.nabucco.business.project.facade.message.ProjectSpecificationMsg;
import org.nabucco.business.project.facade.message.ProjectTaskMsg;
import org.nabucco.framework.base.facade.exception.service.MaintainException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.Service;

/**
 * MaintainProject<p/>Maintain Service for Project<p/>
 *
 * @version 1.0
 * @author Nicolas Moser, PRODYNA AG, 2011-09-26
 */
public interface MaintainProject extends Service {

    /**
     * Maintains a project characteristic.
     *
     * @param rq the ServiceRequest<ProjectCharacteristicMsg>.
     * @return the ServiceResponse<ProjectCharacteristicMsg>.
     * @throws MaintainException
     */
    ServiceResponse<ProjectCharacteristicMsg> maintainProjectCharacteristic(ServiceRequest<ProjectCharacteristicMsg> rq)
            throws MaintainException;

    /**
     * Maintains a project position.
     *
     * @param rq the ServiceRequest<ProjectPositionMsg>.
     * @return the ServiceResponse<ProjectPositionMsg>.
     * @throws MaintainException
     */
    ServiceResponse<ProjectPositionMsg> maintainProjectPosition(ServiceRequest<ProjectPositionMsg> rq)
            throws MaintainException;

    /**
     * Maintains an assignee of a project position.
     *
     * @param rq the ServiceRequest<ProjectPositionAssigneeMsg>.
     * @return the ServiceResponse<ProjectPositionAssigneeMsg>.
     * @throws MaintainException
     */
    ServiceResponse<ProjectPositionAssigneeMsg> maintainProjectPositionAssignee(
            ServiceRequest<ProjectPositionAssigneeMsg> rq) throws MaintainException;

    /**
     * Maintains the task
     *
     * @param rq the ServiceRequest<ProjectTaskMsg>.
     * @return the ServiceResponse<ProjectTaskMsg>.
     * @throws MaintainException
     */
    ServiceResponse<ProjectTaskMsg> maintainProjectTask(ServiceRequest<ProjectTaskMsg> rq) throws MaintainException;

    /**
     * Maintains a project specification.
     *
     * @param rq the ServiceRequest<ProjectSpecificationMsg>.
     * @return the ServiceResponse<ProjectSpecificationMsg>.
     * @throws MaintainException
     */
    ServiceResponse<ProjectSpecificationMsg> maintainProjectSpecification(ServiceRequest<ProjectSpecificationMsg> rq)
            throws MaintainException;
}
