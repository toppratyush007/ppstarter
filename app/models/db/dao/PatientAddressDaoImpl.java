package models.db.dao;

import models.db.PatientAddress;
import models.db.dao.interfaces.PatientAddressDao;

import java.util.List;
import java.util.concurrent.CompletionStage;

public class PatientAddressDaoImpl implements PatientAddressDao {
    @Override
    public CompletionStage<List<PatientAddress>> getPatientAddress(long patientId) {
        return null;
    }

    @Override
    public CompletionStage<Boolean> deletePatientAddress(long patientId, long addressId) {
        return null;
    }

    @Override
    public CompletionStage<PatientAddress> getAddressById(long addressId) {
        return null;
    }

    @Override
    public CompletionStage<Long> addPatientAddress(long patientId, PatientAddress address) {
        return null;
    }
}
