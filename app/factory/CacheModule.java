package factory;

import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.typesafe.config.Config;
import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;

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
    @Inject
    public RedissonClient getRedisClient(Config config) {
        try {
            org.redisson.config.Config redisConfig = new org.redisson.config.Config();
            redisConfig.useSingleServer()
                    .setAddress(config.getString("redis.host"))
                    .setClientName(config.getString("redis.username"));
            String password = config.getString("redis.password");
            if (!password.isEmpty()) {
                redisConfig.useSingleServer().setPassword(password);
            }
            return Redisson.create(redisConfig);
        } catch (Exception e) {
            log.error("Unable to create the redisson client {}", e);
            throw e;
        }
    }
}
