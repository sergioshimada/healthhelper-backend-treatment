package br.com.healthhelper.treatment.app.dto.request;

import br.com.healthhelper.treatment.commons.enumerator.TreatmentTypeEnum;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class TreatmentRequest {

    private Long id;
    private UUID uuid;
    private String name;
    private String description;
    private BigDecimal value;
    private TreatmentTypeEnum type;
}
