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

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import org.nabucco.business.project.facade.message.ProjectCharacteristicMsg;
import org.nabucco.business.project.facade.message.ProjectPositionAssigneeMsg;
import org.nabucco.business.project.facade.message.ProjectPositionMsg;
import org.nabucco.business.project.facade.message.ProjectSpecificationMsg;
import org.nabucco.business.project.facade.message.ProjectTaskMsg;
import org.nabucco.business.project.facade.service.resolve.ResolveProject;
import org.nabucco.framework.base.facade.exception.service.ResolveException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.injection.InjectionException;
import org.nabucco.framework.base.facade.service.injection.InjectionProvider;
import org.nabucco.framework.base.impl.service.ServiceSupport;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManager;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManagerFactory;

/**
 * ResolveProjectImpl<p/>Resolve Service for Project<p/>
 *
 * @version 1.0
 * @author Nicolas Moser, PRODYNA AG, 2011-09-26
 */
public class ResolveProjectImpl extends ServiceSupport implements ResolveProject {

    private static final long serialVersionUID = 1L;

    private static final String ID = "ResolveProject";

    private static Map<String, String[]> ASPECTS;

    private ResolveProjectCharacteristicServiceHandler resolveProjectCharacteristicServiceHandler;

    private ResolveProjectPositionServiceHandler resolveProjectPositionServiceHandler;

    private ResolveProjectPositionAssigneeServiceHandler resolveProjectPositionAssigneeServiceHandler;

    private ResolveProjectTaskServiceHandler resolveProjectTaskServiceHandler;

    private ResolveProjectSpecificationServiceHandler resolveProjectSpecificationServiceHandler;

    private EntityManager entityManager;

    /** Constructs a new ResolveProjectImpl instance. */
    public ResolveProjectImpl() {
        super();
    }

    @Override
    public void postConstruct() {
        super.postConstruct();
        InjectionProvider injector = InjectionProvider.getInstance(ID);
        PersistenceManager persistenceManager = PersistenceManagerFactory.getInstance().createPersistenceManager(
                this.entityManager, super.getLogger());
        this.resolveProjectCharacteristicServiceHandler = injector.inject(ResolveProjectCharacteristicServiceHandler
                .getId());
        if ((this.resolveProjectCharacteristicServiceHandler != null)) {
            this.resolveProjectCharacteristicServiceHandler.setPersistenceManager(persistenceManager);
            this.resolveProjectCharacteristicServiceHandler.setLogger(super.getLogger());
        }
        this.resolveProjectPositionServiceHandler = injector.inject(ResolveProjectPositionServiceHandler.getId());
        if ((this.resolveProjectPositionServiceHandler != null)) {
            this.resolveProjectPositionServiceHandler.setPersistenceManager(persistenceManager);
            this.resolveProjectPositionServiceHandler.setLogger(super.getLogger());
        }
        this.resolveProjectPositionAssigneeServiceHandler = injector
                .inject(ResolveProjectPositionAssigneeServiceHandler.getId());
        if ((this.resolveProjectPositionAssigneeServiceHandler != null)) {
            this.resolveProjectPositionAssigneeServiceHandler.setPersistenceManager(persistenceManager);
            this.resolveProjectPositionAssigneeServiceHandler.setLogger(super.getLogger());
        }
        this.resolveProjectTaskServiceHandler = injector.inject(ResolveProjectTaskServiceHandler.getId());
        if ((this.resolveProjectTaskServiceHandler != null)) {
            this.resolveProjectTaskServiceHandler.setPersistenceManager(persistenceManager);
            this.resolveProjectTaskServiceHandler.setLogger(super.getLogger());
        }
        this.resolveProjectSpecificationServiceHandler = injector.inject(ResolveProjectSpecificationServiceHandler
                .getId());
        if ((this.resolveProjectSpecificationServiceHandler != null)) {
            this.resolveProjectSpecificationServiceHandler.setPersistenceManager(persistenceManager);
            this.resolveProjectSpecificationServiceHandler.setLogger(super.getLogger());
        }
    }

    @Override
    public void preDestroy() {
        super.preDestroy();
    }

    @Override
    public String[] getAspects(String operationName) {
        if ((ASPECTS == null)) {
            ASPECTS = new HashMap<String, String[]>();
            ASPECTS.put("resolveProjectCharacteristic", new String[] { "org.nabucco.aspect.resolving" });
            ASPECTS.put("resolveProjectPosition", new String[] { "org.nabucco.aspect.resolving" });
            ASPECTS.put("resolveProjectPositionAssignee", new String[] { "org.nabucco.aspect.resolving" });
            ASPECTS.put("resolveProjectTask", new String[] { "org.nabucco.aspect.resolving" });
            ASPECTS.put("resolveProjectSpecification", new String[] { "org.nabucco.aspect.resolving" });
        }
        String[] aspects = ASPECTS.get(operationName);
        if ((aspects == null)) {
            return ServiceSupport.NO_ASPECTS;
        }
        return Arrays.copyOf(aspects, aspects.length);
    }

    @Override
    public ServiceResponse<ProjectCharacteristicMsg> resolveProjectCharacteristic(
            ServiceRequest<ProjectCharacteristicMsg> rq) throws ResolveException {
        if ((this.resolveProjectCharacteristicServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for resolveProjectCharacteristic().");
            throw new InjectionException("No service implementation configured for resolveProjectCharacteristic().");
        }
        ServiceResponse<ProjectCharacteristicMsg> rs;
        this.resolveProjectCharacteristicServiceHandler.init();
        rs = this.resolveProjectCharacteristicServiceHandler.invoke(rq);
        this.resolveProjectCharacteristicServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<ProjectPositionMsg> resolveProjectPosition(ServiceRequest<ProjectPositionMsg> rq)
            throws ResolveException {
        if ((this.resolveProjectPositionServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for resolveProjectPosition().");
            throw new InjectionException("No service implementation configured for resolveProjectPosition().");
        }
        ServiceResponse<ProjectPositionMsg> rs;
        this.resolveProjectPositionServiceHandler.init();
        rs = this.resolveProjectPositionServiceHandler.invoke(rq);
        this.resolveProjectPositionServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<ProjectPositionAssigneeMsg> resolveProjectPositionAssignee(
            ServiceRequest<ProjectPositionAssigneeMsg> rq) throws ResolveException {
        if ((this.resolveProjectPositionAssigneeServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for resolveProjectPositionAssignee().");
            throw new InjectionException("No service implementation configured for resolveProjectPositionAssignee().");
        }
        ServiceResponse<ProjectPositionAssigneeMsg> rs;
        this.resolveProjectPositionAssigneeServiceHandler.init();
        rs = this.resolveProjectPositionAssigneeServiceHandler.invoke(rq);
        this.resolveProjectPositionAssigneeServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<ProjectTaskMsg> resolveProjectTask(ServiceRequest<ProjectTaskMsg> rq)
            throws ResolveException {
        if ((this.resolveProjectTaskServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for resolveProjectTask().");
            throw new InjectionException("No service implementation configured for resolveProjectTask().");
        }
        ServiceResponse<ProjectTaskMsg> rs;
        this.resolveProjectTaskServiceHandler.init();
        rs = this.resolveProjectTaskServiceHandler.invoke(rq);
        this.resolveProjectTaskServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<ProjectSpecificationMsg> resolveProjectSpecification(
            ServiceRequest<ProjectSpecificationMsg> rq) throws ResolveException {
        if ((this.resolveProjectSpecificationServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for resolveProjectSpecification().");
            throw new InjectionException("No service implementation configured for resolveProjectSpecification().");
        }
        ServiceResponse<ProjectSpecificationMsg> rs;
        this.resolveProjectSpecificationServiceHandler.init();
        rs = this.resolveProjectSpecificationServiceHandler.invoke(rq);
        this.resolveProjectSpecificationServiceHandler.finish();
        return rs;
    }
}
