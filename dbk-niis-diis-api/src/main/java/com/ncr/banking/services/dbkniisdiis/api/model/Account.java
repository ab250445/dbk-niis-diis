package com.ncr.banking.services.dbkniisdiis.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * Account
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-09-15T15:21:42.115-04:00")

public class Account   {
  @JsonProperty("institutionId")
  private String institutionId = null;

  @JsonProperty("accountType")
  private String accountType = null;

  @JsonProperty("productCode")
  private String productCode = null;

  @JsonProperty("routingNumber")
  private String routingNumber = null;

  /**
   * Gets or Sets category
   */
  public enum CategoryEnum {
    DEPOSIT("DEPOSIT"),
    
    LOAN("LOAN"),
    
    INVESTMENT("INVESTMENT"),
    
    TIERED_LOAN("TIERED_LOAN"),
    
    CROSS_USER_ACCOUNT("CROSS_USER_ACCOUNT");

    private String value;

    CategoryEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static CategoryEnum fromValue(String text) {
      for (CategoryEnum b : CategoryEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("category")
  private CategoryEnum category = null;

  @JsonProperty("ancillaryKeys")
  @Valid
  private List<AncillaryKey> ancillaryKeys = null;

  @JsonProperty("hostAccountIds")
  @Valid
  private List<HostAccountId> hostAccountIds = null;

  @JsonProperty("externalBroker")
  private String externalBroker = null;

  @JsonProperty("nickName")
  private String nickName = null;

  @JsonProperty("description")
  private String description = null;

  /**
   * Gets or Sets status
   */
  public enum StatusEnum {
    OPEN("OPEN"),
    
    CLOSED("CLOSED"),
    
    NEGATIVE_BALANCE("NEGATIVE_BALANCE"),
    
    DELINQUENT("DELINQUENT"),
    
    IN_COLLECTION("IN_COLLECTION"),
    
    OVER_LIMIT("OVER_LIMIT"),
    
    WRITTEN_OFF("WRITTEN_OFF"),
    
    CREDIT_BALANCE("CREDIT_BALANCE"),
    
    PAYMENT_COUPON("PAYMENT_COUPON"),
    
    RETIREMENT_PLAN("RETIREMENT_PLAN"),
    
    RET_PLAN_OWNED_BY_DECEASED("RET_PLAN_OWNED_BY_DECEASED"),
    
    APPROVED("APPROVED"),
    
    NOT_APPROVED("NOT_APPROVED"),
    
    DELETED("DELETED"),
    
    VERIFIED("VERIFIED");

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

  @JsonProperty("qualifyingTiers")
  @Valid
  private List<QualifyingTier> qualifyingTiers = null;

  @JsonProperty("cards")
  @Valid
  private List<Card> cards = null;

  @JsonProperty("currentCounts")
  @Valid
  private List<CurrentCount> currentCounts = null;

  @JsonProperty("accountHolders")
  @Valid
  private List<AccountHolder> accountHolders = null;

  @JsonProperty("alternatePrimaryUsers")
  @Valid
  private List<AccountUser> alternatePrimaryUsers = null;

  @JsonProperty("balanceAmounts")
  @Valid
  private List<BalanceAmount> balanceAmounts = null;

  @JsonProperty("ancillaryAmounts")
  @Valid
  private List<AncillaryAmount> ancillaryAmounts = null;

  @JsonProperty("ancillaryDates")
  @Valid
  private List<AncillaryDate> ancillaryDates = null;

  @JsonProperty("rules")
  @Valid
  private List<Rule> rules = null;

  @JsonProperty("rates")
  @Valid
  private List<Rate> rates = null;

  @JsonProperty("term")
  private Term term = null;

  @JsonProperty("additionalInfo")
  @Valid
  private Map<String, String> additionalInfo = null;

  public Account institutionId(String institutionId) {
    this.institutionId = institutionId;
    return this;
  }

  /**
   * Get institutionId
   * @return institutionId
  **/
  @ApiModelProperty(value = "")


  public String getInstitutionId() {
    return institutionId;
  }

  public void setInstitutionId(String institutionId) {
    this.institutionId = institutionId;
  }

  public Account accountType(String accountType) {
    this.accountType = accountType;
    return this;
  }

  /**
   * Get accountType
   * @return accountType
  **/
  @ApiModelProperty(value = "")


  public String getAccountType() {
    return accountType;
  }

  public void setAccountType(String accountType) {
    this.accountType = accountType;
  }

  public Account productCode(String productCode) {
    this.productCode = productCode;
    return this;
  }

  /**
   * Get productCode
   * @return productCode
  **/
  @ApiModelProperty(value = "")


  public String getProductCode() {
    return productCode;
  }

  public void setProductCode(String productCode) {
    this.productCode = productCode;
  }

  public Account routingNumber(String routingNumber) {
    this.routingNumber = routingNumber;
    return this;
  }

  /**
   * Get routingNumber
   * @return routingNumber
  **/
  @ApiModelProperty(value = "")


  public String getRoutingNumber() {
    return routingNumber;
  }

  public void setRoutingNumber(String routingNumber) {
    this.routingNumber = routingNumber;
  }

  public Account category(CategoryEnum category) {
    this.category = category;
    return this;
  }

  /**
   * Get category
   * @return category
  **/
  @ApiModelProperty(value = "")


  public CategoryEnum getCategory() {
    return category;
  }

  public void setCategory(CategoryEnum category) {
    this.category = category;
  }

  public Account ancillaryKeys(List<AncillaryKey> ancillaryKeys) {
    this.ancillaryKeys = ancillaryKeys;
    return this;
  }

  public Account addAncillaryKeysItem(AncillaryKey ancillaryKeysItem) {
    if (this.ancillaryKeys == null) {
      this.ancillaryKeys = new ArrayList<AncillaryKey>();
    }
    this.ancillaryKeys.add(ancillaryKeysItem);
    return this;
  }

  /**
   * Get ancillaryKeys
   * @return ancillaryKeys
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<AncillaryKey> getAncillaryKeys() {
    return ancillaryKeys;
  }

  public void setAncillaryKeys(List<AncillaryKey> ancillaryKeys) {
    this.ancillaryKeys = ancillaryKeys;
  }

  public Account hostAccountIds(List<HostAccountId> hostAccountIds) {
    this.hostAccountIds = hostAccountIds;
    return this;
  }

  public Account addHostAccountIdsItem(HostAccountId hostAccountIdsItem) {
    if (this.hostAccountIds == null) {
      this.hostAccountIds = new ArrayList<HostAccountId>();
    }
    this.hostAccountIds.add(hostAccountIdsItem);
    return this;
  }

  /**
   * Get hostAccountIds
   * @return hostAccountIds
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<HostAccountId> getHostAccountIds() {
    return hostAccountIds;
  }

  public void setHostAccountIds(List<HostAccountId> hostAccountIds) {
    this.hostAccountIds = hostAccountIds;
  }

  public Account externalBroker(String externalBroker) {
    this.externalBroker = externalBroker;
    return this;
  }

  /**
   * Get externalBroker
   * @return externalBroker
  **/
  @ApiModelProperty(value = "")


  public String getExternalBroker() {
    return externalBroker;
  }

  public void setExternalBroker(String externalBroker) {
    this.externalBroker = externalBroker;
  }

  public Account nickName(String nickName) {
    this.nickName = nickName;
    return this;
  }

  /**
   * Get nickName
   * @return nickName
  **/
  @ApiModelProperty(value = "")


  public String getNickName() {
    return nickName;
  }

  public void setNickName(String nickName) {
    this.nickName = nickName;
  }

  public Account description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
  **/
  @ApiModelProperty(value = "")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Account status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  **/
  @ApiModelProperty(value = "")


  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public Account qualifyingTiers(List<QualifyingTier> qualifyingTiers) {
    this.qualifyingTiers = qualifyingTiers;
    return this;
  }

  public Account addQualifyingTiersItem(QualifyingTier qualifyingTiersItem) {
    if (this.qualifyingTiers == null) {
      this.qualifyingTiers = new ArrayList<QualifyingTier>();
    }
    this.qualifyingTiers.add(qualifyingTiersItem);
    return this;
  }

  /**
   * Get qualifyingTiers
   * @return qualifyingTiers
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<QualifyingTier> getQualifyingTiers() {
    return qualifyingTiers;
  }

  public void setQualifyingTiers(List<QualifyingTier> qualifyingTiers) {
    this.qualifyingTiers = qualifyingTiers;
  }

  public Account cards(List<Card> cards) {
    this.cards = cards;
    return this;
  }

  public Account addCardsItem(Card cardsItem) {
    if (this.cards == null) {
      this.cards = new ArrayList<Card>();
    }
    this.cards.add(cardsItem);
    return this;
  }

  /**
   * Get cards
   * @return cards
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<Card> getCards() {
    return cards;
  }

  public void setCards(List<Card> cards) {
    this.cards = cards;
  }

  public Account currentCounts(List<CurrentCount> currentCounts) {
    this.currentCounts = currentCounts;
    return this;
  }

  public Account addCurrentCountsItem(CurrentCount currentCountsItem) {
    if (this.currentCounts == null) {
      this.currentCounts = new ArrayList<CurrentCount>();
    }
    this.currentCounts.add(currentCountsItem);
    return this;
  }

  /**
   * Get currentCounts
   * @return currentCounts
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<CurrentCount> getCurrentCounts() {
    return currentCounts;
  }

  public void setCurrentCounts(List<CurrentCount> currentCounts) {
    this.currentCounts = currentCounts;
  }

  public Account accountHolders(List<AccountHolder> accountHolders) {
    this.accountHolders = accountHolders;
    return this;
  }

  public Account addAccountHoldersItem(AccountHolder accountHoldersItem) {
    if (this.accountHolders == null) {
      this.accountHolders = new ArrayList<AccountHolder>();
    }
    this.accountHolders.add(accountHoldersItem);
    return this;
  }

  /**
   * Get accountHolders
   * @return accountHolders
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<AccountHolder> getAccountHolders() {
    return accountHolders;
  }

  public void setAccountHolders(List<AccountHolder> accountHolders) {
    this.accountHolders = accountHolders;
  }

  public Account alternatePrimaryUsers(List<AccountUser> alternatePrimaryUsers) {
    this.alternatePrimaryUsers = alternatePrimaryUsers;
    return this;
  }

  public Account addAlternatePrimaryUsersItem(AccountUser alternatePrimaryUsersItem) {
    if (this.alternatePrimaryUsers == null) {
      this.alternatePrimaryUsers = new ArrayList<AccountUser>();
    }
    this.alternatePrimaryUsers.add(alternatePrimaryUsersItem);
    return this;
  }

  /**
   * Get alternatePrimaryUsers
   * @return alternatePrimaryUsers
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<AccountUser> getAlternatePrimaryUsers() {
    return alternatePrimaryUsers;
  }

  public void setAlternatePrimaryUsers(List<AccountUser> alternatePrimaryUsers) {
    this.alternatePrimaryUsers = alternatePrimaryUsers;
  }

  public Account balanceAmounts(List<BalanceAmount> balanceAmounts) {
    this.balanceAmounts = balanceAmounts;
    return this;
  }

  public Account addBalanceAmountsItem(BalanceAmount balanceAmountsItem) {
    if (this.balanceAmounts == null) {
      this.balanceAmounts = new ArrayList<BalanceAmount>();
    }
    this.balanceAmounts.add(balanceAmountsItem);
    return this;
  }

  /**
   * Get balanceAmounts
   * @return balanceAmounts
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<BalanceAmount> getBalanceAmounts() {
    return balanceAmounts;
  }

  public void setBalanceAmounts(List<BalanceAmount> balanceAmounts) {
    this.balanceAmounts = balanceAmounts;
  }

  public Account ancillaryAmounts(List<AncillaryAmount> ancillaryAmounts) {
    this.ancillaryAmounts = ancillaryAmounts;
    return this;
  }

  public Account addAncillaryAmountsItem(AncillaryAmount ancillaryAmountsItem) {
    if (this.ancillaryAmounts == null) {
      this.ancillaryAmounts = new ArrayList<AncillaryAmount>();
    }
    this.ancillaryAmounts.add(ancillaryAmountsItem);
    return this;
  }

  /**
   * Get ancillaryAmounts
   * @return ancillaryAmounts
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<AncillaryAmount> getAncillaryAmounts() {
    return ancillaryAmounts;
  }

  public void setAncillaryAmounts(List<AncillaryAmount> ancillaryAmounts) {
    this.ancillaryAmounts = ancillaryAmounts;
  }

  public Account ancillaryDates(List<AncillaryDate> ancillaryDates) {
    this.ancillaryDates = ancillaryDates;
    return this;
  }

  public Account addAncillaryDatesItem(AncillaryDate ancillaryDatesItem) {
    if (this.ancillaryDates == null) {
      this.ancillaryDates = new ArrayList<AncillaryDate>();
    }
    this.ancillaryDates.add(ancillaryDatesItem);
    return this;
  }

  /**
   * Get ancillaryDates
   * @return ancillaryDates
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<AncillaryDate> getAncillaryDates() {
    return ancillaryDates;
  }

  public void setAncillaryDates(List<AncillaryDate> ancillaryDates) {
    this.ancillaryDates = ancillaryDates;
  }

  public Account rules(List<Rule> rules) {
    this.rules = rules;
    return this;
  }

  public Account addRulesItem(Rule rulesItem) {
    if (this.rules == null) {
      this.rules = new ArrayList<Rule>();
    }
    this.rules.add(rulesItem);
    return this;
  }

  /**
   * Get rules
   * @return rules
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<Rule> getRules() {
    return rules;
  }

  public void setRules(List<Rule> rules) {
    this.rules = rules;
  }

  public Account rates(List<Rate> rates) {
    this.rates = rates;
    return this;
  }

  public Account addRatesItem(Rate ratesItem) {
    if (this.rates == null) {
      this.rates = new ArrayList<Rate>();
    }
    this.rates.add(ratesItem);
    return this;
  }

  /**
   * Get rates
   * @return rates
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<Rate> getRates() {
    return rates;
  }

  public void setRates(List<Rate> rates) {
    this.rates = rates;
  }

  public Account term(Term term) {
    this.term = term;
    return this;
  }

  /**
   * Get term
   * @return term
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Term getTerm() {
    return term;
  }

  public void setTerm(Term term) {
    this.term = term;
  }

  public Account additionalInfo(Map<String, String> additionalInfo) {
    this.additionalInfo = additionalInfo;
    return this;
  }

  public Account putAdditionalInfoItem(String key, String additionalInfoItem) {
    if (this.additionalInfo == null) {
      this.additionalInfo = new HashMap<String, String>();
    }
    this.additionalInfo.put(key, additionalInfoItem);
    return this;
  }

  /**
   * Get additionalInfo
   * @return additionalInfo
  **/
  @ApiModelProperty(value = "")


  public Map<String, String> getAdditionalInfo() {
    return additionalInfo;
  }

  public void setAdditionalInfo(Map<String, String> additionalInfo) {
    this.additionalInfo = additionalInfo;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Account account = (Account) o;
    return Objects.equals(this.institutionId, account.institutionId) &&
        Objects.equals(this.accountType, account.accountType) &&
        Objects.equals(this.productCode, account.productCode) &&
        Objects.equals(this.routingNumber, account.routingNumber) &&
        Objects.equals(this.category, account.category) &&
        Objects.equals(this.ancillaryKeys, account.ancillaryKeys) &&
        Objects.equals(this.hostAccountIds, account.hostAccountIds) &&
        Objects.equals(this.externalBroker, account.externalBroker) &&
        Objects.equals(this.nickName, account.nickName) &&
        Objects.equals(this.description, account.description) &&
        Objects.equals(this.status, account.status) &&
        Objects.equals(this.qualifyingTiers, account.qualifyingTiers) &&
        Objects.equals(this.cards, account.cards) &&
        Objects.equals(this.currentCounts, account.currentCounts) &&
        Objects.equals(this.accountHolders, account.accountHolders) &&
        Objects.equals(this.alternatePrimaryUsers, account.alternatePrimaryUsers) &&
        Objects.equals(this.balanceAmounts, account.balanceAmounts) &&
        Objects.equals(this.ancillaryAmounts, account.ancillaryAmounts) &&
        Objects.equals(this.ancillaryDates, account.ancillaryDates) &&
        Objects.equals(this.rules, account.rules) &&
        Objects.equals(this.rates, account.rates) &&
        Objects.equals(this.term, account.term) &&
        Objects.equals(this.additionalInfo, account.additionalInfo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(institutionId, accountType, productCode, routingNumber, category, ancillaryKeys, hostAccountIds, externalBroker, nickName, description, status, qualifyingTiers, cards, currentCounts, accountHolders, alternatePrimaryUsers, balanceAmounts, ancillaryAmounts, ancillaryDates, rules, rates, term, additionalInfo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Account {\n");
    
    sb.append("    institutionId: ").append(toIndentedString(institutionId)).append("\n");
    sb.append("    accountType: ").append(toIndentedString(accountType)).append("\n");
    sb.append("    productCode: ").append(toIndentedString(productCode)).append("\n");
    sb.append("    routingNumber: ").append(toIndentedString(routingNumber)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    ancillaryKeys: ").append(toIndentedString(ancillaryKeys)).append("\n");
    sb.append("    hostAccountIds: ").append(toIndentedString(hostAccountIds)).append("\n");
    sb.append("    externalBroker: ").append(toIndentedString(externalBroker)).append("\n");
    sb.append("    nickName: ").append(toIndentedString(nickName)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    qualifyingTiers: ").append(toIndentedString(qualifyingTiers)).append("\n");
    sb.append("    cards: ").append(toIndentedString(cards)).append("\n");
    sb.append("    currentCounts: ").append(toIndentedString(currentCounts)).append("\n");
    sb.append("    accountHolders: ").append(toIndentedString(accountHolders)).append("\n");
    sb.append("    alternatePrimaryUsers: ").append(toIndentedString(alternatePrimaryUsers)).append("\n");
    sb.append("    balanceAmounts: ").append(toIndentedString(balanceAmounts)).append("\n");
    sb.append("    ancillaryAmounts: ").append(toIndentedString(ancillaryAmounts)).append("\n");
    sb.append("    ancillaryDates: ").append(toIndentedString(ancillaryDates)).append("\n");
    sb.append("    rules: ").append(toIndentedString(rules)).append("\n");
    sb.append("    rates: ").append(toIndentedString(rates)).append("\n");
    sb.append("    term: ").append(toIndentedString(term)).append("\n");
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

