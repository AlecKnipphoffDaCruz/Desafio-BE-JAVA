package com.example.Sistema.de.Reserva.de.Salas.controllers;

import com.example.Sistema.de.Reserva.de.Salas.dto.BookDto;
import com.example.Sistema.de.Reserva.de.Salas.model.BookModel;
import com.example.Sistema.de.Reserva.de.Salas.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<String> alugarSala(BookDto dto){
        bookService.alugarSala(dto);
        return ResponseEntity.ok("Alugado com sucesso a sala " + dto.sala().getNome() + "data: " + dto.data() + "as " + dto.horaInicio() + "até " + dto.horaFim() );
    }


    @GetMapping("/{dia}")
    public List<BookModel> mostrarReservasDiaX(@PathVariable LocalDate dia){
        List<BookModel> lista = bookService.acharRerva(dia);
        return lista;
    }
}
