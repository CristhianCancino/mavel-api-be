package com.openpay.challenge.be.service;

import com.openpay.challenge.be.dto.CharacterDto;
import com.openpay.challenge.be.mapper.CharacterMapper;
import com.openpay.challenge.marvelapi.MarvelApiClient;
import com.openpay.challenge.marvelapi.models.CharactersApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CharacterService {

    private final MarvelApiClient marvelApiClient;
    private final CharacterMapper characterMapper;

    @Autowired
    public CharacterService(MarvelApiClient marvelApiClient, CharacterMapper characterMapper) {
        this.marvelApiClient = marvelApiClient;
        this.characterMapper = characterMapper;
    }

    public CharacterDto getCharacters() {
        CharactersApiResponse response = marvelApiClient.getCharacters();
        if (response.getData().getResults().isEmpty()) {
            log.info("No characters found");
            return null;
        }
        return characterMapper.resultToCharacter(response.getData().getResults().get(0));
    }

    public List<CharacterDto> getCharacterById(int characterId) {
        CharactersApiResponse response = marvelApiClient.getCharacterById(characterId);
        if (response.getData().getResults().isEmpty()) {
            log.info("No character found with id: {}", characterId);
            return Collections.emptyList();
        }
        return response.getData().getResults()
                .stream().map(characterMapper::resultToCharacter)
                .collect(Collectors.toList());
    }

}
