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

import org.nabucco.business.project.facade.datatype.ProjectTask;
import org.nabucco.business.project.facade.message.ProjectTaskMsg;
import org.nabucco.framework.base.facade.exception.service.MaintainException;

/**
 * MaintainTaskServiceHandlerImpl
 * 
 * @author Leonid Agranovskiy, PRODYNA AG
 */
public class MaintainProjectTaskServiceHandlerImpl extends MaintainProjectTaskServiceHandler {

    private static final long serialVersionUID = 1L;

    @Override
    protected ProjectTaskMsg maintainProjectTask(ProjectTaskMsg msg) throws MaintainException {
        ProjectTaskMsg taskMsg = new ProjectTaskMsg();
        try {
            if (msg.getTask() != null) {
                ProjectTask task = super.getPersistenceManager().persist(msg.getTask());
                taskMsg.setTask(task);
            } else if (msg.getTaskList() != null && msg.getTaskList().isEmpty() == false) {
                for (ProjectTask task : msg.getTaskList()) {
                    ProjectTask maintainedTask = super.getPersistenceManager().persist(task);
                    taskMsg.getTaskList().add(maintainedTask);
                }
            }

            return taskMsg;
        } catch (Exception e) {
            throw new MaintainException("Error maintaining task with id '" + msg.getTask().getId() + "'.");
        }
    }

}
