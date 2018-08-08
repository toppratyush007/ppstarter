package controllers;

import models.db.PatientHealth;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.concurrent.CompletionStage;

public class HealthController extends Controller {

    /**
     * Retrieves the patient health information from
     * @see PatientHealth table
     *
     * The patient Id would be present in the header as patient_id
     *
     * There could be multiple entries corresponding to the patient_id.
     * As a result, choose the latest entry provided by {@see models.db.BaseModel#whenCreated}
     * which is also {@see models.db.BaseModel#enabled} (enabled field is true)
     *
     *
     * The implementation will be done using {@see PatientHealthDao#getPatientHealthInfo}
     *
     * @return CompletionStage of Json result created using
     * @see utils.AppUtil#getSuccessObject(String)  in case of success or
     * @see utils.AppUtil#getBadRequestObject(String) in case of failure
     */
    public CompletionStage<Result> getPatientHealthInfo() {
        return null;
    }




    /**
     * creates a new entry in
     * @see PatientHealth table corresponding to the patient_id
     *
     *
     * The body json would look like:
     * {
     *     "allergies": ["allergy1", "allergy2", ...],
     *     "vitamins": ["vitamin1", "vitamin2", ...]
     * }
     *
     * We will not be performing any checks to the input.
     *
     * There are two cases which we need to look at here.
     * 1) If the entry already exists (this should be done using the {@see getPatientHealthInfo}
     *    function defined above) check if anything has changed. If nothing has changed, just return this entry, else
     *    disable the latest entry, and add a new entry in the table
     *
     * The implementation is will be done using {@see models.db.dao.interfaces.PatientHealthDao#savePatientHealthInfo}
     *
     *
     * @return CompletionStage of Long it result created using
     * @see utils.AppUtil#getSuccessObject(String)  in case of success or
     * @see utils.AppUtil#getBadRequestObject(String) in case of failure
     */
    public CompletionStage<Result> putPatientHealthInfo() {
        return null;
    }
}
