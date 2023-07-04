package com.gr1.shop.service.criteria;

import java.io.Serializable;
import java.util.Objects;
import org.springdoc.api.annotations.ParameterObject;
import io.github.jhipster.service.Criteria;
import io.github.jhipster.service.filter.*;

/**
 * Criteria class for the {@link com.gr1.shop.domain.Giay} entity. This class is used
 * in {@link com.gr1.shop.controller.GiayResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /giays?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class GiayCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private StringFilter id;

    private StringFilter tenGiay;

    private LongFilter gia;

    private StringFilter moTa;



    public GiayCriteria() {}

    public GiayCriteria(GiayCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.tenGiay = other.tenGiay == null ? null : other.tenGiay.copy();
        this.gia = other.gia == null ? null : other.gia.copy();
        this.moTa = other.moTa == null ? null : other.moTa.copy();

    }

    @Override
    public GiayCriteria copy() {
        return new GiayCriteria(this);
    }

    public StringFilter getId() {
        return id;
    }

    public StringFilter id() {
        if (id == null) {
            id = new StringFilter();
        }
        return id;
    }

    public void setId(StringFilter id) {
        this.id = id;
    }

    public StringFilter getTenGiay() {
        return tenGiay;
    }

    public StringFilter tenGiay() {
        if (tenGiay == null) {
            tenGiay = new StringFilter();
        }
        return tenGiay;
    }

    public void setTenGiay(StringFilter tenGiay) {
        this.tenGiay = tenGiay;
    }

    public LongFilter getGia() {
        return gia;
    }

    public LongFilter gia() {
        if (gia == null) {
            gia = new LongFilter();
        }
        return gia;
    }

    public void setGia(LongFilter gia) {
        this.gia = gia;
    }

    public StringFilter getMoTa() {
        return moTa;
    }

    public StringFilter moTa() {
        if (moTa == null) {
            moTa = new StringFilter();
        }
        return moTa;
    }

    public void setMoTa(StringFilter moTa) {
        this.moTa = moTa;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final GiayCriteria that = (GiayCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(tenGiay, that.tenGiay) &&
            Objects.equals(gia, that.gia) &&
            Objects.equals(moTa, that.moTa)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tenGiay, gia, moTa);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "GiayCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (tenGiay != null ? "tenGiay=" + tenGiay + ", " : "") +
            (gia != null ? "gia=" + gia + ", " : "") +
            (moTa != null ? "moTa=" + moTa + ", " : "") +
            "}";
    }
}
