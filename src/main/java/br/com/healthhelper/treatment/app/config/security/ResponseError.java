package br.com.healthhelper.treatment.app.config.security;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ResponseError {

    private String message;
}