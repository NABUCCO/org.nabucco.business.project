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

import org.nabucco.business.project.facade.datatype.ProjectSpecification;
import org.nabucco.business.project.facade.message.ProjectSpecificationMsg;
import org.nabucco.framework.base.facade.exception.service.MaintainException;

/**
 * MaintainProjectSpecificationServiceHandlerImpl
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class MaintainProjectSpecificationServiceHandlerImpl extends MaintainProjectSpecificationServiceHandler {

    private static final long serialVersionUID = 1L;

    @Override
    protected ProjectSpecificationMsg maintainProjectSpecification(ProjectSpecificationMsg msg)
            throws MaintainException {

        try {
            ProjectSpecification specification = super.getPersistenceManager().persist(msg.getProjectSpecification());

            ProjectSpecificationMsg rs = new ProjectSpecificationMsg();
            rs.setProjectSpecification(specification);

            return rs;
        } catch (Exception e) {
            throw new MaintainException("Error maintaining project specification with id '"
                    + msg.getProjectSpecification().getId() + "'.");
        }
    }

}
