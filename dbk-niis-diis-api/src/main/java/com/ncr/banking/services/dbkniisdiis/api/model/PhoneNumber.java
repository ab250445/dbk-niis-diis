package com.ncr.banking.services.dbkniisdiis.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

/**
 * PhoneNumber
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-09-15T15:21:42.115-04:00")

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PhoneNumber   {
  @JsonProperty("countryCode")
  private String countryCode = null;

  @JsonProperty("number")
  private String number = null;

  @JsonProperty("type")
  private String type = null;

  @JsonProperty("isPrimary")
  private Boolean isPrimary = null;

  @JsonProperty("hostRecordId")
  private String hostRecordId = null;

  public PhoneNumber countryCode(String countryCode) {
    this.countryCode = countryCode;
    return this;
  }

  /**
   * Get countryCode
   * @return countryCode
  **/
  @ApiModelProperty(value = "")


  public String getCountryCode() {
    return countryCode;
  }

  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }

  public PhoneNumber number(String number) {
    this.number = number;
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
    PhoneNumber phoneNumber = (PhoneNumber) o;
    return Objects.equals(this.countryCode, phoneNumber.countryCode) &&
        Objects.equals(this.number, phoneNumber.number) &&
        Objects.equals(this.type, phoneNumber.type) &&
        Objects.equals(this.isPrimary, phoneNumber.isPrimary) &&
        Objects.equals(this.hostRecordId, phoneNumber.hostRecordId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(countryCode, number, type, isPrimary, hostRecordId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PhoneNumber {\n");
    
    sb.append("    countryCode: ").append(toIndentedString(countryCode)).append("\n");
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
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

