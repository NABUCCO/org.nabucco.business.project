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
package org.nabucco.business.project.facade.message.search;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.nabucco.business.project.facade.datatype.ProjectCharacteristicType;
import org.nabucco.framework.base.facade.datatype.Identifier;
import org.nabucco.framework.base.facade.datatype.Name;
import org.nabucco.framework.base.facade.datatype.Owner;
import org.nabucco.framework.base.facade.datatype.date.Date;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;
import org.nabucco.framework.base.facade.message.ServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceMessageSupport;

/**
 * ProjectSearchRq<p/>Search request for Projects<p/>
 *
 * @version 1.0
 * @author Nicolas Moser, PRODYNA AG, 2011-26-09
 */
public class ProjectSearchRq extends ServiceMessageSupport implements ServiceMessage {

    private static final long serialVersionUID = 1L;

    private static final ProjectCharacteristicType TYPE_DEFAULT = ProjectCharacteristicType.PLAIN_PROJECT;

    private static final String[] PROPERTY_CONSTRAINTS = { "m1,1;", "l0,255;u0,n;m0,1;", "l3,12;u0,n;m0,1;",
            "l0,n;u0,n;m0,1;", "l0,n;u0,n;m0,1;", "l0,n;u0,n;m0,1;", "l0,n;u0,n;m0,1;", "l0,n;u0,n;m0,1;" };

    public static final String TYPE = "type";

    public static final String NAME = "name";

    public static final String OWNER = "owner";

    public static final String STARTFROM = "startFrom";

    public static final String STARTTO = "startTo";

    public static final String ENDFROM = "endFrom";

    public static final String ENDTO = "endTo";

    public static final String PROJECTPOSITIONID = "projectPositionId";

    /** The Characteristic type to search for. */
    private ProjectCharacteristicType type;

    /** The Project Name. */
    private Name name;

    /** The Project Owner. */
    private Owner owner;

    /** The first start date. */
    private Date startFrom;

    /** The last end date. */
    private Date startTo;

    /** The first start date. */
    private Date endFrom;

    /** The last end date. */
    private Date endTo;

    /** ID of the project position hold by the searched project. */
    private Identifier projectPositionId;

    /** Constructs a new ProjectSearchRq instance. */
    public ProjectSearchRq() {
        super();
        this.initDefaults();
    }

    /** InitDefaults. */
    private void initDefaults() {
        type = TYPE_DEFAULT;
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
        propertyMap.put(NAME,
                PropertyDescriptorSupport.createBasetype(NAME, Name.class, 1, PROPERTY_CONSTRAINTS[1], false));
        propertyMap.put(OWNER,
                PropertyDescriptorSupport.createBasetype(OWNER, Owner.class, 2, PROPERTY_CONSTRAINTS[2], false));
        propertyMap.put(STARTFROM,
                PropertyDescriptorSupport.createBasetype(STARTFROM, Date.class, 3, PROPERTY_CONSTRAINTS[3], false));
        propertyMap.put(STARTTO,
                PropertyDescriptorSupport.createBasetype(STARTTO, Date.class, 4, PROPERTY_CONSTRAINTS[4], false));
        propertyMap.put(ENDFROM,
                PropertyDescriptorSupport.createBasetype(ENDFROM, Date.class, 5, PROPERTY_CONSTRAINTS[5], false));
        propertyMap.put(ENDTO,
                PropertyDescriptorSupport.createBasetype(ENDTO, Date.class, 6, PROPERTY_CONSTRAINTS[6], false));
        propertyMap.put(PROJECTPOSITIONID, PropertyDescriptorSupport.createBasetype(PROJECTPOSITIONID,
                Identifier.class, 7, PROPERTY_CONSTRAINTS[7], false));
        return new NabuccoPropertyContainer(propertyMap);
    }

    /** Init. */
    public void init() {
        this.initDefaults();
    }

    @Override
    public Set<NabuccoProperty> getProperties() {
        Set<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(ProjectSearchRq.getPropertyDescriptor(TYPE), this.getType()));
        properties.add(super.createProperty(ProjectSearchRq.getPropertyDescriptor(NAME), this.name));
        properties.add(super.createProperty(ProjectSearchRq.getPropertyDescriptor(OWNER), this.owner));
        properties.add(super.createProperty(ProjectSearchRq.getPropertyDescriptor(STARTFROM), this.startFrom));
        properties.add(super.createProperty(ProjectSearchRq.getPropertyDescriptor(STARTTO), this.startTo));
        properties.add(super.createProperty(ProjectSearchRq.getPropertyDescriptor(ENDFROM), this.endFrom));
        properties.add(super.createProperty(ProjectSearchRq.getPropertyDescriptor(ENDTO), this.endTo));
        properties.add(super.createProperty(ProjectSearchRq.getPropertyDescriptor(PROJECTPOSITIONID),
                this.projectPositionId));
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
        } else if ((property.getName().equals(NAME) && (property.getType() == Name.class))) {
            this.setName(((Name) property.getInstance()));
            return true;
        } else if ((property.getName().equals(OWNER) && (property.getType() == Owner.class))) {
            this.setOwner(((Owner) property.getInstance()));
            return true;
        } else if ((property.getName().equals(STARTFROM) && (property.getType() == Date.class))) {
            this.setStartFrom(((Date) property.getInstance()));
            return true;
        } else if ((property.getName().equals(STARTTO) && (property.getType() == Date.class))) {
            this.setStartTo(((Date) property.getInstance()));
            return true;
        } else if ((property.getName().equals(ENDFROM) && (property.getType() == Date.class))) {
            this.setEndFrom(((Date) property.getInstance()));
            return true;
        } else if ((property.getName().equals(ENDTO) && (property.getType() == Date.class))) {
            this.setEndTo(((Date) property.getInstance()));
            return true;
        } else if ((property.getName().equals(PROJECTPOSITIONID) && (property.getType() == Identifier.class))) {
            this.setProjectPositionId(((Identifier) property.getInstance()));
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
        final ProjectSearchRq other = ((ProjectSearchRq) obj);
        if ((this.type == null)) {
            if ((other.type != null))
                return false;
        } else if ((!this.type.equals(other.type)))
            return false;
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
        if ((this.startFrom == null)) {
            if ((other.startFrom != null))
                return false;
        } else if ((!this.startFrom.equals(other.startFrom)))
            return false;
        if ((this.startTo == null)) {
            if ((other.startTo != null))
                return false;
        } else if ((!this.startTo.equals(other.startTo)))
            return false;
        if ((this.endFrom == null)) {
            if ((other.endFrom != null))
                return false;
        } else if ((!this.endFrom.equals(other.endFrom)))
            return false;
        if ((this.endTo == null)) {
            if ((other.endTo != null))
                return false;
        } else if ((!this.endTo.equals(other.endTo)))
            return false;
        if ((this.projectPositionId == null)) {
            if ((other.projectPositionId != null))
                return false;
        } else if ((!this.projectPositionId.equals(other.projectPositionId)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.type == null) ? 0 : this.type.hashCode()));
        result = ((PRIME * result) + ((this.name == null) ? 0 : this.name.hashCode()));
        result = ((PRIME * result) + ((this.owner == null) ? 0 : this.owner.hashCode()));
        result = ((PRIME * result) + ((this.startFrom == null) ? 0 : this.startFrom.hashCode()));
        result = ((PRIME * result) + ((this.startTo == null) ? 0 : this.startTo.hashCode()));
        result = ((PRIME * result) + ((this.endFrom == null) ? 0 : this.endFrom.hashCode()));
        result = ((PRIME * result) + ((this.endTo == null) ? 0 : this.endTo.hashCode()));
        result = ((PRIME * result) + ((this.projectPositionId == null) ? 0 : this.projectPositionId.hashCode()));
        return result;
    }

    @Override
    public ServiceMessage cloneObject() {
        return this;
    }

    /**
     * The Characteristic type to search for.
     *
     * @return the ProjectCharacteristicType.
     */
    public ProjectCharacteristicType getType() {
        return this.type;
    }

    /**
     * The Characteristic type to search for.
     *
     * @param type the ProjectCharacteristicType.
     */
    public void setType(ProjectCharacteristicType type) {
        this.type = type;
    }

    /**
     * The Project Name.
     *
     * @return the Name.
     */
    public Name getName() {
        return this.name;
    }

    /**
     * The Project Name.
     *
     * @param name the Name.
     */
    public void setName(Name name) {
        this.name = name;
    }

    /**
     * The Project Owner.
     *
     * @return the Owner.
     */
    public Owner getOwner() {
        return this.owner;
    }

    /**
     * The Project Owner.
     *
     * @param owner the Owner.
     */
    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    /**
     * The first start date.
     *
     * @return the Date.
     */
    public Date getStartFrom() {
        return this.startFrom;
    }

    /**
     * The first start date.
     *
     * @param startFrom the Date.
     */
    public void setStartFrom(Date startFrom) {
        this.startFrom = startFrom;
    }

    /**
     * The last end date.
     *
     * @return the Date.
     */
    public Date getStartTo() {
        return this.startTo;
    }

    /**
     * The last end date.
     *
     * @param startTo the Date.
     */
    public void setStartTo(Date startTo) {
        this.startTo = startTo;
    }

    /**
     * The first start date.
     *
     * @return the Date.
     */
    public Date getEndFrom() {
        return this.endFrom;
    }

    /**
     * The first start date.
     *
     * @param endFrom the Date.
     */
    public void setEndFrom(Date endFrom) {
        this.endFrom = endFrom;
    }

    /**
     * The last end date.
     *
     * @return the Date.
     */
    public Date getEndTo() {
        return this.endTo;
    }

    /**
     * The last end date.
     *
     * @param endTo the Date.
     */
    public void setEndTo(Date endTo) {
        this.endTo = endTo;
    }

    /**
     * ID of the project position hold by the searched project.
     *
     * @return the Identifier.
     */
    public Identifier getProjectPositionId() {
        return this.projectPositionId;
    }

    /**
     * ID of the project position hold by the searched project.
     *
     * @param projectPositionId the Identifier.
     */
    public void setProjectPositionId(Identifier projectPositionId) {
        this.projectPositionId = projectPositionId;
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(ProjectSearchRq.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(ProjectSearchRq.class).getAllProperties();
    }
}
