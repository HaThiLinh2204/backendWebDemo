package com.gr1.fashionshop.service.dto;

import java.io.Serializable;
import java.util.Objects;

public class SizeGiayDTO  implements Serializable {
    private String id;

    private String idSanpham;

    private Long soLuong;

    private String mauSac;

    private String sizeName;


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
                ", idSanpham=" + getIdSanpham() +
                "}";
    }
}
