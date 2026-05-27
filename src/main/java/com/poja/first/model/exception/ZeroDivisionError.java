package com.poja.first.model.exception;

public class ZeroDivisionError extends RuntimeException{
    public ZeroDivisionError() {
        super("Cannot Divide by Zero");
    }
}
