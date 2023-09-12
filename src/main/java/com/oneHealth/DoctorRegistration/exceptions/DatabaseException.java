package com.oneHealth.DoctorRegistration.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Custom exception class for database-related errors.
 * This exception is used to represent database-related exceptions and is annotated with
 * @ResponseStatus to indicate an HTTP status of UNPROCESSABLE_ENTITY when thrown.
 * 
 * @author Anup
 * @version 1.0
 */
@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
public class DatabaseException extends Exception {
    private static final long serialVersionUID = 1L;
    
    /**
     * Constructor to create a DatabaseException with a custom error message.
     *
     * @param message The custom error message to be associated with the exception.
     */
    public DatabaseException(String message) {
        super(message);
    }
}
