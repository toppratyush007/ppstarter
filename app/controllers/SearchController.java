package controllers;

import play.mvc.Controller;
import play.mvc.Result;

import java.util.concurrent.CompletionStage;

/**
 * Presents the CRUD operations for CreditCard
 */
public class PatientCreditCardController extends Controller {

    /**
     * Looks for the credit card information in
     * @see models.db.PatientCreditCard table corresponding to {@code creditCardId}
     * Jsonn response would look like as follows:
     * {
     *     "success": true,
     *     "card": {
     *          "name": "Name on Card",
     *          "number": "last 4-digits",
     *          "postal_code": "V0S3L5"
     *     },
     *     "message": ""
     * } 200 OK
     *
     *
     * The patient id is present in the request header as patient_id
     * @param creditCardId creditcard identifier
     * @return Response
     * @see utils.AppUtil#getSuccessObject(String) if successful
     * @see utils.AppUtil#getBadRequestObject(String) if not
     */
    public CompletionStage<Result> getCreditCardInfo(long creditCardId) {
        return null;
    }

    /**
     * Returns a list of credit cards associated with the patient
     * (the patientId is present in the header as patient_id)
     *
     * Return only the credit cards which for which {@see models.db.BaseModel#enabled} is true
     *
     * The response Json would look like:
     * {
     *     "success": true,
     *     "cards": [
     *          {
     *              "name": "Name on Card",
     *              "number": " last 4-digits",
     *              "postal_code": "V0S5L9"
     *          },
     *          {
     *              "name" : "Some name",
     *              ...
     *          },
     *          ...
     *     ],
     *     "message": ""
     * } 200 OK
     *
     * @see models.db.PatientCreditCard should be used to retrieve the List<PatientCreditCard>
     * @return List<PatientCreditCard> encapsulated in
     * @see utils.AppUtil#getSuccessObject(String) if successful
     * @see utils.AppUtil#getBadRequestObject(String) if not
     */
    public CompletionStage<Result> getPatientCreditCard() {
        return null;
    }

    /**
     * Deletes the credit card corresponding to {@code creditCardId} from
     * @see models.db.PatientCreditCard table
     *
     * Only soft delete the card by setting the {@see models.db.BaseModel#enabled} as false
     *
     * @param creditCardId credit card Id we want do delete
     *
     *
     * @return ResponseObject of type
     * @see utils.AppUtil#getSuccessObject(String)  if successful
     * @see utils.AppUtil#getBadRequestObject(String) if not
     */
    public CompletionStage<Result> deletePatientCreditCard(long creditCardId) {
        return null;
    }

    /**
     * Binds the request body to
     * @see models.db.PatientCreditCard and create an entry corresponding to
     * the patientId present in the request header (as patient_id)
     * The input json body would look like:
     * {
     *      "name": "Some name",
     *      "number" : "4242424242424242",
     *      "postal_code": "V9S2T5",
     *      "cvv": "123"
     * }
     *
     * @return ResponseObject of type
     * @see utils.AppUtil#getSuccessObject(String) with the identifier of credit card successfully added
     * @see utils.AppUtil#getBadRequestObject(String) if not successful
     */
    public CompletionStage<Result> putPatientCreditCard() {
        return null;
    }
}
