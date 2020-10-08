package com.ncr.banking.services.dbkniisdiis.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

/**
 * Rule
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-09-15T15:21:42.115-04:00")

public class Rule   {
  @JsonProperty("condition")
  private String condition = null;

  /**
   * Gets or Sets action
   */
  public enum ActionEnum {
    VALIDATE("VALIDATE"),
    
    RESTRICT("RESTRICT"),
    
    RESTRICT_TRANSFER_TO("RESTRICT_TRANSFER_TO"),
    
    RESTRICT_TRANSFER_FROM("RESTRICT_TRANSFER_FROM");

    private String value;

    ActionEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static ActionEnum fromValue(String text) {
      for (ActionEnum b : ActionEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("action")
  private ActionEnum action = null;

  /**
   * Gets or Sets type
   */
  public enum TypeEnum {
    TRANSACTION("TRANSACTION"),
    
    PAYMENT("PAYMENT"),
    
    TRANSFER("TRANSFER");

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

  public Rule condition(String condition) {
    this.condition = condition;
    return this;
  }

  /**
   * Get condition
   * @return condition
  **/
  @ApiModelProperty(value = "")


  public String getCondition() {
    return condition;
  }

  public void setCondition(String condition) {
    this.condition = condition;
  }

  public Rule action(ActionEnum action) {
    this.action = action;
    return this;
  }

  /**
   * Get action
   * @return action
  **/
  @ApiModelProperty(value = "")


  public ActionEnum getAction() {
    return action;
  }

  public void setAction(ActionEnum action) {
    this.action = action;
  }

  public Rule type(TypeEnum type) {
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
    Rule rule = (Rule) o;
    return Objects.equals(this.condition, rule.condition) &&
        Objects.equals(this.action, rule.action) &&
        Objects.equals(this.type, rule.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(condition, action, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Rule {\n");
    
    sb.append("    condition: ").append(toIndentedString(condition)).append("\n");
    sb.append("    action: ").append(toIndentedString(action)).append("\n");
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

