package br.com.healthhelper.treatment.app.controller;

import br.com.healthhelper.treatment.app.dto.request.TreatmentRequest;
import br.com.healthhelper.treatment.app.dto.response.TreatmentResponse;
import br.com.healthhelper.treatment.app.mapper.TreatmentAppMapper;
import br.com.healthhelper.treatment.domain.entity.Treatment;
import br.com.healthhelper.treatment.commons.exception.TreatmentNotExistsException;
import br.com.healthhelper.treatment.domain.usecase.DeleteTreatmentUseCase;
import br.com.healthhelper.treatment.domain.usecase.FindTreatmentByIdUseCase;
import br.com.healthhelper.treatment.domain.usecase.FindTreatmentListUseCase;
import br.com.healthhelper.treatment.domain.usecase.SaveTreatmentUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/treatment")
@AllArgsConstructor
public class TreatmentController {

    private SaveTreatmentUseCase saveTreatmentUseCase;
    private FindTreatmentByIdUseCase findTreatmentByIdUseCase;
    private FindTreatmentListUseCase findTreatmentListUseCase;
    private DeleteTreatmentUseCase deleteTreatmentUseCase;
    private TreatmentAppMapper treatmentAppMapper;

    @PostMapping
    public @ResponseBody ResponseEntity<TreatmentResponse> save(@RequestBody final TreatmentRequest request) {
        Treatment treatment = this.saveTreatmentUseCase.execute(treatmentAppMapper.requestToDomain(request));
        return new ResponseEntity<>(treatmentAppMapper.domainToResponse(treatment), HttpStatus.CREATED);
    }

    @GetMapping
    public @ResponseBody ResponseEntity<List<TreatmentResponse>> findAll() {
        return new ResponseEntity<>(this.findTreatmentListUseCase.execute().stream().map(treatmentAppMapper::domainToResponse).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping(value = "/{uuid}")
    public @ResponseBody ResponseEntity<TreatmentResponse> findById(@PathVariable("uuid") final String uuid) throws TreatmentNotExistsException {
        Treatment treatment = findTreatmentByIdUseCase.execute(UUID.fromString(uuid));
        return new ResponseEntity<>(treatmentAppMapper.domainToResponse(treatment), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{uuid}")
    public @ResponseBody ResponseEntity<Void> delete(@PathVariable("uuid") final String uuid) throws TreatmentNotExistsException {
        deleteTreatmentUseCase.execute(UUID.fromString(uuid));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
