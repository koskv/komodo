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

package org.komodo.modeshape.teiid.sql.symbol;

import org.komodo.modeshape.teiid.parser.LanguageVisitor;
import org.komodo.modeshape.teiid.parser.TeiidParser;
import org.komodo.spi.query.sql.symbol.IElementSymbol;

public class ElementSymbol extends Symbol implements Expression, IElementSymbol<GroupSymbol, LanguageVisitor> {

    public ElementSymbol(TeiidParser p, int id) {
        super(p, id);
    }

    @Override
    public <T> Class<T> getType() {
        return null;
    }

    @Override
    public GroupSymbol getGroupSymbol() {
        return null;
    }

    @Override
    public void setGroupSymbol(GroupSymbol groupSymbol) {
    }

    @Override
    public boolean isExternalReference() {
        return false;
    }

    @Override
    public void setDisplayFullyQualified(boolean value) {
    }

    @Override
    public org.komodo.spi.query.sql.symbol.IElementSymbol.DisplayMode getDisplayMode() {
        return null;
    }

    @Override
    public void setDisplayMode(org.komodo.spi.query.sql.symbol.IElementSymbol.DisplayMode outputName) {
    }

    @Override
    public void setType(Class<Object> targetType) {
    }

    @Override
    public Object getMetadataID() {
        return null;
    }

    @Override
    public void setMetadataID(Object metadataID) {
    }

    @Override
    public int hashCode() {
        super.hashCode();
    
        if (this.getGroupSymbol() != null) {
            final int prime = 31;
            int result = 1;
    
            result = prime * result + this.getGroupSymbol().hashCode();
            result = prime * result + (this.getShortName() == null ? 0 : this.getShortName().hashCode());
    
            return result;
        }
    
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        ElementSymbol other = (ElementSymbol)obj;
    
        if (this.getGroupSymbol() == null) {
            return super.equals(obj);
        }
    
        if (this.getType() == null) {
            if (other.getType() != null)
                return false;
        } else if (!this.getType().equals(other.getType()))
            return false;
    
        return this.getGroupSymbol().equals(other.getGroupSymbol()) && this.getGroupSymbol().equals(other.getGroupSymbol());
    }

    @Override
    public void acceptVisitor(LanguageVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public ElementSymbol clone() {
        ElementSymbol clone = new ElementSymbol(this.getTeiidParser(), this.getId());

        if (getGroupSymbol() != null)
            clone.setGroupSymbol(getGroupSymbol().clone());
        if (getType() != null)
            clone.setType(getType());
        if (getMetadataID() != null)
            clone.setMetadataID(getMetadataID());
        if (getDisplayMode() != null)
            clone.setDisplayMode(getDisplayMode());
        if (getShortName() != null)
            clone.setShortName(getShortName());
        if (getOutputName() != null)
            clone.setOutputName(getOutputName());

        return clone;
    }

}
