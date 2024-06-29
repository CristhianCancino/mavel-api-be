package com.openpay.challenge.be.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Represents a Marvel character.
 */
@Data
@NoArgsConstructor
public class CharacterDto {

    public String id;
    public String name;
    public String description;
    public String modified;
    public String resourceUri;
    public List<UrlDto> urls;
    public ThumbnailDto thumbnail;
    public ComicsDto comics;
    public StoriesDto stories;
    public EventsDto events;
    public SeriesDto series;

}