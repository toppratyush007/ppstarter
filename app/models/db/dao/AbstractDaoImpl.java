package models.db.dao;

import io.ebean.EbeanServer;

import javax.inject.Inject;

public abstract class AbstractDaoImpl {

    protected final EbeanServer ebeanServer;
    protected final DatabaseExecutionContext executionContext;

    @Inject
    public AbstractDaoImpl(EbeanServer server, DatabaseExecutionContext context) {
        this.ebeanServer = server;
        this.executionContext = context;
    }
}
