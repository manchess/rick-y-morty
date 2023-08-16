package com.practica.rick_morty.prueba.beans;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class Info {
    private int count;
    private int pages;
    private String next;
    private String prev;
}
