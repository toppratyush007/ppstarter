package models.db;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.ebean.annotation.Index;
import io.ebean.annotation.NotNull;
import org.hibernate.validator.constraints.LuhnCheck;
import utils.AppUtil;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "patient_credit_card")
@Index(columnNames = "patient_id, enabled")
public class PatientCreditCard extends BaseModel implements Serializable {
    @Column(name = "patient_id")
    @Index
    private long patientId;

    @Column(name = "name")
    @Size(max = 255, min = 1, message = "Incorrect name length")
    @JsonProperty("name")
    private String nameOnCard;

    @Column(name = "number")
    @NotNull
    @LuhnCheck(message = "Incorrect credit card number")
    @Size(min = 12, max = 19)
    @JsonProperty("card_no")
    private String cardNumber;

    @Column(name = "postal_code")
    @NotNull
    @Size(min = 6, max = 6, message = "Incorrect postal code")
    @JsonProperty("postal_code")
    private String postalCode;

    @Column(name = "cvv")
    @NotNull
    @Size(min = 3, max = 4, message = "Incorrect CVV")
    private String cvv;



    public String getNonRedactedCardNumber() {
        return cardNumber;
    }

    public String getCardNumber() {
        return AppUtil.getLast4CCDigits(cardNumber);
    }
}
