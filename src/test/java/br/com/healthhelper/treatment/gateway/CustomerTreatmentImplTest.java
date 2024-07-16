package br.com.healthhelper.treatment.gateway;

import br.com.healthhelper.treatment.domain.entity.Treatment;
import br.com.healthhelper.treatment.commons.exception.TreatmentNotExistsException;
import br.com.healthhelper.treatment.infra.dataprovider.db.model.TreatmentModel;
import br.com.healthhelper.treatment.infra.dataprovider.db.repository.TreatmentRepository;
import br.com.healthhelper.treatment.infra.gateway.TreatmentGatewayImpl;
import br.com.healthhelper.treatment.infra.mapper.TreatmentInfraMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;

@ExtendWith(MockitoExtension.class)
public class CustomerTreatmentImplTest {

    @InjectMocks
    private TreatmentGatewayImpl customerGateway;
    @Mock
    private TreatmentRepository repository;
    @Mock
    private TreatmentInfraMapper mapper;

    @Test
    public void saveTest() {

        Treatment treatment = new Treatment();
        TreatmentModel treatmentModel = new TreatmentModel();

        Mockito.when(mapper.domainToModel(treatment)).thenReturn(treatmentModel);
        Mockito.when(repository.save(treatmentModel)).thenReturn(treatmentModel);
        Mockito.when(mapper.modelToDomain(treatmentModel)).thenReturn(treatment);

        Treatment eTreatment = customerGateway.save(treatment);

        assertNotNull(eTreatment, "is not null");
    }

    @Test
    public void findByIdTest() throws TreatmentNotExistsException {
        UUID uuid = UUID.randomUUID();

        TreatmentModel TreatmentModel = new TreatmentModel();

        Mockito.when(repository.findByUuid(uuid)).thenReturn(Optional.of(TreatmentModel));
        Mockito.when(mapper.modelToDomain(TreatmentModel)).thenReturn(new Treatment());

        Treatment eTreatment = customerGateway.findById(uuid);

        assertNotNull(eTreatment, "is not null");
    }

    @Test
    public void findByIdCustomerNotExistsExceptionTest()  {
        UUID uuid = UUID.randomUUID();

        Mockito.when(repository.findByUuid(uuid)).thenReturn(Optional.empty());

        Assertions.assertThrows(TreatmentNotExistsException.class, ()-> customerGateway.findById(uuid), "is not null");

    }

    @Test
    public void findAllTest() {

        Mockito.when(repository.findAll()).thenReturn(List.of(new TreatmentModel()));
        Mockito.when(mapper.modelToDomain(new TreatmentModel())).thenReturn(new Treatment());

        List<Treatment> eTreatment = customerGateway.findAll();

        assertNotNull(eTreatment, "is not null");
    }

    @Test
    public void deleteCustomerTest() {

        Treatment treatment = new Treatment();
        TreatmentModel TreatmentModel = new TreatmentModel();

        Mockito.when(mapper.domainToModel(treatment)).thenReturn(TreatmentModel);
        doNothing().when(repository).delete(TreatmentModel);

        Assertions.assertDoesNotThrow(()-> customerGateway.deleteTreatment(treatment));
    }
}
