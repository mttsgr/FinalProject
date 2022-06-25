package com.promineotech.band.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.band.entity.Band;
import com.promineotech.band.entity.BandGenre;
import com.promineotech.band.entity.isBandActive;
import com.promineotech.band.service.BandArchiveService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j 
public class BasicBandArchiveController  implements BandArchiveController{
	
	@Autowired
	private BandArchiveService bandArchiveService;

	
	// RETURN
	
	@Override
	public List<Band> fetchBands(BandGenre genre) {
		log.debug("Genre = {}", genre);
 		return bandArchiveService.fetchBands(genre);
	}
	
	// CREATE
	
	@Override
	public Band createBand(BandGenre genre, String bandName, String cityOfOrigin) {
		log.debug("genre = {}, bandName = {}, cityOfOrigin = {}", genre, bandName, cityOfOrigin);
 		return bandArchiveService.createBand(genre, bandName, cityOfOrigin);


}
	// UPDATE
	
	@Override
	public isBandActive updateBandStatus(boolean isBandActive) {
		log.debug("Band Status = {}", isBandActive);
 		return bandArchiveService.updateBandStatus(isBandActive);
}
	
	// DELETE
	
	@Override
	public Band deleteBand(String band) {
		log.debug("delete band = {}", band);
 		return bandArchiveService.deleteBand(band);
}

}