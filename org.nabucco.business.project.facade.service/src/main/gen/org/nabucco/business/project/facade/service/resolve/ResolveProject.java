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
package org.nabucco.business.project.facade.service.resolve;

import org.nabucco.business.project.facade.message.ProjectCharacteristicMsg;
import org.nabucco.business.project.facade.message.ProjectPositionAssigneeMsg;
import org.nabucco.business.project.facade.message.ProjectPositionMsg;
import org.nabucco.business.project.facade.message.ProjectSpecificationMsg;
import org.nabucco.business.project.facade.message.ProjectTaskMsg;
import org.nabucco.framework.base.facade.exception.service.ResolveException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.Service;

/**
 * ResolveProject<p/>Resolve Service for Project<p/>
 *
 * @version 1.0
 * @author Nicolas Moser, PRODYNA AG, 2011-09-26
 */
public interface ResolveProject extends Service {

    /**
     * Missing description at method resolveProjectCharacteristic.
     *
     * @param rq the ServiceRequest<ProjectCharacteristicMsg>.
     * @return the ServiceResponse<ProjectCharacteristicMsg>.
     * @throws ResolveException
     */
    ServiceResponse<ProjectCharacteristicMsg> resolveProjectCharacteristic(ServiceRequest<ProjectCharacteristicMsg> rq)
            throws ResolveException;

    /**
     * Missing description at method resolveProjectPosition.
     *
     * @param rq the ServiceRequest<ProjectPositionMsg>.
     * @return the ServiceResponse<ProjectPositionMsg>.
     * @throws ResolveException
     */
    ServiceResponse<ProjectPositionMsg> resolveProjectPosition(ServiceRequest<ProjectPositionMsg> rq)
            throws ResolveException;

    /**
     * Missing description at method resolveProjectPositionAssignee.
     *
     * @param rq the ServiceRequest<ProjectPositionAssigneeMsg>.
     * @return the ServiceResponse<ProjectPositionAssigneeMsg>.
     * @throws ResolveException
     */
    ServiceResponse<ProjectPositionAssigneeMsg> resolveProjectPositionAssignee(
            ServiceRequest<ProjectPositionAssigneeMsg> rq) throws ResolveException;

    /**
     * Missing description at method resolveProjectTask.
     *
     * @param rq the ServiceRequest<ProjectTaskMsg>.
     * @return the ServiceResponse<ProjectTaskMsg>.
     * @throws ResolveException
     */
    ServiceResponse<ProjectTaskMsg> resolveProjectTask(ServiceRequest<ProjectTaskMsg> rq) throws ResolveException;

    /**
     * Missing description at method resolveProjectSpecification.
     *
     * @param rq the ServiceRequest<ProjectSpecificationMsg>.
     * @return the ServiceResponse<ProjectSpecificationMsg>.
     * @throws ResolveException
     */
    ServiceResponse<ProjectSpecificationMsg> resolveProjectSpecification(ServiceRequest<ProjectSpecificationMsg> rq)
            throws ResolveException;
}
