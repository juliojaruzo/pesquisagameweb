package com.pesquisa.pesquisa.services;

import com.pesquisa.pesquisa.dto.RecordDTO;
import com.pesquisa.pesquisa.dto.RecordInsertDTO;
import com.pesquisa.pesquisa.entities.Game;
import com.pesquisa.pesquisa.repositories.GameRepository;
import com.pesquisa.pesquisa.repositories.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.pesquisa.pesquisa.entities.Record;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

@Service
public class RecordService {

    @Autowired
    private RecordRepository repository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional
    public RecordDTO insert(RecordInsertDTO dto){
        Record entity = new Record();
        entity.setName(dto.getName());
        entity.setAge(dto.getAge());
        entity.setMoment(Instant.now());
        Game game = gameRepository.getOne(dto.getGameId());
        entity.setGame(game);
        entity = repository.save(entity);
        return new RecordDTO(entity);
    }

    @Transactional(readOnly = true)
    public Page<RecordDTO> findByMoment(Instant minDate, Instant maxDate, PageRequest pageRequest) {
        return repository.findByMoments(minDate, maxDate, pageRequest).map(x -> new RecordDTO(x));
    }
}
