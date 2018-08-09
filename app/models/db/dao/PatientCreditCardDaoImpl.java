package models.db.dao;

import models.db.PatientCreditCard;
import models.db.dao.interfaces.PatientCreditCardDao;

import java.util.List;
import java.util.concurrent.CompletionStage;

public class PatientCreditCardDaoImpl implements PatientCreditCardDao {

    @Override
    public CompletionStage<List<PatientCreditCard>> getPatientCreditCards(long patientId) {
        return null;
    }

    @Override
    public CompletionStage<Boolean> deleteCreditCard(long patientId, long creditCardId) {
        return null;
    }

    @Override
    public CompletionStage<PatientCreditCard> getCreditCardById(long creditCardId) {
        return null;
    }

    @Override
    public CompletionStage<Long> addCreditCard(long patientId, PatientCreditCard creditCardInfo) {
        return null;
    }
}
