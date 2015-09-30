/*
 * JBoss, Home of Professional Open Source.
 *
 * See the LEGAL.txt file distributed with this work for information regarding copyright ownership and licensing.
 *
 * See the AUTHORS.txt file distributed with this work for a full listing of individual contributors.
 */
package org.komodo.relational.commands.tabularresultset;

import org.komodo.relational.Messages;
import org.komodo.relational.commands.RelationalShellCommand;
import org.komodo.relational.model.TabularResultSet;
import org.komodo.relational.model.internal.TabularResultSetImpl;
import org.komodo.shell.api.WorkspaceStatus;

/**
 * A base class for @{link {@link TabularResultSet TabularResultSet}-related shell commands.
 */
abstract class TabularResultSetShellCommand extends RelationalShellCommand {

    protected TabularResultSetShellCommand( final String name,
                                           final WorkspaceStatus status ) {
        super( status, name );
    }

    protected TabularResultSet getTabularResultSet() throws Exception {
        return new TabularResultSetImpl( getTransaction(), getRepository(), getPath() );
    }

    /**
     * {@inheritDoc}
     *
     * @see org.komodo.shell.api.ShellCommand#isValidForCurrentContext()
     */
    @Override
    public final boolean isValidForCurrentContext() {
        try {
            return TabularResultSetImpl.RESOLVER.resolvable(getTransaction(), getContext());
        } catch (Exception ex) {
            // exception returns false
        }
        return false;
    }

    @Override
    protected String getMessage(Enum< ? > key, Object... parameters) {
        return Messages.getString(TabularResultSetCommandMessages.RESOURCE_BUNDLE,key.toString(),parameters);
    }

    /**
     * @see org.komodo.shell.api.ShellCommand#printHelp(int indent)
     */
    @Override
    public void printHelp( final int indent ) {
        print( indent, Messages.getString( TabularResultSetCommandMessages.RESOURCE_BUNDLE, getClass().getSimpleName() + ".help" ) ); //$NON-NLS-1$
    }

    /**
     * @see org.komodo.shell.api.ShellCommand#printUsage(int indent)
     */
    @Override
    public void printUsage( final int indent ) {
        print( indent, Messages.getString( TabularResultSetCommandMessages.RESOURCE_BUNDLE, getClass().getSimpleName() + ".usage" ) ); //$NON-NLS-1$
    }

}
