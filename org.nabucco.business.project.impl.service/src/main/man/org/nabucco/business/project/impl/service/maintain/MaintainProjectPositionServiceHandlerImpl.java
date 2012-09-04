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
package org.nabucco.business.project.impl.service.maintain;

import java.util.List;

import org.nabucco.business.project.facade.datatype.ProjectPosition;
import org.nabucco.business.project.facade.datatype.ProjectPositionAssignee;
import org.nabucco.business.project.facade.message.ProjectPositionMsg;
import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.exception.service.MaintainException;

/**
 * MaintainProjectPositionServiceHandlerImpl
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class MaintainProjectPositionServiceHandlerImpl extends MaintainProjectPositionServiceHandler {

    private static final long serialVersionUID = 1L;

    @Override
    protected ProjectPositionMsg maintainProjectPosition(ProjectPositionMsg msg) throws MaintainException {

        ProjectPosition position = msg.getProjectPosition();
        try {

            List<ProjectPositionAssignee> unassignedAssignees = position.getAssigneeList().getUnassignedElements();
            for (ProjectPositionAssignee assignee : unassignedAssignees) {
                assignee.setDatatypeState(DatatypeState.DELETED);
                super.getPersistenceManager().persist(assignee);
            }

            position = super.getPersistenceManager().persist(position);
            position.getAssigneeList().size();
            position.getProjectTaskList().size();
        } catch (Exception e) {
            throw new MaintainException("Error maintaining project position with id '" + position.getId() + "'.");
        }

        ProjectPositionMsg rs = new ProjectPositionMsg();
        rs.setProjectPosition(position);
        return rs;
    }

}
