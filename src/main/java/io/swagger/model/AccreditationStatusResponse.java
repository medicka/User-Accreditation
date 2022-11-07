package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

/**
 * AccreditationStatusResponse is a model of creation and finalization response
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-11-06T09:31:38.352Z")


public class AccreditationStatusResponse {
    @JsonProperty("accreditation_id")
    private String accreditationId = null;

    public AccreditationStatusResponse accreditationId(String accreditationId) {
        this.accreditationId = accreditationId;
        return this;
    }

    /**
     * Unique Id for the accreditation
     *
     * @return accreditationId
     **/
    @ApiModelProperty(example = "87bb6030-458e-11ed-b023-039b275a916a", value = "Unique Id for the accreditation")


    public String getAccreditationId() {
        return accreditationId;
    }

    public void setAccreditationId(String accreditationId) {
        this.accreditationId = accreditationId;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AccreditationStatusResponse accreditationStatusResponse = (AccreditationStatusResponse) o;
        return Objects.equals(this.accreditationId, accreditationStatusResponse.accreditationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accreditationId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AccreditationStatusResponse {\n");

        sb.append("    accreditationId: ").append(toIndentedString(accreditationId)).append("\n");
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

