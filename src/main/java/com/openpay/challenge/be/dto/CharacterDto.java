package com.openpay.challenge.be.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Represents a Marvel character.
 */
@Data
@NoArgsConstructor
@Schema(description = "Represents a Marvel character.")
public class CharacterDto {

    @Schema(description = "The ID of the character.")
    public String id;

    @Schema(description = "The name of the character.")
    public String name;

    @Schema(description = "The description of the character.")
    public String description;

    @Schema(description = "The modification date of the character.")
    public String modified;

    @Schema(description = "The resource URI of the character.")
    public String resourceUri;

    @Schema(description = "The list of URLs of the character.")
    public List<UrlDto> urls;

    @Schema(description = "The thumbnail of the character.")
    public ThumbnailDto thumbnail;

    @Schema(description = "The comics of the character.")
    public ComicsDto comics;

    @Schema(description = "The stories of the character.")
    public StoriesDto stories;

    @Schema(description = "The events of the character.")
    public EventsDto events;

    @Schema(description = "The series of the character.")
    public SeriesDto series;

}