package com.promineotech.band.service;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.promineotech.band.dao.BandArchiveDao;
import com.promineotech.band.entity.Band;
import com.promineotech.band.entity.BandGenre;
import com.promineotech.band.entity.isBandActive;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultBandArchiveService implements BandArchiveService{
	
	@Autowired
	private BandArchiveDao bandArchiveDao;

	@Transactional(readOnly = true)
	@Override
	public List<Band> fetchBands(BandGenre genre) {
		log.info("The fetchBands method was called with genre={}", genre);
				
		List<Band> bands = bandArchiveDao.fetchBands(genre);
		
		if(bands.isEmpty()) {
			String msg = String.format("No bands found with genre = {}", genre);
			
			throw new NoSuchElementException(msg);
		}
		
		Collections.sort(bands);
		return bands;
	}

	@Override
	public Band createBand(BandGenre genre, String bandName, String cityOfOrigin) {
		log.info("The createBand method was called with genre={}, bandName={}, cityofOrigin={}", genre, bandName, cityOfOrigin);
		
		Band newBand = bandArchiveDao.createBand(genre, bandName, cityOfOrigin);
		
		if(newBand.isEmpty()) {
			String msg = String.format("No bands found with genre = {}, bandName={}, cityofOrigin={}", genre, bandName, cityOfOrigin);
			
			throw new NoSuchElementException(msg);
		}
		return newBand;
	}

	@Override
	public isBandActive updateBandStatus(boolean isBandActive) {
		log.info("The updateBandStatus method was called with bandStatus={}", isBandActive);
		
		isBandActive bandStatus = bandArchiveDao.updateBandStatus(isBandActive);
		
		if(bandStatus.isEmpty()) {
			String msg = String.format("No bands found with bandStatus = {}", isBandActive);
			
			throw new NoSuchElementException(msg);
		}
				return bandStatus;
	}

	@Override
	public Band deleteBand(String bandName) {
		public Band deleteBand(String bandName) {
			log.info("The fetchBands method was called with bandName={}", bandName);
					
			Band bands = bandArchiveDao.deleteBand(bandName);
			
			if(bands.isEmpty()) {
				String msg = String.format("No bands found with genre = {}", bandName);
				
				throw new NoSuchElementException(msg);
			}
			
			return bandName;
	}


}
