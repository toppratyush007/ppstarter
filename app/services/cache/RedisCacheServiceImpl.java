package services.cache;

import java.util.concurrent.CompletableFuture;

/**
 * Please make use of the redisson library (the library has already been included as a dependency)
 *
 * Read more about it here:
 * {@see <a href="https://github.com/redisson/redisson/wiki/Table-of-Content">Redisson</a>})
 *
 * Ensure that all calls made to the redis server are non-blocking. You may want to read about
 * making non-blocking calls here:
 * {@see <a href="https://www.playframework.com/documentation/2.6.x/JavaAsync">CustomExecutionContext</a>}
 *
 */
public class RedisCacheServiceImpl implements CacheService {

  @Override
  public CompletableFuture<Boolean> addObject(String mapName, String key, Object obj) {
    return null;
  }

  @Override
  public CompletableFuture<Object> getObject(String mapName, String key) {
    return null;
  }

  @Override
  public CompletableFuture<Boolean> addObjectWithExpiry(String mapName, String key, Object object,
      int expiryInSeconds) {
    return null;
  }

  @Override
  public CompletableFuture<Boolean> setKey(String mapName, String key, String value) {
    return null;
  }

  @Override
  public CompletableFuture<Boolean> deleteMapKey(String mapName, String key) {
    return null;
  }

  @Override
  public CompletableFuture<Boolean> addKeyToSet(String setName, String key) {
    return null;
  }

  @Override
  public CompletableFuture<Boolean> doesKeyExistInSet(String setName, String key) {
    return null;
  }
}
