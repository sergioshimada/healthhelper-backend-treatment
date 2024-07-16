package br.com.healthhelper.treatment.infra.dataprovider.db.repository;

import br.com.healthhelper.treatment.infra.dataprovider.db.model.TreatmentModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface TreatmentRepository extends JpaRepository<TreatmentModel, Long>  {

    Optional<TreatmentModel> findByUuid(UUID uuid);
}
