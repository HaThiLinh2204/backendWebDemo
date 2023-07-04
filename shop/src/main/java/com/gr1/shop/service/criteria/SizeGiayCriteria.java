package com.gr1.shop.service.criteria;

import java.io.Serializable;
import java.util.Objects;
import org.springdoc.api.annotations.ParameterObject;
import io.github.jhipster.service.Criteria;
import io.github.jhipster.service.filter.*;

/**
 * Criteria class for the {@link com.gr1.shop.domain.SizeGiay} entity. This class is used
 * in {@link com.gr1.shop.controller.SizeGiayResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /size-giays?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class SizeGiayCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private StringFilter id;

    private StringFilter idSanpham;

    private LongFilter soLuong;

    private StringFilter mauSac;

    private StringFilter sizeName;

    private StringFilter isDeleted;



    public SizeGiayCriteria() {}

    public SizeGiayCriteria(SizeGiayCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.idSanpham = other.idSanpham == null ? null : other.idSanpham.copy();
        this.soLuong = other.soLuong == null ? null : other.soLuong.copy();
        this.mauSac = other.mauSac == null ? null : other.mauSac.copy();
        this.sizeName = other.sizeName == null ? null : other.sizeName.copy();
        this.isDeleted = other.isDeleted == null ? null : other.isDeleted.copy();

    }

    @Override
    public SizeGiayCriteria copy() {
        return new SizeGiayCriteria(this);
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

    public StringFilter getIdSanpham() {
        return idSanpham;
    }

    public StringFilter idSanpham() {
        if (idSanpham == null) {
            idSanpham = new StringFilter();
        }
        return idSanpham;
    }

    public void setIdSanpham(StringFilter idSanpham) {
        this.idSanpham = idSanpham;
    }

    public LongFilter getSoLuong() {
        return soLuong;
    }

    public LongFilter soLuong() {
        if (soLuong == null) {
            soLuong = new LongFilter();
        }
        return soLuong;
    }

    public void setSoLuong(LongFilter soLuong) {
        this.soLuong = soLuong;
    }

    public StringFilter getMauSac() {
        return mauSac;
    }

    public StringFilter mauSac() {
        if (mauSac == null) {
            mauSac = new StringFilter();
        }
        return mauSac;
    }

    public void setMauSac(StringFilter mauSac) {
        this.mauSac = mauSac;
    }

    public StringFilter getSizeName() {
        return sizeName;
    }

    public StringFilter sizeName() {
        if (sizeName == null) {
            sizeName = new StringFilter();
        }
        return sizeName;
    }

    public void setSizeName(StringFilter sizeName) {
        this.sizeName = sizeName;
    }

    public StringFilter getIsDeleted() {
        return isDeleted;
    }

    public StringFilter isDeleted() {
        if (isDeleted == null) {
            isDeleted = new StringFilter();
        }
        return isDeleted;
    }

    public void setIsDeleted(StringFilter isDeleted) {
        this.isDeleted = isDeleted;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final SizeGiayCriteria that = (SizeGiayCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(idSanpham, that.idSanpham) &&
            Objects.equals(soLuong, that.soLuong) &&
            Objects.equals(mauSac, that.mauSac) &&
            Objects.equals(sizeName, that.sizeName) &&
            Objects.equals(isDeleted, that.isDeleted)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idSanpham, soLuong, mauSac, sizeName, isDeleted);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SizeGiayCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (idSanpham != null ? "idSanpham=" + idSanpham + ", " : "") +
            (soLuong != null ? "soLuong=" + soLuong + ", " : "") +
            (mauSac != null ? "mauSac=" + mauSac + ", " : "") +
            (sizeName != null ? "sizeName=" + sizeName + ", " : "") +
            (isDeleted != null ? "isDeleted=" + isDeleted + ", " : "") +
            "}";
    }
}
