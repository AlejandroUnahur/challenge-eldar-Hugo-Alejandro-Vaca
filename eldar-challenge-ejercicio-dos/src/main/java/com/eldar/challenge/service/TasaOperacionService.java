package com.eldar.challenge.service;

import com.eldar.challenge.entity.TasaOperacion;
import com.eldar.challenge.exception.TasaOperacionNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TasaOperacionService {

    TasaOperacion createTasaOperacion(TasaOperacion tasaOperacion);

    List<TasaOperacion> getAllTasaOperacion();

    Optional<TasaOperacion> getTasaOperacionById(UUID id) throws TasaOperacionNotFoundException;

    TasaOperacion updateTasaOperacion(UUID id, TasaOperacion tasaOperacion);

    void deleteTasaOperacion(UUID id);
}
