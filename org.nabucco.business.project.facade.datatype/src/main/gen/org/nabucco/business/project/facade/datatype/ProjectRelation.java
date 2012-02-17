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
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.NabuccoDatatype;
import org.nabucco.framework.base.facade.datatype.code.Code;
import org.nabucco.framework.base.facade.datatype.code.CodePath;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyAssociationType;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;
import org.nabucco.framework.base.facade.datatype.relation.RelationType;

/**
 * ProjectRelation<p/>Relation between two Project Characteristics.<p/>
 *
 * @version 1.0
 * @author Nicolas Moser, PRODYNA AG, 2011-09-23
 */
public class ProjectRelation extends NabuccoDatatype implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_CONSTRAINTS = { "m1,1;", "m1,1;", "m0,1;" };

    public static final String CHARACTERISTIC = "characteristic";

    public static final String RELATIONTYPE = "relationType";

    public static final String PROJECTRELATIONTYPE = "projectRelationType";

    /** The target characteristic of the relation. */
    private ProjectCharacteristic characteristic;

    /** Type of the relation. */
    private RelationType relationType;

    /** Project Specific Relation Type. */
    private Code projectRelationType;

    private Long projectRelationTypeRefId;

    protected static final String PROJECTRELATIONTYPE_CODEPATH = "nabucco.business.project.relationtype";

    /** Constructs a new ProjectRelation instance. */
    public ProjectRelation() {
        super();
        this.initDefaults();
    }

    /** InitDefaults. */
    private void initDefaults() {
    }

    /**
     * CloneObject.
     *
     * @param clone the ProjectRelation.
     */
    protected void cloneObject(ProjectRelation clone) {
        super.cloneObject(clone);
        if ((this.getCharacteristic() != null)) {
            clone.setCharacteristic(this.getCharacteristic().cloneObject());
        }
        clone.setRelationType(this.getRelationType());
        if ((this.getProjectRelationType() != null)) {
            clone.setProjectRelationType(this.getProjectRelationType().cloneObject());
        }
        if ((this.getProjectRelationTypeRefId() != null)) {
            clone.setProjectRelationTypeRefId(this.getProjectRelationTypeRefId());
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
        propertyMap.put(CHARACTERISTIC, PropertyDescriptorSupport.createDatatype(CHARACTERISTIC,
                ProjectCharacteristic.class, 3, PROPERTY_CONSTRAINTS[0], false, PropertyAssociationType.AGGREGATION));
        propertyMap.put(RELATIONTYPE, PropertyDescriptorSupport.createEnumeration(RELATIONTYPE, RelationType.class, 4,
                PROPERTY_CONSTRAINTS[1], false));
        propertyMap.put(PROJECTRELATIONTYPE, PropertyDescriptorSupport.createDatatype(PROJECTRELATIONTYPE, Code.class,
                5, PROPERTY_CONSTRAINTS[2], false, PropertyAssociationType.COMPONENT, PROJECTRELATIONTYPE_CODEPATH));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public Set<NabuccoProperty> getProperties() {
        Set<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(ProjectRelation.getPropertyDescriptor(CHARACTERISTIC),
                this.getCharacteristic(), null));
        properties.add(super.createProperty(ProjectRelation.getPropertyDescriptor(RELATIONTYPE),
                this.getRelationType(), null));
        properties.add(super.createProperty(ProjectRelation.getPropertyDescriptor(PROJECTRELATIONTYPE),
                this.getProjectRelationType(), this.projectRelationTypeRefId));
        return properties;
    }

    @Override
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(CHARACTERISTIC) && (property.getType() == ProjectCharacteristic.class))) {
            this.setCharacteristic(((ProjectCharacteristic) property.getInstance()));
            return true;
        } else if ((property.getName().equals(RELATIONTYPE) && (property.getType() == RelationType.class))) {
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
        final ProjectRelation other = ((ProjectRelation) obj);
        if ((this.characteristic == null)) {
            if ((other.characteristic != null))
                return false;
        } else if ((!this.characteristic.equals(other.characteristic)))
            return false;
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
        if ((this.projectRelationTypeRefId == null)) {
            if ((other.projectRelationTypeRefId != null))
                return false;
        } else if ((!this.projectRelationTypeRefId.equals(other.projectRelationTypeRefId)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.characteristic == null) ? 0 : this.characteristic.hashCode()));
        result = ((PRIME * result) + ((this.relationType == null) ? 0 : this.relationType.hashCode()));
        result = ((PRIME * result) + ((this.projectRelationType == null) ? 0 : this.projectRelationType.hashCode()));
        result = ((PRIME * result) + ((this.projectRelationTypeRefId == null) ? 0 : this.projectRelationTypeRefId
                .hashCode()));
        return result;
    }

    @Override
    public ProjectRelation cloneObject() {
        ProjectRelation clone = new ProjectRelation();
        this.cloneObject(clone);
        return clone;
    }

    /**
     * The target characteristic of the relation.
     *
     * @param characteristic the ProjectCharacteristic.
     */
    public void setCharacteristic(ProjectCharacteristic characteristic) {
        this.characteristic = characteristic;
    }

    /**
     * The target characteristic of the relation.
     *
     * @return the ProjectCharacteristic.
     */
    public ProjectCharacteristic getCharacteristic() {
        return this.characteristic;
    }

    /**
     * Type of the relation.
     *
     * @return the RelationType.
     */
    public RelationType getRelationType() {
        return this.relationType;
    }

    /**
     * Type of the relation.
     *
     * @param relationType the RelationType.
     */
    public void setRelationType(RelationType relationType) {
        this.relationType = relationType;
    }

    /**
     * Type of the relation.
     *
     * @param relationType the String.
     */
    public void setRelationType(String relationType) {
        if ((relationType == null)) {
            this.relationType = null;
        } else {
            this.relationType = RelationType.valueOf(relationType);
        }
    }

    /**
     * Project Specific Relation Type.
     *
     * @param projectRelationType the Code.
     */
    public void setProjectRelationType(Code projectRelationType) {
        this.projectRelationType = projectRelationType;
        if ((projectRelationType != null)) {
            this.setProjectRelationTypeRefId(projectRelationType.getId());
        } else {
            this.setProjectRelationTypeRefId(null);
        }
    }

    /**
     * Project Specific Relation Type.
     *
     * @return the Code.
     */
    public Code getProjectRelationType() {
        return this.projectRelationType;
    }

    /**
     * Getter for the ProjectRelationTypeRefId.
     *
     * @return the Long.
     */
    public Long getProjectRelationTypeRefId() {
        return this.projectRelationTypeRefId;
    }

    /**
     * Setter for the ProjectRelationTypeRefId.
     *
     * @param projectRelationTypeRefId the Long.
     */
    public void setProjectRelationTypeRefId(Long projectRelationTypeRefId) {
        this.projectRelationTypeRefId = projectRelationTypeRefId;
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(ProjectRelation.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(ProjectRelation.class).getAllProperties();
    }

    /**
     * Getter for the ProjectRelationTypeCodePath.
     *
     * @return the CodePath.
     */
    public static CodePath getProjectRelationTypeCodePath() {
        return new CodePath(PROJECTRELATIONTYPE_CODEPATH);
    }
}
