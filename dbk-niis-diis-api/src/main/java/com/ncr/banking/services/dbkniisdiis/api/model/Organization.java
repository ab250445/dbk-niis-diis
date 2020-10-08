package com.ncr.banking.services.dbkniisdiis.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * Organization
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-09-15T15:21:42.115-04:00")

public class Organization   {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("taxId")
  private TaxId taxId = null;

  @JsonProperty("postalAddresses")
  @Valid
  private List<PostalAddress> postalAddresses = null;

  @JsonProperty("emailAddresses")
  @Valid
  private List<EmailAddress> emailAddresses = null;

  @JsonProperty("phoneNumberes")
  @Valid
  private List<PhoneNumber> phoneNumberes = null;

  public Organization name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(value = "")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Organization taxId(TaxId taxId) {
    this.taxId = taxId;
    return this;
  }

  /**
   * Get taxId
   * @return taxId
  **/
  @ApiModelProperty(value = "")

  @Valid

  public TaxId getTaxId() {
    return taxId;
  }

  public void setTaxId(TaxId taxId) {
    this.taxId = taxId;
  }

  public Organization postalAddresses(List<PostalAddress> postalAddresses) {
    this.postalAddresses = postalAddresses;
    return this;
  }

  public Organization addPostalAddressesItem(PostalAddress postalAddressesItem) {
    if (this.postalAddresses == null) {
      this.postalAddresses = new ArrayList<PostalAddress>();
    }
    this.postalAddresses.add(postalAddressesItem);
    return this;
  }

  /**
   * Get postalAddresses
   * @return postalAddresses
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<PostalAddress> getPostalAddresses() {
    return postalAddresses;
  }

  public void setPostalAddresses(List<PostalAddress> postalAddresses) {
    this.postalAddresses = postalAddresses;
  }

  public Organization emailAddresses(List<EmailAddress> emailAddresses) {
    this.emailAddresses = emailAddresses;
    return this;
  }

  public Organization addEmailAddressesItem(EmailAddress emailAddressesItem) {
    if (this.emailAddresses == null) {
      this.emailAddresses = new ArrayList<EmailAddress>();
    }
    this.emailAddresses.add(emailAddressesItem);
    return this;
  }

  /**
   * Get emailAddresses
   * @return emailAddresses
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<EmailAddress> getEmailAddresses() {
    return emailAddresses;
  }

  public void setEmailAddresses(List<EmailAddress> emailAddresses) {
    this.emailAddresses = emailAddresses;
  }

  public Organization phoneNumberes(List<PhoneNumber> phoneNumberes) {
    this.phoneNumberes = phoneNumberes;
    return this;
  }

  public Organization addPhoneNumberesItem(PhoneNumber phoneNumberesItem) {
    if (this.phoneNumberes == null) {
      this.phoneNumberes = new ArrayList<PhoneNumber>();
    }
    this.phoneNumberes.add(phoneNumberesItem);
    return this;
  }

  /**
   * Get phoneNumberes
   * @return phoneNumberes
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<PhoneNumber> getPhoneNumberes() {
    return phoneNumberes;
  }

  public void setPhoneNumberes(List<PhoneNumber> phoneNumberes) {
    this.phoneNumberes = phoneNumberes;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Organization organization = (Organization) o;
    return Objects.equals(this.name, organization.name) &&
        Objects.equals(this.taxId, organization.taxId) &&
        Objects.equals(this.postalAddresses, organization.postalAddresses) &&
        Objects.equals(this.emailAddresses, organization.emailAddresses) &&
        Objects.equals(this.phoneNumberes, organization.phoneNumberes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, taxId, postalAddresses, emailAddresses, phoneNumberes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Organization {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    taxId: ").append(toIndentedString(taxId)).append("\n");
    sb.append("    postalAddresses: ").append(toIndentedString(postalAddresses)).append("\n");
    sb.append("    emailAddresses: ").append(toIndentedString(emailAddresses)).append("\n");
    sb.append("    phoneNumberes: ").append(toIndentedString(phoneNumberes)).append("\n");
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

