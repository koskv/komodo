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
package org.komodo.teiid;

import org.komodo.spi.constants.StringConstants;

public interface ExtensionConstants extends StringConstants {

    String TRANSLATOR = "translator";

    String DEPLOYMENT = "deployment";

    String DRIVER_CLASS_NAME = "driver-class-name";

    String DRIVER_NAME = "driver-name";

    String INSTALLED_DRIVERS_LIST = "installed-drivers-list";

    String DATA_SOURCES = "datasources";

    String RESULT = "result";

    String SUBSYSTEM = "subsystem";

    String PROFILE = "profile";

    String CHILD_TYPE = "child-type";

    String READ_CHILDREN_NAMES = "read-children-names";

    String READ_ATTRIBUTE = "read-attribute";

    String NAME = "name";

    String CONNECTION_FIELD = "connection";

    String DOMAIN_MODE_FIELD = "domainMode";

    String TEIID = "teiid";

    String TEIID_RUNTIME_VERSION = "runtime-version";
}
