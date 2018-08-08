package controllers;

import play.mvc.Controller;
import play.mvc.Result;

import java.util.concurrent.CompletionStage;

public class AddressController extends Controller {

    /**
     * Retrieves the List of addresses which are enabled corresponding to the patientId present in the header
     *
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
     * @see models.db.PatientAddress and the body are bound together. The patientId is present in the header
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
