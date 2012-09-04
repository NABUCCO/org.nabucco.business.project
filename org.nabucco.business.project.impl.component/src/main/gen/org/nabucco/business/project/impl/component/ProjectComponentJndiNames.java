/*
 * Copyright 2012 PRODYNA AG
 * 
 * Licensed under the Eclipse Public License (EPL), Version 1.0 (the "License"); you may not use
 * this file except in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.opensource.org/licenses/eclipse-1.0.php or
 * http://www.nabucco.org/License.html
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */
package org.nabucco.business.project.impl.component;

/**
 * ProjectComponentJndiNames<p/>Component for Project Management.<p/>
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2010-11-30
 */
public interface ProjectComponentJndiNames {

    final String COMPONENT_RELATION_SERVICE_LOCAL = "nabucco/org.nabucco.business.project/org.nabucco.business.project.facade.component.ComponentRelationService/local";

    final String COMPONENT_RELATION_SERVICE_REMOTE = "nabucco/org.nabucco.business.project/org.nabucco.business.project.facade.component.ComponentRelationService/remote";

    final String QUERY_FILTER_SERVICE_LOCAL = "nabucco/org.nabucco.business.project/org.nabucco.business.project.facade.component.QueryFilterService/local";

    final String QUERY_FILTER_SERVICE_REMOTE = "nabucco/org.nabucco.business.project/org.nabucco.business.project.facade.component.QueryFilterService/remote";

    final String MAINTAIN_PROJECT_LOCAL = "nabucco/org.nabucco.business.project/org.nabucco.business.project.facade.service.maintain.MaintainProject/local";

    final String MAINTAIN_PROJECT_REMOTE = "nabucco/org.nabucco.business.project/org.nabucco.business.project.facade.service.maintain.MaintainProject/remote";

    final String PRODUCE_PROJECT_LOCAL = "nabucco/org.nabucco.business.project/org.nabucco.business.project.facade.service.produce.ProduceProject/local";

    final String PRODUCE_PROJECT_REMOTE = "nabucco/org.nabucco.business.project/org.nabucco.business.project.facade.service.produce.ProduceProject/remote";

    final String RESOLVE_PROJECT_LOCAL = "nabucco/org.nabucco.business.project/org.nabucco.business.project.facade.service.resolve.ResolveProject/local";

    final String RESOLVE_PROJECT_REMOTE = "nabucco/org.nabucco.business.project/org.nabucco.business.project.facade.service.resolve.ResolveProject/remote";

    final String SEARCH_PROJECT_LOCAL = "nabucco/org.nabucco.business.project/org.nabucco.business.project.facade.service.search.SearchProject/local";

    final String SEARCH_PROJECT_REMOTE = "nabucco/org.nabucco.business.project/org.nabucco.business.project.facade.service.search.SearchProject/remote";
}
