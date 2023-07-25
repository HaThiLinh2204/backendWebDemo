package com.gr1.fashionshop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException  {
    private static final long serialVersionUID = 1L;

    private String id;
    private String errorCode;
    private String resourceName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    @Deprecated
    public ResourceNotFoundException(String message) {
        super(message);
    }

    public static ResourceNotFoundException fromResource(String resourceName, String id) {
        return new ResourceNotFoundException("error.resourceNotFound")
                .resourceName(resourceName)
                .id(id)
                .errorCode("error.resourceNotFound");
    }

//    @Override
//    public List<BusinessError> toErrors() {
//        return Collections.singletonList(BusinessError.builder()
//                .errorCode(errorCode)
//                .params(Arrays.asList(resourceName, id))
//                .build());
//    }

    public ResourceNotFoundException id(String id) {
        this.id = id;
        return this;
    }

    public ResourceNotFoundException errorCode(String errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    public ResourceNotFoundException resourceName(String resourceName) {
        this.resourceName = resourceName;
        return this;
    }
}
