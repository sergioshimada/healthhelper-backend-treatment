package br.com.healthhelper.treatment.commons.exception;

public class TreatmentNotExistsException extends RuntimeException {

    public TreatmentNotExistsException() {
        super("treatment not found");
    }
}
