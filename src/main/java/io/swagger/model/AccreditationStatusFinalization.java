package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AccreditationStatusFinalization
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-11-06T09:31:38.352Z")


public class AccreditationStatusFinalization   {
  /**
   * Status of the reviewed or expired accreditation
   */
  public enum OutcomeEnum {
    CONFIRMED("CONFIRMED"),
    
    EXPIRED("EXPIRED"),
    
    FAILED("FAILED");

    private String value;

    OutcomeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static OutcomeEnum fromValue(String text) {
      for (OutcomeEnum b : OutcomeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("outcome")
  private OutcomeEnum outcome = null;

  public AccreditationStatusFinalization outcome(OutcomeEnum outcome) {
    this.outcome = outcome;
    return this;
  }

  /**
   * Status of the reviewed or expired accreditation
   * @return outcome
  **/
  @ApiModelProperty(example = "CONFIRMED", value = "Status of the reviewed or expired accreditation")


  public OutcomeEnum getOutcome() {
    return outcome;
  }

  public void setOutcome(OutcomeEnum outcome) {
    this.outcome = outcome;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccreditationStatusFinalization accreditationStatusFinalization = (AccreditationStatusFinalization) o;
    return Objects.equals(this.outcome, accreditationStatusFinalization.outcome);
  }

  @Override
  public int hashCode() {
    return Objects.hash(outcome);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccreditationStatusFinalization {\n");
    
    sb.append("    outcome: ").append(toIndentedString(outcome)).append("\n");
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

