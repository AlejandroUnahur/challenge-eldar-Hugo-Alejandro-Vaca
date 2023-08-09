package com.eldar.challenge.service.imp;

import com.eldar.challenge.entity.TasaOperacion;
import com.eldar.challenge.exception.TasaOperacionNotFoundException;
import com.eldar.challenge.repository.TasaOperacionRepository;
import com.eldar.challenge.service.TasaOperacionService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TasaOperacionServiceImp implements TasaOperacionService {
    @Autowired
    private final TasaOperacionRepository tasaOperacionRepository;
    @Autowired
    public TasaOperacionServiceImp(TasaOperacionRepository tasaOperacionRepository) {
        this.tasaOperacionRepository = tasaOperacionRepository;
    }
    @Override
    public TasaOperacion createTasaOperacion(TasaOperacion tasaOperacion) {
        return tasaOperacionRepository.save(tasaOperacion);
    }
    @Override
    public List<TasaOperacion> getAllTasaOperacion() {
        return tasaOperacionRepository.findAll();
    }
    @Override
    public Optional<TasaOperacion> getTasaOperacionById(UUID id) {
        Optional<TasaOperacion> tasaOperacionOptional = tasaOperacionRepository.findById(id);
        if (tasaOperacionOptional.isPresent()) {
            return tasaOperacionOptional;
        } else {
            throw new EntityNotFoundException("Tasa not found");
        }

    }
    @Override
    public TasaOperacion updateTasaOperacion(UUID id, TasaOperacion tasaOperacion) {
        Optional<TasaOperacion> tasaOperacionOptional = tasaOperacionRepository.findById(id);
        if (tasaOperacionOptional.isPresent()) {
            TasaOperacion existingTasaOperacion = tasaOperacionOptional.get();
            existingTasaOperacion.setMarca(tasaOperacion.getMarca());
            existingTasaOperacion.setImporte(tasaOperacion.getImporte());
            return tasaOperacionRepository.save(existingTasaOperacion);
        } else {
           throw new TasaOperacionNotFoundException("Tasa not found");
        }
    }
    @Override
    public void deleteTasaOperacion(UUID id) {
        Optional<TasaOperacion> tasaOperacion = tasaOperacionRepository.findById(id);
        if(tasaOperacion.isPresent()) {
            tasaOperacionRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Tasa not found");
        }
    }
}
