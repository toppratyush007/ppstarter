package controllers;

import play.mvc.Controller;
import play.mvc.Result;

import java.util.concurrent.CompletionStage;

public class AddressController extends Controller {

    /**
     * Retrieves the List of addresses which are enabled corresponding to the patientId
     * (presented in the header as patient_id)
     * present in the header
     *
     * We need to return only those addresses which have enabled flag set
     * as True {@see models.db.BaseModel#enabled}
     *
     *
     * The resultant JSON would look like:
     * {
     *     "success": true,
     *     "addresses": [
     *          {
     *              "nickname": "John Doe",
     *              "province": "Manitoba",
     *              "postal_code": "V0S0B1",
     *              "street_address": "410, Hasbrouck, Gali number 37, Sector 4",
     *              "city": "Toronto",
     *          },
     *          {
     *              "nickname": "Batman",
     *              ...
     *          },
     *          ...
     *     ]
     * }
     * The addresses are given in the table
     * @see models.db.PatientAddress
     *
     * @return List<Address> encapsulated in
     * @see utils.AppUtil#getSuccessObject(String) if successful or
     * @see utils.AppUtil#getBadRequestObject(String) if unsuccessful
     */
    public CompletionStage<Result> getPatientAddress() {
        return null;
    }

    /**
     * @see models.db.PatientAddress and the body are bound together.
     * The json body will look like as follows:
     * {
     *     "nickname": "John Doe",
     *     "province": "Manitoba",
     *     "postal_code": "V0S0B1",
     *     "street_address": "410, Hasbrouck, Gali number 37, Sector 4",
     *     "city": "Toronto",
     * }
     * The patientId is present in the header (presented in the header as patient_id)
     *
     * This object is saved in the table with enabled as True
     *
     * @return json with the id of address encapsulated in
     * @see utils.AppUtil#getSuccessObject(String) if successfull
     * @see utils.AppUtil#getBadRequestObject(String) if unsuccessfull
     */
    public CompletionStage<Result> addPatientAddress() {
        return null;
    }


    /**
     * @see models.db.PatientAddress entry is deleted corresponding to the {@code addressId}
     * For deleting a particular address, we just set the
     * enabled flag as false {@see models.db.BaseModel#enabled}
     *
     * @param addressId which we need to delete
     * @return json denoting success or failure encapsulated in
     * @see utils.AppUtil#getSuccessObject(String)  if successfully deleted
     * @see utils.AppUtil#getBadRequestObject(String) if unsuccessfull
     */
    public CompletionStage<Result> deletePatientAddress(long addressId) {
        return null;
    }


}
