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
package org.nabucco.business.project.impl.service.produce;

import org.nabucco.business.project.facade.datatype.ProjectTask;
import org.nabucco.business.project.facade.message.ProjectTaskMsg;
import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.exception.service.ProduceException;
import org.nabucco.framework.base.facade.message.EmptyServiceMessage;

/**
 * ProduceTaskServiceHandlerImpl
 * 
 * @author Leonid Agranovskiy, PRODYNA AG
 */
public class ProduceProjectTaskServiceHandlerImpl extends ProduceProjectTaskServiceHandler {

    private static final long serialVersionUID = 1L;

    @Override
    protected ProjectTaskMsg produceProjectTask(EmptyServiceMessage msg) throws ProduceException {
        ProjectTask task = new ProjectTask();
        task.setDatatypeState(DatatypeState.INITIALIZED);
        task.setName("Neue Task");

        ProjectTaskMsg rs = new ProjectTaskMsg();
        rs.setTask(task);
        return rs;
    }

}
