package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

/**
 * Document ia s model of Document part of the creation request
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-11-06T09:31:38.352Z")


public class Document {
    @JsonProperty("name")
    private String name = null;

    @JsonProperty("mime_type")
    private String mimeType = null;

    @JsonProperty("content")
    private String content = null;

    public Document name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Name of the submited document
     *
     * @return name
     **/
    @ApiModelProperty(example = "2018.pdf", value = "Name of the submited document")


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Document mimeType(String mimeType) {
        this.mimeType = mimeType;
        return this;
    }

    /**
     * Type of mime
     *
     * @return mimeType
     **/
    @ApiModelProperty(example = "application/pdf", value = "Type of mime")


    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public Document content(String content) {
        this.content = content;
        return this;
    }

    /**
     * Document content
     *
     * @return content
     **/
    @ApiModelProperty(example = "ICAiQC8qIjogWyJzcmMvKiJdCiAgICB9CiAgfQp9Cg==", value = "Document content")


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Document document = (Document) o;
        return Objects.equals(this.name, document.name) &&
                Objects.equals(this.mimeType, document.mimeType) &&
                Objects.equals(this.content, document.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, mimeType, content);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Document {\n");

        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    mimeType: ").append(toIndentedString(mimeType)).append("\n");
        sb.append("    content: ").append(toIndentedString(content)).append("\n");
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

