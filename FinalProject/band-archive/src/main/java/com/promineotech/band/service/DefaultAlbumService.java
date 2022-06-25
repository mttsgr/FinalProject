package com.promineotech.band.service;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.promineotech.band.dao.AlbumDao;
import com.promineotech.band.dao.BandArchiveDao;
import com.promineotech.band.entity.Album;
import com.promineotech.band.entity.Band;
import com.promineotech.band.entity.BandGenre;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DefaultAlbumService implements AlbumService{

	@Autowired
	private AlbumDao albumDao;

	@Transactional(readOnly = true)
	@Override
	public List<Album> createAlbum(String bandName, String albumName, BandGenre genre) {
		log.info("The createAlbum method was called with album={}", albumName);
				
		List<Album> albums = AlbumDao.createAlbum(albumName);
		
		if(albums.isEmpty()) {
			String msg = String.format("No albums found with albumName = {}", albumName);
			
			throw new NoSuchElementException(msg);
		}
		
		Collections.sort(albums);
		return albums;
	}

}
