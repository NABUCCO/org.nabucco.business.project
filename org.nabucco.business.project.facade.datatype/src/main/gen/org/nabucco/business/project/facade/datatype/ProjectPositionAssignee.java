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
package org.nabucco.business.project.facade.datatype;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.nabucco.business.project.facade.datatype.ProjectTask;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.NabuccoDatatype;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoCollectionState;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoList;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoListImpl;
import org.nabucco.framework.base.facade.datatype.date.Date;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyAssociationType;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;

/**
 * ProjectPositionAssignee<p/>Assignee of a project position.<p/>
 *
 * @version 1.0
 * @author Nicolas Moser, PRODYNA AG, 2011-09-23
 */
public class ProjectPositionAssignee extends NabuccoDatatype implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_CONSTRAINTS = { "l0,n;u0,n;m1,1;", "l0,n;u0,n;m1,1;", "m0,n;" };

    public static final String STARTDATE = "startDate";

    public static final String ENDDATE = "endDate";

    public static final String TASKLIST = "taskList";

    /** Start Date of the Assignment. */
    private Date startDate;

    /** End Date of the Assignment. */
    private Date endDate;

    /** The Tasks of the project position assignee */
    private NabuccoList<ProjectTask> taskList;

    /** Constructs a new ProjectPositionAssignee instance. */
    public ProjectPositionAssignee() {
        super();
        this.initDefaults();
    }

    /** InitDefaults. */
    private void initDefaults() {
    }

    /**
     * CloneObject.
     *
     * @param clone the ProjectPositionAssignee.
     */
    protected void cloneObject(ProjectPositionAssignee clone) {
        super.cloneObject(clone);
        if ((this.getStartDate() != null)) {
            clone.setStartDate(this.getStartDate().cloneObject());
        }
        if ((this.getEndDate() != null)) {
            clone.setEndDate(this.getEndDate().cloneObject());
        }
        if ((this.taskList != null)) {
            clone.taskList = this.taskList.cloneCollection();
        }
    }

    /**
     * Getter for the TaskListJPA.
     *
     * @return the List<ProjectTask>.
     */
    List<ProjectTask> getTaskListJPA() {
        if ((this.taskList == null)) {
            this.taskList = new NabuccoListImpl<ProjectTask>(NabuccoCollectionState.LAZY);
        }
        return ((NabuccoListImpl<ProjectTask>) this.taskList).getDelegate();
    }

    /**
     * Setter for the TaskListJPA.
     *
     * @param taskList the List<ProjectTask>.
     */
    void setTaskListJPA(List<ProjectTask> taskList) {
        if ((this.taskList == null)) {
            this.taskList = new NabuccoListImpl<ProjectTask>(NabuccoCollectionState.LAZY);
        }
        ((NabuccoListImpl<ProjectTask>) this.taskList).setDelegate(taskList);
    }

    /**
     * CreatePropertyContainer.
     *
     * @return the NabuccoPropertyContainer.
     */
    protected static NabuccoPropertyContainer createPropertyContainer() {
        Map<String, NabuccoPropertyDescriptor> propertyMap = new HashMap<String, NabuccoPropertyDescriptor>();
        propertyMap.putAll(PropertyCache.getInstance().retrieve(NabuccoDatatype.class).getPropertyMap());
        propertyMap.put(STARTDATE,
                PropertyDescriptorSupport.createBasetype(STARTDATE, Date.class, 3, PROPERTY_CONSTRAINTS[0], false));
        propertyMap.put(ENDDATE,
                PropertyDescriptorSupport.createBasetype(ENDDATE, Date.class, 4, PROPERTY_CONSTRAINTS[1], false));
        propertyMap.put(TASKLIST, PropertyDescriptorSupport.createCollection(TASKLIST, ProjectTask.class, 5,
                PROPERTY_CONSTRAINTS[2], false, PropertyAssociationType.COMPOSITION));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public Set<NabuccoProperty> getProperties() {
        Set<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(ProjectPositionAssignee.getPropertyDescriptor(STARTDATE), this.startDate,
                null));
        properties
                .add(super.createProperty(ProjectPositionAssignee.getPropertyDescriptor(ENDDATE), this.endDate, null));
        properties.add(super.createProperty(ProjectPositionAssignee.getPropertyDescriptor(TASKLIST), this.taskList,
                null));
        return properties;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(STARTDATE) && (property.getType() == Date.class))) {
            this.setStartDate(((Date) property.getInstance()));
            return true;
        } else if ((property.getName().equals(ENDDATE) && (property.getType() == Date.class))) {
            this.setEndDate(((Date) property.getInstance()));
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
        final ProjectPositionAssignee other = ((ProjectPositionAssignee) obj);
        if ((this.startDate == null)) {
            if ((other.startDate != null))
                return false;
        } else if ((!this.startDate.equals(other.startDate)))
            return false;
        if ((this.endDate == null)) {
            if ((other.endDate != null))
                return false;
        } else if ((!this.endDate.equals(other.endDate)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.startDate == null) ? 0 : this.startDate.hashCode()));
        result = ((PRIME * result) + ((this.endDate == null) ? 0 : this.endDate.hashCode()));
        return result;
    }

    @Override
    public ProjectPositionAssignee cloneObject() {
        ProjectPositionAssignee clone = new ProjectPositionAssignee();
        this.cloneObject(clone);
        return clone;
    }

    /**
     * Start Date of the Assignment.
     *
     * @return the Date.
     */
    public Date getStartDate() {
        return this.startDate;
    }

    /**
     * Start Date of the Assignment.
     *
     * @param startDate the Date.
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * Start Date of the Assignment.
     *
     * @param startDate the java.util.Date.
     */
    public void setStartDate(java.util.Date startDate) {
        if ((this.startDate == null)) {
            if ((startDate == null)) {
                return;
            }
            this.startDate = new Date();
        }
        this.startDate.setValue(startDate);
    }

    /**
     * End Date of the Assignment.
     *
     * @return the Date.
     */
    public Date getEndDate() {
        return this.endDate;
    }

    /**
     * End Date of the Assignment.
     *
     * @param endDate the Date.
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * End Date of the Assignment.
     *
     * @param endDate the java.util.Date.
     */
    public void setEndDate(java.util.Date endDate) {
        if ((this.endDate == null)) {
            if ((endDate == null)) {
                return;
            }
            this.endDate = new Date();
        }
        this.endDate.setValue(endDate);
    }

    /**
     * The Tasks of the project position assignee
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
        return PropertyCache.getInstance().retrieve(ProjectPositionAssignee.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(ProjectPositionAssignee.class).getAllProperties();
    }
}
