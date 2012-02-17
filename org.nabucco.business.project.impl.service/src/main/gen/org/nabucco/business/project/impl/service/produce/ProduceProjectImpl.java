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

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import org.nabucco.business.project.facade.message.ProjectCharacteristicMsg;
import org.nabucco.business.project.facade.message.ProjectPositionAssigneeMsg;
import org.nabucco.business.project.facade.message.ProjectPositionMsg;
import org.nabucco.business.project.facade.message.ProjectRelationMsg;
import org.nabucco.business.project.facade.message.ProjectSpecificationMsg;
import org.nabucco.business.project.facade.message.ProjectTaskMsg;
import org.nabucco.business.project.facade.message.produce.ProjectCharacteristicPrototypeRq;
import org.nabucco.business.project.facade.message.produce.ProjectRelationPrototypeRq;
import org.nabucco.business.project.facade.service.produce.ProduceProject;
import org.nabucco.framework.base.facade.exception.service.ProduceException;
import org.nabucco.framework.base.facade.message.EmptyServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.injection.InjectionException;
import org.nabucco.framework.base.facade.service.injection.InjectionProvider;
import org.nabucco.framework.base.impl.service.ServiceSupport;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManager;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManagerFactory;

/**
 * ProduceProjectImpl<p/>Produce Service for the Project Component<p/>
 *
 * @version 1.0
 * @author Nicolas Moser, PRODYNA AG, 2011-09-26
 */
public class ProduceProjectImpl extends ServiceSupport implements ProduceProject {

    private static final long serialVersionUID = 1L;

    private static final String ID = "ProduceProject";

    private static Map<String, String[]> ASPECTS;

    private ProduceProjectCharacteristicServiceHandler produceProjectCharacteristicServiceHandler;

    private ProduceProjectRelationServiceHandler produceProjectRelationServiceHandler;

    private ProduceProjectPositionServiceHandler produceProjectPositionServiceHandler;

    private ProduceProjectPositionAssigneeServiceHandler produceProjectPositionAssigneeServiceHandler;

    private ProduceProjectTaskServiceHandler produceProjectTaskServiceHandler;

    private ProduceProjectSpecificationServiceHandler produceProjectSpecificationServiceHandler;

    private EntityManager entityManager;

    /** Constructs a new ProduceProjectImpl instance. */
    public ProduceProjectImpl() {
        super();
    }

    @Override
    public void postConstruct() {
        super.postConstruct();
        InjectionProvider injector = InjectionProvider.getInstance(ID);
        PersistenceManager persistenceManager = PersistenceManagerFactory.getInstance().createPersistenceManager(
                this.entityManager, super.getLogger());
        this.produceProjectCharacteristicServiceHandler = injector.inject(ProduceProjectCharacteristicServiceHandler
                .getId());
        if ((this.produceProjectCharacteristicServiceHandler != null)) {
            this.produceProjectCharacteristicServiceHandler.setPersistenceManager(persistenceManager);
            this.produceProjectCharacteristicServiceHandler.setLogger(super.getLogger());
        }
        this.produceProjectRelationServiceHandler = injector.inject(ProduceProjectRelationServiceHandler.getId());
        if ((this.produceProjectRelationServiceHandler != null)) {
            this.produceProjectRelationServiceHandler.setPersistenceManager(persistenceManager);
            this.produceProjectRelationServiceHandler.setLogger(super.getLogger());
        }
        this.produceProjectPositionServiceHandler = injector.inject(ProduceProjectPositionServiceHandler.getId());
        if ((this.produceProjectPositionServiceHandler != null)) {
            this.produceProjectPositionServiceHandler.setPersistenceManager(persistenceManager);
            this.produceProjectPositionServiceHandler.setLogger(super.getLogger());
        }
        this.produceProjectPositionAssigneeServiceHandler = injector
                .inject(ProduceProjectPositionAssigneeServiceHandler.getId());
        if ((this.produceProjectPositionAssigneeServiceHandler != null)) {
            this.produceProjectPositionAssigneeServiceHandler.setPersistenceManager(persistenceManager);
            this.produceProjectPositionAssigneeServiceHandler.setLogger(super.getLogger());
        }
        this.produceProjectTaskServiceHandler = injector.inject(ProduceProjectTaskServiceHandler.getId());
        if ((this.produceProjectTaskServiceHandler != null)) {
            this.produceProjectTaskServiceHandler.setPersistenceManager(persistenceManager);
            this.produceProjectTaskServiceHandler.setLogger(super.getLogger());
        }
        this.produceProjectSpecificationServiceHandler = injector.inject(ProduceProjectSpecificationServiceHandler
                .getId());
        if ((this.produceProjectSpecificationServiceHandler != null)) {
            this.produceProjectSpecificationServiceHandler.setPersistenceManager(persistenceManager);
            this.produceProjectSpecificationServiceHandler.setLogger(super.getLogger());
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
            ASPECTS.put("produceProjectCharacteristic", new String[] { "org.nabucco.aspect.initializing" });
            ASPECTS.put("produceProjectRelation", new String[] { "org.nabucco.aspect.initializing" });
            ASPECTS.put("produceProjectPosition", new String[] { "org.nabucco.aspect.initializing" });
            ASPECTS.put("produceProjectPositionAssignee", new String[] { "org.nabucco.aspect.initializing" });
            ASPECTS.put("produceProjectTask", new String[] { "org.nabucco.aspect.initializing" });
            ASPECTS.put("produceProjectSpecification", new String[] { "org.nabucco.aspect.initializing" });
        }
        String[] aspects = ASPECTS.get(operationName);
        if ((aspects == null)) {
            return ServiceSupport.NO_ASPECTS;
        }
        return Arrays.copyOf(aspects, aspects.length);
    }

    @Override
    public ServiceResponse<ProjectCharacteristicMsg> produceProjectCharacteristic(
            ServiceRequest<ProjectCharacteristicPrototypeRq> rq) throws ProduceException {
        if ((this.produceProjectCharacteristicServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for produceProjectCharacteristic().");
            throw new InjectionException("No service implementation configured for produceProjectCharacteristic().");
        }
        ServiceResponse<ProjectCharacteristicMsg> rs;
        this.produceProjectCharacteristicServiceHandler.init();
        rs = this.produceProjectCharacteristicServiceHandler.invoke(rq);
        this.produceProjectCharacteristicServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<ProjectRelationMsg> produceProjectRelation(ServiceRequest<ProjectRelationPrototypeRq> rq)
            throws ProduceException {
        if ((this.produceProjectRelationServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for produceProjectRelation().");
            throw new InjectionException("No service implementation configured for produceProjectRelation().");
        }
        ServiceResponse<ProjectRelationMsg> rs;
        this.produceProjectRelationServiceHandler.init();
        rs = this.produceProjectRelationServiceHandler.invoke(rq);
        this.produceProjectRelationServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<ProjectPositionMsg> produceProjectPosition(ServiceRequest<EmptyServiceMessage> rq)
            throws ProduceException {
        if ((this.produceProjectPositionServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for produceProjectPosition().");
            throw new InjectionException("No service implementation configured for produceProjectPosition().");
        }
        ServiceResponse<ProjectPositionMsg> rs;
        this.produceProjectPositionServiceHandler.init();
        rs = this.produceProjectPositionServiceHandler.invoke(rq);
        this.produceProjectPositionServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<ProjectPositionAssigneeMsg> produceProjectPositionAssignee(
            ServiceRequest<EmptyServiceMessage> rq) throws ProduceException {
        if ((this.produceProjectPositionAssigneeServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for produceProjectPositionAssignee().");
            throw new InjectionException("No service implementation configured for produceProjectPositionAssignee().");
        }
        ServiceResponse<ProjectPositionAssigneeMsg> rs;
        this.produceProjectPositionAssigneeServiceHandler.init();
        rs = this.produceProjectPositionAssigneeServiceHandler.invoke(rq);
        this.produceProjectPositionAssigneeServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<ProjectTaskMsg> produceProjectTask(ServiceRequest<EmptyServiceMessage> rq)
            throws ProduceException {
        if ((this.produceProjectTaskServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for produceProjectTask().");
            throw new InjectionException("No service implementation configured for produceProjectTask().");
        }
        ServiceResponse<ProjectTaskMsg> rs;
        this.produceProjectTaskServiceHandler.init();
        rs = this.produceProjectTaskServiceHandler.invoke(rq);
        this.produceProjectTaskServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<ProjectSpecificationMsg> produceProjectSpecification(ServiceRequest<EmptyServiceMessage> rq)
            throws ProduceException {
        if ((this.produceProjectSpecificationServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for produceProjectSpecification().");
            throw new InjectionException("No service implementation configured for produceProjectSpecification().");
        }
        ServiceResponse<ProjectSpecificationMsg> rs;
        this.produceProjectSpecificationServiceHandler.init();
        rs = this.produceProjectSpecificationServiceHandler.invoke(rq);
        this.produceProjectSpecificationServiceHandler.finish();
        return rs;
    }
}
