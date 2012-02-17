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

import org.nabucco.business.project.facade.datatype.ProjectRelation;
import org.nabucco.business.project.facade.message.ProjectRelationMsg;
import org.nabucco.business.project.facade.message.produce.ProjectRelationPrototypeRq;
import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.exception.service.ProduceException;

/**
 * ProduceProjectRelationServiceHandlerImpl
 * 
 * @author Dominic Trumpfheller, PRODYNA AG
 */
public class ProduceProjectRelationServiceHandlerImpl extends ProduceProjectRelationServiceHandler {

    private static final long serialVersionUID = 1L;

    @Override
    protected ProjectRelationMsg produceProjectRelation(ProjectRelationPrototypeRq rq) throws ProduceException {

        ProjectRelation relation = new ProjectRelation();
        relation.setDatatypeState(DatatypeState.INITIALIZED);

        ProjectRelationMsg response = new ProjectRelationMsg();
        response.setProjectRelation(relation);

        return response;
    }

}
