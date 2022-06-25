package com.promineotech.band.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.promineotech.band.entity.Band;
import com.promineotech.band.entity.BandGenre;
import com.promineotech.band.service.GenreService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BasicGenreController implements GenreController{
	
	@Autowired
	private GenreService genreService;
	
	// UPDATE
	
	@Override
	public BandGenre updateGenreDescription(String genreDescription) {
		log.debug("Genre Description = {}", genreDescription);
 		return genreService.updateGenreDescription(genreDescription);
}
}
