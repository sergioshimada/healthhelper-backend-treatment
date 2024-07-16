package br.com.healthhelper.treatment.infra.mapper;

import br.com.healthhelper.treatment.domain.entity.Treatment;
import br.com.healthhelper.treatment.infra.dataprovider.db.model.TreatmentModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TreatmentInfraMapper {

    Treatment modelToDomain(TreatmentModel treatmentModel);
    TreatmentModel domainToModel(Treatment treatment);
}
