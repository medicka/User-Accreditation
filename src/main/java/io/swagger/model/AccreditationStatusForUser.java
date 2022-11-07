package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.AccreditationStatus;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AccreditationStatusForUser
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-11-06T09:31:38.352Z")


public class AccreditationStatusForUser   {
  @JsonProperty("user_id")
  private String userId = null;

  @JsonProperty("accreditation_statuses")
  private AccreditationStatus accreditationStatuses = null;

  public AccreditationStatusForUser(String userId, AccreditationStatus accreditationStatuses) {
    this.userId = userId;
    this.accreditationStatuses = accreditationStatuses;
  }

  public AccreditationStatusForUser() {
  }

  public AccreditationStatusForUser userId(String userId) {
    this.userId = userId;
    return this;
  }

  /**
   * Id of the user
   * @return userId
  **/
  @ApiModelProperty(example = "g8NlYJnk7zK9BlB1J2Ebjs0AkhCTpE1V", value = "Id of the user")


  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public AccreditationStatusForUser accreditationStatuses(AccreditationStatus accreditationStatuses) {
    this.accreditationStatuses = accreditationStatuses;
    return this;
  }

  /**
   * Get accreditationStatuses
   * @return accreditationStatuses
  **/
  @ApiModelProperty(value = "")

  @Valid

  public AccreditationStatus getAccreditationStatuses() {
    return accreditationStatuses;
  }

  public void setAccreditationStatuses(AccreditationStatus accreditationStatuses) {
    this.accreditationStatuses = accreditationStatuses;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccreditationStatusForUser accreditationStatusForUser = (AccreditationStatusForUser) o;
    return Objects.equals(this.userId, accreditationStatusForUser.userId) &&
        Objects.equals(this.accreditationStatuses, accreditationStatusForUser.accreditationStatuses);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, accreditationStatuses);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccreditationStatusForUser {\n");
    
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    accreditationStatuses: ").append(toIndentedString(accreditationStatuses)).append("\n");
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

