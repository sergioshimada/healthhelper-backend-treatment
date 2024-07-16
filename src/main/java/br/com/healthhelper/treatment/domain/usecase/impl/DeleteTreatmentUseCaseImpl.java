package br.com.healthhelper.treatment.domain.usecase.impl;

import br.com.healthhelper.treatment.commons.exception.TreatmentNotExistsException;
import br.com.healthhelper.treatment.domain.gateway.TreatmentGateway;
import br.com.healthhelper.treatment.domain.usecase.DeleteTreatmentUseCase;
import br.com.healthhelper.treatment.domain.usecase.FindTreatmentByIdUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class DeleteTreatmentUseCaseImpl implements DeleteTreatmentUseCase {

    private FindTreatmentByIdUseCase findTreatmentByIdUseCase;
    private TreatmentGateway treatmentGateway;

    @Override
    public void execute(UUID uuid) throws TreatmentNotExistsException {

        treatmentGateway.deleteTreatment(findTreatmentByIdUseCase.execute(uuid));
    }
}
