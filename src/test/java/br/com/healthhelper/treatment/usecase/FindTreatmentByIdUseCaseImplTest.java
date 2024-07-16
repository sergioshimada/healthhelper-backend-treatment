package br.com.healthhelper.treatment.usecase;

import br.com.healthhelper.treatment.domain.entity.Treatment;
import br.com.healthhelper.treatment.commons.exception.TreatmentNotExistsException;
import br.com.healthhelper.treatment.domain.usecase.FindTreatmentByIdUseCase;
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

@ExtendWith(MockitoExtension.class)
public class FindTreatmentByIdUseCaseImplTest {

    @Mock
    private TreatmentGatewayImpl treatmentGateway;

    @InjectMocks
    private FindTreatmentByIdUseCaseImpl findTreatmentByIdUseCase;

    @Test
    public void execute() throws TreatmentNotExistsException {

        final UUID uuid = UUID.randomUUID();

        Mockito.when(this.treatmentGateway.findById(uuid)).thenReturn(new Treatment());

        Treatment treatment = this.findTreatmentByIdUseCase.execute(uuid);

        Assertions.assertNotNull(treatment, "is not null");
    }
}
