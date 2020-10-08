package com.ncr.banking.services.dbkniisdiis.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

/**
 * AccountUser
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-09-15T15:21:42.115-04:00")

public class AccountUser   {
  @JsonProperty("hostId")
  private String hostId = null;

  /**
   * Gets or Sets hostIdType
   */
  public enum HostIdTypeEnum {
    UNKNOWN("UNKNOWN"),
    
    MEMBER_ID("MEMBER_ID"),
    
    CIF("CIF"),
    
    UCAAM("UCAAM");

    private String value;

    HostIdTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static HostIdTypeEnum fromValue(String text) {
      for (HostIdTypeEnum b : HostIdTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("hostIdType")
  private HostIdTypeEnum hostIdType = null;

  public AccountUser hostId(String hostId) {
    this.hostId = hostId;
    return this;
  }

  /**
   * Get hostId
   * @return hostId
  **/
  @ApiModelProperty(value = "")


  public String getHostId() {
    return hostId;
  }

  public void setHostId(String hostId) {
    this.hostId = hostId;
  }

  public AccountUser hostIdType(HostIdTypeEnum hostIdType) {
    this.hostIdType = hostIdType;
    return this;
  }

  /**
   * Get hostIdType
   * @return hostIdType
  **/
  @ApiModelProperty(value = "")


  public HostIdTypeEnum getHostIdType() {
    return hostIdType;
  }

  public void setHostIdType(HostIdTypeEnum hostIdType) {
    this.hostIdType = hostIdType;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountUser accountUser = (AccountUser) o;
    return Objects.equals(this.hostId, accountUser.hostId) &&
        Objects.equals(this.hostIdType, accountUser.hostIdType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(hostId, hostIdType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountUser {\n");
    
    sb.append("    hostId: ").append(toIndentedString(hostId)).append("\n");
    sb.append("    hostIdType: ").append(toIndentedString(hostIdType)).append("\n");
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

