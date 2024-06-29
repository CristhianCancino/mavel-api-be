package com.openpay.challenge.be.controller;

import com.openpay.challenge.be.dto.CharacterDto;
import com.openpay.challenge.be.repository.domain.ServiceUsage;
import com.openpay.challenge.be.service.CharacterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/characters")
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @GetMapping
    public CharacterDto getCharacters() {
        log.info("Getting characters from Marvel API");
        return characterService.getCharacters();
    }

    @GetMapping("/{id}")
    public List<CharacterDto> getCharacterById(@PathVariable("id") int characterId) {
        log.info("Getting character with id {} from Marvel API", characterId);
        return characterService.getCharacterById(characterId);
    }

    @GetMapping("/logs")
    public List<ServiceUsage> getLogs() {
        return characterService.getLogs();
    }
}