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
package org.nabucco.business.project.facade.message.produce;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.nabucco.business.project.facade.datatype.ProjectCharacteristicType;
import org.nabucco.business.project.facade.datatype.ProjectMaster;
import org.nabucco.business.project.facade.datatype.ProjectSpecification;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyAssociationType;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;
import org.nabucco.framework.base.facade.message.ServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceMessageSupport;

/**
 * ProjectCharacteristicPrototypeRq<p/>Request Message for Project Characteristic Production.<p/>
 *
 * @version 1.0
 * @author Nicolas Moser, PRODYNA AG, 2011-09-23
 */
public class ProjectCharacteristicPrototypeRq extends ServiceMessageSupport implements ServiceMessage {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_CONSTRAINTS = { "m1,1;", "m0,1;", "m0,1;" };

    public static final String TYPE = "type";

    public static final String SPECIFICATION = "specification";

    public static final String PROJECTMASTER = "projectMaster";

    /** Type of the characteristic to produce. */
    private ProjectCharacteristicType type;

    /** The project specification. */
    private ProjectSpecification specification;

    /** The project master to use. */
    private ProjectMaster projectMaster;

    /** Constructs a new ProjectCharacteristicPrototypeRq instance. */
    public ProjectCharacteristicPrototypeRq() {
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
        propertyMap.put(TYPE, PropertyDescriptorSupport.createEnumeration(TYPE, ProjectCharacteristicType.class, 0,
                PROPERTY_CONSTRAINTS[0], false));
        propertyMap.put(SPECIFICATION, PropertyDescriptorSupport.createDatatype(SPECIFICATION,
                ProjectSpecification.class, 1, PROPERTY_CONSTRAINTS[1], false, PropertyAssociationType.COMPOSITION));
        propertyMap.put(PROJECTMASTER, PropertyDescriptorSupport.createDatatype(PROJECTMASTER, ProjectMaster.class, 2,
                PROPERTY_CONSTRAINTS[2], false, PropertyAssociationType.COMPOSITION));
        return new NabuccoPropertyContainer(propertyMap);
    }

    /** Init. */
    public void init() {
        this.initDefaults();
    }

    @Override
    public Set<NabuccoProperty> getProperties() {
        Set<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(ProjectCharacteristicPrototypeRq.getPropertyDescriptor(TYPE),
                this.getType()));
        properties.add(super.createProperty(ProjectCharacteristicPrototypeRq.getPropertyDescriptor(SPECIFICATION),
                this.getSpecification()));
        properties.add(super.createProperty(ProjectCharacteristicPrototypeRq.getPropertyDescriptor(PROJECTMASTER),
                this.getProjectMaster()));
        return properties;
    }

    @Override
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(TYPE) && (property.getType() == ProjectCharacteristicType.class))) {
            this.setType(((ProjectCharacteristicType) property.getInstance()));
            return true;
        } else if ((property.getName().equals(SPECIFICATION) && (property.getType() == ProjectSpecification.class))) {
            this.setSpecification(((ProjectSpecification) property.getInstance()));
            return true;
        } else if ((property.getName().equals(PROJECTMASTER) && (property.getType() == ProjectMaster.class))) {
            this.setProjectMaster(((ProjectMaster) property.getInstance()));
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
        final ProjectCharacteristicPrototypeRq other = ((ProjectCharacteristicPrototypeRq) obj);
        if ((this.type == null)) {
            if ((other.type != null))
                return false;
        } else if ((!this.type.equals(other.type)))
            return false;
        if ((this.specification == null)) {
            if ((other.specification != null))
                return false;
        } else if ((!this.specification.equals(other.specification)))
            return false;
        if ((this.projectMaster == null)) {
            if ((other.projectMaster != null))
                return false;
        } else if ((!this.projectMaster.equals(other.projectMaster)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.type == null) ? 0 : this.type.hashCode()));
        result = ((PRIME * result) + ((this.specification == null) ? 0 : this.specification.hashCode()));
        result = ((PRIME * result) + ((this.projectMaster == null) ? 0 : this.projectMaster.hashCode()));
        return result;
    }

    @Override
    public ServiceMessage cloneObject() {
        return this;
    }

    /**
     * Type of the characteristic to produce.
     *
     * @return the ProjectCharacteristicType.
     */
    public ProjectCharacteristicType getType() {
        return this.type;
    }

    /**
     * Type of the characteristic to produce.
     *
     * @param type the ProjectCharacteristicType.
     */
    public void setType(ProjectCharacteristicType type) {
        this.type = type;
    }

    /**
     * The project specification.
     *
     * @return the ProjectSpecification.
     */
    public ProjectSpecification getSpecification() {
        return this.specification;
    }

    /**
     * The project specification.
     *
     * @param specification the ProjectSpecification.
     */
    public void setSpecification(ProjectSpecification specification) {
        this.specification = specification;
    }

    /**
     * The project master to use.
     *
     * @return the ProjectMaster.
     */
    public ProjectMaster getProjectMaster() {
        return this.projectMaster;
    }

    /**
     * The project master to use.
     *
     * @param projectMaster the ProjectMaster.
     */
    public void setProjectMaster(ProjectMaster projectMaster) {
        this.projectMaster = projectMaster;
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(ProjectCharacteristicPrototypeRq.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(ProjectCharacteristicPrototypeRq.class).getAllProperties();
    }
}
