package com.example.Sistema.de.Reserva.de.Salas.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    @JoinColumn(name = "sala_id", nullable = false)
    RoomModel sala;
    @Column(name = "nome_pessoa")
    @NotNull
    @NotBlank
    String nomePessoa;
    @Column(name = "DATA")
    LocalDate data;
    @JsonFormat(pattern = "HH:mm:ss")
    @Column(name = "hora_inicio")
    @NotNull
    LocalTime horaInicio;
    @Column(name = "hora_fim")
    @NotNull
    @JsonFormat(pattern = "HH:mm:ss")
    LocalTime horaFim;


}
