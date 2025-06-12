package com.example.Sistema.de.Reserva.de.Salas.service;

import com.example.Sistema.de.Reserva.de.Salas.dto.BookDto;
import com.example.Sistema.de.Reserva.de.Salas.model.BookModel;
import com.example.Sistema.de.Reserva.de.Salas.model.RoomModel;
import com.example.Sistema.de.Reserva.de.Salas.repository.BookRepository;
import com.example.Sistema.de.Reserva.de.Salas.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    @Autowired
    private RoomRepository roomRepository;

    @Transactional
    public void alugarSala(BookDto dto) {
        LocalTime horaMinima = LocalTime.of(8, 0);
        LocalTime horaMaxima = LocalTime.of(20, 0);

        if (dto.horaInicio().isBefore(horaMinima) || dto.horaFim().isAfter(horaMaxima)) {
            throw new RuntimeException("Sala fora do horário permitido!");
        }


        RoomModel salaX = roomRepository.getReferenceById(dto.sala().getId());

        List<BookModel> listaDeBooks = repository.findAllBySalaId(salaX.getId());

        for (BookModel reserva : listaDeBooks) {
            boolean conflito = !(dto.horaFim().isBefore(reserva.getHoraInicio()) ||
                    dto.horaInicio().isAfter(reserva.getHoraFim()));

            if (conflito) {
                throw new RuntimeException("Conflito de horário com reserva existente!");
            }
        }

        BookModel novaReserva = new BookModel();
        novaReserva.setSala(salaX);
        novaReserva.setData(dto.data());
        novaReserva.setNomePessoa(dto.nomePessoa());
        novaReserva.setHoraInicio(dto.horaInicio());
        novaReserva.setHoraFim(dto.horaFim());

        repository.save(novaReserva);
    }

    public List<BookModel> acharRerva(LocalDate inicio){
    List<BookModel> lista = repository.buscarPorData(inicio);
    return lista;
    }



}
