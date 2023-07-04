package com.gr1.shop.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.gr1.shop.domain.SizeGiay} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class SizeGiayDTO implements Serializable {

    private String id;

    private String idSanpham;

    private Long soLuong;

    private String mauSac;

    private String sizeName;

    private String isDeleted;

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

    public Long getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Long soLuong) {
        this.soLuong = soLuong;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SizeGiayDTO)) {
            return false;
        }

        SizeGiayDTO sizeGiayDTO = (SizeGiayDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, sizeGiayDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SizeGiayDTO{" +
            "id='" + getId() + "'" +
            ", idSanpham='" + getIdSanpham() + "'" +
            ", soLuong=" + getSoLuong() +
            ", mauSac='" + getMauSac() + "'" +
            ", sizeName='" + getSizeName() + "'" +
            ", isDeleted='" + getIsDeleted() + "'" +
            ", idSanpham=" + getIdSanpham() +
            "}";
    }
}
