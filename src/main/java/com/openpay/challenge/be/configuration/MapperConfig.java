package com.openpay.challenge.be.configuration;

import com.openpay.challenge.be.mapper.CharacterMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public CharacterMapper characterMapper() {
        return Mappers.getMapper(CharacterMapper.class);
    }
}