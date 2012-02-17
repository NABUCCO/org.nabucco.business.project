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
import org.nabucco.business.project.facade.datatype.ProjectCharacteristicType;
import org.nabucco.business.project.facade.datatype.ProjectMaster;
import org.nabucco.business.project.facade.datatype.ProjectPosition;
import org.nabucco.business.project.facade.datatype.ProjectRelation;
import org.nabucco.business.project.facade.datatype.ProjectSpecification;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.NabuccoDatatype;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoCollectionState;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoList;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoListImpl;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyAssociationType;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;

/**
 * ProjectCharacteristic<p/>A Generic Characteristic of a Project.<p/>
 *
 * @version 1.0
 * @author Nicolas Moser, PRODYNA AG, 2011-09-23
 */
public abstract class ProjectCharacteristic extends NabuccoDatatype implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_CONSTRAINTS = { "m1,1;", "m1,1;", "m0,n;", "m0,n;", "m1,1;" };

    public static final String CHARACTERISTICTYPE = "characteristicType";

    public static final String MASTER = "master";

    public static final String RELATIONLIST = "relationList";

    public static final String PROJECTPOSITIONLIST = "projectPositionList";

    public static final String SPECIFICATION = "specification";

    /** Type of a Project Characteristic. */
    protected ProjectCharacteristicType characteristicType;

    /** The common project master. */
    private ProjectMaster master;

    /** The list of project relations. */
    private NabuccoList<ProjectRelation> relationList;

    /** The list of project positions. */
    private NabuccoList<ProjectPosition> projectPositionList;

    /** The specification of the project. */
    private ProjectSpecification specification;

    /** Constructs a new ProjectCharacteristic instance. */
    public ProjectCharacteristic() {
        super();
        this.initDefaults();
    }

    /** InitDefaults. */
    private void initDefaults() {
    }

    /**
     * CloneObject.
     *
     * @param clone the ProjectCharacteristic.
     */
    protected void cloneObject(ProjectCharacteristic clone) {
        super.cloneObject(clone);
        clone.setCharacteristicType(this.getCharacteristicType());
        if ((this.getMaster() != null)) {
            clone.setMaster(this.getMaster().cloneObject());
        }
        if ((this.relationList != null)) {
            clone.relationList = this.relationList.cloneCollection();
        }
        if ((this.projectPositionList != null)) {
            clone.projectPositionList = this.projectPositionList.cloneCollection();
        }
        if ((this.getSpecification() != null)) {
            clone.setSpecification(this.getSpecification().cloneObject());
        }
    }

    /**
     * Getter for the RelationListJPA.
     *
     * @return the List<ProjectRelation>.
     */
    List<ProjectRelation> getRelationListJPA() {
        if ((this.relationList == null)) {
            this.relationList = new NabuccoListImpl<ProjectRelation>(NabuccoCollectionState.LAZY);
        }
        return ((NabuccoListImpl<ProjectRelation>) this.relationList).getDelegate();
    }

    /**
     * Setter for the RelationListJPA.
     *
     * @param relationList the List<ProjectRelation>.
     */
    void setRelationListJPA(List<ProjectRelation> relationList) {
        if ((this.relationList == null)) {
            this.relationList = new NabuccoListImpl<ProjectRelation>(NabuccoCollectionState.LAZY);
        }
        ((NabuccoListImpl<ProjectRelation>) this.relationList).setDelegate(relationList);
    }

    /**
     * Getter for the ProjectPositionListJPA.
     *
     * @return the List<ProjectPosition>.
     */
    List<ProjectPosition> getProjectPositionListJPA() {
        if ((this.projectPositionList == null)) {
            this.projectPositionList = new NabuccoListImpl<ProjectPosition>(NabuccoCollectionState.LAZY);
        }
        return ((NabuccoListImpl<ProjectPosition>) this.projectPositionList).getDelegate();
    }

    /**
     * Setter for the ProjectPositionListJPA.
     *
     * @param projectPositionList the List<ProjectPosition>.
     */
    void setProjectPositionListJPA(List<ProjectPosition> projectPositionList) {
        if ((this.projectPositionList == null)) {
            this.projectPositionList = new NabuccoListImpl<ProjectPosition>(NabuccoCollectionState.LAZY);
        }
        ((NabuccoListImpl<ProjectPosition>) this.projectPositionList).setDelegate(projectPositionList);
    }

    /**
     * CreatePropertyContainer.
     *
     * @return the NabuccoPropertyContainer.
     */
    protected static NabuccoPropertyContainer createPropertyContainer() {
        Map<String, NabuccoPropertyDescriptor> propertyMap = new HashMap<String, NabuccoPropertyDescriptor>();
        propertyMap.putAll(PropertyCache.getInstance().retrieve(NabuccoDatatype.class).getPropertyMap());
        propertyMap.put(CHARACTERISTICTYPE, PropertyDescriptorSupport.createEnumeration(CHARACTERISTICTYPE,
                ProjectCharacteristicType.class, 3, PROPERTY_CONSTRAINTS[0], false));
        propertyMap.put(MASTER, PropertyDescriptorSupport.createDatatype(MASTER, ProjectMaster.class, 4,
                PROPERTY_CONSTRAINTS[1], false, PropertyAssociationType.AGGREGATION));
        propertyMap.put(RELATIONLIST, PropertyDescriptorSupport.createCollection(RELATIONLIST, ProjectRelation.class,
                5, PROPERTY_CONSTRAINTS[2], false, PropertyAssociationType.COMPOSITION));
        propertyMap.put(PROJECTPOSITIONLIST, PropertyDescriptorSupport.createCollection(PROJECTPOSITIONLIST,
                ProjectPosition.class, 6, PROPERTY_CONSTRAINTS[3], false, PropertyAssociationType.COMPOSITION));
        propertyMap.put(SPECIFICATION, PropertyDescriptorSupport.createDatatype(SPECIFICATION,
                ProjectSpecification.class, 7, PROPERTY_CONSTRAINTS[4], false, PropertyAssociationType.AGGREGATION));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public Set<NabuccoProperty> getProperties() {
        Set<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(ProjectCharacteristic.getPropertyDescriptor(CHARACTERISTICTYPE),
                this.getCharacteristicType(), null));
        properties
                .add(super.createProperty(ProjectCharacteristic.getPropertyDescriptor(MASTER), this.getMaster(), null));
        properties.add(super.createProperty(ProjectCharacteristic.getPropertyDescriptor(RELATIONLIST),
                this.relationList, null));
        properties.add(super.createProperty(ProjectCharacteristic.getPropertyDescriptor(PROJECTPOSITIONLIST),
                this.projectPositionList, null));
        properties.add(super.createProperty(ProjectCharacteristic.getPropertyDescriptor(SPECIFICATION),
                this.getSpecification(), null));
        return properties;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(CHARACTERISTICTYPE) && (property.getType() == ProjectCharacteristicType.class))) {
            this.setCharacteristicType(((ProjectCharacteristicType) property.getInstance()));
            return true;
        } else if ((property.getName().equals(MASTER) && (property.getType() == ProjectMaster.class))) {
            this.setMaster(((ProjectMaster) property.getInstance()));
            return true;
        } else if ((property.getName().equals(RELATIONLIST) && (property.getType() == ProjectRelation.class))) {
            this.relationList = ((NabuccoList<ProjectRelation>) property.getInstance());
            return true;
        } else if ((property.getName().equals(PROJECTPOSITIONLIST) && (property.getType() == ProjectPosition.class))) {
            this.projectPositionList = ((NabuccoList<ProjectPosition>) property.getInstance());
            return true;
        } else if ((property.getName().equals(SPECIFICATION) && (property.getType() == ProjectSpecification.class))) {
            this.setSpecification(((ProjectSpecification) property.getInstance()));
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
        final ProjectCharacteristic other = ((ProjectCharacteristic) obj);
        if ((this.characteristicType == null)) {
            if ((other.characteristicType != null))
                return false;
        } else if ((!this.characteristicType.equals(other.characteristicType)))
            return false;
        if ((this.master == null)) {
            if ((other.master != null))
                return false;
        } else if ((!this.master.equals(other.master)))
            return false;
        if ((this.specification == null)) {
            if ((other.specification != null))
                return false;
        } else if ((!this.specification.equals(other.specification)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.characteristicType == null) ? 0 : this.characteristicType.hashCode()));
        result = ((PRIME * result) + ((this.master == null) ? 0 : this.master.hashCode()));
        result = ((PRIME * result) + ((this.specification == null) ? 0 : this.specification.hashCode()));
        return result;
    }

    @Override
    public abstract ProjectCharacteristic cloneObject();

    /**
     * Type of a Project Characteristic.
     *
     * @return the ProjectCharacteristicType.
     */
    public ProjectCharacteristicType getCharacteristicType() {
        return this.characteristicType;
    }

    /**
     * Type of a Project Characteristic.
     *
     * @param characteristicType the ProjectCharacteristicType.
     */
    public void setCharacteristicType(ProjectCharacteristicType characteristicType) {
        this.characteristicType = characteristicType;
    }

    /**
     * Type of a Project Characteristic.
     *
     * @param characteristicType the String.
     */
    public void setCharacteristicType(String characteristicType) {
        if ((characteristicType == null)) {
            this.characteristicType = null;
        } else {
            this.characteristicType = ProjectCharacteristicType.valueOf(characteristicType);
        }
    }

    /**
     * The common project master.
     *
     * @param master the ProjectMaster.
     */
    public void setMaster(ProjectMaster master) {
        this.master = master;
    }

    /**
     * The common project master.
     *
     * @return the ProjectMaster.
     */
    public ProjectMaster getMaster() {
        return this.master;
    }

    /**
     * The list of project relations.
     *
     * @return the NabuccoList<ProjectRelation>.
     */
    public NabuccoList<ProjectRelation> getRelationList() {
        if ((this.relationList == null)) {
            this.relationList = new NabuccoListImpl<ProjectRelation>(NabuccoCollectionState.INITIALIZED);
        }
        return this.relationList;
    }

    /**
     * The list of project positions.
     *
     * @return the NabuccoList<ProjectPosition>.
     */
    public NabuccoList<ProjectPosition> getProjectPositionList() {
        if ((this.projectPositionList == null)) {
            this.projectPositionList = new NabuccoListImpl<ProjectPosition>(NabuccoCollectionState.INITIALIZED);
        }
        return this.projectPositionList;
    }

    /**
     * The specification of the project.
     *
     * @param specification the ProjectSpecification.
     */
    public void setSpecification(ProjectSpecification specification) {
        this.specification = specification;
    }

    /**
     * The specification of the project.
     *
     * @return the ProjectSpecification.
     */
    public ProjectSpecification getSpecification() {
        return this.specification;
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(ProjectCharacteristic.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(ProjectCharacteristic.class).getAllProperties();
    }
}
