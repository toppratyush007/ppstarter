package models.db;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.ebean.annotation.DbJson;
import io.ebean.annotation.Index;
import io.ebean.annotation.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "patient_health")
@Index(columnNames = "patient_id, enabled")
public class PatientHealth extends BaseModel implements Serializable {
    @NotNull
    @Index
    @Column(name = "patient_id")
    long patientId;

    @Column(name = "allergies")
    @JsonProperty("allergies")
    @DbJson
    List<String> allergies;


    @Column(name = "vitamins")
    @JsonProperty("vitamins")
    @DbJson
    List<String> vitamins;
}
