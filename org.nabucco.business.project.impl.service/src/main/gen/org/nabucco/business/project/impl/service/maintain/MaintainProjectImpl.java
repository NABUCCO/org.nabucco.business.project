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

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import org.nabucco.business.project.facade.message.ProjectCharacteristicMsg;
import org.nabucco.business.project.facade.message.ProjectPositionAssigneeMsg;
import org.nabucco.business.project.facade.message.ProjectPositionMsg;
import org.nabucco.business.project.facade.message.ProjectSpecificationMsg;
import org.nabucco.business.project.facade.message.ProjectTaskMsg;
import org.nabucco.business.project.facade.service.maintain.MaintainProject;
import org.nabucco.framework.base.facade.exception.service.MaintainException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.injection.InjectionException;
import org.nabucco.framework.base.facade.service.injection.InjectionProvider;
import org.nabucco.framework.base.impl.service.ServiceSupport;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManager;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManagerFactory;

/**
 * MaintainProjectImpl<p/>Maintain Service for Project<p/>
 *
 * @version 1.0
 * @author Nicolas Moser, PRODYNA AG, 2011-09-26
 */
public class MaintainProjectImpl extends ServiceSupport implements MaintainProject {

    private static final long serialVersionUID = 1L;

    private static final String ID = "MaintainProject";

    private static Map<String, String[]> ASPECTS;

    private MaintainProjectCharacteristicServiceHandler maintainProjectCharacteristicServiceHandler;

    private MaintainProjectPositionServiceHandler maintainProjectPositionServiceHandler;

    private MaintainProjectPositionAssigneeServiceHandler maintainProjectPositionAssigneeServiceHandler;

    private MaintainProjectTaskServiceHandler maintainProjectTaskServiceHandler;

    private MaintainProjectSpecificationServiceHandler maintainProjectSpecificationServiceHandler;

    private EntityManager entityManager;

    /** Constructs a new MaintainProjectImpl instance. */
    public MaintainProjectImpl() {
        super();
    }

    @Override
    public void postConstruct() {
        super.postConstruct();
        InjectionProvider injector = InjectionProvider.getInstance(ID);
        PersistenceManager persistenceManager = PersistenceManagerFactory.getInstance().createPersistenceManager(
                this.entityManager, super.getLogger());
        this.maintainProjectCharacteristicServiceHandler = injector.inject(MaintainProjectCharacteristicServiceHandler
                .getId());
        if ((this.maintainProjectCharacteristicServiceHandler != null)) {
            this.maintainProjectCharacteristicServiceHandler.setPersistenceManager(persistenceManager);
            this.maintainProjectCharacteristicServiceHandler.setLogger(super.getLogger());
        }
        this.maintainProjectPositionServiceHandler = injector.inject(MaintainProjectPositionServiceHandler.getId());
        if ((this.maintainProjectPositionServiceHandler != null)) {
            this.maintainProjectPositionServiceHandler.setPersistenceManager(persistenceManager);
            this.maintainProjectPositionServiceHandler.setLogger(super.getLogger());
        }
        this.maintainProjectPositionAssigneeServiceHandler = injector
                .inject(MaintainProjectPositionAssigneeServiceHandler.getId());
        if ((this.maintainProjectPositionAssigneeServiceHandler != null)) {
            this.maintainProjectPositionAssigneeServiceHandler.setPersistenceManager(persistenceManager);
            this.maintainProjectPositionAssigneeServiceHandler.setLogger(super.getLogger());
        }
        this.maintainProjectTaskServiceHandler = injector.inject(MaintainProjectTaskServiceHandler.getId());
        if ((this.maintainProjectTaskServiceHandler != null)) {
            this.maintainProjectTaskServiceHandler.setPersistenceManager(persistenceManager);
            this.maintainProjectTaskServiceHandler.setLogger(super.getLogger());
        }
        this.maintainProjectSpecificationServiceHandler = injector.inject(MaintainProjectSpecificationServiceHandler
                .getId());
        if ((this.maintainProjectSpecificationServiceHandler != null)) {
            this.maintainProjectSpecificationServiceHandler.setPersistenceManager(persistenceManager);
            this.maintainProjectSpecificationServiceHandler.setLogger(super.getLogger());
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
            ASPECTS.put("maintainProjectCharacteristic", new String[] { "org.nabucco.aspect.permissioning",
                    "org.nabucco.aspect.validating", "org.nabucco.aspect.indexing", "org.nabucco.aspect.relating",
                    "org.nabucco.aspect.resolving" });
            ASPECTS.put("maintainProjectPosition", new String[] { "org.nabucco.aspect.permissioning",
                    "org.nabucco.aspect.validating", "org.nabucco.aspect.relating", "org.nabucco.aspect.resolving" });
            ASPECTS.put("maintainProjectPositionAssignee", new String[] { "org.nabucco.aspect.permissioning",
                    "org.nabucco.aspect.validating", "org.nabucco.aspect.relating", "org.nabucco.aspect.resolving" });
            ASPECTS.put("maintainProjectTask", new String[] { "org.nabucco.aspect.permissioning",
                    "org.nabucco.aspect.validating", "org.nabucco.aspect.relating", "org.nabucco.aspect.resolving" });
            ASPECTS.put("maintainProjectSpecification", new String[] { "org.nabucco.aspect.permissioning",
                    "org.nabucco.aspect.validating", "org.nabucco.aspect.relating", "org.nabucco.aspect.resolving" });
        }
        String[] aspects = ASPECTS.get(operationName);
        if ((aspects == null)) {
            return ServiceSupport.NO_ASPECTS;
        }
        return Arrays.copyOf(aspects, aspects.length);
    }

    @Override
    public ServiceResponse<ProjectCharacteristicMsg> maintainProjectCharacteristic(
            ServiceRequest<ProjectCharacteristicMsg> rq) throws MaintainException {
        if ((this.maintainProjectCharacteristicServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for maintainProjectCharacteristic().");
            throw new InjectionException("No service implementation configured for maintainProjectCharacteristic().");
        }
        ServiceResponse<ProjectCharacteristicMsg> rs;
        this.maintainProjectCharacteristicServiceHandler.init();
        rs = this.maintainProjectCharacteristicServiceHandler.invoke(rq);
        this.maintainProjectCharacteristicServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<ProjectPositionMsg> maintainProjectPosition(ServiceRequest<ProjectPositionMsg> rq)
            throws MaintainException {
        if ((this.maintainProjectPositionServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for maintainProjectPosition().");
            throw new InjectionException("No service implementation configured for maintainProjectPosition().");
        }
        ServiceResponse<ProjectPositionMsg> rs;
        this.maintainProjectPositionServiceHandler.init();
        rs = this.maintainProjectPositionServiceHandler.invoke(rq);
        this.maintainProjectPositionServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<ProjectPositionAssigneeMsg> maintainProjectPositionAssignee(
            ServiceRequest<ProjectPositionAssigneeMsg> rq) throws MaintainException {
        if ((this.maintainProjectPositionAssigneeServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for maintainProjectPositionAssignee().");
            throw new InjectionException("No service implementation configured for maintainProjectPositionAssignee().");
        }
        ServiceResponse<ProjectPositionAssigneeMsg> rs;
        this.maintainProjectPositionAssigneeServiceHandler.init();
        rs = this.maintainProjectPositionAssigneeServiceHandler.invoke(rq);
        this.maintainProjectPositionAssigneeServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<ProjectTaskMsg> maintainProjectTask(ServiceRequest<ProjectTaskMsg> rq)
            throws MaintainException {
        if ((this.maintainProjectTaskServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for maintainProjectTask().");
            throw new InjectionException("No service implementation configured for maintainProjectTask().");
        }
        ServiceResponse<ProjectTaskMsg> rs;
        this.maintainProjectTaskServiceHandler.init();
        rs = this.maintainProjectTaskServiceHandler.invoke(rq);
        this.maintainProjectTaskServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<ProjectSpecificationMsg> maintainProjectSpecification(
            ServiceRequest<ProjectSpecificationMsg> rq) throws MaintainException {
        if ((this.maintainProjectSpecificationServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for maintainProjectSpecification().");
            throw new InjectionException("No service implementation configured for maintainProjectSpecification().");
        }
        ServiceResponse<ProjectSpecificationMsg> rs;
        this.maintainProjectSpecificationServiceHandler.init();
        rs = this.maintainProjectSpecificationServiceHandler.invoke(rq);
        this.maintainProjectSpecificationServiceHandler.finish();
        return rs;
    }
}
