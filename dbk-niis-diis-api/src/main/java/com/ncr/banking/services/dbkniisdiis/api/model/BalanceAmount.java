package com.ncr.banking.services.dbkniisdiis.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * BalanceAmount
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-09-15T15:21:42.115-04:00")

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BalanceAmount   {
  @JsonProperty("value")
  private Amount value = null;

  /**
   * Gets or Sets type
   */
  public enum TypeEnum {
    AVAILABLE_BALANCE("AVAILABLE_BALANCE"),
    
    CURRENT_BALANCE("CURRENT_BALANCE"),
    
    AVERAGE_DAILY_BALANCE("AVERAGE_DAILY_BALANCE"),
    
    PRINCIPAL_BALANCE("PRINCIPAL_BALANCE"),
    
    LEDGER_BALANCE("LEDGER_BALANCE"),
    
    LAST_STATEMENT_BALANCE("LAST_STATEMENT_BALANCE"),
    
    ESCROW_BALANCE("ESCROW_BALANCE");

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

  public BalanceAmount value(Amount value) {
    this.value = value;
    return this;
  }

  /**
   * Get value
   * @return value
  **/
  @ApiModelProperty(value = "")

  @Valid

  public BalanceAmount type(TypeEnum type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
  **/
  @ApiModelProperty(value = "")


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BalanceAmount balanceAmount = (BalanceAmount) o;
    return Objects.equals(this.value, balanceAmount.value) &&
        Objects.equals(this.type, balanceAmount.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BalanceAmount {\n");
    
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

