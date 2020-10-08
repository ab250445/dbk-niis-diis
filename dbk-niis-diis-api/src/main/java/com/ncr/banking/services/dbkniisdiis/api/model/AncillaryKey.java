package com.ncr.banking.services.dbkniisdiis.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

/**
 * AncillaryKey
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-09-15T15:21:42.115-04:00")

public class AncillaryKey   {
  @JsonProperty("key")
  private String key = null;

  @JsonProperty("value")
  private String value = null;

  public AncillaryKey key(String key) {
    this.key = key;
    return this;
  }

  /**
   * Get key
   * @return key
  **/
  @ApiModelProperty(value = "")


  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public AncillaryKey value(String value) {
    this.value = value;
    return this;
  }

  /**
   * Get value
   * @return value
  **/
  @ApiModelProperty(value = "")


  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AncillaryKey ancillaryKey = (AncillaryKey) o;
    return Objects.equals(this.key, ancillaryKey.key) &&
        Objects.equals(this.value, ancillaryKey.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(key, value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AncillaryKey {\n");
    
    sb.append("    key: ").append(toIndentedString(key)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
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

