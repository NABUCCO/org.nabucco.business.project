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
package org.nabucco.business.project.impl.service.resolve;

import org.nabucco.business.project.facade.datatype.ProjectCharacteristic;
import org.nabucco.business.project.facade.message.ProjectCharacteristicMsg;
import org.nabucco.framework.base.facade.exception.service.ResolveException;

/**
 * ResolvePlainProjectServiceHandlerImpl
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class ResolveProjectCharacteristicServiceHandlerImpl extends ResolveProjectCharacteristicServiceHandler {

    private static final long serialVersionUID = 1L;

    @Override
    protected ProjectCharacteristicMsg resolveProjectCharacteristic(ProjectCharacteristicMsg msg)
            throws ResolveException {

        ProjectCharacteristic characteristic = msg.getProjectCharacteristic();

        try {
            characteristic = super.getPersistenceManager().find(characteristic);

            characteristic.getProjectPositionList().size();
            characteristic.getRelationList().size();

        } catch (Exception e) {
            throw new ResolveException("Cannot resolve Project Characteristic with id " + characteristic.getId(), e);
        }

        ProjectCharacteristicMsg response = new ProjectCharacteristicMsg();
        response.setProjectCharacteristic(characteristic);
        return response;
    }

}
