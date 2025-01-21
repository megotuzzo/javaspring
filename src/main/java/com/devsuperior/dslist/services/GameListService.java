package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.repositories.GameListRepository;

@Service
public class GameListService {
    
    @Autowired
    GameListRepository gameListRepository;
    
    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> list = gameListRepository.findAll();
        List<GameListDTO> dto = list.stream().map(l -> new GameListDTO(l)).toList();
        return dto;
    }


}
