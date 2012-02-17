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
import org.nabucco.framework.base.facade.datatype.business.project.Project;
import org.nabucco.framework.base.facade.datatype.code.Code;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;

/**
 * ProjectMaster<p/>Persistent Representation of a Project<p/>
 *
 * @version 1.0
 * @author Nicolas Moser, PRODYNA AG, 2010-11-23
 */
public class ProjectMaster extends Project implements Datatype {

    private static final long serialVersionUID = 1L;

    private Long projectSchemaRefId;

    /** Constructs a new ProjectMaster instance. */
    public ProjectMaster() {
        super();
        this.initDefaults();
    }

    /** InitDefaults. */
    private void initDefaults() {
    }

    /**
     * CloneObject.
     *
     * @param clone the ProjectMaster.
     */
    protected void cloneObject(ProjectMaster clone) {
        super.cloneObject(clone);
    }

    /**
     * CreatePropertyContainer.
     *
     * @return the NabuccoPropertyContainer.
     */
    protected static NabuccoPropertyContainer createPropertyContainer() {
        Map<String, NabuccoPropertyDescriptor> propertyMap = new HashMap<String, NabuccoPropertyDescriptor>();
        propertyMap.putAll(PropertyCache.getInstance().retrieve(Project.class).getPropertyMap());
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public Set<NabuccoProperty> getProperties() {
        Set<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(ProjectMaster.getPropertyDescriptor(PROJECTSCHEMA),
                this.getProjectSchema(), this.projectSchemaRefId));
        return properties;
    }

    @Override
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
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
        final ProjectMaster other = ((ProjectMaster) obj);
        if ((this.projectSchemaRefId == null)) {
            if ((other.projectSchemaRefId != null))
                return false;
        } else if ((!this.projectSchemaRefId.equals(other.projectSchemaRefId)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.projectSchemaRefId == null) ? 0 : this.projectSchemaRefId.hashCode()));
        return result;
    }

    @Override
    public ProjectMaster cloneObject() {
        ProjectMaster clone = new ProjectMaster();
        this.cloneObject(clone);
        return clone;
    }

    /**
     * Getter for the ProjectSchemaRefId.
     *
     * @return the Long.
     */
    public Long getProjectSchemaRefId() {
        return this.projectSchemaRefId;
    }

    /**
     * Setter for the ProjectSchemaRefId.
     *
     * @param projectSchemaRefId the Long.
     */
    public void setProjectSchemaRefId(Long projectSchemaRefId) {
        this.projectSchemaRefId = projectSchemaRefId;
    }

    /**
     * Setter for the ProjectSchema.
     *
     * @param projectSchema the Code.
     */
    public void setProjectSchema(Code projectSchema) {
        super.setProjectSchema(projectSchema);
        if ((projectSchema != null)) {
            this.setProjectSchemaRefId(projectSchema.getId());
        } else {
            this.setProjectSchemaRefId(null);
        }
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(ProjectMaster.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(ProjectMaster.class).getAllProperties();
    }
}
