package com.pesquisa.pesquisa.resources;

import com.pesquisa.pesquisa.dto.GameDTO;
import com.pesquisa.pesquisa.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameResource {

    @Autowired
    private GameService service;

    @GetMapping
    public ResponseEntity<List<GameDTO>> findAll() {
       List<GameDTO> list = service.findAll();
       return ResponseEntity.ok().body(list);
    }
}
