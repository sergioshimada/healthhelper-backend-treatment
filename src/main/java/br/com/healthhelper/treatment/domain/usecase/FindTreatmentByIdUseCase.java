package br.com.healthhelper.treatment.domain.usecase;

import br.com.healthhelper.treatment.domain.entity.Treatment;
import br.com.healthhelper.treatment.commons.exception.TreatmentNotExistsException;

import java.util.UUID;

public interface FindTreatmentByIdUseCase {
    Treatment execute(final UUID uuid) throws TreatmentNotExistsException;
}
