package com.gr1.shop.domain;




import javax.persistence.*;
import java.io.Serializable;



@Entity
@Table(name = "size_giay")

@SuppressWarnings("common-java:DuplicatedBlocks")
public class SizeGiay implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "id_sanpham")
    private String idSanpham;

    @Column(name = "so_luong")
    private Long soLuong;

    @Column(name = "mau_sac")
    private String mauSac;

    @Column(name = "size_name")
    private String sizeName;

    @Column(name = "is_deleted")
    private String isDeleted;

    @Transient
    private boolean isPersisted;


    // jhipster-needle-entity-add-field - JHipster will add fields here

    public String getId() {
        return this.id;
    }

    public SizeGiay id(String id) {
        this.setId(id);
        return this;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdSanpham() {
        return this.idSanpham;
    }

    public SizeGiay idSanpham(String idSanpham) {
        this.setIdSanpham(idSanpham);
        return this;
    }

    public void setIdSanpham(String idSanpham) {
        this.idSanpham = idSanpham;
    }

    public Long getSoLuong() {
        return this.soLuong;
    }

    public SizeGiay soLuong(Long soLuong) {
        this.setSoLuong(soLuong);
        return this;
    }

    public void setSoLuong(Long soLuong) {
        this.soLuong = soLuong;
    }

    public String getMauSac() {
        return this.mauSac;
    }

    public SizeGiay mauSac(String mauSac) {
        this.setMauSac(mauSac);
        return this;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public String getSizeName() {
        return this.sizeName;
    }

    public SizeGiay sizeName(String sizeName) {
        this.setSizeName(sizeName);
        return this;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }

    public String getIsDeleted() {
        return this.isDeleted;
    }

    public SizeGiay isDeleted(String isDeleted) {
        this.setIsDeleted(isDeleted);
        return this;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }







    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SizeGiay)) {
            return false;
        }
        return id != null && id.equals(((SizeGiay) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SizeGiay{" +
                "id=" + getId() +
                ", idSanpham='" + getIdSanpham() + "'" +
                ", soLuong=" + getSoLuong() +
                ", mauSac='" + getMauSac() + "'" +
                ", sizeName='" + getSizeName() + "'" +
                ", isDeleted='" + getIsDeleted() + "'" +
                "}";
    }



}
