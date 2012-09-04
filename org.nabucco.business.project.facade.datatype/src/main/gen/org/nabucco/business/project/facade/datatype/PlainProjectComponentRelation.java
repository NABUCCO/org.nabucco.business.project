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
package org.nabucco.business.project.facade.datatype;

import org.nabucco.framework.base.facade.datatype.componentrelation.ComponentRelation;
import org.nabucco.framework.base.facade.datatype.componentrelation.ComponentRelationType;

/**
 * PlainProjectComponentRelation<p/>Plain Representation of a Project<p/>
 *
 * @version 1.0
 * @author Nicolas Moser, PRODYNA AG, 2011-09-23
 */
public class PlainProjectComponentRelation extends ComponentRelation<PlainProject> {

    private static final long serialVersionUID = 1L;

    /** Constructs a new PlainProjectComponentRelation instance. */
    protected PlainProjectComponentRelation() {
        super();
    }

    /**
     * Constructs a new PlainProjectComponentRelation instance.
     *
     * @param relationType the ComponentRelationType.
     */
    public PlainProjectComponentRelation(ComponentRelationType relationType) {
        super(relationType);
    }

    /**
     * Getter for the Tarthe .
     *
     * @return the PlainProject.
     */
    public PlainProject getTarget() {
        return super.getTarget();
    }

    /**
     * Setter for the Target.
     *
     * @param target the PlainProject.
     */
    public void setTarget(PlainProject target) {
        super.setTarget(target);
    }

    @Override
    public PlainProjectComponentRelation cloneObject() {
        PlainProjectComponentRelation clone = new PlainProjectComponentRelation();
        super.cloneObject(clone);
        return clone;
    }
}
