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
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.Description;
import org.nabucco.framework.base.facade.datatype.Flag;
import org.nabucco.framework.base.facade.datatype.NabuccoDatatype;
import org.nabucco.framework.base.facade.datatype.code.Code;
import org.nabucco.framework.base.facade.datatype.code.CodePath;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyAssociationType;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;

/**
 * ProjectSpecification<p/>Functional Specification of a Project Characteristic.<p/>
 *
 * @version 1.0
 * @author Nicolas Moser, PRODYNA AG, 2011-09-23
 */
public class ProjectSpecification extends NabuccoDatatype implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final Flag ALLOWSUBPROJECTS_DEFAULT = new Flag(true);

    private static final String[] PROPERTY_CONSTRAINTS = { "m1,1;", "l0,255;u0,n;m0,1;", "l0,n;u0,n;m1,1;" };

    public static final String SPECIFICATIONTYPE = "specificationType";

    public static final String DESCRIPTION = "description";

    public static final String ALLOWSUBPROJECTS = "allowSubProjects";

    /** The project Specification type. */
    private Code specificationType;

    private Long specificationTypeRefId;

    protected static final String SPECIFICATIONTYPE_CODEPATH = "nabucco.business.project.specification";

    /** An optional description of the specification. */
    private Description description;

    /** Whether sub projects are allowed or not. */
    private Flag allowSubProjects;

    /** Constructs a new ProjectSpecification instance. */
    public ProjectSpecification() {
        super();
        this.initDefaults();
    }

    /** InitDefaults. */
    private void initDefaults() {
        allowSubProjects = ALLOWSUBPROJECTS_DEFAULT;
    }

    /**
     * CloneObject.
     *
     * @param clone the ProjectSpecification.
     */
    protected void cloneObject(ProjectSpecification clone) {
        super.cloneObject(clone);
        if ((this.getSpecificationType() != null)) {
            clone.setSpecificationType(this.getSpecificationType().cloneObject());
        }
        if ((this.getSpecificationTypeRefId() != null)) {
            clone.setSpecificationTypeRefId(this.getSpecificationTypeRefId());
        }
        if ((this.getDescription() != null)) {
            clone.setDescription(this.getDescription().cloneObject());
        }
        if ((this.getAllowSubProjects() != null)) {
            clone.setAllowSubProjects(this.getAllowSubProjects().cloneObject());
        }
    }

    /**
     * CreatePropertyContainer.
     *
     * @return the NabuccoPropertyContainer.
     */
    protected static NabuccoPropertyContainer createPropertyContainer() {
        Map<String, NabuccoPropertyDescriptor> propertyMap = new HashMap<String, NabuccoPropertyDescriptor>();
        propertyMap.putAll(PropertyCache.getInstance().retrieve(NabuccoDatatype.class).getPropertyMap());
        propertyMap.put(SPECIFICATIONTYPE, PropertyDescriptorSupport.createDatatype(SPECIFICATIONTYPE, Code.class, 3,
                PROPERTY_CONSTRAINTS[0], false, PropertyAssociationType.COMPONENT, SPECIFICATIONTYPE_CODEPATH));
        propertyMap.put(DESCRIPTION, PropertyDescriptorSupport.createBasetype(DESCRIPTION, Description.class, 4,
                PROPERTY_CONSTRAINTS[1], false));
        propertyMap.put(ALLOWSUBPROJECTS, PropertyDescriptorSupport.createBasetype(ALLOWSUBPROJECTS, Flag.class, 5,
                PROPERTY_CONSTRAINTS[2], false));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public Set<NabuccoProperty> getProperties() {
        Set<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(ProjectSpecification.getPropertyDescriptor(SPECIFICATIONTYPE),
                this.getSpecificationType(), this.specificationTypeRefId));
        properties.add(super.createProperty(ProjectSpecification.getPropertyDescriptor(DESCRIPTION), this.description,
                null));
        properties.add(super.createProperty(ProjectSpecification.getPropertyDescriptor(ALLOWSUBPROJECTS),
                this.allowSubProjects, null));
        return properties;
    }

    @Override
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(SPECIFICATIONTYPE) && (property.getType() == Code.class))) {
            this.setSpecificationType(((Code) property.getInstance()));
            return true;
        } else if ((property.getName().equals(DESCRIPTION) && (property.getType() == Description.class))) {
            this.setDescription(((Description) property.getInstance()));
            return true;
        } else if ((property.getName().equals(ALLOWSUBPROJECTS) && (property.getType() == Flag.class))) {
            this.setAllowSubProjects(((Flag) property.getInstance()));
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
        final ProjectSpecification other = ((ProjectSpecification) obj);
        if ((this.specificationType == null)) {
            if ((other.specificationType != null))
                return false;
        } else if ((!this.specificationType.equals(other.specificationType)))
            return false;
        if ((this.specificationTypeRefId == null)) {
            if ((other.specificationTypeRefId != null))
                return false;
        } else if ((!this.specificationTypeRefId.equals(other.specificationTypeRefId)))
            return false;
        if ((this.description == null)) {
            if ((other.description != null))
                return false;
        } else if ((!this.description.equals(other.description)))
            return false;
        if ((this.allowSubProjects == null)) {
            if ((other.allowSubProjects != null))
                return false;
        } else if ((!this.allowSubProjects.equals(other.allowSubProjects)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.specificationType == null) ? 0 : this.specificationType.hashCode()));
        result = ((PRIME * result) + ((this.specificationTypeRefId == null) ? 0 : this.specificationTypeRefId
                .hashCode()));
        result = ((PRIME * result) + ((this.description == null) ? 0 : this.description.hashCode()));
        result = ((PRIME * result) + ((this.allowSubProjects == null) ? 0 : this.allowSubProjects.hashCode()));
        return result;
    }

    @Override
    public ProjectSpecification cloneObject() {
        ProjectSpecification clone = new ProjectSpecification();
        this.cloneObject(clone);
        return clone;
    }

    /**
     * The project Specification type.
     *
     * @param specificationType the Code.
     */
    public void setSpecificationType(Code specificationType) {
        this.specificationType = specificationType;
        if ((specificationType != null)) {
            this.setSpecificationTypeRefId(specificationType.getId());
        } else {
            this.setSpecificationTypeRefId(null);
        }
    }

    /**
     * The project Specification type.
     *
     * @return the Code.
     */
    public Code getSpecificationType() {
        return this.specificationType;
    }

    /**
     * Getter for the SpecificationTypeRefId.
     *
     * @return the Long.
     */
    public Long getSpecificationTypeRefId() {
        return this.specificationTypeRefId;
    }

    /**
     * Setter for the SpecificationTypeRefId.
     *
     * @param specificationTypeRefId the Long.
     */
    public void setSpecificationTypeRefId(Long specificationTypeRefId) {
        this.specificationTypeRefId = specificationTypeRefId;
    }

    /**
     * An optional description of the specification.
     *
     * @return the Description.
     */
    public Description getDescription() {
        return this.description;
    }

    /**
     * An optional description of the specification.
     *
     * @param description the Description.
     */
    public void setDescription(Description description) {
        this.description = description;
    }

    /**
     * An optional description of the specification.
     *
     * @param description the String.
     */
    public void setDescription(String description) {
        if ((this.description == null)) {
            if ((description == null)) {
                return;
            }
            this.description = new Description();
        }
        this.description.setValue(description);
    }

    /**
     * Whether sub projects are allowed or not.
     *
     * @return the Flag.
     */
    public Flag getAllowSubProjects() {
        return this.allowSubProjects;
    }

    /**
     * Whether sub projects are allowed or not.
     *
     * @param allowSubProjects the Flag.
     */
    public void setAllowSubProjects(Flag allowSubProjects) {
        this.allowSubProjects = allowSubProjects;
    }

    /**
     * Whether sub projects are allowed or not.
     *
     * @param allowSubProjects the Boolean.
     */
    public void setAllowSubProjects(Boolean allowSubProjects) {
        if ((this.allowSubProjects == null)) {
            if ((allowSubProjects == null)) {
                return;
            }
            this.allowSubProjects = new Flag();
        }
        this.allowSubProjects.setValue(allowSubProjects);
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(ProjectSpecification.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(ProjectSpecification.class).getAllProperties();
    }

    /**
     * Getter for the SpecificationTypeCodePath.
     *
     * @return the CodePath.
     */
    public static CodePath getSpecificationTypeCodePath() {
        return new CodePath(SPECIFICATIONTYPE_CODEPATH);
    }
}
