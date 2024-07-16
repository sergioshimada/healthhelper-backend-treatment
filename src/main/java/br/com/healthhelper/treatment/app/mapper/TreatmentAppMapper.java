package br.com.healthhelper.treatment.app.mapper;

import br.com.healthhelper.treatment.app.dto.request.TreatmentRequest;
import br.com.healthhelper.treatment.app.dto.response.TreatmentResponse;
import br.com.healthhelper.treatment.domain.entity.Treatment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TreatmentAppMapper {


    Treatment requestToDomain(TreatmentRequest request);

    TreatmentResponse domainToResponse(Treatment treatment);
}
