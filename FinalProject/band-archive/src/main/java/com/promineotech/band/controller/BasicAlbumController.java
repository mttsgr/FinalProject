package com.promineotech.band.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.promineotech.band.entity.Album;
import com.promineotech.band.entity.Band;
import com.promineotech.band.entity.BandGenre;
import com.promineotech.band.service.AlbumService;
import com.promineotech.band.service.BandArchiveService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BasicAlbumController implements AlbumController{
	
	@Autowired
	private AlbumService albumService;
	
	// CREATE
	
	public List<Album> createAlbum(String bandName, String albumName, BandGenre genre) {
		log.debug("band name = {}, album name = {}, genre = {}", bandName, albumName, genre);
 		return albumService.createAlbum(bandName, albumName, genre);


}
}
