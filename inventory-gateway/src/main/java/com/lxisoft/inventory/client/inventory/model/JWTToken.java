package com.lxisoft.inventory.client.inventory.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * JWTToken
 */
@Validated
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-05-28T11:30:35.547+05:30[Asia/Kolkata]")

public class JWTToken   {
  @JsonProperty("id_token")
  private String idToken = null;

  public JWTToken idToken(String idToken) {
    this.idToken = idToken;
    return this;
  }

  /**
   * Get idToken
   * @return idToken
  **/
  @ApiModelProperty(value = "")


  public String getIdToken() {
    return idToken;
  }

  public void setIdToken(String idToken) {
    this.idToken = idToken;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JWTToken jwTToken = (JWTToken) o;
    return Objects.equals(this.idToken, jwTToken.idToken);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idToken);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JWTToken {\n");
    
    sb.append("    idToken: ").append(toIndentedString(idToken)).append("\n");
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

