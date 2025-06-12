package com.example.Sistema.de.Reserva.de.Salas.controllers;

import com.example.Sistema.de.Reserva.de.Salas.dto.RoomDto;
import com.example.Sistema.de.Reserva.de.Salas.model.BookModel;
import com.example.Sistema.de.Reserva.de.Salas.model.RoomModel;
import com.example.Sistema.de.Reserva.de.Salas.repository.RoomRepository;
import com.example.Sistema.de.Reserva.de.Salas.service.BookService;
import com.example.Sistema.de.Reserva.de.Salas.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.ConditionalOnOAuth2ClientRegistrationProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @Autowired
    private BookService bookService;


    @PostMapping
    public ResponseEntity<String> criarSala(@RequestBody RoomDto dto){
        roomService.criarSala(dto);
        return ResponseEntity.ok("Criado com sucesso!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarSala(@PathVariable Long id ,@RequestBody RoomDto dto){
        roomService.atualizarSala(dto, id);
        return ResponseEntity.ok("Atualizado com sucesso");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarSala(@PathVariable Long id){
        roomService.deletarSala(id);
        return ResponseEntity.ok("Deletado com sucesso!");
    }

    @PostMapping("/salasLivres")
    public List<RoomModel> salasLivresDiaX(@RequestBody Map<String, String> json){
        LocalDate dia = LocalDate.parse(json.get("dia")); // esperando formato yyyy-MM-dd
        List<BookModel> lista = bookService.acharRerva(dia);
        List<RoomModel> listaLivres = roomService.listarSalasLivres(lista);
        return listaLivres;
    }


}
