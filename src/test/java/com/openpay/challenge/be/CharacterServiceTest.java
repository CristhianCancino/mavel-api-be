package com.openpay.challenge.be;

import com.openpay.challenge.be.dto.CharacterDto;
import com.openpay.challenge.be.mapper.CharacterMapper;
import com.openpay.challenge.be.repository.ServiceUsageRepository;
import com.openpay.challenge.be.repository.domain.ServiceUsage;
import com.openpay.challenge.be.service.CharacterService;
import com.openpay.challenge.marvelapi.MarvelApiClient;
import com.openpay.challenge.marvelapi.models.CharactersApiResponse;
import com.openpay.challenge.marvelapi.models.Data;
import com.openpay.challenge.marvelapi.models.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

public class CharacterServiceTest {

    @InjectMocks
    private CharacterService characterService;

    @Mock
    private MarvelApiClient marvelApiClient;

    @Mock
    private CharacterMapper characterMapper;

    @Mock
    private ServiceUsageRepository serviceUsageRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Characters are returned when Marvel API returns data")
    public void charactersAreReturnedWhenMarvelApiReturnsData() {
        CharactersApiResponse response = new CharactersApiResponse();
        response.setData(new Data());
        response.getData().setResults(Collections.singletonList(new Result()));
        when(marvelApiClient.getCharacters()).thenReturn(response);
        when(characterMapper.resultToCharacter(response.getData().getResults().get(0))).thenReturn(new CharacterDto());

        CharacterDto result = characterService.getCharacters();

        assertEquals(new CharacterDto(), result);
    }

    @Test
    @DisplayName("No characters are returned when Marvel API returns no data")
    public void noCharactersAreReturnedWhenMarvelApiReturnsNoData() {
        CharactersApiResponse response = new CharactersApiResponse();
        response.setData(new Data());
        response.getData().setResults(Collections.emptyList());
        when(marvelApiClient.getCharacters()).thenReturn(response);

        CharacterDto result = characterService.getCharacters();

        assertEquals(null, result);
    }

    @Test
    @DisplayName("Character by ID is returned when Marvel API returns data")
    public void characterByIdIsReturnedWhenMarvelApiReturnsData() {
        int characterId = 1;
        CharactersApiResponse response = new CharactersApiResponse();
        response.setData(new Data());
        response.getData().setResults(Collections.singletonList(new Result()));
        when(marvelApiClient.getCharacterById(characterId)).thenReturn(response);
        when(characterMapper.resultToCharacter(response.getData().getResults().get(0))).thenReturn(new CharacterDto());

        List<CharacterDto> result = characterService.getCharacterById(characterId);

        assertEquals(Collections.singletonList(new CharacterDto()), result);
    }

    @Test
    @DisplayName("No character by ID is returned when Marvel API returns no data")
    public void noCharacterByIdIsReturnedWhenMarvelApiReturnsNoData() {
        int characterId = 1;
        CharactersApiResponse response = new CharactersApiResponse();
        response.setData(new Data());
        response.getData().setResults(Collections.emptyList());
        when(marvelApiClient.getCharacterById(characterId)).thenReturn(response);

        List<CharacterDto> result = characterService.getCharacterById(characterId);

        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("Service logs are returned")
    public void serviceLogsAreReturned() {
        when(serviceUsageRepository.findAll()).thenReturn(Collections.singletonList(new ServiceUsage()));

        List<ServiceUsage> result = characterService.getLogs();

        assertEquals(Collections.singletonList(new ServiceUsage()), result);
    }
}
