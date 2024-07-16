package br.com.healthhelper.treatment.infra.gateway;

import br.com.healthhelper.treatment.domain.entity.Treatment;
import br.com.healthhelper.treatment.commons.exception.TreatmentNotExistsException;
import br.com.healthhelper.treatment.domain.gateway.TreatmentGateway;
import br.com.healthhelper.treatment.infra.dataprovider.db.model.TreatmentModel;
import br.com.healthhelper.treatment.infra.dataprovider.db.repository.TreatmentRepository;
import br.com.healthhelper.treatment.infra.mapper.TreatmentInfraMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class TreatmentGatewayImpl implements TreatmentGateway {

    private TreatmentRepository repository;
    private TreatmentInfraMapper treatmentInfraMapper;

    @Override
    public Treatment save(Treatment customer) {

        TreatmentModel model = repository.save(treatmentInfraMapper.domainToModel(customer));

        return treatmentInfraMapper.modelToDomain(model);
    }

    @Override
    public Treatment findById(UUID uuid) throws TreatmentNotExistsException {

        Optional<TreatmentModel> model = repository.findByUuid(uuid);

        if (model.isEmpty()) {
            log.error("Customer not exists uuid:{}", uuid);
            throw new TreatmentNotExistsException();
        }

        return treatmentInfraMapper.modelToDomain(model.get());
    }

    @Override
    public List<Treatment> findAll() {
        return repository.findAll().stream().map(treatmentInfraMapper::modelToDomain).collect(Collectors.toList());
    }

    @Override
    public void deleteTreatment(Treatment customer) {
        repository.delete(treatmentInfraMapper.domainToModel(customer));
    }
}
