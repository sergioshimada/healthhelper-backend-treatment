package br.com.healthhelper.treatment.usecase;

import br.com.healthhelper.treatment.domain.entity.Treatment;
import br.com.healthhelper.treatment.domain.usecase.impl.SaveTreatmentUseCaseImpl;
import br.com.healthhelper.treatment.infra.gateway.TreatmentGatewayImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class SaveTreatmentUseCaseImplTest {

    @InjectMocks
    private SaveTreatmentUseCaseImpl saveTreatmentUseCase;

    @Mock
    private TreatmentGatewayImpl treatmentGateway;

    @Test
    public void execute() {

        Treatment treatment = new Treatment();

        treatment.setUuid(UUID.randomUUID());

        Mockito.when(treatmentGateway.save(treatment)).thenReturn(new Treatment());

        Treatment eTreatment = saveTreatmentUseCase.execute(treatment);

        assertNotNull(eTreatment, "is not null");
    }
}
