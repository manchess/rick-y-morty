package com.practica.rick_morty.prueba.exceptions;

public class CharacterExistException extends RuntimeException {

    public CharacterExistException(String msg) {
        super(msg);
    }
}
