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

import org.nabucco.business.project.facade.datatype.ProjectCharacteristic;
import org.nabucco.business.project.facade.datatype.ProjectMaster;
import org.nabucco.business.project.facade.datatype.ProjectRelation;
import org.nabucco.business.project.facade.message.ProjectCharacteristicMsg;
import org.nabucco.framework.base.facade.exception.persistence.PersistenceException;
import org.nabucco.framework.base.facade.exception.service.MaintainException;

/**
 * MaintainProjectCharacteristicServiceHandlerImpl
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class MaintainProjectCharacteristicServiceHandlerImpl extends MaintainProjectCharacteristicServiceHandler {

    private static final long serialVersionUID = 1L;

    @Override
    protected ProjectCharacteristicMsg maintainProjectCharacteristic(ProjectCharacteristicMsg rq)
            throws MaintainException {

        ProjectCharacteristic characteristic = rq.getProjectCharacteristic();

        try {
            ProjectMaster master = this.maintainMaster(characteristic.getMaster());
            characteristic.setMaster(master);

            for (ProjectRelation relation : characteristic.getRelationList()) {
                relation = this.maintainRelation(relation);
            }

            characteristic = this.maintainCharacteristic(characteristic);
            characteristic.getRelationList().size();
            characteristic.getProjectPositionList().size();

        } catch (Exception e) {
            throw new MaintainException("Error maintaining project characteristic with id '"
                    + characteristic.getId() + "'.", e);
        }

        ProjectCharacteristicMsg rs = new ProjectCharacteristicMsg();
        rs.setProjectCharacteristic(characteristic);

        return rs;
    }

    /**
     * Maintains the project characteristic master when it does not already exist.
     * 
     * @param master
     *            the master to maintain
     * 
     * @return the maintained master
     * 
     * @throws PersistenceException
     *             when the master cannot be persisted
     */
    private ProjectMaster maintainMaster(ProjectMaster master) throws PersistenceException {
        return super.getPersistenceManager().persist(master);
    }

    /**
     * Maintains the project characteristic when it does not already exist.
     * 
     * @param characteristic
     *            the characteristic to maintain
     * 
     * @return the maintained characteristic
     * 
     * @throws PersistenceException
     *             when the characteristic cannot be persisted
     */
    private ProjectCharacteristic maintainCharacteristic(ProjectCharacteristic characteristic)
            throws PersistenceException {
        return super.getPersistenceManager().persist(characteristic);
    }

    /**
     * Maintains the project relation.
     * 
     * @param relation
     *            the relation to maintain
     * 
     * @return the maintained relation
     * 
     * @throws PersistenceException
     *             when the relation cannot be persisted
     * 
     */
    private ProjectRelation maintainRelation(ProjectRelation relation) throws PersistenceException {
        return super.getPersistenceManager().persist(relation);
    }

}
