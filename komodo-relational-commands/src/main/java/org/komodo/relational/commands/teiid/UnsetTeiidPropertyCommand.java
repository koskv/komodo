/*
 * JBoss, Home of Professional Open Source.
 *
 * See the LEGAL.txt file distributed with this work for information regarding copyright ownership and licensing.
 *
 * See the AUTHORS.txt file distributed with this work for a full listing of individual contributors.
 */
package org.komodo.relational.commands.teiid;

import java.util.List;
import org.komodo.relational.commands.workspace.WorkspaceCommandsI18n;
import org.komodo.relational.teiid.Teiid;
import org.komodo.shell.CommandResultImpl;
import org.komodo.shell.api.Arguments;
import org.komodo.shell.api.CommandResult;
import org.komodo.shell.api.TabCompletionModifier;
import org.komodo.shell.api.WorkspaceStatus;
import org.komodo.shell.commands.UnsetPropertyCommand;
import org.komodo.spi.repository.Repository.UnitOfWork;
import org.komodo.spi.runtime.TeiidAdminInfo;
import org.komodo.spi.runtime.TeiidJdbcInfo;
import org.komodo.utils.StringUtils;
import org.komodo.utils.i18n.I18n;

/**
 * A shell command to unset {@link Teiid} properties.
 */
public final class UnsetTeiidPropertyCommand extends TeiidShellCommand {

    static final String NAME = UnsetPropertyCommand.NAME;

    /**
     * @param status
     *        the shell's workspace status (cannot be <code>null</code>)
     */
    public UnsetTeiidPropertyCommand( final WorkspaceStatus status ) {
        super( NAME, status );
    }

    /**
     * {@inheritDoc}
     *
     * @see org.komodo.shell.BuiltInShellCommand#doExecute()
     */
    @Override
    protected CommandResult doExecute() {
        CommandResult result = null;

        try {
            final String name = requiredArgument( 0, I18n.bind( WorkspaceCommandsI18n.unsetMissingPropertyName ) );

            final Teiid teiid = getTeiid();
            final UnitOfWork transaction = getTransaction();
            String errorMsg = null;

            if ( ADMIN_PORT.equals( name ) ) {
                teiid.setAdminPort( transaction, TeiidAdminInfo.DEFAULT_PORT );
            } else if ( ADMIN_PASSWORD.equals( name ) ) {
                teiid.setAdminPassword( transaction, null );
            } else if ( ADMIN_SECURE.equals( name ) ) {
                teiid.setAdminSecure( transaction, TeiidAdminInfo.DEFAULT_SECURE );
            } else if ( ADMIN_USER.equals( name ) ) {
                teiid.setAdminUser( transaction, null );
            } else if ( JDBC_PORT.equals( name ) ) {
                teiid.setJdbcPort( transaction, TeiidJdbcInfo.DEFAULT_PORT );
            } else if ( JDBC_PASSWORD.equals( name ) ) {
                teiid.setJdbcPassword( transaction, null );
            } else if ( JDBC_SECURE.equals( name ) ) {
                teiid.setJdbcSecure( transaction, TeiidJdbcInfo.DEFAULT_SECURE );
            } else if ( JDBC_USER.equals( name ) ) {
                teiid.setJdbcUsername( transaction, null );
            } else {
                errorMsg = I18n.bind( WorkspaceCommandsI18n.invalidPropertyName, name, Teiid.class.getSimpleName() );
            }

            if ( StringUtils.isBlank( errorMsg ) ) {
                result = new CommandResultImpl( I18n.bind( WorkspaceCommandsI18n.unsetPropertySuccess, name ) );
            } else {
                result = new CommandResultImpl( false, errorMsg, null );
            }
        } catch ( final Exception e ) {
            result = new CommandResultImpl( e );
        }

        return result;
    }

    /**
     * {@inheritDoc}
     *
     * @see org.komodo.shell.BuiltInShellCommand#getMaxArgCount()
     */
    @Override
    protected int getMaxArgCount() {
        return 1;
    }

    /**
     * {@inheritDoc}
     *
     * @see org.komodo.shell.BuiltInShellCommand#printHelpDescription(int)
     */
    @Override
    protected void printHelpDescription( final int indent ) {
        print( indent, I18n.bind( TeiidCommandsI18n.unsetTeiidPropertyHelp, getName() ) );
    }

    /**
     * {@inheritDoc}
     *
     * @see org.komodo.shell.BuiltInShellCommand#printHelpExamples(int)
     */
    @Override
    protected void printHelpExamples( final int indent ) {
        print( indent, I18n.bind( TeiidCommandsI18n.unsetTeiidPropertyExamples ) );
    }

    /**
     * {@inheritDoc}
     *
     * @see org.komodo.shell.BuiltInShellCommand#printHelpUsage(int)
     */
    @Override
    protected void printHelpUsage( final int indent ) {
        print( indent, I18n.bind( TeiidCommandsI18n.unsetTeiidPropertyUsage ) );
    }

    /**
     * {@inheritDoc}
     *
     * @see org.komodo.shell.BuiltInShellCommand#tabCompletion(java.lang.String, java.util.List)
     */
    @Override
    public TabCompletionModifier tabCompletion( final String lastArgument,
                              final List< CharSequence > candidates ) throws Exception {
        final Arguments args = getArguments();

        if ( args.isEmpty() ) {
            if ( lastArgument == null ) {
                candidates.addAll( ALL_PROPS );
            } else {
                for ( final String item : ALL_PROPS ) {
                    if ( item.toUpperCase().startsWith( lastArgument.toUpperCase() ) ) {
                        candidates.add( item );
                    }
                }
            }
        }
        return TabCompletionModifier.AUTO;
    }

}