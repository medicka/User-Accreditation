package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Document;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AccreditationStatusCreation
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-11-06T09:31:38.352Z")


public class AccreditationStatusCreation   {
  @JsonProperty("user_id")
  private String userId = null;

  /**
   * Possibel type of accreditation
   */
  public enum AccreditationTypeEnum {
    INCOME("BY_INCOME"),
    
    NET_WORTH("BY_NET_WORTH");

    private String value;

    AccreditationTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static AccreditationTypeEnum fromValue(String text) {
      for (AccreditationTypeEnum b : AccreditationTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("accreditation_type")
  private AccreditationTypeEnum accreditationType = null;

  @JsonProperty("document")
  private Document document = null;

  public AccreditationStatusCreation userId(String userId) {
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

  public AccreditationStatusCreation accreditationType(AccreditationTypeEnum accreditationType) {
    this.accreditationType = accreditationType;
    return this;
  }

  /**
   * Possibel type of accreditation
   * @return accreditationType
  **/
  @ApiModelProperty(example = "BY_INCOME", value = "Possibel type of accreditation")


  public AccreditationTypeEnum getAccreditationType() {
    return accreditationType;
  }

  public void setAccreditationType(AccreditationTypeEnum accreditationType) {
    this.accreditationType = accreditationType;
  }

  public AccreditationStatusCreation document(Document document) {
    this.document = document;
    return this;
  }

  /**
   * Get document
   * @return document
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Document getDocument() {
    return document;
  }

  public void setDocument(Document document) {
    this.document = document;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccreditationStatusCreation accreditationStatusCreation = (AccreditationStatusCreation) o;
    return Objects.equals(this.userId, accreditationStatusCreation.userId) &&
        Objects.equals(this.accreditationType, accreditationStatusCreation.accreditationType) &&
        Objects.equals(this.document, accreditationStatusCreation.document);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, accreditationType, document);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccreditationStatusCreation {\n");
    
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    accreditationType: ").append(toIndentedString(accreditationType)).append("\n");
    sb.append("    document: ").append(toIndentedString(document)).append("\n");
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

