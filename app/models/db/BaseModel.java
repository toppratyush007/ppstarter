package models.db;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.ebean.annotation.*;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.sql.Timestamp;

@MappedSuperclass
public class BaseModel {

    @Id
    @JsonIgnore
    @Column(name = "id", unique = true)
    Long id;

    @WhenCreated
    @JsonIgnore
    Timestamp whenCreated;

    @SoftDelete
    @JsonIgnore
    @JsonProperty("enabled")
    @Index
    boolean enabled;

    @WhenModified
    @JsonIgnore
    Timestamp whenModified;

    @WhoCreated
    @JsonIgnore
    Long whoCreated;

    @WhoModified
    @JsonIgnore
    Long whoModified;

    @Version
    @JsonIgnore
    Long version;

}
