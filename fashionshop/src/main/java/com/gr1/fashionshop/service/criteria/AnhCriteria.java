package com.gr1.fashionshop.service.criteria;

import java.io.Serializable;
import java.util.Objects;
import org.springdoc.api.annotations.ParameterObject;
import io.github.jhipster.service.Criteria;
import io.github.jhipster.service.filter.*;

/**
 * Criteria class for the {@link com.gr1.fashionshop.domain.Anh} entity. This class is used
 * in {@link com.gr1.fashionshop.controller.AnhResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /anhs?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class AnhCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private StringFilter id;


    private StringFilter idSanpham;

    private StringFilter url;



    public AnhCriteria() {}

    public AnhCriteria(AnhCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.idSanpham = other.idSanpham == null ? null : other.idSanpham.copy();
        this.url = other.url == null ? null : other.url.copy();
    }

    @Override
    public AnhCriteria copy() {
        return new AnhCriteria(this);
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

    public StringFilter getUrl() {
        return url;
    }

    public StringFilter url() {
        if (url == null) {
            url = new StringFilter();
        }
        return url;
    }

    public void setUrl(StringFilter url) {
        this.url = url;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final AnhCriteria that = (AnhCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(idSanpham, that.idSanpham) &&
            Objects.equals(url, that.url)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idSanpham, url);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AnhCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (idSanpham != null ? "idSanpham=" + idSanpham + ", " : "") +
            (url != null ? "url=" + url + ", " : "") +
            "}";
    }
}
