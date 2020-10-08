package com.ncr.banking.services.dbkniisdiis.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

/**
 * QualifyingTier
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-09-15T15:21:42.115-04:00")

public class QualifyingTier   {
  /**
   * Gets or Sets tier
   */
  public enum TierEnum {
    NON_QUALIFIED("NON_QUALIFIED"),
    
    TIER1("TIER1"),
    
    TIER2("TIER2");

    private String value;

    TierEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TierEnum fromValue(String text) {
      for (TierEnum b : TierEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("tier")
  private TierEnum tier = null;

  @JsonProperty("rate")
  private String rate = null;

  @JsonProperty("description")
  private String description = null;

  public QualifyingTier tier(TierEnum tier) {
    this.tier = tier;
    return this;
  }

  /**
   * Get tier
   * @return tier
  **/
  @ApiModelProperty(value = "")


  public TierEnum getTier() {
    return tier;
  }

  public void setTier(TierEnum tier) {
    this.tier = tier;
  }

  public QualifyingTier rate(String rate) {
    this.rate = rate;
    return this;
  }

  /**
   * Get rate
   * @return rate
  **/
  @ApiModelProperty(value = "")


  public String getRate() {
    return rate;
  }

  public void setRate(String rate) {
    this.rate = rate;
  }

  public QualifyingTier description(String description) {
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


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    QualifyingTier qualifyingTier = (QualifyingTier) o;
    return Objects.equals(this.tier, qualifyingTier.tier) &&
        Objects.equals(this.rate, qualifyingTier.rate) &&
        Objects.equals(this.description, qualifyingTier.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tier, rate, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class QualifyingTier {\n");
    
    sb.append("    tier: ").append(toIndentedString(tier)).append("\n");
    sb.append("    rate: ").append(toIndentedString(rate)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

