package services.cache;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import redis.embedded.RedisServer;

import java.util.concurrent.CompletableFuture;

import static org.junit.Assert.assertEquals;

/**
 * Created by pratyush.k on 09/09/18.
 */
@RunWith(MockitoJUnitRunner.class)
public class RedisCacheServiceImplTest {

    private static final Integer redisTestPort = 7001;
    private static RedisServer server = null;
    private RedisCacheServiceImpl redisCacheService;
    private RedissonClient redissonClient;

    @Before
    public void setUp() throws Exception {
        server = new RedisServer(redisTestPort);  // bind to a random port
        server.start();
        String address = "redis://" + "0.0.0.0" + ":" + redisTestPort;
        Config config = new Config();
        config.useSingleServer().setAddress(address);
        redissonClient = Redisson.create(config);
        redisCacheService = new RedisCacheServiceImpl(redissonClient);
    }

    @After
    public void tearDown() throws Exception {
        server.stop();
        server = null;
    }

    @Test
    public void addObject() throws Exception {
        redisCacheService.addObject("mymap", "a", 1).get();
        assertEquals("In mymap a is 1", 1, redissonClient.getMapCache("mymap").get("a"));
    }

    @Test
    public void getObject() throws Exception {
        redissonClient.getMapCache("mymap").put("b", 2);
        assertEquals("In mymap b is 2", 2, redisCacheService.getObject("mymap", "b").get());
        server.stop();
        CompletableFuture<Object> completableFuture =
                redisCacheService.getObject("mymap", "ex");
        assertEquals("Mymap should end with exception", false, completableFuture.get());
    }

    @Test
    public void addObjectWithExpiry() throws Exception {
        redisCacheService.addObjectWithExpiry("mymap", "c", 3, 5).get();
        assertEquals("In mymap c is 3", 3, redissonClient.getMapCache("mymap").get("c"));
        Thread.sleep(6000);
        assertEquals("In mymap c should now be null", null, redissonClient.getMapCache("mymap").get("c"));
    }

    @Test
    public void setKey() throws Exception {
        redisCacheService.setKey("mymap", "d", "4").get();
        assertEquals("In mymap d is 4", "4", redissonClient.getMapCache("mymap").get("d"));
    }

    @Test
    public void deleteMapKey() throws Exception {
        redissonClient.getMapCache("mymap").put("e", 5);
        assertEquals("In mymap e is set", 5, redissonClient.getMapCache("mymap").get("e"));
        assertEquals("Deletion in redis successful", true, redisCacheService.deleteMapKey("mymap", "e").get());
        assertEquals("In mymap e is now deleted", null, redissonClient.getMapCache("mymap").get("e"));
    }

    @Test
    public void addKeyToSet() throws Exception {
        redisCacheService.addKeyToSet("myset", "s1").get();
        assertEquals("myset should contain s1", true, redissonClient.getSet("myset").contains("s1"));
    }

    @Test
    public void doesKeyExistInSet() throws Exception {
        redissonClient.getSet("myset").add("s2");
        assertEquals("myset should contain s2", true, redisCacheService.doesKeyExistInSet("myset", "s2").get());
    }

    @Test
    public void checkClientSetter() throws Exception {
        redisCacheService.setClient(redissonClient);
        assertEquals(redisCacheService.getClient(), redissonClient);
    }

}