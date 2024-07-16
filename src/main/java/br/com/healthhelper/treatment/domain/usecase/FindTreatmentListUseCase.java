package br.com.healthhelper.treatment.domain.usecase;

import br.com.healthhelper.treatment.domain.entity.Treatment;

import java.util.List;

public interface FindTreatmentListUseCase {
    List<Treatment> execute();
}
