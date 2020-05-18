
package com.cabinvoicegenrator.exception;

public class CabInvoiceServiceException extends RuntimeException {
    public enum ExceptionType {
        NEGATIVE_DISTANCE;
    }
    public ExceptionType type;
    public CabInvoiceServiceException(ExceptionType type,String message) {
        super((message));
        this.type=type;
        System.out.println(message);

    }
}

