package com.ncr.banking.services.dbkniisdiis.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * Identity
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-09-15T15:21:42.115-04:00")

public class Identity   {
  @JsonProperty("number")
  private String number = null;

  @JsonProperty("country")
  private String country = null;

  @JsonProperty("state")
  private String state = null;

  @JsonProperty("issueDate")
  private OffsetDateTime issueDate = null;

  @JsonProperty("expiryDate")
  private OffsetDateTime expiryDate = null;

  /**
   * Gets or Sets type
   */
  public enum TypeEnum {
    PASSPORT("PASSPORT"),
    
    DRIVERS_LICENSE("DRIVERS_LICENSE"),
    
    STATE_ID("STATE_ID");

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

  public Identity number(String number) {
    this.number = number;
    return this;
  }

  /**
   * Get number
   * @return number
  **/
  @ApiModelProperty(value = "")


  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public Identity country(String country) {
    this.country = country;
    return this;
  }

  /**
   * Get country
   * @return country
  **/
  @ApiModelProperty(value = "")


  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public Identity state(String state) {
    this.state = state;
    return this;
  }

  /**
   * Get state
   * @return state
  **/
  @ApiModelProperty(value = "")


  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public Identity issueDate(OffsetDateTime issueDate) {
    this.issueDate = issueDate;
    return this;
  }

  /**
   * datetime in UTC
   * @return issueDate
  **/
  @ApiModelProperty(value = "datetime in UTC")

  @Valid

  public OffsetDateTime getIssueDate() {
    return issueDate;
  }

  public void setIssueDate(OffsetDateTime issueDate) {
    this.issueDate = issueDate;
  }

  public Identity expiryDate(OffsetDateTime expiryDate) {
    this.expiryDate = expiryDate;
    return this;
  }

  /**
   * datetime in UTC
   * @return expiryDate
  **/
  @ApiModelProperty(value = "datetime in UTC")

  @Valid

  public OffsetDateTime getExpiryDate() {
    return expiryDate;
  }

  public void setExpiryDate(OffsetDateTime expiryDate) {
    this.expiryDate = expiryDate;
  }

  public Identity type(TypeEnum type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
  **/
  @ApiModelProperty(value = "")


  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Identity identity = (Identity) o;
    return Objects.equals(this.number, identity.number) &&
        Objects.equals(this.country, identity.country) &&
        Objects.equals(this.state, identity.state) &&
        Objects.equals(this.issueDate, identity.issueDate) &&
        Objects.equals(this.expiryDate, identity.expiryDate) &&
        Objects.equals(this.type, identity.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(number, country, state, issueDate, expiryDate, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Identity {\n");
    
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    issueDate: ").append(toIndentedString(issueDate)).append("\n");
    sb.append("    expiryDate: ").append(toIndentedString(expiryDate)).append("\n");
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

