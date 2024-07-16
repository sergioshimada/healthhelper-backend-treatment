package br.com.healthhelper.treatment.commons.enumerator;

public enum TreatmentTypeEnum {

    BODY("body"), FACIAL("facial");

    public final String type;

    TreatmentTypeEnum(String body) {
        this.type = body;
    }
}
