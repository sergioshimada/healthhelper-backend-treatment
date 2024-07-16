package br.com.healthhelper.treatment.domain.usecase.impl;

import br.com.healthhelper.treatment.domain.entity.Treatment;
import br.com.healthhelper.treatment.domain.gateway.TreatmentGateway;
import br.com.healthhelper.treatment.domain.usecase.SaveTreatmentUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class SaveTreatmentUseCaseImpl implements SaveTreatmentUseCase {

    private TreatmentGateway treatmentGateway;

    @Override
    public Treatment execute(Treatment treatment) {

        treatment.setUuid(UUID.randomUUID());

        return treatmentGateway.save(treatment);
    }
}
