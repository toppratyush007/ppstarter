package services.cache;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RedissonClient;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * Please make use of the redisson library (the library has already been included as a dependency)
 * <p>
 * Read more about it here:
 * {@see <a href="https://github.com/redisson/redisson/wiki/Table-of-Content">Redisson</a>})
 * <p>
 * Ensure that all calls made to the redis server are non-blocking. You may want to read about
 * making non-blocking calls here:
 * {@see <a href="https://www.playframework.com/documentation/2.6.x/JavaAsync">CustomExecutionContext</a>}
 */
@Slf4j
@Data
class RedisCacheServiceImpl implements CacheService {

    private static final String redisFailureMessage = "Failed in redis with exception";
    private RedissonClient client;

    @Inject
    public RedisCacheServiceImpl(@Named("redisson") RedissonClient redissonClient) {
        client = redissonClient;
    }

    @Override
    public CompletableFuture<Boolean> addObject(String mapName, String key, Object obj) {
        return client.
                getMapCache(mapName).
                putAsync(key, obj).
                exceptionally(this::logError).
                toCompletableFuture().
                thenApplyAsync(o -> true);
    }

    @Override
    public CompletableFuture<Object> getObject(String mapName, String key) {
        return client.
                getMapCache(mapName).
                getAsync(key).
                exceptionally(this::logError).
                toCompletableFuture();
    }

    @Override
    public CompletableFuture<Boolean> addObjectWithExpiry(String mapName, String key, Object object,
                                                          int expiryInSeconds) {
        return client.
                getMapCache(mapName).
                putAsync(key, object, expiryInSeconds, TimeUnit.SECONDS).
                exceptionally(this::logError).
                toCompletableFuture().
                thenApplyAsync(o -> true);
    }

    @Override
    public CompletableFuture<Boolean> setKey(String mapName, String key, String value) {
        return addObject(mapName, key, value);
    }

    @Override
    public CompletableFuture<Boolean> deleteMapKey(String mapName, String key) {
        return client.
                getMapCache(mapName).
                removeAsync(key).
                exceptionally(this::logError).
                toCompletableFuture().
                thenApplyAsync(r -> true);
    }

    @Override
    public CompletableFuture<Boolean> addKeyToSet(String setName, String key) {
        return client.
                getSet(setName).
                addAsync(key).
                exceptionally(this::logError).
                toCompletableFuture().
                thenApplyAsync(r -> true);
    }

    @Override
    public CompletableFuture<Boolean> doesKeyExistInSet(String setName, String key) {
        return client.
                getSet(setName).
                containsAsync(key).
                exceptionally(this::logError).
                toCompletableFuture();
    }

    private Boolean logError(Throwable t) {
        log.error("{} {}", redisFailureMessage, t.getMessage());
        return false;
    }
}
