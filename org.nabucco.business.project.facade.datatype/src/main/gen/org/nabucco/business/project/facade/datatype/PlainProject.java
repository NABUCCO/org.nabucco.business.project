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
import org.nabucco.business.project.facade.datatype.ProjectCharacteristic;
import org.nabucco.business.project.facade.datatype.ProjectCharacteristicType;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.code.Code;
import org.nabucco.framework.base.facade.datatype.code.CodePath;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyAssociationType;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;

/**
 * PlainProject<p/>Plain Representation of a Project<p/>
 *
 * @version 1.0
 * @author Nicolas Moser, PRODYNA AG, 2011-09-23
 */
public class PlainProject extends ProjectCharacteristic implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final ProjectCharacteristicType CHARACTERISTICTYPE_DEFAULT = ProjectCharacteristicType.PLAIN_PROJECT;

    private static final String[] PROPERTY_CONSTRAINTS = { "m0,1;" };

    public static final String PROJECTSTATUS = "projectStatus";

    /** Status of the Project */
    private Code projectStatus;

    private Long projectStatusRefId;

    protected static final String PROJECTSTATUS_CODEPATH = "nabucco.business.project.status";

    /** Constructs a new PlainProject instance. */
    public PlainProject() {
        super();
        this.initDefaults();
    }

    /** InitDefaults. */
    private void initDefaults() {
        characteristicType = CHARACTERISTICTYPE_DEFAULT;
    }

    /**
     * CloneObject.
     *
     * @param clone the PlainProject.
     */
    protected void cloneObject(PlainProject clone) {
        super.cloneObject(clone);
        clone.setCharacteristicType(this.getCharacteristicType());
        if ((this.getProjectStatus() != null)) {
            clone.setProjectStatus(this.getProjectStatus().cloneObject());
        }
        if ((this.getProjectStatusRefId() != null)) {
            clone.setProjectStatusRefId(this.getProjectStatusRefId());
        }
    }

    /**
     * CreatePropertyContainer.
     *
     * @return the NabuccoPropertyContainer.
     */
    protected static NabuccoPropertyContainer createPropertyContainer() {
        Map<String, NabuccoPropertyDescriptor> propertyMap = new HashMap<String, NabuccoPropertyDescriptor>();
        propertyMap.putAll(PropertyCache.getInstance().retrieve(ProjectCharacteristic.class).getPropertyMap());
        propertyMap.put(PROJECTSTATUS, PropertyDescriptorSupport.createDatatype(PROJECTSTATUS, Code.class, 8,
                PROPERTY_CONSTRAINTS[0], false, PropertyAssociationType.COMPONENT, PROJECTSTATUS_CODEPATH));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public Set<NabuccoProperty> getProperties() {
        Set<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(PlainProject.getPropertyDescriptor(PROJECTSTATUS), this.getProjectStatus(),
                this.projectStatusRefId));
        return properties;
    }

    @Override
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(PROJECTSTATUS) && (property.getType() == Code.class))) {
            this.setProjectStatus(((Code) property.getInstance()));
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
        final PlainProject other = ((PlainProject) obj);
        if ((this.projectStatus == null)) {
            if ((other.projectStatus != null))
                return false;
        } else if ((!this.projectStatus.equals(other.projectStatus)))
            return false;
        if ((this.projectStatusRefId == null)) {
            if ((other.projectStatusRefId != null))
                return false;
        } else if ((!this.projectStatusRefId.equals(other.projectStatusRefId)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.projectStatus == null) ? 0 : this.projectStatus.hashCode()));
        result = ((PRIME * result) + ((this.projectStatusRefId == null) ? 0 : this.projectStatusRefId.hashCode()));
        return result;
    }

    @Override
    public PlainProject cloneObject() {
        PlainProject clone = new PlainProject();
        this.cloneObject(clone);
        return clone;
    }

    /**
     * Status of the Project
     *
     * @param projectStatus the Code.
     */
    public void setProjectStatus(Code projectStatus) {
        this.projectStatus = projectStatus;
        if ((projectStatus != null)) {
            this.setProjectStatusRefId(projectStatus.getId());
        } else {
            this.setProjectStatusRefId(null);
        }
    }

    /**
     * Status of the Project
     *
     * @return the Code.
     */
    public Code getProjectStatus() {
        return this.projectStatus;
    }

    /**
     * Getter for the ProjectStatusRefId.
     *
     * @return the Long.
     */
    public Long getProjectStatusRefId() {
        return this.projectStatusRefId;
    }

    /**
     * Setter for the ProjectStatusRefId.
     *
     * @param projectStatusRefId the Long.
     */
    public void setProjectStatusRefId(Long projectStatusRefId) {
        this.projectStatusRefId = projectStatusRefId;
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(PlainProject.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(PlainProject.class).getAllProperties();
    }

    /**
     * Getter for the ProjectStatusCodePath.
     *
     * @return the CodePath.
     */
    public static CodePath getProjectStatusCodePath() {
        return new CodePath(PROJECTSTATUS_CODEPATH);
    }
}
