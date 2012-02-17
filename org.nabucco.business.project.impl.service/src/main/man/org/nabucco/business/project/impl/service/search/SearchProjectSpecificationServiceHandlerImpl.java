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
package org.nabucco.business.project.impl.service.search;

import org.nabucco.business.project.facade.datatype.ProjectSpecification;
import org.nabucco.business.project.facade.message.ProjectSpecificationListMsg;
import org.nabucco.business.project.facade.message.search.ProjectSpecificationSearchRq;
import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.framework.base.impl.service.maintain.NabuccoQuery;

/**
 * SearchProjectSpecificationServiceHandlerImpl
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class SearchProjectSpecificationServiceHandlerImpl extends SearchProjectSpecificationServiceHandler {

    private static final long serialVersionUID = 1L;

    @Override
    protected ProjectSpecificationListMsg searchProjectSpecification(ProjectSpecificationSearchRq msg)
            throws SearchException {

        try {
            String queryString = "select s from ProjectSpecification s";
            NabuccoQuery<ProjectSpecification> query = super.getPersistenceManager().createQuery(queryString);

            ProjectSpecificationListMsg rs = new ProjectSpecificationListMsg();
            rs.getProjectSpecificationList().addAll(query.getResultList());

            return rs;

        } catch (Exception e) {
            throw new SearchException("Error searching for project specifications.", e);
        }
    }

}
