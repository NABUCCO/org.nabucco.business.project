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
import java.util.Date;
import java.util.List;

import javax.persistence.TemporalType;

import org.nabucco.business.project.facade.datatype.ProjectPositionAssignee;
import org.nabucco.business.project.facade.message.ProjectPositionAssigneeSearchMsg;
import org.nabucco.business.project.facade.message.search.ProjectPositionAssignmentSearchRq;
import org.nabucco.framework.base.facade.datatype.Identifier;
import org.nabucco.framework.base.facade.exception.persistence.PersistenceException;
import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.framework.base.impl.service.maintain.NabuccoQuery;

/**
 * SearchProjectCharacteristicServiceHandlerImpl
 * 
 * Operation search for the project position assignees with given paramters
 * 
 * @author Leonid Agranovskiy, PRODYNA AG
 */
public class SearchProjectPositionAssignmentsServiceHandlerImpl extends SearchProjectPositionAssignmentsServiceHandler {

    private static final long serialVersionUID = 1L;

    private static String queryString;

    @Override
    protected ProjectPositionAssigneeSearchMsg searchProjectPositionAssignments(
            ProjectPositionAssignmentSearchRq rq) throws SearchException {

        try {
            List<Long> idList = new ArrayList<Long>();

            for (Identifier id : rq.getIdList()) {
                idList.add(id.getValue());
            }

            NabuccoQuery<ProjectPositionAssignee> query = this.createQuery(idList);


            Date startDate = (rq.getStartFrom() != null) ? rq.getStartFrom().getValue() : null;
            Date startDateTo = (rq.getStartTo() != null) ? rq.getStartTo().getValue() : null;

            Date endDate = (rq.getEndFrom() != null) ? rq.getEndFrom().getValue() : null;
            Date endDateTo = (rq.getEndTo() != null) ? rq.getEndTo().getValue() : null;

            if (!idList.isEmpty()) {
                query.setParameter(ProjectPositionAssignmentSearchRq.IDLIST, idList);
            }
            query.setParameter(ProjectPositionAssignmentSearchRq.STARTFROM, startDate, TemporalType.DATE);
            query.setParameter(ProjectPositionAssignmentSearchRq.STARTTO, startDateTo, TemporalType.DATE);
            query.setParameter(ProjectPositionAssignmentSearchRq.ENDFROM, endDate, TemporalType.DATE);
            query.setParameter(ProjectPositionAssignmentSearchRq.ENDTO, endDateTo, TemporalType.DATE);

            ProjectPositionAssigneeSearchMsg rs = new ProjectPositionAssigneeSearchMsg();
            rs.getProjectPositionAssignees().addAll(query.getResultList());

            return rs;

        } catch (PersistenceException e) {
            throw new SearchException("Error searching for project characteristic.");
        }
    }

    /**
     * Create the project position assignee query.
     * 
     * @param idList
     *            the list with id's
     * @return the query
     * 
     * @throws PersistenceException
     *             when the query is not valid
     */
    private NabuccoQuery<ProjectPositionAssignee> createQuery(List<Long> idList) throws PersistenceException {
        if (queryString == null) {

            StringBuilder query = new StringBuilder();

            query.append(" select p from ProjectPositionAssignee p");

            query.append(" where (p.startDate >= :startFrom or :startFrom is null)");
            query.append(" and (p.startDate <= :startTo or :startTo is null)");

            query.append(" and (p.endDate >= :endFrom or :endFrom is null)");
            query.append(" and (p.endDate <= :endTo or :endTo is null)");

            if (!idList.isEmpty()) {
                query.append(" and p.id in (:idList) ");
            }

            queryString = query.toString();
        }

        return super.getPersistenceManager().createQuery(queryString);
    }

}
