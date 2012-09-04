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
package org.nabucco.business.project.facade.datatype;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.nabucco.business.project.facade.datatype.ProjectCharacteristic;
import org.nabucco.business.project.facade.datatype.ProjectPosition;
import org.nabucco.business.project.facade.datatype.ProjectPositionAssignee;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.DatatypeSupport;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyAssociationType;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;

/**
 * ProjectPositionAssigneeContainer<p/>Message with project and project position pro assignment<p/>
 *
 * @version 1.0
 * @author Leonid Agranovskiy, PRODYNA AG, 2012-01-23
 */
public class ProjectPositionAssigneeContainer extends DatatypeSupport implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_CONSTRAINTS = { "m1,1;", "m1,1;", "m1,1;" };

    public static final String PROJECTPOSITIONASSIGNEE = "projectPositionAssignee";

    public static final String PROJECTPOSITION = "projectPosition";

    public static final String PROJECT = "project";

    /** project position assignee */
    private ProjectPositionAssignee projectPositionAssignee;

    /** project position for the assignee */
    private ProjectPosition projectPosition;

    /** project for the assignee */
    private ProjectCharacteristic project;

    /** Constructs a new ProjectPositionAssigneeContainer instance. */
    public ProjectPositionAssigneeContainer() {
        super();
        this.initDefaults();
    }

    /** InitDefaults. */
    private void initDefaults() {
    }

    /**
     * CloneObject.
     *
     * @param clone the ProjectPositionAssigneeContainer.
     */
    protected void cloneObject(ProjectPositionAssigneeContainer clone) {
        super.cloneObject(clone);
        if ((this.getProjectPositionAssignee() != null)) {
            clone.setProjectPositionAssignee(this.getProjectPositionAssignee().cloneObject());
        }
        if ((this.getProjectPosition() != null)) {
            clone.setProjectPosition(this.getProjectPosition().cloneObject());
        }
        if ((this.getProject() != null)) {
            clone.setProject(this.getProject().cloneObject());
        }
    }

    /**
     * CreatePropertyContainer.
     *
     * @return the NabuccoPropertyContainer.
     */
    protected static NabuccoPropertyContainer createPropertyContainer() {
        Map<String, NabuccoPropertyDescriptor> propertyMap = new HashMap<String, NabuccoPropertyDescriptor>();
        propertyMap.put(PROJECTPOSITIONASSIGNEE, PropertyDescriptorSupport.createDatatype(PROJECTPOSITIONASSIGNEE,
                ProjectPositionAssignee.class, 0, PROPERTY_CONSTRAINTS[0], false, PropertyAssociationType.COMPOSITION));
        propertyMap.put(PROJECTPOSITION, PropertyDescriptorSupport.createDatatype(PROJECTPOSITION,
                ProjectPosition.class, 1, PROPERTY_CONSTRAINTS[1], false, PropertyAssociationType.COMPOSITION));
        propertyMap.put(PROJECT, PropertyDescriptorSupport.createDatatype(PROJECT, ProjectCharacteristic.class, 2,
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
        properties.add(super.createProperty(
                ProjectPositionAssigneeContainer.getPropertyDescriptor(PROJECTPOSITIONASSIGNEE),
                this.getProjectPositionAssignee(), null));
        properties.add(super.createProperty(ProjectPositionAssigneeContainer.getPropertyDescriptor(PROJECTPOSITION),
                this.getProjectPosition(), null));
        properties.add(super.createProperty(ProjectPositionAssigneeContainer.getPropertyDescriptor(PROJECT),
                this.getProject(), null));
        return properties;
    }

    @Override
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(PROJECTPOSITIONASSIGNEE) && (property.getType() == ProjectPositionAssignee.class))) {
            this.setProjectPositionAssignee(((ProjectPositionAssignee) property.getInstance()));
            return true;
        } else if ((property.getName().equals(PROJECTPOSITION) && (property.getType() == ProjectPosition.class))) {
            this.setProjectPosition(((ProjectPosition) property.getInstance()));
            return true;
        } else if ((property.getName().equals(PROJECT) && (property.getType() == ProjectCharacteristic.class))) {
            this.setProject(((ProjectCharacteristic) property.getInstance()));
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
        final ProjectPositionAssigneeContainer other = ((ProjectPositionAssigneeContainer) obj);
        if ((this.projectPositionAssignee == null)) {
            if ((other.projectPositionAssignee != null))
                return false;
        } else if ((!this.projectPositionAssignee.equals(other.projectPositionAssignee)))
            return false;
        if ((this.projectPosition == null)) {
            if ((other.projectPosition != null))
                return false;
        } else if ((!this.projectPosition.equals(other.projectPosition)))
            return false;
        if ((this.project == null)) {
            if ((other.project != null))
                return false;
        } else if ((!this.project.equals(other.project)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.projectPositionAssignee == null) ? 0 : this.projectPositionAssignee
                .hashCode()));
        result = ((PRIME * result) + ((this.projectPosition == null) ? 0 : this.projectPosition.hashCode()));
        result = ((PRIME * result) + ((this.project == null) ? 0 : this.project.hashCode()));
        return result;
    }

    @Override
    public ProjectPositionAssigneeContainer cloneObject() {
        ProjectPositionAssigneeContainer clone = new ProjectPositionAssigneeContainer();
        this.cloneObject(clone);
        return clone;
    }

    /**
     * project position assignee
     *
     * @param projectPositionAssignee the ProjectPositionAssignee.
     */
    public void setProjectPositionAssignee(ProjectPositionAssignee projectPositionAssignee) {
        this.projectPositionAssignee = projectPositionAssignee;
    }

    /**
     * project position assignee
     *
     * @return the ProjectPositionAssignee.
     */
    public ProjectPositionAssignee getProjectPositionAssignee() {
        return this.projectPositionAssignee;
    }

    /**
     * project position for the assignee
     *
     * @param projectPosition the ProjectPosition.
     */
    public void setProjectPosition(ProjectPosition projectPosition) {
        this.projectPosition = projectPosition;
    }

    /**
     * project position for the assignee
     *
     * @return the ProjectPosition.
     */
    public ProjectPosition getProjectPosition() {
        return this.projectPosition;
    }

    /**
     * project for the assignee
     *
     * @param project the ProjectCharacteristic.
     */
    public void setProject(ProjectCharacteristic project) {
        this.project = project;
    }

    /**
     * project for the assignee
     *
     * @return the ProjectCharacteristic.
     */
    public ProjectCharacteristic getProject() {
        return this.project;
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(ProjectPositionAssigneeContainer.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(ProjectPositionAssigneeContainer.class).getAllProperties();
    }
}
