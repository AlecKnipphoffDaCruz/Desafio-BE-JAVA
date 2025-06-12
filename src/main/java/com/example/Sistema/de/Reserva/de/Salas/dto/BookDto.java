package com.example.Sistema.de.Reserva.de.Salas.dto;

import com.example.Sistema.de.Reserva.de.Salas.model.RoomModel;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public record BookDto(Long id, RoomModel sala, String nomePessoa, LocalDate data, LocalTime horaInicio, LocalTime horaFim) {
}
