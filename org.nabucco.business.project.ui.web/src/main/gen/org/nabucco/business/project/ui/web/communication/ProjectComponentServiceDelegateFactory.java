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
package org.nabucco.business.project.ui.web.communication;

import org.nabucco.business.project.facade.component.ProjectComponent;
import org.nabucco.business.project.facade.component.ProjectComponentLocator;
import org.nabucco.business.project.ui.web.communication.maintain.MaintainProjectDelegate;
import org.nabucco.business.project.ui.web.communication.produce.ProduceProjectDelegate;
import org.nabucco.business.project.ui.web.communication.resolve.ResolveProjectDelegate;
import org.nabucco.business.project.ui.web.communication.search.SearchProjectDelegate;
import org.nabucco.framework.base.facade.component.connection.ConnectionException;
import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.base.facade.exception.service.ServiceException;
import org.nabucco.framework.base.ui.web.communication.ServiceDelegateFactorySupport;

/**
 * ServiceDelegateFactoryTemplate<p/>Component for Project Management.<p/>
 *
 * @version 1.0
 * @author Dominic Trumpfheller, PRODYNA AG, 2010-11-30
 */
public class ProjectComponentServiceDelegateFactory extends ServiceDelegateFactorySupport<ProjectComponent> {

    private static ProjectComponentServiceDelegateFactory instance = new ProjectComponentServiceDelegateFactory();

    private MaintainProjectDelegate maintainProjectDelegate;

    private ProduceProjectDelegate produceProjectDelegate;

    private ResolveProjectDelegate resolveProjectDelegate;

    private SearchProjectDelegate searchProjectDelegate;

    /** Constructs a new ProjectComponentServiceDelegateFactory instance. */
    private ProjectComponentServiceDelegateFactory() {
        super(ProjectComponentLocator.getInstance());
    }

    /**
     * Getter for the MaintainProject.
     *
     * @return the MaintainProjectDelegate.
     * @throws ClientException
     */
    public MaintainProjectDelegate getMaintainProject() throws ClientException {
        try {
            if ((this.maintainProjectDelegate == null)) {
                this.maintainProjectDelegate = new MaintainProjectDelegate(this.getComponent().getMaintainProject());
            }
            return this.maintainProjectDelegate;
        } catch (ConnectionException e) {
            throw new ClientException("Cannot locate service: MaintainProject", e);
        } catch (ServiceException e) {
            throw new ClientException("Cannot locate service: ServiceDelegateTemplate", e);
        }
    }

    /**
     * Getter for the ProduceProject.
     *
     * @return the ProduceProjectDelegate.
     * @throws ClientException
     */
    public ProduceProjectDelegate getProduceProject() throws ClientException {
        try {
            if ((this.produceProjectDelegate == null)) {
                this.produceProjectDelegate = new ProduceProjectDelegate(this.getComponent().getProduceProject());
            }
            return this.produceProjectDelegate;
        } catch (ConnectionException e) {
            throw new ClientException("Cannot locate service: ProduceProject", e);
        } catch (ServiceException e) {
            throw new ClientException("Cannot locate service: ServiceDelegateTemplate", e);
        }
    }

    /**
     * Getter for the ResolveProject.
     *
     * @return the ResolveProjectDelegate.
     * @throws ClientException
     */
    public ResolveProjectDelegate getResolveProject() throws ClientException {
        try {
            if ((this.resolveProjectDelegate == null)) {
                this.resolveProjectDelegate = new ResolveProjectDelegate(this.getComponent().getResolveProject());
            }
            return this.resolveProjectDelegate;
        } catch (ConnectionException e) {
            throw new ClientException("Cannot locate service: ResolveProject", e);
        } catch (ServiceException e) {
            throw new ClientException("Cannot locate service: ServiceDelegateTemplate", e);
        }
    }

    /**
     * Getter for the SearchProject.
     *
     * @return the SearchProjectDelegate.
     * @throws ClientException
     */
    public SearchProjectDelegate getSearchProject() throws ClientException {
        try {
            if ((this.searchProjectDelegate == null)) {
                this.searchProjectDelegate = new SearchProjectDelegate(this.getComponent().getSearchProject());
            }
            return this.searchProjectDelegate;
        } catch (ConnectionException e) {
            throw new ClientException("Cannot locate service: SearchProject", e);
        } catch (ServiceException e) {
            throw new ClientException("Cannot locate service: ServiceDelegateTemplate", e);
        }
    }

    /**
     * Getter for the Instance.
     *
     * @return the ProjectComponentServiceDelegateFactory.
     */
    public static ProjectComponentServiceDelegateFactory getInstance() {
        return instance;
    }
}
