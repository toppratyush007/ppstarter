package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.CacheEntry;
import models.SetEntry;
import play.libs.Json;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Controller;
import play.mvc.Result;
import services.cache.CacheService;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

/**
 * You may or may not want to use the controller for tests.
 */
@Singleton
public class CacheController extends Controller {

    private final CacheService cacheService;
    private final HttpExecutionContext context;

    @Inject
    public CacheController(CacheService cacheService, HttpExecutionContext context) {
        this.cacheService = cacheService;
        this.context = context;
    }

    public CompletionStage<Result> addObject(String mapName) {
        JsonNode json = request().body().asJson();
        if (json == null) {
            return CompletableFuture.completedFuture(this.getResponse("invalid JSON"));
        }
        CacheEntry cacheEntry = Json.fromJson(json, CacheEntry.class);

        return (cacheEntry.getTtl() != 0 ?
                cacheService.addObjectWithExpiry(
                        mapName,
                        cacheEntry.getKey(),
                        cacheEntry.getValue(),
                        cacheEntry.getTtl()
                ) :
                cacheService.addObject(
                        mapName,
                        cacheEntry.getKey(),
                        cacheEntry.getValue()
                )
        ).thenApplyAsync(this::getResponse, context.current());
    }

    public CompletionStage<Result> getObject(String mapName, String key) {
        return cacheService.getObject(mapName, key).
                thenApplyAsync(this::getResponse, context.current());
    }

    public CompletionStage<Result> deleteMapKey(String mapName, String key) {
        return cacheService.deleteMapKey(mapName, key).
                thenApplyAsync(this::getResponse, context.current());
    }

    public CompletionStage<Result> addKeyToSet(String setName) {
        JsonNode json = request().body().asJson();
        if (json == null) {
            return CompletableFuture.completedFuture(this.getResponse("invalid JSON"));
        }
        SetEntry setEntry = Json.fromJson(json, SetEntry.class);
        return cacheService.addKeyToSet(setName, setEntry.getKey())
                .thenApplyAsync(this::getResponse, context.current());
    }

    public CompletionStage<Result> doesKeyExistInSet(String setName, String key) {
        return cacheService.doesKeyExistInSet(setName, key)
                .thenApplyAsync(this::getResponse, context.current());
    }

    private Result getResponse(Object resp) {
        return resp == null ?
                ok("Key not found") :
                ok(resp.toString());
    }
}
