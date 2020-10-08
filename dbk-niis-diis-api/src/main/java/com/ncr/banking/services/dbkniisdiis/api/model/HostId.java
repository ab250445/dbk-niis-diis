package com.ncr.banking.services.dbkniisdiis.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

/**
 * HostId
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-09-15T15:21:42.115-04:00")

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HostId   {
  @JsonProperty("value")
  private String value = null;

  @JsonProperty("pin")
  private String pin = null;

  /**
   * Gets or Sets type
   */
  public enum TypeEnum {
    UNKNOWN("UNKNOWN"),
    
    MEMBER_ID("MEMBER_ID"),
    
    CIF("CIF"),
    
    UCAAM("UCAAM"),
    
    RELATED_MEMBER_ID("RELATED_MEMBER_ID");

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TypeEnum fromValue(String text) {
      for (TypeEnum b : TypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("type")
  private TypeEnum type = null;


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HostId hostId = (HostId) o;
    return Objects.equals(this.value, hostId.value) &&
        Objects.equals(this.pin, hostId.pin) &&
        Objects.equals(this.type, hostId.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, pin, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HostId {\n");
    
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    pin: ").append(toIndentedString(pin)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

