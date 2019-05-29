package com.lxisoft.library.client.library.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.lxisoft.library.client.library.model.Book;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Category
 */
@Validated
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-05-28T12:22:48.432+05:30[Asia/Kolkata]")

public class Category   {
  @JsonProperty("books")
  @Valid
  private List<Book> books = null;

  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("name")
  private String name = null;

  public Category books(List<Book> books) {
    this.books = books;
    return this;
  }

  public Category addBooksItem(Book booksItem) {
    if (this.books == null) {
      this.books = new ArrayList<Book>();
    }
    this.books.add(booksItem);
    return this;
  }

  /**
   * Get books
   * @return books
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<Book> getBooks() {
    return books;
  }

  public void setBooks(List<Book> books) {
    this.books = books;
  }

  public Category id(Long id) {
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

  public Category name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(value = "")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Category category = (Category) o;
    return Objects.equals(this.books, category.books) &&
        Objects.equals(this.id, category.id) &&
        Objects.equals(this.name, category.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(books, id, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Category {\n");
    
    sb.append("    books: ").append(toIndentedString(books)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

