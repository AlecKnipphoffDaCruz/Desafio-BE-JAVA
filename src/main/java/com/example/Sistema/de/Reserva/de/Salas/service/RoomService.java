package com.example.Sistema.de.Reserva.de.Salas.service;

import com.example.Sistema.de.Reserva.de.Salas.dto.RoomDto;
import com.example.Sistema.de.Reserva.de.Salas.model.BookModel;
import com.example.Sistema.de.Reserva.de.Salas.model.RoomModel;
import com.example.Sistema.de.Reserva.de.Salas.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomService {

        @Autowired
        private RoomRepository repository;

    @Transactional
    public void criarSala(RoomDto dto){
        RoomModel salanova = new RoomModel();
        salanova.setNome(dto.nome());
        salanova.setCapacidade(dto.capacidade());
        repository.save(salanova);
    }

    @Transactional
    public void atualizarSala(RoomDto dto , Long id){
        RoomModel sala = repository.getReferenceById(id);
        sala.setNome(dto.nome());
        sala.setCapacidade(dto.capacidade());
        repository.save(sala);
    }
    @Transactional
    public void deletarSala(Long id){
        repository.deleteById(id);
    }
    public List<RoomModel> listarSalasLivres(List<BookModel> listaReservas){
        List<RoomModel> listaSalas = repository.findAll();
        List<RoomModel> salasLivres = new ArrayList<>();

        for (RoomModel r : listaSalas) {
            if (!(listaReservas.contains(r))){
                salasLivres.add(r);
            }

        }
        return salasLivres;
    }



}
