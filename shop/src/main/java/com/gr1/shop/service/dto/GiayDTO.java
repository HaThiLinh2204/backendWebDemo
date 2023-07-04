package com.gr1.shop.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.gr1.shop.domain.Giay} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class GiayDTO implements Serializable {

    private String id;

    private String tenGiay;

    private Long gia;

    private String moTa;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenGiay() {
        return tenGiay;
    }

    public void setTenGiay(String tenGiay) {
        this.tenGiay = tenGiay;
    }

    public Long getGia() {
        return gia;
    }

    public void setGia(Long gia) {
        this.gia = gia;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GiayDTO)) {
            return false;
        }

        GiayDTO giayDTO = (GiayDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, giayDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "GiayDTO{" +
            "id='" + getId() + "'" +
            ", tenGiay='" + getTenGiay() + "'" +
            ", gia=" + getGia() +
            ", moTa='" + getMoTa() + "'" +
            "}";
    }
}
