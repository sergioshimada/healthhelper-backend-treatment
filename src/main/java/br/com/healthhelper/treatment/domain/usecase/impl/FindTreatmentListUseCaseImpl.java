package br.com.healthhelper.treatment.domain.usecase.impl;

import br.com.healthhelper.treatment.domain.entity.Treatment;
import br.com.healthhelper.treatment.domain.gateway.TreatmentGateway;
import br.com.healthhelper.treatment.domain.usecase.FindTreatmentListUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FindTreatmentListUseCaseImpl implements FindTreatmentListUseCase {

    private TreatmentGateway treatmentGateway;

    @Override
    public List<Treatment> execute() {
        return treatmentGateway.findAll();
    }
}
