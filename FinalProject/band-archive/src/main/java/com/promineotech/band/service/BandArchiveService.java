package com.promineotech.band.service;

import java.util.List;

import com.promineotech.band.entity.Band;
import com.promineotech.band.entity.BandGenre;
import com.promineotech.band.entity.isBandActive;

public interface BandArchiveService {

	List<Band> fetchBands(BandGenre genre);

	Band createBand(BandGenre genre, String bandName, String cityOfOrigin);

	isBandActive updateBandStatus(boolean isBandActive);

	Band deleteBand(String band);

}
