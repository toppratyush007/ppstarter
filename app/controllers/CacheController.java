package controllers;

import java.util.concurrent.CompletionStage;
import javax.inject.Inject;
import javax.inject.Singleton;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Controller;
import play.mvc.Result;
import services.cache.CacheService;

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

  public CompletionStage<Result> setKey(String setName, String key) {
    return cacheService.addKeyToSet(setName, key)
        .thenApplyAsync(resp -> ok(resp.toString()), context.current());
  }

}
