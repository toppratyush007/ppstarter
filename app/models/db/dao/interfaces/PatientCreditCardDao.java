package models.db.dao.interfaces;

import models.db.PatientCreditCard;

import java.util.List;
import java.util.concurrent.CompletionStage;

public interface PatientCreditCardDao {

    /**
     * Retrieves a list of credit cards corresponding to the {@code patientId} which are enabled;
     *
     * @param patientId Patient Identifier
     * @return CompletableFuture of type <List<{@see PatientCreditCard}>>
     */
    CompletionStage<List<PatientCreditCard>> getPatientCreditCards(long patientId);


    /**
     * Deletes are all soft-deletes. Sets {@see models.db.BaseModel#enabled} as false
     *
     * @param patientId patient identifier
     * @param creditCardId creditcard identifier
     * @return CompletableFuture of type True if successfull, false otherwise
     */
    CompletionStage<Boolean> deleteCreditCard(long patientId, long creditCardId);


    /**
     * Returns {@see PatientCreditCard} information corresponding to the
     * {@code creditCardId}.
     * @param creditCardId Credit card identifier
     * @return CompletableFuture of type {@see PatientCreditCard}
     */
    CompletionStage<PatientCreditCard> getCreditCardById(long creditCardId);

    /**
     * Inserts the credit card with enabled flag set as True.
     * Assumption: This entry does not exist in the database already
     *
     * @param patientId patient identifier
     * @param creditCardInfo {@see PatientCreditCard}
     * @return CompletableFuture of type Long - the identifier of the inserted object
     */
    CompletionStage<Long> addCreditCard(long patientId, PatientCreditCard creditCardInfo);
}
