package com.eldar.challenge.repository;

import com.eldar.challenge.entity.TasaOperacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TasaOperacionRepository extends JpaRepository<TasaOperacion, UUID> {
}
