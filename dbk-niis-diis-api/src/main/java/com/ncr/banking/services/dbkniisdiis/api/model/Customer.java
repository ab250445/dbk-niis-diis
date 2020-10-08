package com.ncr.banking.services.dbkniisdiis.api.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * Customer
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-09-15T15:21:42.115-04:00")

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("institutionId")
  private String institutionId = null;

  @JsonProperty("branchId")
  private String branchId = null;

  @JsonProperty("secretQuestion")
  private String secretQuestion = null;

  @JsonProperty("secretAnswer")
  private String secretAnswer = null;

  @JsonProperty("status")
  private String status = null;

  @JsonProperty("segmentation")
  private String segmentation = null;

  @JsonProperty("ancillaryKeys")
  @Valid
  private List<AncillaryKey> ancillaryKeys = null;

  @JsonProperty("hostIds")
  @Valid
  private List<HostId> hostIds = null;

  @JsonProperty("person")
  private Person person = null;

  @JsonProperty("organization")
  private Organization organization = null;

  @JsonProperty("additionalInfo")
  @Valid
  private Map<String, String> additionalInfo = null;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Customer customer = (Customer) o;
    return Objects.equals(this.id, customer.id) &&
        Objects.equals(this.institutionId, customer.institutionId) &&
        Objects.equals(this.branchId, customer.branchId) &&
        Objects.equals(this.secretQuestion, customer.secretQuestion) &&
        Objects.equals(this.secretAnswer, customer.secretAnswer) &&
        Objects.equals(this.status, customer.status) &&
        Objects.equals(this.segmentation, customer.segmentation) &&
        Objects.equals(this.ancillaryKeys, customer.ancillaryKeys) &&
        Objects.equals(this.hostIds, customer.hostIds) &&
        Objects.equals(this.person, customer.person) &&
        Objects.equals(this.organization, customer.organization) &&
        Objects.equals(this.additionalInfo, customer.additionalInfo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, institutionId, branchId, secretQuestion, secretAnswer, status, segmentation, ancillaryKeys, hostIds, person, organization, additionalInfo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Customer {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    institutionId: ").append(toIndentedString(institutionId)).append("\n");
    sb.append("    branchId: ").append(toIndentedString(branchId)).append("\n");
    sb.append("    secretQuestion: ").append(toIndentedString(secretQuestion)).append("\n");
    sb.append("    secretAnswer: ").append(toIndentedString(secretAnswer)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    segmentation: ").append(toIndentedString(segmentation)).append("\n");
    sb.append("    ancillaryKeys: ").append(toIndentedString(ancillaryKeys)).append("\n");
    sb.append("    hostIds: ").append(toIndentedString(hostIds)).append("\n");
    sb.append("    person: ").append(toIndentedString(person)).append("\n");
    sb.append("    organization: ").append(toIndentedString(organization)).append("\n");
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

