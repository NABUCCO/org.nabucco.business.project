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

import java.util.Date;

import javax.persistence.TemporalType;

import org.nabucco.business.project.facade.datatype.ProjectCharacteristic;
import org.nabucco.business.project.facade.message.ProjectCharacteristicListMsg;
import org.nabucco.business.project.facade.message.search.ProjectSearchRq;
import org.nabucco.framework.base.facade.exception.persistence.PersistenceException;
import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.framework.base.impl.service.maintain.NabuccoQuery;

/**
 * SearchProjectCharacteristicServiceHandlerImpl
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public class SearchProjectCharacteristicServiceHandlerImpl extends SearchProjectCharacteristicServiceHandler {

    private static final long serialVersionUID = 1L;

    private static String queryString;

    @Override
    protected ProjectCharacteristicListMsg searchProjectCharacteristic(ProjectSearchRq rq) throws SearchException {

        try {
            NabuccoQuery<ProjectCharacteristic> query = this.createQuery();

            Date startDate = (rq.getStartFrom() != null) ? rq.getStartFrom().getValue() : null;
            Date startDateTo = (rq.getStartTo() != null) ? rq.getStartTo().getValue() : null;

            Date endDate = (rq.getEndFrom() != null) ? rq.getEndFrom().getValue() : null;
            Date endDateTo = (rq.getEndTo() != null) ? rq.getEndTo().getValue() : null;

            Long projectPositionId = rq.getProjectPositionId() != null ? rq.getProjectPositionId().getValue() : null;

            query.setParameter(ProjectSearchRq.NAME, rq.getName());
            query.setParameter(ProjectSearchRq.TYPE, rq.getType());
            query.setParameter(ProjectSearchRq.OWNER, rq.getOwner());
            query.setParameter(ProjectSearchRq.STARTFROM, startDate, TemporalType.DATE);
            query.setParameter(ProjectSearchRq.STARTTO, startDateTo, TemporalType.DATE);
            query.setParameter(ProjectSearchRq.ENDFROM, endDate, TemporalType.DATE);
            query.setParameter(ProjectSearchRq.ENDTO, endDateTo, TemporalType.DATE);
            query.setParameter(ProjectSearchRq.PROJECTPOSITIONID, projectPositionId);

            ProjectCharacteristicListMsg rs = new ProjectCharacteristicListMsg();
            rs.getProjectCharacteristicList().addAll(query.getResultList());

            return rs;

        } catch (PersistenceException e) {
            throw new SearchException("Error searching for project characteristic.");
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
    private NabuccoQuery<ProjectCharacteristic> createQuery() throws PersistenceException {
        if (queryString == null) {

            StringBuilder query = new StringBuilder();

            query.append("select p from ProjectCharacteristic p");
            query.append(" inner join p.master m");
            query.append(" inner join p.projectPositionListJPA pp");

            query.append(" where p.characteristicType = :type");

            query.append(" and m.name = :name or :name is null");
            query.append(" and m.owner = :owner or :owner is null");

            query.append(" and (m.startDate >= :startFrom or :startFrom is null)");
            query.append(" and (m.startDate <= :startTo or :startTo is null)");

            query.append(" and (m.endDate >= :endFrom or :endFrom is null)");
            query.append(" and (m.endDate <= :endTo or :endTo is null)");
            query.append(" and (pp.id = :projectPositionId or :projectPositionId is null)");

            queryString = query.toString();
        }

        return super.getPersistenceManager().createQuery(queryString);
    }

}
