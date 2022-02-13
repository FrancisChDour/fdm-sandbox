package fdm.sandbox.controllers;

import fdm.sandbox.domain.ErrorMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Optional;

@ControllerAdvice
@Slf4j
public class ExceptionHandlerController {

    @ExceptionHandler(javax.validation.ValidationException.class)
    public ResponseEntity<?> handleException(javax.validation.ValidationException ex, WebRequest request) {
        ErrorMessage errorMessage = ErrorMessage.builder()
                .error("badRequest")
                .message(ex.getMessage())
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleExceptionTwo(MethodArgumentNotValidException ex, WebRequest request) {
        ErrorMessage errorMessage = ErrorMessage.builder()
                .error("badRequest")
                .message(Optional.ofNullable(ex.getFieldError())
                        .map(fieldError -> fieldError.getField() + " : " + fieldError.getDefaultMessage())
                        .orElse("Error when validating body"))
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }

}
