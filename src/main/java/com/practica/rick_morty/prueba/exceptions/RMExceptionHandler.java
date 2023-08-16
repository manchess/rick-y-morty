package com.practica.rick_morty.prueba.exceptions;

import com.practica.rick_morty.prueba.beans.CharacterInfo;
import com.practica.rick_morty.prueba.beans.ExceptionRMApi;
import com.practica.rick_morty.prueba.beans.Info;
import com.practica.rick_morty.prueba.beans.RMApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.RestClientException;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
@Component
public class RMExceptionHandler {

    @ExceptionHandler(RestClientException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionRMApi handleRestClientException(RestClientException ex) {

        ExceptionRMApi response = new ExceptionRMApi();
        response.setErrorDescription(ex.getMessage().replaceAll("\"", ""));

        return response;
    }

    @ExceptionHandler(CharacterExistException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.CONFLICT)
    public ExceptionRMApi handleCharacterExistExceptionException(CharacterExistException ex) {

        ExceptionRMApi response = new ExceptionRMApi();
        response.setErrorDescription(ex.getMessage());

        return response;
    }
}
