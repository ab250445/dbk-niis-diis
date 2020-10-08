package com.ncr.banking.services.dbkniisdiis.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

/**
 * AccountHolder
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-09-15T15:21:42.115-04:00")

public class AccountHolder   {
  @JsonProperty("name")
  private String name = null;

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

  /**
   * Gets or Sets accountHolderType
   */
  public enum AccountHolderTypeEnum {
    PRIMARY("PRIMARY"),
    
    SECONDARY("SECONDARY");

    private String value;

    AccountHolderTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static AccountHolderTypeEnum fromValue(String text) {
      for (AccountHolderTypeEnum b : AccountHolderTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("accountHolderType")
  private AccountHolderTypeEnum accountHolderType = null;

  public AccountHolder name(String name) {
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

  public AccountHolder hostId(String hostId) {
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

  public AccountHolder hostIdType(HostIdTypeEnum hostIdType) {
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

  public AccountHolder accountHolderType(AccountHolderTypeEnum accountHolderType) {
    this.accountHolderType = accountHolderType;
    return this;
  }

  /**
   * Get accountHolderType
   * @return accountHolderType
  **/
  @ApiModelProperty(value = "")


  public AccountHolderTypeEnum getAccountHolderType() {
    return accountHolderType;
  }

  public void setAccountHolderType(AccountHolderTypeEnum accountHolderType) {
    this.accountHolderType = accountHolderType;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountHolder accountHolder = (AccountHolder) o;
    return Objects.equals(this.name, accountHolder.name) &&
        Objects.equals(this.hostId, accountHolder.hostId) &&
        Objects.equals(this.hostIdType, accountHolder.hostIdType) &&
        Objects.equals(this.accountHolderType, accountHolder.accountHolderType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, hostId, hostIdType, accountHolderType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountHolder {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    hostId: ").append(toIndentedString(hostId)).append("\n");
    sb.append("    hostIdType: ").append(toIndentedString(hostIdType)).append("\n");
    sb.append("    accountHolderType: ").append(toIndentedString(accountHolderType)).append("\n");
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

