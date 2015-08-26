/*
 * Copyright 2014 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.komodo.relational.commands.translator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.komodo.relational.commands.AbstractCommandTest;
import org.komodo.relational.vdb.Translator;
import org.komodo.relational.vdb.Vdb;
import org.komodo.relational.workspace.WorkspaceManager;
import org.komodo.shell.api.CommandResult;

/**
 * Test Class to test UnsetTranslatorPropertyCommand
 *
 */
@SuppressWarnings( {"javadoc", "nls"} )
public class UnsetTranslatorPropertyCommandTest extends AbstractCommandTest {

    @Test
    public void testUnsetProperty1() throws Exception {
        final String[] commands = { 
            "workspace",
            "create-vdb myVdb vdbPath",
            "cd myVdb",
            "add-translator myTranslator tType",
            "cd myTranslator",
            "set-property description myDescription",
            "unset-property description" };
        
        setup( commands );

        CommandResult result = execute();
        assertCommandResultOk(result);

        WorkspaceManager wkspMgr = WorkspaceManager.getInstance(_repo);
        Vdb[] vdbs = wkspMgr.findVdbs(getTransaction());

        assertEquals(1, vdbs.length);

        Translator[] translators = vdbs[0].getTranslators(getTransaction());
        assertEquals(1, translators.length);
        assertEquals("myTranslator", translators[0].getName(getTransaction())); //$NON-NLS-1$

        assertEquals(null, translators[0].getDescription(getTransaction()));
    }

}