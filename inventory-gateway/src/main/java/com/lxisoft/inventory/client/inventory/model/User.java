package com.lxisoft.inventory.client.inventory.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * User
 */
@Validated
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-05-28T11:30:35.547+05:30[Asia/Kolkata]")

public class User   {
  @JsonProperty("activated")
  private Boolean activated = null;

  @JsonProperty("email")
  private String email = null;

  @JsonProperty("firstName")
  private String firstName = null;

  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("imageUrl")
  private String imageUrl = null;

  @JsonProperty("langKey")
  private String langKey = null;

  @JsonProperty("lastName")
  private String lastName = null;

  @JsonProperty("login")
  private String login = null;

  @JsonProperty("resetDate")
  private OffsetDateTime resetDate = null;

  public User activated(Boolean activated) {
    this.activated = activated;
    return this;
  }

  /**
   * Get activated
   * @return activated
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Boolean isActivated() {
    return activated;
  }

  public void setActivated(Boolean activated) {
    this.activated = activated;
  }

  public User email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
  **/
  @ApiModelProperty(value = "")

@Size(min=5,max=254) 
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public User firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * Get firstName
   * @return firstName
  **/
  @ApiModelProperty(value = "")

@Size(min=0,max=50) 
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public User id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public User imageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
    return this;
  }

  /**
   * Get imageUrl
   * @return imageUrl
  **/
  @ApiModelProperty(value = "")

@Size(min=0,max=256) 
  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public User langKey(String langKey) {
    this.langKey = langKey;
    return this;
  }

  /**
   * Get langKey
   * @return langKey
  **/
  @ApiModelProperty(value = "")

@Size(min=2,max=6) 
  public String getLangKey() {
    return langKey;
  }

  public void setLangKey(String langKey) {
    this.langKey = langKey;
  }

  public User lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * Get lastName
   * @return lastName
  **/
  @ApiModelProperty(value = "")

@Size(min=0,max=50) 
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public User login(String login) {
    this.login = login;
    return this;
  }

  /**
   * Get login
   * @return login
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

@Pattern(regexp="^[_.@A-Za-z0-9-]*$") @Size(min=1,max=50) 
  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public User resetDate(OffsetDateTime resetDate) {
    this.resetDate = resetDate;
    return this;
  }

  /**
   * Get resetDate
   * @return resetDate
  **/
  @ApiModelProperty(value = "")

  @Valid

  public OffsetDateTime getResetDate() {
    return resetDate;
  }

  public void setResetDate(OffsetDateTime resetDate) {
    this.resetDate = resetDate;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(this.activated, user.activated) &&
        Objects.equals(this.email, user.email) &&
        Objects.equals(this.firstName, user.firstName) &&
        Objects.equals(this.id, user.id) &&
        Objects.equals(this.imageUrl, user.imageUrl) &&
        Objects.equals(this.langKey, user.langKey) &&
        Objects.equals(this.lastName, user.lastName) &&
        Objects.equals(this.login, user.login) &&
        Objects.equals(this.resetDate, user.resetDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(activated, email, firstName, id, imageUrl, langKey, lastName, login, resetDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class User {\n");
    
    sb.append("    activated: ").append(toIndentedString(activated)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    imageUrl: ").append(toIndentedString(imageUrl)).append("\n");
    sb.append("    langKey: ").append(toIndentedString(langKey)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    login: ").append(toIndentedString(login)).append("\n");
    sb.append("    resetDate: ").append(toIndentedString(resetDate)).append("\n");
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

