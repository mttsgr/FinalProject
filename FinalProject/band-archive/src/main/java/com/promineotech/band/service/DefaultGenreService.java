package com.promineotech.band.service;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.promineotech.band.dao.AlbumDao;
import com.promineotech.band.dao.GenreDao;
import com.promineotech.band.entity.Album;
import com.promineotech.band.entity.BandGenre;
import com.promineotech.band.entity.Genre;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DefaultGenreService implements GenreService{

	@Override
	public BandGenre updateGenreDescription(String genreDescription) {
		
		@Autowired
		private GenreDao genreDao;

		@Transactional(readOnly = true)
		@Override
		public List<Album> updateGenreDescription(String genreDescription) {
			log.info("The updateGenreDescription method was called with genre description={}", genreDescription);
					
			List<Genre> genres = genreDao.updateGenreDescription(genreDescription);
			
			if(genres.isEmpty()) {
				String msg = String.format("No genres found with genre = {}", genreDescription);
				
				throw new NoSuchElementException(msg);
			}
			
			return genres;
		}

}
