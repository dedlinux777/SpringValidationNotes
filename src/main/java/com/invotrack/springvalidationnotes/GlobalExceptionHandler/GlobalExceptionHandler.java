package com.invotrack.springvalidationnotes.GlobalExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiErrorResponse> handleValidationException(
            MethodArgumentNotValidException ex, HttpServletRequest request) {

        ApiErrorResponse response = new ApiErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                "Validation Failed",
                "The input provided is invalid.",
                request.getRequestURI()
        );

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage()));

        response.setValidationErrors(errors);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    //exception.getBindingResult():
    //When validation (via @Valid or @Validated) fails on a request body, Spring throws a MethodArgumentNotValidException. This method call retrieves the BindingResult object, which acts as a container for all errors discovered during the validation process.
    //.getFieldErrors():
    //This extracts a list of FieldError objects from the result. Each FieldError represents a specific field (like "email" or "password") that failed a validation constraint (like @NotBlank or @Size).
    //.forEach(error -> ...):
    //This iterates through every validation error found in the request.
    //errors.put(error.getField(), error.getDefaultMessage()):
    //For each error, it stores the failing field name (the key) and the error message (the value) into a Map (usually a HashMap<String, String>).
    //Example Output: If an email is invalid, the map might contain: {"email": "must be a well-formed email address"}
}
