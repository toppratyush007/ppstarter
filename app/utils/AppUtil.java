package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Preconditions;
import models.Credentials;
import org.mindrot.jbcrypt.BCrypt;
import play.libs.Json;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.HashSet;
import java.util.Random;
import java.util.concurrent.CompletionStage;

public class AppUtil {

    private static final String STR_SUCCESS = "success";
    private static final String STR_MESSAGE = "message";

    @Inject
    public AppUtil() {

    }

    /**
     * Base json response object for failed response
     * @param message message for failure
     * @return JsonObject for failed message
     */
    public static ObjectNode getBadRequestObject(String message) {
        ObjectNode badRequestObj = Json.newObject();
        badRequestObj.put(STR_SUCCESS, false);
        badRequestObj.put(STR_MESSAGE, message);
        return badRequestObj;
    }

    /**
     * Base json response object for success response
     * @param message message for success
     * @return JsonObject for success message
     */
    public static ObjectNode getSuccessObject(String message) {
        ObjectNode successObj = Json.newObject();
        successObj.put(STR_SUCCESS, true);
        successObj.put(STR_MESSAGE, message);
        return successObj;
    }


}
