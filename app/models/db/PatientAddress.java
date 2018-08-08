package models.db;


import io.ebean.annotation.Index;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import java.io.Serializable;


@Entity
@Table(name = "patient_address")
@Index(columnNames = "patient_id, enabled")
public class PatientAddress extends BaseModel implements Serializable {

    @Column(name = "patient_id")
    @Index
    private long patientId;

    @Column(name = "nickname")
    @NotNull(message = "Name cannot be null")
    @Size(max = 255, min = 1, message = "Name must be between 1 and 255 characters long")
    private String nickname;

    @Column(name = "province")
    @NotNull(message = "Province is required")
    @Size(min = 1, max = 87)
    private String province;

    @Column(name = "postal_code")
    @NotNull(message = "Postal Code  is required")
    @Size(min = 6, max = 40, message = "Incorrect Province length")
    private String postalCode;

    @Column(name = "street_address")
    @NotNull(message = "Street Address is required")
    @Size(min = 1, max = 255, message = "Street address length is incorrect")
    private String streetAddress;

    @Column(name = "city")
    @NotNull(message = "City is required")
    @Size(min = 1, max = 58, message = "City name length is incorrect")
    private String city;

    //Storing only the TLDs
    @Column(name = "country")
    @Size(min = 2, max = 4)
    private String country = "ca";

}
