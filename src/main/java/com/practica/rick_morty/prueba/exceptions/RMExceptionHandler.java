package com.practica.rick_morty.prueba.exceptions;

import com.practica.rick_morty.prueba.beans.ExceptionRMApi;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.RestClientException;

@ControllerAdvice
@Component
public class RMExceptionHandler {

    @ExceptionHandler(RestClientException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionRMApi handleRestClientException(RestClientException ex) {

        ExceptionRMApi response = new ExceptionRMApi();

        // To avoid a possible NullPointerException
        if (ex.getMessage() != null) {
            response.setErrorDescription(ex.getMessage().replaceAll("\"", ""));
        }

        return response;
    }

    @ExceptionHandler(CharacterException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.CONFLICT)
    public ExceptionRMApi handleCharacterExceptionException(CharacterException ex) {

        ExceptionRMApi response = new ExceptionRMApi();
        response.setErrorDescription(ex.getMessage());

        return response;
    }
}
