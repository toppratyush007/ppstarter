package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.CacheEntry;
import models.SetEntry;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import play.core.j.DefaultJavaContextComponents;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Http;
import services.cache.CacheService;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static play.test.Helpers.contentAsString;

/**
 * The controller test cases go here
 */
@RunWith(MockitoJUnitRunner.class)
public class CacheControllerTest {
    @Mock
    CacheService cacheService;
    @Mock
    HttpExecutionContext httpExecutionContext;
    @InjectMocks
    CacheController cacheController;
    private JsonNode cacheEntryJsonNode;
    private JsonNode cacheEntryJsonNodeWithTTL;
    private JsonNode setEntryNode;
    private ForkJoinPool forkJoinPool = new ForkJoinPool();

    @Mock
    private Http.Request request;
    @Mock
    private Http.RequestBody requestBody;

    @Before
    public void setUp() throws Exception {
        Map<String, String> flashData = Collections.emptyMap();
        Map<String, Object> argData = Collections.emptyMap();
        Long id = 2L;
        play.api.mvc.RequestHeader header = mock(play.api.mvc.RequestHeader.class);
        Http.Context context = new Http.Context(id, header, request, flashData, flashData, argData, new DefaultJavaContextComponents(null, null, null, null));
        Http.Context.current.set(context);
        ObjectMapper objectMapper = new ObjectMapper();
        CacheEntry cacheEntry = new CacheEntry("c1", 1, 0);
        cacheEntryJsonNode = objectMapper.readTree(objectMapper.writeValueAsString(cacheEntry));
        CacheEntry cacheEntryWithTTL = new CacheEntry("c2", 1, 60);
        cacheEntryJsonNodeWithTTL = objectMapper.readTree(objectMapper.writeValueAsString(cacheEntryWithTTL));
        SetEntry setEntry = new SetEntry("s1");
        setEntryNode = objectMapper.readTree(objectMapper.writeValueAsString(setEntry));
        Mockito.when(httpExecutionContext.current()).thenReturn(forkJoinPool);
        Mockito.when(request.body()).thenReturn(requestBody);
    }

    @Test
    public void addObject() throws Exception {
        Mockito.when(requestBody.asJson()).thenReturn(null);
        assertTrue(contentAsString(cacheController.addObject("mymap").toCompletableFuture().get()).
                contains("invalid JSON")
        );
        Mockito.when(requestBody.asJson()).thenReturn(cacheEntryJsonNode);
        Mockito.when(cacheService.addObject("mymap", "c1", 1)).thenReturn(CompletableFuture.completedFuture(true));
        assertTrue(contentAsString(cacheController.addObject("mymap").toCompletableFuture().get()).contains("true"));
        Mockito.when(requestBody.asJson()).thenReturn(cacheEntryJsonNodeWithTTL);
        Mockito.when(cacheService.addObjectWithExpiry("mymap", "c2", 1, 60)).thenReturn(CompletableFuture.completedFuture(true));
        assertTrue(contentAsString(cacheController.addObject("mymap").toCompletableFuture().get()).contains("true"));
    }

    @Test
    public void getObject() throws Exception {
        Mockito.when(cacheService.getObject("mymap", "a")).thenReturn(CompletableFuture.completedFuture("1"));
        assertTrue(contentAsString(cacheController.getObject("mymap", "a").toCompletableFuture().get()).contains("1"));
    }

    @Test
    public void deleteMapKey() throws Exception {
        Mockito.when(cacheService.deleteMapKey("mymap", "a")).thenReturn(CompletableFuture.completedFuture(true));
        assertTrue(contentAsString(cacheController.deleteMapKey("mymap", "a").toCompletableFuture().get()).contains("true"));
        Mockito.when(cacheService.deleteMapKey("mymap", "a")).thenReturn(CompletableFuture.completedFuture(null));
        assertTrue(contentAsString(cacheController.deleteMapKey("mymap", "a").toCompletableFuture().get()).contains("Key not found"));
    }

    @Test
    public void addKeyToSet() throws Exception {
        Mockito.when(requestBody.asJson()).thenReturn(null);
        assertTrue(contentAsString(cacheController.addKeyToSet("mymap").toCompletableFuture().get()).
                contains("invalid JSON")
        );
        Mockito.when(requestBody.asJson()).thenReturn(setEntryNode);
        Mockito.when(cacheService.addKeyToSet("mymap", "s1")).thenReturn(CompletableFuture.completedFuture(true));
        assertTrue(contentAsString(cacheController.addKeyToSet("mymap").toCompletableFuture().get()).contains("true"));
    }

    @Test
    public void doesKeyExistInSet() throws Exception {
        Mockito.when(cacheService.doesKeyExistInSet("mymap", "s1")).thenReturn(CompletableFuture.completedFuture(false));
        assertTrue(contentAsString(cacheController.doesKeyExistInSet("mymap", "s1").toCompletableFuture().get()).contains("false"));
    }

}
