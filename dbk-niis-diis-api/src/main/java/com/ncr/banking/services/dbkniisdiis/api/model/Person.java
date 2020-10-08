package com.ncr.banking.services.dbkniisdiis.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;


import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * Person
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-09-15T15:21:42.115-04:00")

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person   {
  @JsonProperty("fullName")
  private String fullName = null;

  @JsonProperty("salutation")
  private String salutation = null;

  @JsonProperty("firstName")
  private String firstName = null;

  @JsonProperty("middleName")
  private String middleName = null;

  @JsonProperty("lastName")
  private String lastName = null;

  @JsonProperty("suffix")
  private String suffix = null;

  @JsonProperty("nickName")
  private String nickName = null;

  @JsonProperty("legalName")
  private String legalName = null;

  @JsonProperty("dateOfBirth")
  private String dateOfBirth = null;

  @JsonProperty("mothersMaidenName")
  private String mothersMaidenName = null;

  @JsonProperty("spouseName")
  private String spouseName = null;

  @JsonProperty("taxId")
  private TaxId taxId = null;

  @JsonProperty("identity")
  @Valid
  private List<Identity> identity = null;

  @JsonProperty("postalAddresses")
  @Valid
  private List<PostalAddress> postalAddresses = null;

  @JsonProperty("emailAddresses")
  @Valid
  private List<EmailAddress> emailAddresses = null;

  @JsonProperty("phoneNumbers")
  @Valid
  private List<PhoneNumber> phoneNumbers = null;

  public Person fullName(String fullName) {
    this.fullName = fullName;
    return this;
  }


  @Override
  public int hashCode() {
    return Objects.hash(fullName, salutation, firstName, middleName, lastName, suffix, nickName, legalName, dateOfBirth, mothersMaidenName, spouseName, taxId, identity, postalAddresses, emailAddresses, phoneNumbers);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Person {\n");
    
    sb.append("    fullName: ").append(toIndentedString(fullName)).append("\n");
    sb.append("    salutation: ").append(toIndentedString(salutation)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    middleName: ").append(toIndentedString(middleName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    suffix: ").append(toIndentedString(suffix)).append("\n");
    sb.append("    nickName: ").append(toIndentedString(nickName)).append("\n");
    sb.append("    legalName: ").append(toIndentedString(legalName)).append("\n");
    sb.append("    dateOfBirth: ").append(toIndentedString(dateOfBirth)).append("\n");
    sb.append("    mothersMaidenName: ").append(toIndentedString(mothersMaidenName)).append("\n");
    sb.append("    spouseName: ").append(toIndentedString(spouseName)).append("\n");
    sb.append("    taxId: ").append(toIndentedString(taxId)).append("\n");
    sb.append("    identity: ").append(toIndentedString(identity)).append("\n");
    sb.append("    postalAddresses: ").append(toIndentedString(postalAddresses)).append("\n");
    sb.append("    emailAddresses: ").append(toIndentedString(emailAddresses)).append("\n");
    sb.append("    phoneNumbers: ").append(toIndentedString(phoneNumbers)).append("\n");
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

