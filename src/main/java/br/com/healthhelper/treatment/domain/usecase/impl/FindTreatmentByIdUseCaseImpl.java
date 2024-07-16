package br.com.healthhelper.treatment.domain.usecase.impl;

import br.com.healthhelper.treatment.domain.entity.Treatment;
import br.com.healthhelper.treatment.commons.exception.TreatmentNotExistsException;
import br.com.healthhelper.treatment.domain.gateway.TreatmentGateway;
import br.com.healthhelper.treatment.domain.usecase.FindTreatmentByIdUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class FindTreatmentByIdUseCaseImpl implements FindTreatmentByIdUseCase {

    private TreatmentGateway treatmentGateway;

    @Override
    public Treatment execute(UUID uuid) throws TreatmentNotExistsException {

        return this.treatmentGateway.findById(uuid);
    }
}
