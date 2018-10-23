package com.lxisoft.myjhipsterapp.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Publisher entity.
 */
public class PublisherDTO implements Serializable {

    private Long id;

    private String publisherName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PublisherDTO publisherDTO = (PublisherDTO) o;
        if (publisherDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), publisherDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "PublisherDTO{" +
            "id=" + getId() +
            ", publisherName='" + getPublisherName() + "'" +
            "}";
    }
}
