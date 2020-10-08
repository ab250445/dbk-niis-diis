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
 * AncillaryDate
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-09-15T15:21:42.115-04:00")

public class AncillaryDate   {
  @JsonProperty("value")
  private OffsetDateTime value = null;

  /**
   * Gets or Sets type
   */
  public enum TypeEnum {
    ESCROW_TAX_DUE("ESCROW_TAX_DUE"),
    
    DUE("DUE"),
    
    PAST_DUE("PAST_DUE"),
    
    PAYOFF("PAYOFF"),
    
    PAYMENT_NEXT("PAYMENT_NEXT"),
    
    ORIGINATION("ORIGINATION"),
    
    ISSUE("ISSUE"),
    
    MATURITY("MATURITY"),
    
    LAST_RENEWAL("LAST_RENEWAL"),
    
    LAST_INTEREST_PAYMENT("LAST_INTEREST_PAYMENT"),
    
    LAST_STATEMENT_START("LAST_STATEMENT_START"),
    
    LAST_STATEMENT_END("LAST_STATEMENT_END");

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

  public AncillaryDate value(OffsetDateTime value) {
    this.value = value;
    return this;
  }

  /**
   * datetime in UTC
   * @return value
  **/
  @ApiModelProperty(value = "datetime in UTC")

  @Valid

  public OffsetDateTime getValue() {
    return value;
  }

  public void setValue(OffsetDateTime value) {
    this.value = value;
  }

  public AncillaryDate type(TypeEnum type) {
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
    AncillaryDate ancillaryDate = (AncillaryDate) o;
    return Objects.equals(this.value, ancillaryDate.value) &&
        Objects.equals(this.type, ancillaryDate.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AncillaryDate {\n");
    
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
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

