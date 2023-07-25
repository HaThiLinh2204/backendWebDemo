package com.gr1.fashionshop.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "image_giay")
public class Anh implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_anh")
    private String id;

    @Column(name = "id_sanpham")
    private String idSanpham;

    @Column(name = "url")
    private String url;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public String getId() {
        return this.id;
    }

    public Anh id(String id) {
        this.setId(id);
        return this;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getIdSanpham() {
        return this.idSanpham;
    }

    public Anh idSanpham(String idSanpham) {
        this.setIdSanpham(idSanpham);
        return this;
    }

    public void setIdSanpham(String idSanpham) {
        this.idSanpham = idSanpham;
    }

    public String getUrl() {
        return this.url;
    }

    public Anh url(String url) {
        this.setUrl(url);
        return this;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Anh)) {
            return false;
        }
        return id != null && id.equals(((Anh) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Anh{" +
                "id=" + getId() +
                ", idSanpham='" + getIdSanpham() + "'" +
                ", url='" + getUrl() + "'" +
                "}";
    }
}
