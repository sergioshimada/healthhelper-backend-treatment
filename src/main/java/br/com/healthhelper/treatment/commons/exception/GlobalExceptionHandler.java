package br.com.healthhelper.treatment.commons.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(TreatmentNotExistsException.class)
    ProblemDetail handleTreatmentNotExistsException(TreatmentNotExistsException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getLocalizedMessage());
        problemDetail.setTitle("UUID of treatment is null or invalid");
        problemDetail.setDetail("Treatment uuid valid is necessary to execute");
        problemDetail.setProperty("Category", "Platform");
        problemDetail.setProperty("TimeStamp", Instant.now());
        return problemDetail;
    }
}
