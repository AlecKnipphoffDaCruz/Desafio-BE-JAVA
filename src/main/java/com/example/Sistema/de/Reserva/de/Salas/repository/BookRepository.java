package com.example.Sistema.de.Reserva.de.Salas.repository;

import com.example.Sistema.de.Reserva.de.Salas.model.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public interface BookRepository extends JpaRepository<BookModel, Long> {

    List<BookModel> findAllBySalaId(Long id);


    @Query("SELECT b FROM BookModel b WHERE b.data = :data")
    List<BookModel> buscarPorData(@Param("data") LocalDate data);


}
