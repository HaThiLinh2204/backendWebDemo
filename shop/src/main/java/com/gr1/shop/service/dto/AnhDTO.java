package com.gr1.shop.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.gr1.shop.domain.Anh} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class AnhDTO implements Serializable {

    private String id;


    private String idSanpham;

    private String url;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    public String getIdSanpham() {
        return idSanpham;
    }

    public void setIdSanpham(String idSanpham) {
        this.idSanpham = idSanpham;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AnhDTO)) {
            return false;
        }

        AnhDTO anhDTO = (AnhDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, anhDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AnhDTO{" +
            "id=" + getId() +
            ", idSanpham='" + getIdSanpham() + "'" +
            ", url='" + getUrl() + "'" +
            ", idSanpham=" + getIdSanpham() +
            "}";
    }
}
