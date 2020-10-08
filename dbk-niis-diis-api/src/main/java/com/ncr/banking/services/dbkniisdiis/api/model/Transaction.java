package com.ncr.banking.services.dbkniisdiis.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * Transaction
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-09-15T15:21:42.115-04:00")

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transaction   {
  @JsonProperty("institutionId")
  private String institutionId = null;

  /**
   * Gets or Sets transactionType
   */
  public enum TransactionTypeEnum {
    DEBIT("DEBIT"),
    
    CREDIT("CREDIT"),
    
    UNKNOWN("UNKNOWN");

    private String value;

    TransactionTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TransactionTypeEnum fromValue(String text) {
      for (TransactionTypeEnum b : TransactionTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("transactionType")
  private TransactionTypeEnum transactionType = null;

  @JsonProperty("hostTransactionCodes")
  @Valid
  private List<HostTransactionCode> hostTransactionCodes = null;

  @JsonProperty("hostTransactionIds")
  @Valid
  private List<HostTransactionId> hostTransactionIds = null;

  @JsonProperty("hostAccountIds")
  @Valid
  private List<HostAccountId> hostAccountIds = null;

  @JsonProperty("ancillaryKeys")
  @Valid
  private List<AncillaryKey> ancillaryKeys = null;

  @JsonProperty("transactionAmounts")
  @Valid
  private List<TransactionAmount> transactionAmounts = null;

  @JsonProperty("balanceAmounts")
  @Valid
  private List<BalanceAmount> balanceAmounts = null;

  @JsonProperty("transactionDate")
  private OffsetDateTime transactionDate = null;

  @JsonProperty("effectiveDate")
  private OffsetDateTime effectiveDate = null;

  @JsonProperty("checkNumber")
  private String checkNumber = null;

  @JsonProperty("memo")
  private String memo = null;

  @JsonProperty("description")
  private String description = null;

  /**
   * Gets or Sets status
   */
  public enum StatusEnum {
    UNKNOWN("UNKNOWN"),
    
    LEDGER_POSTED("LEDGER_POSTED"),
    
    MEMO_POSTED("MEMO_POSTED"),
    
    HOLD("HOLD"),
    
    NON_PERSISTENT("NON_PERSISTENT");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(String text) {
      for (StatusEnum b : StatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("status")
  private StatusEnum status = null;

  @JsonProperty("images")
  @Valid
  private List<Image> images = null;

  @JsonProperty("error")
  private String error = null;

  @JsonProperty("additionalInfo")
  @Valid
  private Map<String, String> additionalInfo = null;

  public Transaction institutionId(String institutionId) {
    this.institutionId = institutionId;
    return this;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Transaction transaction = (Transaction) o;
    return Objects.equals(this.institutionId, transaction.institutionId) &&
        Objects.equals(this.transactionType, transaction.transactionType) &&
        Objects.equals(this.hostTransactionCodes, transaction.hostTransactionCodes) &&
        Objects.equals(this.hostTransactionIds, transaction.hostTransactionIds) &&
        Objects.equals(this.hostAccountIds, transaction.hostAccountIds) &&
        Objects.equals(this.ancillaryKeys, transaction.ancillaryKeys) &&
        Objects.equals(this.transactionAmounts, transaction.transactionAmounts) &&
        Objects.equals(this.balanceAmounts, transaction.balanceAmounts) &&
        Objects.equals(this.transactionDate, transaction.transactionDate) &&
        Objects.equals(this.effectiveDate, transaction.effectiveDate) &&
        Objects.equals(this.checkNumber, transaction.checkNumber) &&
        Objects.equals(this.memo, transaction.memo) &&
        Objects.equals(this.description, transaction.description) &&
        Objects.equals(this.status, transaction.status) &&
        Objects.equals(this.images, transaction.images) &&
        Objects.equals(this.error, transaction.error) &&
        Objects.equals(this.additionalInfo, transaction.additionalInfo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(institutionId, transactionType, hostTransactionCodes, hostTransactionIds, hostAccountIds, ancillaryKeys, transactionAmounts, balanceAmounts, transactionDate, effectiveDate, checkNumber, memo, description, status, images, error, additionalInfo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Transaction {\n");
    
    sb.append("    institutionId: ").append(toIndentedString(institutionId)).append("\n");
    sb.append("    transactionType: ").append(toIndentedString(transactionType)).append("\n");
    sb.append("    hostTransactionCodes: ").append(toIndentedString(hostTransactionCodes)).append("\n");
    sb.append("    hostTransactionIds: ").append(toIndentedString(hostTransactionIds)).append("\n");
    sb.append("    hostAccountIds: ").append(toIndentedString(hostAccountIds)).append("\n");
    sb.append("    ancillaryKeys: ").append(toIndentedString(ancillaryKeys)).append("\n");
    sb.append("    transactionAmounts: ").append(toIndentedString(transactionAmounts)).append("\n");
    sb.append("    balanceAmounts: ").append(toIndentedString(balanceAmounts)).append("\n");
    sb.append("    transactionDate: ").append(toIndentedString(transactionDate)).append("\n");
    sb.append("    effectiveDate: ").append(toIndentedString(effectiveDate)).append("\n");
    sb.append("    checkNumber: ").append(toIndentedString(checkNumber)).append("\n");
    sb.append("    memo: ").append(toIndentedString(memo)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    images: ").append(toIndentedString(images)).append("\n");
    sb.append("    error: ").append(toIndentedString(error)).append("\n");
    sb.append("    additionalInfo: ").append(toIndentedString(additionalInfo)).append("\n");
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

