package com.openpay.challenge.be.mapper;

import com.openpay.challenge.be.dto.CharacterDto;
import com.openpay.challenge.be.dto.ComicsDto;
import com.openpay.challenge.be.dto.EventsDto;
import com.openpay.challenge.be.dto.ItemDto;
import com.openpay.challenge.be.dto.SeriesDto;
import com.openpay.challenge.be.dto.StoriesDto;
import com.openpay.challenge.be.dto.ThumbnailDto;
import com.openpay.challenge.be.dto.UrlDto;
import com.openpay.challenge.marvelapi.models.Comics;
import com.openpay.challenge.marvelapi.models.Events;
import com.openpay.challenge.marvelapi.models.Item;
import com.openpay.challenge.marvelapi.models.Result;
import com.openpay.challenge.marvelapi.models.Series;
import com.openpay.challenge.marvelapi.models.Stories;
import com.openpay.challenge.marvelapi.models.Thumbnail;
import com.openpay.challenge.marvelapi.models.Url;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-29T23:09:01-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Amazon.com Inc.)"
)
public class CharacterMapperImpl implements CharacterMapper {

    @Override
    public CharacterDto resultToCharacter(Result result) {
        if ( result == null ) {
            return null;
        }

        CharacterDto characterDto = new CharacterDto();

        characterDto.setId( result.getId() );
        characterDto.setName( result.getName() );
        characterDto.setDescription( result.getDescription() );
        characterDto.setModified( result.getModified() );
        characterDto.setResourceUri( result.getResourceUri() );
        characterDto.setUrls( urlListToUrlDtoList( result.getUrls() ) );
        characterDto.setThumbnail( thumbnailToThumbnailDto( result.getThumbnail() ) );
        characterDto.setComics( comicsToComicsDto( result.getComics() ) );
        characterDto.setStories( storiesToStoriesDto( result.getStories() ) );
        characterDto.setEvents( eventsToEventsDto( result.getEvents() ) );
        characterDto.setSeries( seriesToSeriesDto( result.getSeries() ) );

        return characterDto;
    }

    @Override
    public UrlDto urlToUrlDto(Url url) {
        if ( url == null ) {
            return null;
        }

        UrlDto urlDto = new UrlDto();

        urlDto.setUrl( url.getUniformResourceLocator() );
        urlDto.setType( url.getType() );

        return urlDto;
    }

    @Override
    public Result characterToResult(CharacterDto character) {
        if ( character == null ) {
            return null;
        }

        Result result = new Result();

        result.setId( character.getId() );
        result.setName( character.getName() );
        result.setDescription( character.getDescription() );
        result.setModified( character.getModified() );
        result.setResourceUri( character.getResourceUri() );
        result.setUrls( urlDtoListToUrlList( character.getUrls() ) );
        result.setThumbnail( thumbnailDtoToThumbnail( character.getThumbnail() ) );
        result.setComics( comicsDtoToComics( character.getComics() ) );
        result.setStories( storiesDtoToStories( character.getStories() ) );
        result.setEvents( eventsDtoToEvents( character.getEvents() ) );
        result.setSeries( seriesDtoToSeries( character.getSeries() ) );

        return result;
    }

    protected List<UrlDto> urlListToUrlDtoList(List<Url> list) {
        if ( list == null ) {
            return null;
        }

        List<UrlDto> list1 = new ArrayList<UrlDto>( list.size() );
        for ( Url url : list ) {
            list1.add( urlToUrlDto( url ) );
        }

        return list1;
    }

    protected ThumbnailDto thumbnailToThumbnailDto(Thumbnail thumbnail) {
        if ( thumbnail == null ) {
            return null;
        }

        ThumbnailDto thumbnailDto = new ThumbnailDto();

        thumbnailDto.setPath( thumbnail.getPath() );
        thumbnailDto.setExtension( thumbnail.getExtension() );

        return thumbnailDto;
    }

    protected ItemDto itemToItemDto(Item item) {
        if ( item == null ) {
            return null;
        }

        ItemDto itemDto = new ItemDto();

        itemDto.setResourceUri( item.getResourceUri() );
        itemDto.setName( item.getName() );
        itemDto.setType( item.getType() );

        return itemDto;
    }

    protected List<ItemDto> itemListToItemDtoList(List<Item> list) {
        if ( list == null ) {
            return null;
        }

        List<ItemDto> list1 = new ArrayList<ItemDto>( list.size() );
        for ( Item item : list ) {
            list1.add( itemToItemDto( item ) );
        }

        return list1;
    }

    protected ComicsDto comicsToComicsDto(Comics comics) {
        if ( comics == null ) {
            return null;
        }

        ComicsDto comicsDto = new ComicsDto();

        comicsDto.setAvailable( comics.getAvailable() );
        comicsDto.setReturned( comics.getReturned() );
        comicsDto.setCollectionUri( comics.getCollectionUri() );
        comicsDto.setItems( itemListToItemDtoList( comics.getItems() ) );

        return comicsDto;
    }

    protected StoriesDto storiesToStoriesDto(Stories stories) {
        if ( stories == null ) {
            return null;
        }

        StoriesDto storiesDto = new StoriesDto();

        storiesDto.setAvailable( stories.getAvailable() );
        storiesDto.setReturned( stories.getReturned() );
        storiesDto.setCollectionUri( stories.getCollectionUri() );
        storiesDto.setItems( itemListToItemDtoList( stories.getItems() ) );

        return storiesDto;
    }

    protected EventsDto eventsToEventsDto(Events events) {
        if ( events == null ) {
            return null;
        }

        EventsDto eventsDto = new EventsDto();

        eventsDto.setAvailable( events.getAvailable() );
        eventsDto.setReturned( events.getReturned() );
        eventsDto.setCollectionUri( events.getCollectionUri() );
        eventsDto.setItems( itemListToItemDtoList( events.getItems() ) );

        return eventsDto;
    }

    protected SeriesDto seriesToSeriesDto(Series series) {
        if ( series == null ) {
            return null;
        }

        SeriesDto seriesDto = new SeriesDto();

        seriesDto.setAvailable( series.getAvailable() );
        seriesDto.setReturned( series.getReturned() );
        seriesDto.setCollectionUri( series.getCollectionUri() );
        seriesDto.setItems( itemListToItemDtoList( series.getItems() ) );

        return seriesDto;
    }

    protected Url urlDtoToUrl(UrlDto urlDto) {
        if ( urlDto == null ) {
            return null;
        }

        Url url = new Url();

        url.setType( urlDto.getType() );

        return url;
    }

    protected List<Url> urlDtoListToUrlList(List<UrlDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Url> list1 = new ArrayList<Url>( list.size() );
        for ( UrlDto urlDto : list ) {
            list1.add( urlDtoToUrl( urlDto ) );
        }

        return list1;
    }

    protected Thumbnail thumbnailDtoToThumbnail(ThumbnailDto thumbnailDto) {
        if ( thumbnailDto == null ) {
            return null;
        }

        Thumbnail thumbnail = new Thumbnail();

        thumbnail.setPath( thumbnailDto.getPath() );
        thumbnail.setExtension( thumbnailDto.getExtension() );

        return thumbnail;
    }

    protected Item itemDtoToItem(ItemDto itemDto) {
        if ( itemDto == null ) {
            return null;
        }

        Item item = new Item();

        item.setResourceUri( itemDto.getResourceUri() );
        item.setName( itemDto.getName() );
        item.setType( itemDto.getType() );

        return item;
    }

    protected List<Item> itemDtoListToItemList(List<ItemDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Item> list1 = new ArrayList<Item>( list.size() );
        for ( ItemDto itemDto : list ) {
            list1.add( itemDtoToItem( itemDto ) );
        }

        return list1;
    }

    protected Comics comicsDtoToComics(ComicsDto comicsDto) {
        if ( comicsDto == null ) {
            return null;
        }

        Comics comics = new Comics();

        comics.setAvailable( comicsDto.getAvailable() );
        comics.setReturned( comicsDto.getReturned() );
        comics.setCollectionUri( comicsDto.getCollectionUri() );
        comics.setItems( itemDtoListToItemList( comicsDto.getItems() ) );

        return comics;
    }

    protected Stories storiesDtoToStories(StoriesDto storiesDto) {
        if ( storiesDto == null ) {
            return null;
        }

        Stories stories = new Stories();

        stories.setAvailable( storiesDto.getAvailable() );
        stories.setReturned( storiesDto.getReturned() );
        stories.setCollectionUri( storiesDto.getCollectionUri() );
        stories.setItems( itemDtoListToItemList( storiesDto.getItems() ) );

        return stories;
    }

    protected Events eventsDtoToEvents(EventsDto eventsDto) {
        if ( eventsDto == null ) {
            return null;
        }

        Events events = new Events();

        events.setAvailable( eventsDto.getAvailable() );
        events.setReturned( eventsDto.getReturned() );
        events.setCollectionUri( eventsDto.getCollectionUri() );
        events.setItems( itemDtoListToItemList( eventsDto.getItems() ) );

        return events;
    }

    protected Series seriesDtoToSeries(SeriesDto seriesDto) {
        if ( seriesDto == null ) {
            return null;
        }

        Series series = new Series();

        series.setAvailable( seriesDto.getAvailable() );
        series.setReturned( seriesDto.getReturned() );
        series.setCollectionUri( seriesDto.getCollectionUri() );
        series.setItems( itemDtoListToItemList( seriesDto.getItems() ) );

        return series;
    }
}
