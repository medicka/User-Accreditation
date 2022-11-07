package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * StatusDetails
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-11-06T09:31:38.352Z")


public class StatusDetails   {
  @JsonProperty("accreditation_type")
  private String accreditationType = null;

  @JsonProperty("status")
  private String status = null;

  public StatusDetails(String accreditationType, String status) {
    this.accreditationType = accreditationType;
    this.status = status;
  }

  public StatusDetails() {
  }

  public StatusDetails accreditationType(String accreditationType) {
    this.accreditationType = accreditationType;
    return this;
  }

  /**
   * Type of this accreditation
   * @return accreditationType
  **/
  @ApiModelProperty(example = "BY_INCOME", value = "Type of this accreditation")


  public String getAccreditationType() {
    return accreditationType;
  }

  public void setAccreditationType(String accreditationType) {
    this.accreditationType = accreditationType;
  }

  public StatusDetails status(String status) {
    this.status = status;
    return this;
  }

  /**
   * Status of the accreditation
   * @return status
  **/
  @ApiModelProperty(example = "FAILED", value = "Status of the accreditation")


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StatusDetails statusDetails = (StatusDetails) o;
    return Objects.equals(this.accreditationType, statusDetails.accreditationType) &&
        Objects.equals(this.status, statusDetails.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accreditationType, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StatusDetails {\n");
    
    sb.append("    accreditationType: ").append(toIndentedString(accreditationType)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

