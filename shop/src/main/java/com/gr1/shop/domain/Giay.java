package com.gr1.shop.domain;







import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "giay")

@SuppressWarnings("common-java:DuplicatedBlocks")
public class Giay implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "ten_giay")
    private String tenGiay;

    @Column(name = "gia")
    private Long gia;

    @Column(name = "mo_ta")
    private String moTa;

    @Transient
    private boolean isPersisted;




    // jhipster-needle-entity-add-field - JHipster will add fields here

    public String getId() {
        return this.id;
    }

    public Giay id(String id) {
        this.setId(id);
        return this;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenGiay() {
        return this.tenGiay;
    }

    public Giay tenGiay(String tenGiay) {
        this.setTenGiay(tenGiay);
        return this;
    }

    public void setTenGiay(String tenGiay) {
        this.tenGiay = tenGiay;
    }

    public Long getGia() {
        return this.gia;
    }

    public Giay gia(Long gia) {
        this.setGia(gia);
        return this;
    }

    public void setGia(Long gia) {
        this.gia = gia;
    }

    public String getMoTa() {
        return this.moTa;
    }

    public Giay moTa(String moTa) {
        this.setMoTa(moTa);
        return this;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }




    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Giay)) {
            return false;
        }
        return id != null && id.equals(((Giay) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Giay{" +
                "id=" + getId() +
                ", tenGiay='" + getTenGiay() + "'" +
                ", gia=" + getGia() +
                ", moTa='" + getMoTa() + "'" +
                "}";
    }

}
