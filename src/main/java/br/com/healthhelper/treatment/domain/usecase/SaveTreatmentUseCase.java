package br.com.healthhelper.treatment.domain.usecase;

import br.com.healthhelper.treatment.domain.entity.Treatment;

public interface SaveTreatmentUseCase {

    Treatment execute(Treatment treatment);
}
