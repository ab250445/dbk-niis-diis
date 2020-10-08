package com.ncr.banking.services.dbkniisdiis.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * AncillaryAmount
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-09-15T15:21:42.115-04:00")

public class AncillaryAmount   {
  @JsonProperty("value")
  private Amount value = null;

  /**
   * Gets or Sets type
   */
  public enum TypeEnum {
    TOTAL_FUNDS_AVAILABLE("TOTAL_FUNDS_AVAILABLE"),
    
    ORIGINAL_LOAN("ORIGINAL_LOAN"),
    
    ISSUE("ISSUE"),
    
    LINE_OF_CREDIT("LINE_OF_CREDIT"),
    
    INTEREST_ACCRUED("INTEREST_ACCRUED"),
    
    INTEREST_YEAR_TO_DATE("INTEREST_YEAR_TO_DATE"),
    
    INTEREST_PRIOR_YEAR_TO_DATE("INTEREST_PRIOR_YEAR_TO_DATE"),
    
    TAX_YEAR_TO_DATE("TAX_YEAR_TO_DATE"),
    
    TAX_PRIOR_YEAR_TO_DATE("TAX_PRIOR_YEAR_TO_DATE"),
    
    OVERDRAFT_LIMIT("OVERDRAFT_LIMIT"),
    
    OVERDRAFT_AVAILABLE("OVERDRAFT_AVAILABLE"),
    
    CONTRIBUTION_CURRENT_YEAR("CONTRIBUTION_CURRENT_YEAR"),
    
    CONTRIBUTION_CURRENT_YEAR_MAXIMUM("CONTRIBUTION_CURRENT_YEAR_MAXIMUM"),
    
    CONTRIBUTION_CURRENT_YEAR_ELIGIBLE("CONTRIBUTION_CURRENT_YEAR_ELIGIBLE"),
    
    CONTRIBUTION_LAST_YEAR("CONTRIBUTION_LAST_YEAR"),
    
    CONTRIBUTION_LAST_YEAR_MAXIMUM("CONTRIBUTION_LAST_YEAR_MAXIMUM"),
    
    CONTRIBUTION_LAST_YEAR_ELIGIBLE("CONTRIBUTION_LAST_YEAR_ELIGIBLE"),
    
    DISTRIBUTION_CURRENT_YEAR("DISTRIBUTION_CURRENT_YEAR"),
    
    DISTRIBUTION_LAST_YEAR("DISTRIBUTION_LAST_YEAR"),
    
    DISTRIBUTION_REQUIRED_MINIMUM("DISTRIBUTION_REQUIRED_MINIMUM"),
    
    LAST_PAYMENT_DEPOSIT("LAST_PAYMENT_DEPOSIT"),
    
    LAST_PAYMENT_DIVIDEND("LAST_PAYMENT_DIVIDEND"),
    
    LAST_PAYMENT_PRINCIPAL("LAST_PAYMENT_PRINCIPAL"),
    
    LAST_PAYMENT_INTEREST("LAST_PAYMENT_INTEREST"),
    
    ESCROW_YEAR_TO_DATE("ESCROW_YEAR_TO_DATE"),
    
    ESCROW_PRIOR_YEAR_TO_DATE("ESCROW_PRIOR_YEAR_TO_DATE"),
    
    ESCROW_INTEREST("ESCROW_INTEREST"),
    
    DUE_TOTAL("DUE_TOTAL"),
    
    DUE_INTEREST("DUE_INTEREST"),
    
    DUE_PRINCIPAL("DUE_PRINCIPAL"),
    
    DUE_MINIMUM("DUE_MINIMUM"),
    
    PAST_DUE_TOTAL("PAST_DUE_TOTAL"),
    
    PAST_DUE_INTEREST("PAST_DUE_INTEREST"),
    
    PAST_DUE_PRINCIPAL("PAST_DUE_PRINCIPAL"),
    
    PAY_OFF("PAY_OFF"),
    
    PAYMENT_MINIMUM("PAYMENT_MINIMUM"),
    
    PAYMENT_NEXT("PAYMENT_NEXT");

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

  public AncillaryAmount value(Amount value) {
    this.value = value;
    return this;
  }

  /**
   * Get value
   * @return value
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Amount getValue() {
    return value;
  }

  public void setValue(Amount value) {
    this.value = value;
  }

  public AncillaryAmount type(TypeEnum type) {
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
    AncillaryAmount ancillaryAmount = (AncillaryAmount) o;
    return Objects.equals(this.value, ancillaryAmount.value) &&
        Objects.equals(this.type, ancillaryAmount.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AncillaryAmount {\n");
    
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

