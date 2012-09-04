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
import org.nabucco.business.project.facade.datatype.ProjectPositionAssignee;
import org.nabucco.business.project.facade.datatype.ProjectTask;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.NabuccoDatatype;
import org.nabucco.framework.base.facade.datatype.Name;
import org.nabucco.framework.base.facade.datatype.Owner;
import org.nabucco.framework.base.facade.datatype.code.Code;
import org.nabucco.framework.base.facade.datatype.code.CodePath;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoCollectionState;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoList;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoListImpl;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyAssociationType;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;
import org.nabucco.framework.base.facade.datatype.text.LongDescription;

/**
 * ProjectPosition<p/>Position in a Project<p/>
 *
 * @version 1.0
 * @author Nicolas Moser, PRODYNA AG, 2011-09-23
 */
public class ProjectPosition extends NabuccoDatatype implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_CONSTRAINTS = { "l0,255;u0,n;m1,1;", "l3,12;u0,n;m1,1;",
            "l0,4000;u0,n;m0,1;", "m1,1;", "m0,n;", "m0,n;" };

    public static final String NAME = "name";

    public static final String OWNER = "owner";

    public static final String DESCRIPTION = "description";

    public static final String PROJECTROLE = "projectRole";

    public static final String ASSIGNEELIST = "assigneeList";

    public static final String PROJECTTASKLIST = "projectTaskList";

    /** Name of the Project Position */
    private Name name;

    /** Owner of the Project Position */
    private Owner owner;

    /** Description of the Project Position */
    private LongDescription description;

    /** Role of the assignee in this position. */
    private Code projectRole;

    private Long projectRoleRefId;

    protected static final String PROJECTROLE_CODEPATH = "nabucco.business.project.projectposition.role";

    /** List of assignees for this position. */
    private NabuccoList<ProjectPositionAssignee> assigneeList;

    /** The Tasks of the project position */
    private NabuccoList<ProjectTask> projectTaskList;

    /** Constructs a new ProjectPosition instance. */
    public ProjectPosition() {
        super();
        this.initDefaults();
    }

    /** InitDefaults. */
    private void initDefaults() {
    }

    /**
     * CloneObject.
     *
     * @param clone the ProjectPosition.
     */
    protected void cloneObject(ProjectPosition clone) {
        super.cloneObject(clone);
        if ((this.getName() != null)) {
            clone.setName(this.getName().cloneObject());
        }
        if ((this.getOwner() != null)) {
            clone.setOwner(this.getOwner().cloneObject());
        }
        if ((this.getDescription() != null)) {
            clone.setDescription(this.getDescription().cloneObject());
        }
        if ((this.getProjectRole() != null)) {
            clone.setProjectRole(this.getProjectRole().cloneObject());
        }
        if ((this.getProjectRoleRefId() != null)) {
            clone.setProjectRoleRefId(this.getProjectRoleRefId());
        }
        if ((this.assigneeList != null)) {
            clone.assigneeList = this.assigneeList.cloneCollection();
        }
        if ((this.projectTaskList != null)) {
            clone.projectTaskList = this.projectTaskList.cloneCollection();
        }
    }

    /**
     * Getter for the AssigneeListJPA.
     *
     * @return the List<ProjectPositionAssignee>.
     */
    List<ProjectPositionAssignee> getAssigneeListJPA() {
        if ((this.assigneeList == null)) {
            this.assigneeList = new NabuccoListImpl<ProjectPositionAssignee>(NabuccoCollectionState.LAZY);
        }
        return ((NabuccoListImpl<ProjectPositionAssignee>) this.assigneeList).getDelegate();
    }

    /**
     * Setter for the AssigneeListJPA.
     *
     * @param assigneeList the List<ProjectPositionAssignee>.
     */
    void setAssigneeListJPA(List<ProjectPositionAssignee> assigneeList) {
        if ((this.assigneeList == null)) {
            this.assigneeList = new NabuccoListImpl<ProjectPositionAssignee>(NabuccoCollectionState.LAZY);
        }
        ((NabuccoListImpl<ProjectPositionAssignee>) this.assigneeList).setDelegate(assigneeList);
    }

    /**
     * Getter for the ProjectTaskListJPA.
     *
     * @return the List<ProjectTask>.
     */
    List<ProjectTask> getProjectTaskListJPA() {
        if ((this.projectTaskList == null)) {
            this.projectTaskList = new NabuccoListImpl<ProjectTask>(NabuccoCollectionState.LAZY);
        }
        return ((NabuccoListImpl<ProjectTask>) this.projectTaskList).getDelegate();
    }

    /**
     * Setter for the ProjectTaskListJPA.
     *
     * @param projectTaskList the List<ProjectTask>.
     */
    void setProjectTaskListJPA(List<ProjectTask> projectTaskList) {
        if ((this.projectTaskList == null)) {
            this.projectTaskList = new NabuccoListImpl<ProjectTask>(NabuccoCollectionState.LAZY);
        }
        ((NabuccoListImpl<ProjectTask>) this.projectTaskList).setDelegate(projectTaskList);
    }

    /**
     * CreatePropertyContainer.
     *
     * @return the NabuccoPropertyContainer.
     */
    protected static NabuccoPropertyContainer createPropertyContainer() {
        Map<String, NabuccoPropertyDescriptor> propertyMap = new HashMap<String, NabuccoPropertyDescriptor>();
        propertyMap.putAll(PropertyCache.getInstance().retrieve(NabuccoDatatype.class).getPropertyMap());
        propertyMap.put(NAME,
                PropertyDescriptorSupport.createBasetype(NAME, Name.class, 3, PROPERTY_CONSTRAINTS[0], false));
        propertyMap.put(OWNER,
                PropertyDescriptorSupport.createBasetype(OWNER, Owner.class, 4, PROPERTY_CONSTRAINTS[1], false));
        propertyMap.put(DESCRIPTION, PropertyDescriptorSupport.createBasetype(DESCRIPTION, LongDescription.class, 5,
                PROPERTY_CONSTRAINTS[2], false));
        propertyMap.put(PROJECTROLE, PropertyDescriptorSupport.createDatatype(PROJECTROLE, Code.class, 6,
                PROPERTY_CONSTRAINTS[3], false, PropertyAssociationType.COMPONENT, PROJECTROLE_CODEPATH));
        propertyMap.put(ASSIGNEELIST, PropertyDescriptorSupport.createCollection(ASSIGNEELIST,
                ProjectPositionAssignee.class, 7, PROPERTY_CONSTRAINTS[4], false, PropertyAssociationType.COMPOSITION));
        propertyMap.put(PROJECTTASKLIST, PropertyDescriptorSupport.createCollection(PROJECTTASKLIST, ProjectTask.class,
                8, PROPERTY_CONSTRAINTS[5], false, PropertyAssociationType.COMPOSITION));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public Set<NabuccoProperty> getProperties() {
        Set<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(ProjectPosition.getPropertyDescriptor(NAME), this.name, null));
        properties.add(super.createProperty(ProjectPosition.getPropertyDescriptor(OWNER), this.owner, null));
        properties
                .add(super.createProperty(ProjectPosition.getPropertyDescriptor(DESCRIPTION), this.description, null));
        properties.add(super.createProperty(ProjectPosition.getPropertyDescriptor(PROJECTROLE), this.getProjectRole(),
                this.projectRoleRefId));
        properties.add(super.createProperty(ProjectPosition.getPropertyDescriptor(ASSIGNEELIST), this.assigneeList,
                null));
        properties.add(super.createProperty(ProjectPosition.getPropertyDescriptor(PROJECTTASKLIST),
                this.projectTaskList, null));
        return properties;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(NAME) && (property.getType() == Name.class))) {
            this.setName(((Name) property.getInstance()));
            return true;
        } else if ((property.getName().equals(OWNER) && (property.getType() == Owner.class))) {
            this.setOwner(((Owner) property.getInstance()));
            return true;
        } else if ((property.getName().equals(DESCRIPTION) && (property.getType() == LongDescription.class))) {
            this.setDescription(((LongDescription) property.getInstance()));
            return true;
        } else if ((property.getName().equals(PROJECTROLE) && (property.getType() == Code.class))) {
            this.setProjectRole(((Code) property.getInstance()));
            return true;
        } else if ((property.getName().equals(ASSIGNEELIST) && (property.getType() == ProjectPositionAssignee.class))) {
            this.assigneeList = ((NabuccoList<ProjectPositionAssignee>) property.getInstance());
            return true;
        } else if ((property.getName().equals(PROJECTTASKLIST) && (property.getType() == ProjectTask.class))) {
            this.projectTaskList = ((NabuccoList<ProjectTask>) property.getInstance());
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
        final ProjectPosition other = ((ProjectPosition) obj);
        if ((this.name == null)) {
            if ((other.name != null))
                return false;
        } else if ((!this.name.equals(other.name)))
            return false;
        if ((this.owner == null)) {
            if ((other.owner != null))
                return false;
        } else if ((!this.owner.equals(other.owner)))
            return false;
        if ((this.description == null)) {
            if ((other.description != null))
                return false;
        } else if ((!this.description.equals(other.description)))
            return false;
        if ((this.projectRole == null)) {
            if ((other.projectRole != null))
                return false;
        } else if ((!this.projectRole.equals(other.projectRole)))
            return false;
        if ((this.projectRoleRefId == null)) {
            if ((other.projectRoleRefId != null))
                return false;
        } else if ((!this.projectRoleRefId.equals(other.projectRoleRefId)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.name == null) ? 0 : this.name.hashCode()));
        result = ((PRIME * result) + ((this.owner == null) ? 0 : this.owner.hashCode()));
        result = ((PRIME * result) + ((this.description == null) ? 0 : this.description.hashCode()));
        result = ((PRIME * result) + ((this.projectRole == null) ? 0 : this.projectRole.hashCode()));
        result = ((PRIME * result) + ((this.projectRoleRefId == null) ? 0 : this.projectRoleRefId.hashCode()));
        return result;
    }

    @Override
    public ProjectPosition cloneObject() {
        ProjectPosition clone = new ProjectPosition();
        this.cloneObject(clone);
        return clone;
    }

    /**
     * Name of the Project Position
     *
     * @return the Name.
     */
    public Name getName() {
        return this.name;
    }

    /**
     * Name of the Project Position
     *
     * @param name the Name.
     */
    public void setName(Name name) {
        this.name = name;
    }

    /**
     * Name of the Project Position
     *
     * @param name the String.
     */
    public void setName(String name) {
        if ((this.name == null)) {
            if ((name == null)) {
                return;
            }
            this.name = new Name();
        }
        this.name.setValue(name);
    }

    /**
     * Owner of the Project Position
     *
     * @return the Owner.
     */
    public Owner getOwner() {
        return this.owner;
    }

    /**
     * Owner of the Project Position
     *
     * @param owner the Owner.
     */
    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    /**
     * Owner of the Project Position
     *
     * @param owner the String.
     */
    public void setOwner(String owner) {
        if ((this.owner == null)) {
            if ((owner == null)) {
                return;
            }
            this.owner = new Owner();
        }
        this.owner.setValue(owner);
    }

    /**
     * Description of the Project Position
     *
     * @return the LongDescription.
     */
    public LongDescription getDescription() {
        return this.description;
    }

    /**
     * Description of the Project Position
     *
     * @param description the LongDescription.
     */
    public void setDescription(LongDescription description) {
        this.description = description;
    }

    /**
     * Description of the Project Position
     *
     * @param description the String.
     */
    public void setDescription(String description) {
        if ((this.description == null)) {
            if ((description == null)) {
                return;
            }
            this.description = new LongDescription();
        }
        this.description.setValue(description);
    }

    /**
     * Role of the assignee in this position.
     *
     * @param projectRole the Code.
     */
    public void setProjectRole(Code projectRole) {
        this.projectRole = projectRole;
        if ((projectRole != null)) {
            this.setProjectRoleRefId(projectRole.getId());
        } else {
            this.setProjectRoleRefId(null);
        }
    }

    /**
     * Role of the assignee in this position.
     *
     * @return the Code.
     */
    public Code getProjectRole() {
        return this.projectRole;
    }

    /**
     * Getter for the ProjectRoleRefId.
     *
     * @return the Long.
     */
    public Long getProjectRoleRefId() {
        return this.projectRoleRefId;
    }

    /**
     * Setter for the ProjectRoleRefId.
     *
     * @param projectRoleRefId the Long.
     */
    public void setProjectRoleRefId(Long projectRoleRefId) {
        this.projectRoleRefId = projectRoleRefId;
    }

    /**
     * List of assignees for this position.
     *
     * @return the NabuccoList<ProjectPositionAssignee>.
     */
    public NabuccoList<ProjectPositionAssignee> getAssigneeList() {
        if ((this.assigneeList == null)) {
            this.assigneeList = new NabuccoListImpl<ProjectPositionAssignee>(NabuccoCollectionState.INITIALIZED);
        }
        return this.assigneeList;
    }

    /**
     * The Tasks of the project position
     *
     * @return the NabuccoList<ProjectTask>.
     */
    public NabuccoList<ProjectTask> getProjectTaskList() {
        if ((this.projectTaskList == null)) {
            this.projectTaskList = new NabuccoListImpl<ProjectTask>(NabuccoCollectionState.INITIALIZED);
        }
        return this.projectTaskList;
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(ProjectPosition.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(ProjectPosition.class).getAllProperties();
    }

    /**
     * Getter for the ProjectRoleCodePath.
     *
     * @return the CodePath.
     */
    public static CodePath getProjectRoleCodePath() {
        return new CodePath(PROJECTROLE_CODEPATH);
    }
}
