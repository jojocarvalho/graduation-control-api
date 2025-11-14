package com.jonatas.graduation_control_api.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class RestExceptionHandler {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
        );

        return errors;
    }




    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public Map<String, String> handleDataIntegrity(DataIntegrityViolationException ex) {

        Throwable rootCause = ex.getMostSpecificCause();
        String rootMessage = rootCause.getMessage();

        String userMessage;

        if (rootMessage != null && rootMessage.contains("clients_cpf_key")) {
            userMessage = "O CPF informado já está cadastrado.";
        } else {
            userMessage = "Erro de integridade dos dados: um registro com informações únicas já existe.";
        }

        Map<String, String> error = new HashMap<>();
        error.put("status", "error");
        error.put("message", userMessage);

        return error;
    }
}
