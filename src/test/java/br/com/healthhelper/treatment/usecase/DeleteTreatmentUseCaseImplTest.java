package br.com.healthhelper.treatment.usecase;

import br.com.healthhelper.treatment.domain.entity.Treatment;
import br.com.healthhelper.treatment.domain.usecase.impl.DeleteTreatmentUseCaseImpl;
import br.com.healthhelper.treatment.domain.usecase.impl.FindTreatmentByIdUseCaseImpl;
import br.com.healthhelper.treatment.infra.gateway.TreatmentGatewayImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.mockito.Mockito.doNothing;

@ExtendWith(MockitoExtension.class)
public class DeleteTreatmentUseCaseImplTest {

    @InjectMocks
    private DeleteTreatmentUseCaseImpl deleteTreatmentUseCase;
    @Mock
    private FindTreatmentByIdUseCaseImpl findTreatmentByIdUseCase;
    @Mock
    private TreatmentGatewayImpl treatmentGateway;

    @Test
    public void execute() {

        UUID uuid = UUID.randomUUID();

        Treatment treatment = new Treatment();
        treatment.setUuid(uuid);

        Mockito.when(findTreatmentByIdUseCase.execute(uuid)).thenReturn(treatment);
        doNothing().when(treatmentGateway).deleteTreatment(treatment);

        Assertions.assertDoesNotThrow(()-> deleteTreatmentUseCase.execute(uuid));
    }
}
