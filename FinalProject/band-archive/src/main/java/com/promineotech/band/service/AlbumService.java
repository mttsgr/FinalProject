package com.promineotech.band.service;

import java.util.List;

import com.promineotech.band.entity.Album;
import com.promineotech.band.entity.Band;
import com.promineotech.band.entity.BandGenre;

public interface AlbumService {
	
	  List<Album> createAlbum(String bandName, String albumName, BandGenre genre);

}
