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
import org.nabucco.framework.base.facade.datatype.Identifier;
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
import org.nabucco.framework.base.facade.message.ServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceMessageSupport;

/**
 * ProjectPositionAssignmentSearchRq<p/>Search request for Project position assignments<p/>
 *
 * @version 1.0
 * @author Leonid Agranovskiy, PRODYNA AG, 2011-12-08
 */
public class ProjectPositionAssignmentSearchRq extends ServiceMessageSupport implements ServiceMessage {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_CONSTRAINTS = { "l0,n;u0,n;m0,1;", "l0,n;u0,n;m0,1;", "l0,n;u0,n;m0,1;",
            "l0,n;u0,n;m0,1;", "l0,n;u0,n;m0,n;" };

    public static final String STARTFROM = "startFrom";

    public static final String STARTTO = "startTo";

    public static final String ENDFROM = "endFrom";

    public static final String ENDTO = "endTo";

    public static final String IDLIST = "idList";

    /** The first start date. */
    private Date startFrom;

    /** The last end date. */
    private Date startTo;

    /** The first start date. */
    private Date endFrom;

    /** The last end date. */
    private Date endTo;

    /** The id list of the provisiton assignments for search */
    private NabuccoList<Identifier> idList;

    /** Constructs a new ProjectPositionAssignmentSearchRq instance. */
    public ProjectPositionAssignmentSearchRq() {
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
        propertyMap.put(STARTFROM,
                PropertyDescriptorSupport.createBasetype(STARTFROM, Date.class, 0, PROPERTY_CONSTRAINTS[0], false));
        propertyMap.put(STARTTO,
                PropertyDescriptorSupport.createBasetype(STARTTO, Date.class, 1, PROPERTY_CONSTRAINTS[1], false));
        propertyMap.put(ENDFROM,
                PropertyDescriptorSupport.createBasetype(ENDFROM, Date.class, 2, PROPERTY_CONSTRAINTS[2], false));
        propertyMap.put(ENDTO,
                PropertyDescriptorSupport.createBasetype(ENDTO, Date.class, 3, PROPERTY_CONSTRAINTS[3], false));
        propertyMap.put(IDLIST, PropertyDescriptorSupport.createCollection(IDLIST, Identifier.class, 4,
                PROPERTY_CONSTRAINTS[4], false, PropertyAssociationType.COMPONENT));
        return new NabuccoPropertyContainer(propertyMap);
    }

    /** Init. */
    public void init() {
        this.initDefaults();
    }

    @Override
    public Set<NabuccoProperty> getProperties() {
        Set<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(ProjectPositionAssignmentSearchRq.getPropertyDescriptor(STARTFROM),
                this.startFrom));
        properties.add(super.createProperty(ProjectPositionAssignmentSearchRq.getPropertyDescriptor(STARTTO),
                this.startTo));
        properties.add(super.createProperty(ProjectPositionAssignmentSearchRq.getPropertyDescriptor(ENDFROM),
                this.endFrom));
        properties
                .add(super.createProperty(ProjectPositionAssignmentSearchRq.getPropertyDescriptor(ENDTO), this.endTo));
        properties.add(super.createProperty(ProjectPositionAssignmentSearchRq.getPropertyDescriptor(IDLIST),
                this.idList));
        return properties;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(STARTFROM) && (property.getType() == Date.class))) {
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
        } else if ((property.getName().equals(IDLIST) && (property.getType() == Identifier.class))) {
            this.idList = ((NabuccoList<Identifier>) property.getInstance());
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
        final ProjectPositionAssignmentSearchRq other = ((ProjectPositionAssignmentSearchRq) obj);
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
        if ((this.idList == null)) {
            if ((other.idList != null))
                return false;
        } else if ((!this.idList.equals(other.idList)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.startFrom == null) ? 0 : this.startFrom.hashCode()));
        result = ((PRIME * result) + ((this.startTo == null) ? 0 : this.startTo.hashCode()));
        result = ((PRIME * result) + ((this.endFrom == null) ? 0 : this.endFrom.hashCode()));
        result = ((PRIME * result) + ((this.endTo == null) ? 0 : this.endTo.hashCode()));
        result = ((PRIME * result) + ((this.idList == null) ? 0 : this.idList.hashCode()));
        return result;
    }

    @Override
    public ServiceMessage cloneObject() {
        return this;
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
     * The id list of the provisiton assignments for search
     *
     * @return the NabuccoList<Identifier>.
     */
    public NabuccoList<Identifier> getIdList() {
        if ((this.idList == null)) {
            this.idList = new NabuccoListImpl<Identifier>(NabuccoCollectionState.INITIALIZED);
        }
        return this.idList;
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(ProjectPositionAssignmentSearchRq.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(ProjectPositionAssignmentSearchRq.class).getAllProperties();
    }
}
