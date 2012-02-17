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
import org.nabucco.framework.base.facade.datatype.code.Code;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyAssociationType;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;
import org.nabucco.framework.base.facade.datatype.relation.RelationType;
import org.nabucco.framework.base.facade.message.ServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceMessageSupport;

/**
 * ProjectRelationPrototypeRq<p/>Request Message for Project Characteristic Production.<p/>
 *
 * @version 1.0
 * @author Nicolas Moser, PRODYNA AG, 2011-09-23
 */
public class ProjectRelationPrototypeRq extends ServiceMessageSupport implements ServiceMessage {

    private static final long serialVersionUID = 1L;

    private static final RelationType RELATIONTYPE_DEFAULT = RelationType.IS;

    private static final String[] PROPERTY_CONSTRAINTS = { "m1,1;", "m0,1;" };

    public static final String RELATIONTYPE = "relationType";

    public static final String PROJECTRELATIONTYPE = "projectRelationType";

    /** Type of the Relation. */
    private RelationType relationType;

    /** Type of the Project Relation. */
    private Code projectRelationType;

    /** Constructs a new ProjectRelationPrototypeRq instance. */
    public ProjectRelationPrototypeRq() {
        super();
        this.initDefaults();
    }

    /** InitDefaults. */
    private void initDefaults() {
        relationType = RELATIONTYPE_DEFAULT;
    }

    /**
     * CreatePropertyContainer.
     *
     * @return the NabuccoPropertyContainer.
     */
    protected static NabuccoPropertyContainer createPropertyContainer() {
        Map<String, NabuccoPropertyDescriptor> propertyMap = new HashMap<String, NabuccoPropertyDescriptor>();
        propertyMap.put(RELATIONTYPE, PropertyDescriptorSupport.createEnumeration(RELATIONTYPE, RelationType.class, 0,
                PROPERTY_CONSTRAINTS[0], false));
        propertyMap.put(PROJECTRELATIONTYPE, PropertyDescriptorSupport.createDatatype(PROJECTRELATIONTYPE, Code.class,
                1, PROPERTY_CONSTRAINTS[1], false, PropertyAssociationType.COMPONENT));
        return new NabuccoPropertyContainer(propertyMap);
    }

    /** Init. */
    public void init() {
        this.initDefaults();
    }

    @Override
    public Set<NabuccoProperty> getProperties() {
        Set<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(ProjectRelationPrototypeRq.getPropertyDescriptor(RELATIONTYPE),
                this.getRelationType()));
        properties.add(super.createProperty(ProjectRelationPrototypeRq.getPropertyDescriptor(PROJECTRELATIONTYPE),
                this.getProjectRelationType()));
        return properties;
    }

    @Override
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(RELATIONTYPE) && (property.getType() == RelationType.class))) {
            this.setRelationType(((RelationType) property.getInstance()));
            return true;
        } else if ((property.getName().equals(PROJECTRELATIONTYPE) && (property.getType() == Code.class))) {
            this.setProjectRelationType(((Code) property.getInstance()));
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
        final ProjectRelationPrototypeRq other = ((ProjectRelationPrototypeRq) obj);
        if ((this.relationType == null)) {
            if ((other.relationType != null))
                return false;
        } else if ((!this.relationType.equals(other.relationType)))
            return false;
        if ((this.projectRelationType == null)) {
            if ((other.projectRelationType != null))
                return false;
        } else if ((!this.projectRelationType.equals(other.projectRelationType)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.relationType == null) ? 0 : this.relationType.hashCode()));
        result = ((PRIME * result) + ((this.projectRelationType == null) ? 0 : this.projectRelationType.hashCode()));
        return result;
    }

    @Override
    public ServiceMessage cloneObject() {
        return this;
    }

    /**
     * Type of the Relation.
     *
     * @return the RelationType.
     */
    public RelationType getRelationType() {
        return this.relationType;
    }

    /**
     * Type of the Relation.
     *
     * @param relationType the RelationType.
     */
    public void setRelationType(RelationType relationType) {
        this.relationType = relationType;
    }

    /**
     * Type of the Project Relation.
     *
     * @return the Code.
     */
    public Code getProjectRelationType() {
        return this.projectRelationType;
    }

    /**
     * Type of the Project Relation.
     *
     * @param projectRelationType the Code.
     */
    public void setProjectRelationType(Code projectRelationType) {
        this.projectRelationType = projectRelationType;
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(ProjectRelationPrototypeRq.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(ProjectRelationPrototypeRq.class).getAllProperties();
    }
}
