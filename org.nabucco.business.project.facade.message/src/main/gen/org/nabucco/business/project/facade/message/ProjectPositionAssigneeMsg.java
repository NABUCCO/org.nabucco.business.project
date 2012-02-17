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
package org.nabucco.business.project.facade.message;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.nabucco.business.project.facade.datatype.ProjectPositionAssignee;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyAssociationType;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;
import org.nabucco.framework.base.facade.message.ServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceMessageSupport;

/**
 * ProjectPositionAssigneeMsg<p/>Default message for ProjectPositionAssignee datatype<p/>
 *
 * @version 1.0
 * @author Oliver Teichmann, PRODYNA AG, 2010-12-01
 */
public class ProjectPositionAssigneeMsg extends ServiceMessageSupport implements ServiceMessage {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_CONSTRAINTS = { "m1,1;" };

    public static final String PROJECTPOSITIONASSIGNEE = "projectPositionAssignee";

    private ProjectPositionAssignee projectPositionAssignee;

    /** Constructs a new ProjectPositionAssigneeMsg instance. */
    public ProjectPositionAssigneeMsg() {
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
        propertyMap.put(PROJECTPOSITIONASSIGNEE, PropertyDescriptorSupport.createDatatype(PROJECTPOSITIONASSIGNEE,
                ProjectPositionAssignee.class, 0, PROPERTY_CONSTRAINTS[0], false, PropertyAssociationType.COMPOSITION));
        return new NabuccoPropertyContainer(propertyMap);
    }

    /** Init. */
    public void init() {
        this.initDefaults();
    }

    @Override
    public Set<NabuccoProperty> getProperties() {
        Set<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(ProjectPositionAssigneeMsg.getPropertyDescriptor(PROJECTPOSITIONASSIGNEE),
                this.getProjectPositionAssignee()));
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
        final ProjectPositionAssigneeMsg other = ((ProjectPositionAssigneeMsg) obj);
        if ((this.projectPositionAssignee == null)) {
            if ((other.projectPositionAssignee != null))
                return false;
        } else if ((!this.projectPositionAssignee.equals(other.projectPositionAssignee)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.projectPositionAssignee == null) ? 0 : this.projectPositionAssignee
                .hashCode()));
        return result;
    }

    @Override
    public ServiceMessage cloneObject() {
        return this;
    }

    /**
     * Missing description at method getProjectPositionAssignee.
     *
     * @return the ProjectPositionAssignee.
     */
    public ProjectPositionAssignee getProjectPositionAssignee() {
        return this.projectPositionAssignee;
    }

    /**
     * Missing description at method setProjectPositionAssignee.
     *
     * @param projectPositionAssignee the ProjectPositionAssignee.
     */
    public void setProjectPositionAssignee(ProjectPositionAssignee projectPositionAssignee) {
        this.projectPositionAssignee = projectPositionAssignee;
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(ProjectPositionAssigneeMsg.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(ProjectPositionAssigneeMsg.class).getAllProperties();
    }
}
