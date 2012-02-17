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

import java.util.ArrayList;
import java.util.List;

import org.nabucco.business.project.facade.datatype.ProjectCharacteristic;
import org.nabucco.business.project.facade.datatype.ProjectPosition;
import org.nabucco.business.project.facade.datatype.ProjectPositionAssignee;
import org.nabucco.business.project.facade.datatype.ProjectPositionAssigneeContainer;
import org.nabucco.business.project.facade.message.ResolvedProjectPositionAssigneeMsg;
import org.nabucco.business.project.facade.message.search.ProjectPositionAssignmentIdsSearchRq;
import org.nabucco.framework.base.facade.datatype.Identifier;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoList;
import org.nabucco.framework.base.facade.exception.persistence.PersistenceException;
import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.framework.base.impl.service.maintain.NabuccoQuery;

/**
 * SearchForAssigneeRelatedElementsServiceHandlerImpl
 * 
 * @author Leonid Agranovskiy, PRODYNA AG
 */
public class SearchForAssigneeRelatedElementsServiceHandlerImpl extends SearchForAssigneeRelatedElementsServiceHandler {

    private static final long serialVersionUID = 1L;

    private static String queryString;

    @Override
    protected ResolvedProjectPositionAssigneeMsg searchForAssigneeRelatedElements(
            ProjectPositionAssignmentIdsSearchRq msg) throws SearchException {

        try {
            NabuccoList<Identifier> assigneeIdList = msg.getIdList();
            if (assigneeIdList == null) {
                throw new SearchException("Cannot resolve project position assignee list with list of id's 'null'");
            }

            ResolvedProjectPositionAssigneeMsg rs = new ResolvedProjectPositionAssigneeMsg();

            if (!assigneeIdList.isEmpty()) {

                List<Long> ppaList = new ArrayList<Long>();
                for (Identifier id : assigneeIdList) {
                    ppaList.add(id.getValue());
                }

                NabuccoQuery<Object[]> query = this.createQuery();

                query.setParameter(ProjectPositionAssignmentIdsSearchRq.IDLIST, ppaList);
                List<Object[]> resultList = query.getResultList();

                for (Object[] res : resultList) {
                    ProjectPositionAssigneeContainer container = new ProjectPositionAssigneeContainer();

                    ProjectCharacteristic project = (ProjectCharacteristic) res[0];
                    container.setProject(project);

                    ProjectPosition projectPosition = (ProjectPosition) res[1];
                    projectPosition.getTaskList().size();
                    container.setProjectPosition(projectPosition);

                    ProjectPositionAssignee assignee = (ProjectPositionAssignee) res[2];
                    assignee.getTaskList().size();
                    container.setProjectPositionAssignee(assignee);

                    rs.getAssigneeContainerList().add(container);
                }
            }

            return rs;

        } catch (PersistenceException e) {
            throw new SearchException("Error searching for project position assignment assignments.");
        }
    }

    /**
     * Create the project characteristic query.
     * 
     * @return the query
     * 
     * @throws PersistenceException
     *             when the query is not valid
     */
    private NabuccoQuery<Object[]> createQuery() throws PersistenceException {
        if (queryString == null) {

            StringBuilder query = new StringBuilder();

            query.append(" select p, pp, ppa from ProjectCharacteristic p");
            query.append(" inner join p.projectPositionListJPA pp");
            query.append(" inner join pp.assigneeListJPA ppa");

            query.append(" where ppa.id in (:idList)");

            queryString = query.toString();
        }

        return super.getPersistenceManager().createQuery(queryString);
    }

}
