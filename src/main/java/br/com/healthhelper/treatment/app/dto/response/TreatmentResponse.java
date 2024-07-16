package br.com.healthhelper.treatment.app.dto.response;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class TreatmentResponse {

    private Long id;
    private UUID uuid;
    private String name;
    private String description;
    private BigDecimal value;
}
