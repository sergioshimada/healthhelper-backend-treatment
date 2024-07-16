package br.com.healthhelper.treatment.domain.usecase;

import br.com.healthhelper.treatment.commons.exception.TreatmentNotExistsException;

import java.util.UUID;

public interface DeleteTreatmentUseCase {
    void execute(final UUID uuid) throws TreatmentNotExistsException;
}
