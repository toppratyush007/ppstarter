package utils;

import com.fasterxml.jackson.databind.node.ObjectNode;
import play.libs.Json;

import javax.inject.Inject;


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

    /**
     * Returns the last 4 digits of the credit card number
     * e.g.
     * if the card number is 4242-4242-4242-1234, we return 1234
     * @param cardNumber credit card number
     * @return Last 4-digits of credit card number
     */
    public static String getLast4CCDigits(String cardNumber) {
        if (cardNumber.length()>=3) {
            return cardNumber.substring(cardNumber.length()-4);
        }
        return null;
    }

}
