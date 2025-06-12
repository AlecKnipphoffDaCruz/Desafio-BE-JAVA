package com.example.Sistema.de.Reserva.de.Salas.repository;

import com.example.Sistema.de.Reserva.de.Salas.model.BookModel;
import com.example.Sistema.de.Reserva.de.Salas.model.RoomModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RoomRepository extends JpaRepository<RoomModel, Long> {

    void findAllById(Long id);
}
