package com.openpay.challenge.be.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class EventsDto {

    public String available;
    public String returned;
    public String collectionUri;
    public List<ItemDto> items;
}