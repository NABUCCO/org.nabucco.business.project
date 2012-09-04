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
package org.nabucco.business.project.facade.message;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.nabucco.business.project.facade.datatype.ProjectTask;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoCollectionState;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoList;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoListImpl;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyAssociationType;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;
import org.nabucco.framework.base.facade.message.ServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceMessageSupport;

/**
 * ProjectTaskMsg<p/>Task message<p/>
 *
 * @version 1.0
 * @author Leonid Agranovskiy, PRODYNA AG, 2012-01-26
 */
public class ProjectTaskMsg extends ServiceMessageSupport implements ServiceMessage {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_CONSTRAINTS = { "m0,1;", "m0,n;" };

    public static final String TASK = "task";

    public static final String TASKLIST = "taskList";

    /** The task to be modified (maintained etc) */
    private ProjectTask task;

    /** The list of tasks to be modified (maintained etc) */
    private NabuccoList<ProjectTask> taskList;

    /** Constructs a new ProjectTaskMsg instance. */
    public ProjectTaskMsg() {
        super();
        this.initDefaults();
    }

    /** InitDefaults. */
    private void initDefaults() {
    }

    /**
     * CreatePropertyContainer.
     *
     * @return the NabuccoPropertyContainer.
     */
    protected static NabuccoPropertyContainer createPropertyContainer() {
        Map<String, NabuccoPropertyDescriptor> propertyMap = new HashMap<String, NabuccoPropertyDescriptor>();
        propertyMap.put(TASK, PropertyDescriptorSupport.createDatatype(TASK, ProjectTask.class, 0,
                PROPERTY_CONSTRAINTS[0], false, PropertyAssociationType.COMPOSITION));
        propertyMap.put(TASKLIST, PropertyDescriptorSupport.createCollection(TASKLIST, ProjectTask.class, 1,
                PROPERTY_CONSTRAINTS[1], false, PropertyAssociationType.COMPOSITION));
        return new NabuccoPropertyContainer(propertyMap);
    }

    /** Init. */
    public void init() {
        this.initDefaults();
    }

    @Override
    public Set<NabuccoProperty> getProperties() {
        Set<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(ProjectTaskMsg.getPropertyDescriptor(TASK), this.getTask()));
        properties.add(super.createProperty(ProjectTaskMsg.getPropertyDescriptor(TASKLIST), this.taskList));
        return properties;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(TASK) && (property.getType() == ProjectTask.class))) {
            this.setTask(((ProjectTask) property.getInstance()));
            return true;
        } else if ((property.getName().equals(TASKLIST) && (property.getType() == ProjectTask.class))) {
            this.taskList = ((NabuccoList<ProjectTask>) property.getInstance());
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if ((this == obj)) {
            return true;
        }
        if ((obj == null)) {
            return false;
        }
        if ((this.getClass() != obj.getClass())) {
            return false;
        }
        if ((!super.equals(obj))) {
            return false;
        }
        final ProjectTaskMsg other = ((ProjectTaskMsg) obj);
        if ((this.task == null)) {
            if ((other.task != null))
                return false;
        } else if ((!this.task.equals(other.task)))
            return false;
        if ((this.taskList == null)) {
            if ((other.taskList != null))
                return false;
        } else if ((!this.taskList.equals(other.taskList)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.task == null) ? 0 : this.task.hashCode()));
        result = ((PRIME * result) + ((this.taskList == null) ? 0 : this.taskList.hashCode()));
        return result;
    }

    @Override
    public ServiceMessage cloneObject() {
        return this;
    }

    /**
     * The task to be modified (maintained etc)
     *
     * @return the ProjectTask.
     */
    public ProjectTask getTask() {
        return this.task;
    }

    /**
     * The task to be modified (maintained etc)
     *
     * @param task the ProjectTask.
     */
    public void setTask(ProjectTask task) {
        this.task = task;
    }

    /**
     * The list of tasks to be modified (maintained etc)
     *
     * @return the NabuccoList<ProjectTask>.
     */
    public NabuccoList<ProjectTask> getTaskList() {
        if ((this.taskList == null)) {
            this.taskList = new NabuccoListImpl<ProjectTask>(NabuccoCollectionState.INITIALIZED);
        }
        return this.taskList;
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(ProjectTaskMsg.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(ProjectTaskMsg.class).getAllProperties();
    }
}
