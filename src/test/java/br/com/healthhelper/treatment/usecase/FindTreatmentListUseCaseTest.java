package br.com.healthhelper.treatment.usecase;

import br.com.healthhelper.treatment.domain.entity.Treatment;
import br.com.healthhelper.treatment.domain.usecase.impl.FindTreatmentListUseCaseImpl;
import br.com.healthhelper.treatment.infra.gateway.TreatmentGatewayImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class FindTreatmentListUseCaseTest {

    @InjectMocks
    private FindTreatmentListUseCaseImpl findTreatmentListUseCase;

    @Mock
    private TreatmentGatewayImpl treatmentGateway;


    @Test
    public void executeTest() {

        Mockito.when(treatmentGateway.findAll()).thenReturn(new ArrayList<>());

        List<Treatment> treatments = findTreatmentListUseCase.execute();

        Assertions.assertNotNull(treatments);
    }
}
