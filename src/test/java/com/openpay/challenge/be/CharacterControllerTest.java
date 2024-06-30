package com.openpay.challenge.be;

import com.openpay.challenge.be.controller.CharacterController;
import com.openpay.challenge.be.dto.CharacterDto;
import com.openpay.challenge.be.repository.domain.ServiceUsage;
import com.openpay.challenge.be.service.CharacterService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class CharacterControllerTest {

    @InjectMocks
    private CharacterController characterController;

    @Mock
    private CharacterService characterService;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(characterController).build();
    }

    @Test
    void getCharactersReturnsOk() throws Exception {
        CharacterDto characterDto = new CharacterDto();
        when(characterService.getCharacters()).thenReturn(characterDto);

        mockMvc.perform(get("/api/characters")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void getCharacterByIdReturnsOk() throws Exception {
        int characterId = 1;
        List<CharacterDto> characterDtoList = Arrays.asList(new CharacterDto());
        when(characterService.getCharacterById(characterId)).thenReturn(characterDtoList);

        mockMvc.perform(get("/api/characters/" + characterId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void getLogsReturnsOk() throws Exception {
        List<ServiceUsage> serviceUsageList = Arrays.asList(new ServiceUsage());
        when(characterService.getLogs()).thenReturn(serviceUsageList);

        mockMvc.perform(get("/api/characters/logs")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}