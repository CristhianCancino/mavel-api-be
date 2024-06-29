package com.openpay.challenge.be.mapper;

import com.openpay.challenge.be.dto.CharacterDto;
import com.openpay.challenge.be.dto.UrlDto;
import com.openpay.challenge.marvelapi.models.Result;
import com.openpay.challenge.marvelapi.models.Url;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper
public interface CharacterMapper {

    CharacterDto resultToCharacter(Result result);

    @Mapping(target = "url", source = "uniformResourceLocator")
    UrlDto urlToUrlDto(Url url);

    Result characterToResult(CharacterDto character);

}