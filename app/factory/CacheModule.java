package factory;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import javax.inject.Named;

/**
 * Created by pratyush.k on 09/09/18.
 */
@Slf4j
public class CacheModule extends AbstractModule {

    @Override
    protected void configure() {

    }

    @Provides
    @Named("redisson")
    @Singleton
    public RedissonClient getRedisClient() {
        try {
            Config config = new Config();
            config.useSingleServer()
                    .setAddress("redis://127.0.0.1:6379");
            return Redisson.create(config);
        } catch (Exception e) {
            log.error("Unable to create the redisson client {}", e);
            throw e;
        }
    }
}
