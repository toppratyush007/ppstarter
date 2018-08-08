package models.db.dao;

import io.ebean.EbeanServer;
import models.db.PatientHealth;
import models.db.dao.interfaces.SessionDao;

import java.util.Optional;
import java.util.concurrent.CompletionStage;

public class PatientHealthDaoImpl extends AbstractDaoImpl
        implements PatientHealthDao {

    /**
     * Retrieves the {@see PatientHealth#allergies} and {@see PatientHealth#vitamins}
     * corresponding to the {@code patientId}
     *
     * The {@see PatientHealth} table may contain multiple entries corresponding to the {@code patientId}
     * As a result, pick the the latest on sorted on {@see models.db.BaseModel#whenCreated} DESC and
     * @see models.db.BaseModel#enabled == true
     *
     * @param patientId Patient identifier who's information we want to fetch
     * @return CompletableFuture of type {@see PatientHealth}
     */
    public CompletionStage<PatientHealth> getPatientHealthInfo(long patientId) {
        return null;
    }

    /**
     * 1) Retrieve the {@see PatientHealth} information using {@see getPatientHealthInfo} function
     * 2) Check if the current {@code health} matches the one obtained from step 1.
     *
     * If it matches, we just return the corresponding identifier, else
     * disable the entry obtained in step 1 by setting {@see BaseModel#enabled} as false and
     * creating a new entry in the {@see PatientHealth} table with {@see health} information
     * and returning the id of the object inserted
     *
     * @param patientId
     * @param health
     * @return CompletableFuture of type Long which denotes the id of the object
     */
    public CompletionStage<Long> savePatientHealthInfo(long patientId, PatientHealth health) {
        return null;
    }

}