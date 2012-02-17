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
package org.nabucco.business.project.facade.service.search;

import org.nabucco.business.project.facade.message.ProjectCharacteristicListMsg;
import org.nabucco.business.project.facade.message.ProjectPositionAssigneeSearchMsg;
import org.nabucco.business.project.facade.message.ProjectSpecificationListMsg;
import org.nabucco.business.project.facade.message.ResolvedProjectPositionAssigneeMsg;
import org.nabucco.business.project.facade.message.search.ProjectPositionAssignmentIdsSearchRq;
import org.nabucco.business.project.facade.message.search.ProjectPositionAssignmentSearchRq;
import org.nabucco.business.project.facade.message.search.ProjectSearchRq;
import org.nabucco.business.project.facade.message.search.ProjectSpecificationSearchRq;
import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.Service;

/**
 * SearchProject<p/>Search Service for Project<p/>
 *
 * @version 1.0
 * @author Nicolas Moser, PRODYNA AG, 2011-09-26
 */
public interface SearchProject extends Service {

    /**
     * Missing description at method searchProjectCharacteristic.
     *
     * @param rq the ServiceRequest<ProjectSearchRq>.
     * @return the ServiceResponse<ProjectCharacteristicListMsg>.
     * @throws SearchException
     */
    ServiceResponse<ProjectCharacteristicListMsg> searchProjectCharacteristic(ServiceRequest<ProjectSearchRq> rq)
            throws SearchException;

    /**
     * Missing description at method searchProjectSpecification.
     *
     * @param rq the ServiceRequest<ProjectSpecificationSearchRq>.
     * @return the ServiceResponse<ProjectSpecificationListMsg>.
     * @throws SearchException
     */
    ServiceResponse<ProjectSpecificationListMsg> searchProjectSpecification(
            ServiceRequest<ProjectSpecificationSearchRq> rq) throws SearchException;

    /**
     * Missing description at method searchProjectPositionAssignments.
     *
     * @param rq the ServiceRequest<ProjectPositionAssignmentSearchRq>.
     * @return the ServiceResponse<ProjectPositionAssigneeSearchMsg>.
     * @throws SearchException
     */
    ServiceResponse<ProjectPositionAssigneeSearchMsg> searchProjectPositionAssignments(
            ServiceRequest<ProjectPositionAssignmentSearchRq> rq) throws SearchException;

    /**
     * Search for the project and project position for every given project position assignment element
     *
     * @param rq the ServiceRequest<ProjectPositionAssignmentIdsSearchRq>.
     * @return the ServiceResponse<ResolvedProjectPositionAssigneeMsg>.
     * @throws SearchException
     */
    ServiceResponse<ResolvedProjectPositionAssigneeMsg> searchForAssigneeRelatedElements(
            ServiceRequest<ProjectPositionAssignmentIdsSearchRq> rq) throws SearchException;
}
