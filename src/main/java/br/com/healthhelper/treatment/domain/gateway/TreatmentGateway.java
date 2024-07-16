package br.com.healthhelper.treatment.domain.gateway;

import br.com.healthhelper.treatment.domain.entity.Treatment;
import br.com.healthhelper.treatment.commons.exception.TreatmentNotExistsException;

import java.util.List;
import java.util.UUID;

public interface TreatmentGateway {

    Treatment save(final Treatment treatment);
    Treatment findById(final UUID uuid) throws TreatmentNotExistsException;
    List<Treatment> findAll();
    void deleteTreatment(final Treatment treatment);
}
