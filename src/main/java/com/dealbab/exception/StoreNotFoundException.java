package com.dealbab.exception;

public class StoreNotFoundException extends RuntimeException {

    private Integer errorMessage;

    public StoreNotFoundException(Integer id){
        this.errorMessage = id;
    }

    public Integer getErrorMessage() {
        return errorMessage;
    }

}