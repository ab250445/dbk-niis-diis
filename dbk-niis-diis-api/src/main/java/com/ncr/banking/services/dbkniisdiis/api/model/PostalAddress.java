package com.ncr.banking.services.dbkniisdiis.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;

/**
 * PostalAddress
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-09-15T15:21:42.115-04:00")

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostalAddress   {
  @JsonProperty("streetAddress1")
  private String streetAddress1 = null;

  @JsonProperty("streetAddress2")
  private String streetAddress2 = null;

  @JsonProperty("streetAddress3")
  private String streetAddress3 = null;

  @JsonProperty("streetAddress4")
  private String streetAddress4 = null;

  @JsonProperty("city")
  private String city = null;

  @JsonProperty("state")
  private String state = null;

  @JsonProperty("postalcode")
  private String postalcode = null;

  @JsonProperty("country")
  private String country = null;

  @JsonProperty("startDate")
  private OffsetDateTime startDate = null;

  @JsonProperty("endDate")
  private OffsetDateTime endDate = null;

  @JsonProperty("type")
  private String type = null;

  @JsonProperty("isPrimary")
  private Boolean isPrimary = null;

  @JsonProperty("hostRecordId")
  private String hostRecordId = null;



  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PostalAddress postalAddress = (PostalAddress) o;
    return Objects.equals(this.streetAddress1, postalAddress.streetAddress1) &&
        Objects.equals(this.streetAddress2, postalAddress.streetAddress2) &&
        Objects.equals(this.streetAddress3, postalAddress.streetAddress3) &&
        Objects.equals(this.streetAddress4, postalAddress.streetAddress4) &&
        Objects.equals(this.city, postalAddress.city) &&
        Objects.equals(this.state, postalAddress.state) &&
        Objects.equals(this.postalcode, postalAddress.postalcode) &&
        Objects.equals(this.country, postalAddress.country) &&
        Objects.equals(this.startDate, postalAddress.startDate) &&
        Objects.equals(this.endDate, postalAddress.endDate) &&
        Objects.equals(this.type, postalAddress.type) &&
        Objects.equals(this.isPrimary, postalAddress.isPrimary) &&
        Objects.equals(this.hostRecordId, postalAddress.hostRecordId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(streetAddress1, streetAddress2, streetAddress3, streetAddress4, city, state, postalcode, country, startDate, endDate, type, isPrimary, hostRecordId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PostalAddress {\n");
    
    sb.append("    streetAddress1: ").append(toIndentedString(streetAddress1)).append("\n");
    sb.append("    streetAddress2: ").append(toIndentedString(streetAddress2)).append("\n");
    sb.append("    streetAddress3: ").append(toIndentedString(streetAddress3)).append("\n");
    sb.append("    streetAddress4: ").append(toIndentedString(streetAddress4)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    postalcode: ").append(toIndentedString(postalcode)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
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

