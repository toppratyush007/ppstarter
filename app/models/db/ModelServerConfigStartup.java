package models.db;

import io.ebean.config.ServerConfig;
import io.ebean.event.ServerConfigStartup;
import modules.ApiUserProvider;

public class ModelServerConfigStartup implements ServerConfigStartup {
    @Override
    public void onStart(ServerConfig serverConfig) {
        serverConfig.setDatabaseSequenceBatchSize(1);
        serverConfig.setCurrentUserProvider(new ApiUserProvider());
    }
}
