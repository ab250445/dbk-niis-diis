package com.ncr.banking.services.dbkniisdiis.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

/**
 * EmailAddress
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-09-15T15:21:42.115-04:00")

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmailAddress   {
  @JsonProperty("email")
  private String email = null;

  @JsonProperty("type")
  private String type = null;

  @JsonProperty("isPrimary")
  private Boolean isPrimary = null;

  @JsonProperty("hostRecordId")
  private String hostRecordId = null;

  public EmailAddress email(String email) {
    this.email = email;
    return this;
  }



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EmailAddress emailAddress = (EmailAddress) o;
    return Objects.equals(this.email, emailAddress.email) &&
        Objects.equals(this.type, emailAddress.type) &&
        Objects.equals(this.isPrimary, emailAddress.isPrimary) &&
        Objects.equals(this.hostRecordId, emailAddress.hostRecordId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(email, type, isPrimary, hostRecordId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EmailAddress {\n");
    
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    isPrimary: ").append(toIndentedString(isPrimary)).append("\n");
    sb.append("    hostRecordId: ").append(toIndentedString(hostRecordId)).append("\n");
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

