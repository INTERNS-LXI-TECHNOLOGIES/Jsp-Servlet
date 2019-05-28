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
 * KeyAndPasswordVM
 */
@Validated
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-05-28T11:30:35.547+05:30[Asia/Kolkata]")

public class KeyAndPasswordVM   {
  @JsonProperty("key")
  private String key = null;

  @JsonProperty("newPassword")
  private String newPassword = null;

  public KeyAndPasswordVM key(String key) {
    this.key = key;
    return this;
  }

  /**
   * Get key
   * @return key
  **/
  @ApiModelProperty(value = "")


  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public KeyAndPasswordVM newPassword(String newPassword) {
    this.newPassword = newPassword;
    return this;
  }

  /**
   * Get newPassword
   * @return newPassword
  **/
  @ApiModelProperty(value = "")


  public String getNewPassword() {
    return newPassword;
  }

  public void setNewPassword(String newPassword) {
    this.newPassword = newPassword;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    KeyAndPasswordVM keyAndPasswordVM = (KeyAndPasswordVM) o;
    return Objects.equals(this.key, keyAndPasswordVM.key) &&
        Objects.equals(this.newPassword, keyAndPasswordVM.newPassword);
  }

  @Override
  public int hashCode() {
    return Objects.hash(key, newPassword);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class KeyAndPasswordVM {\n");
    
    sb.append("    key: ").append(toIndentedString(key)).append("\n");
    sb.append("    newPassword: ").append(toIndentedString(newPassword)).append("\n");
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

