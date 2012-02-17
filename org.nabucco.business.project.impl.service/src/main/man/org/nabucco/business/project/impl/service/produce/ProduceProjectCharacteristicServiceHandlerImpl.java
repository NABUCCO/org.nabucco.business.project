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

import org.nabucco.business.project.facade.datatype.PlainProject;
import org.nabucco.business.project.facade.datatype.ProjectCharacteristic;
import org.nabucco.business.project.facade.datatype.ProjectCharacteristicType;
import org.nabucco.business.project.facade.datatype.ProjectMaster;
import org.nabucco.business.project.facade.message.ProjectCharacteristicMsg;
import org.nabucco.business.project.facade.message.produce.ProjectCharacteristicPrototypeRq;
import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.exception.service.ProduceException;

/**
 * ProduceProjectCharacteristicServiceHandlerImpl
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class ProduceProjectCharacteristicServiceHandlerImpl extends ProduceProjectCharacteristicServiceHandler {

    private static final long serialVersionUID = 1L;

    @Override
    protected ProjectCharacteristicMsg produceProjectCharacteristic(ProjectCharacteristicPrototypeRq rq)
            throws ProduceException {

        ProjectCharacteristic characteristic = this.createCharacteristic(rq.getType());
        characteristic.setDatatypeState(DatatypeState.INITIALIZED);

        if (rq.getSpecification() != null && rq.getSpecification().getId() != null) {
            characteristic.setSpecification(rq.getSpecification());
        }

        ProjectMaster master = this.createMaster(rq.getProjectMaster());
        characteristic.setMaster(master);

        ProjectCharacteristicMsg rs = new ProjectCharacteristicMsg();
        rs.setProjectCharacteristic(characteristic);

        return rs;
    }

    /**
     * Create the project master instance when no original master is delivered.
     * 
     * @param master
     *            the original project master
     * 
     * @return the original project master, or a new one if the original is null
     */
    private ProjectMaster createMaster(ProjectMaster master) {
        if (master == null) {
            master = new ProjectMaster();
            master.setName("New Project");
            master.setOwner(super.getContext().getOwner());
            master.setDatatypeState(DatatypeState.INITIALIZED);
        }
        return master;
    }

    /**
     * Create a new {@link ProjectCharacteristic} instance.
     * 
     * @param type
     *            the characteristic type
     * 
     * @return the new characteristic instance
     */
    private ProjectCharacteristic createCharacteristic(ProjectCharacteristicType type) {

        switch (type) {

        case PLAIN_PROJECT:
            return new PlainProject();

        default:
            throw new IllegalStateException("Project Characteristic '" + type + "' is not supported yet.");
        }
    }

}
