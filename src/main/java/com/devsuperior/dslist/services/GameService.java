package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repositories.GameRepository;

@Service
public class GameService {
    
    @Autowired
    GameRepository gameRepository;
    
    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        List<Game> list = gameRepository.findAll();
        List<GameMinDTO> dto = list.stream().map(g -> new GameMinDTO(g)).toList();
        return dto;
    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {  //deveria fazer tratamento caso o id nao exista
        return new GameDTO(gameRepository.findById(id).get());
    }
}
