package services.cache;

import com.google.inject.ImplementedBy;

@ImplementedBy(RedisCacheServiceImpl.class)
public interface CacheService {

}
