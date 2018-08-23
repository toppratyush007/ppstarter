package services.cache;

import com.google.inject.ImplementedBy;
import java.util.concurrent.CompletableFuture;

@ImplementedBy(RedisCacheServiceImpl.class)
public interface CacheService {

  /**
   * Stores the object against the key in the cache. In case the key already exists, the value will
   * be overridden
   *
   * @param mapName Namespace of the Map in cache
   * @param key Key
   * @param obj Value
   * @return true if successful, else false (completable future)
   */
  CompletableFuture<Boolean> addObject(String mapName, String key, Object obj);

  /**
   * Retrieves the object stored against a key. In case the key-value pair does not exit, return
   * null
   *
   * @param mapName Namespace of the Map in cache
   * @param key Key
   * @return Object if successfully found, null otherwise (encapsulated in a completable future)
   */
  CompletableFuture<Object> getObject(String mapName, String key);

  /**
   * Stores the object against a key with an expiry. The object will get automatically deleted after
   * {@see expiryInSeconds}
   *
   * @param mapName Namespace of the Map in cache
   * @param key Key
   * @param object Object to be stored
   * @param expiryInSeconds expiry in seconds
   * @return true if successful, else false (in a completable future)
   */
  CompletableFuture<Boolean> addObjectWithExpiry(String mapName, String key, Object object,
      int expiryInSeconds);

  /**
   * Sets a string value against a key. Ideally, this function should make use of {@see addObject}
   * function defined above
   *
   * @param mapName Namespace of the Map in cache
   * @param key Key
   * @param value Value
   * @return true if operation is successful
   */
  CompletableFuture<Boolean> setKey(String mapName, String key, String value);

  /**
   * Removes the key from the map. In case the key is not present in the map, return true
   *
   * @param mapName Namespace of the Map in cache
   * @param key Key
   * @return true if successfull, false otherwise (in case of any error)
   */
  CompletableFuture<Boolean> deleteMapKey(String mapName, String key);


  /**
   * Adds a key to a set.
   *
   * @param setName Namespace of the Set in cache
   * @param key key to be stored
   * @return true if operation is successful, false otherwise
   */
  CompletableFuture<Boolean> addKeyToSet(String setName, String key);

  /**
   * Checks if a key is present in a set or not
   *
   * @param setName Namespace of the set in cache
   * @param key key whose existence needs to be checked
   * @return true if found, false otherwise
   */
  CompletableFuture<Boolean> doesKeyExistInSet(String setName, String key);

}
