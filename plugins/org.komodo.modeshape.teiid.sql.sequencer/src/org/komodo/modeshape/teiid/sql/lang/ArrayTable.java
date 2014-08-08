/*
 * JBoss, Home of Professional Open Source.
 * See the COPYRIGHT.txt file distributed with this work for information
 * regarding copyright ownership.  Some portions may be licensed
 * to Red Hat, Inc. under one or more contributor license agreements.
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
 * 02110-1301 USA.
 */

package org.komodo.modeshape.teiid.sql.lang;

import java.util.List;
import org.komodo.modeshape.teiid.parser.LanguageVisitor;
import org.komodo.modeshape.teiid.parser.TeiidParser;
import org.komodo.modeshape.teiid.sql.symbol.Expression;
import org.komodo.spi.query.sql.lang.IArrayTable;

/**
 *
 */
public class ArrayTable extends TableFunctionReference implements IArrayTable<LanguageVisitor> {

    /**
     * @param p
     * @param id
     */
    public ArrayTable(TeiidParser p, int id) {
        super(p, id);
    }

    /**
     * @return columns
     */
    @Override
    public List<ProjectedColumn> getColumns() {
        return null;
    }

    /**
     * @param columns
     */
    public void setColumns(List<ProjectedColumn> columns) {
    }

    /**
     * @return array value
     */
    public Expression getArrayValue() {
        return null;
    }

    /**
     * @param arrayValue
     */
    public void setArrayValue(Expression arrayValue) {
    }

    

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((this.getArrayValue() == null) ? 0 : this.getArrayValue().hashCode());
        result = prime * result + ((this.getColumns() == null) ? 0 : this.getColumns().hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        ArrayTable other = (ArrayTable)obj;
        if (this.getArrayValue() == null) {
            if (other.getArrayValue() != null)
                return false;
        } else if (!this.getArrayValue().equals(other.getArrayValue()))
            return false;
        if (this.getColumns() == null) {
            if (other.getColumns() != null)
                return false;
        } else if (!this.getColumns().equals(other.getColumns()))
            return false;
        return true;
    }

    /** Accept the visitor. **/
    @Override
    public void acceptVisitor(LanguageVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public ArrayTable clone() {
        ArrayTable clone = new ArrayTable(this.getTeiidParser(), this.getId());

        if(getColumns() != null)
            clone.setColumns(cloneList(getColumns()));
        if(getArrayValue() != null)
            clone.setArrayValue(getArrayValue().clone());
        if(getName() != null)
            clone.setName(getName());
        clone.setOptional(isOptional());
        clone.setMakeInd(isMakeInd());
        clone.setNoUnnest(isNoUnnest());
        clone.setMakeDep(isMakeDep());
        clone.setMakeNotDep(isMakeNotDep());
        clone.setPreserve(isPreserve());

        return clone;
    }

}