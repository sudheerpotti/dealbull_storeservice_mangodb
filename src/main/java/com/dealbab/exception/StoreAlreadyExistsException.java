package com.dealbab.exception;

public class StoreAlreadyExistsException extends RuntimeException {
	public StoreAlreadyExistsException(Integer integer) {
        super("Store already exists for ID: '" + integer + "'");
    }
}