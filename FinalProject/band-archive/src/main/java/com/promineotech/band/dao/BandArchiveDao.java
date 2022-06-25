package com.promineotech.band.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.promineotech.band.entity.Band;
import com.promineotech.band.entity.BandGenre;
import com.promineotech.band.service.isBandActive;

public interface BandArchiveDao {

	List<Band> fetchBands(BandGenre genre);

	Band createBand(BandGenre genre, String bandName, String cityOfOrigin);

	isBandActive updateBandStatus(boolean isBandActive);

	Band deleteBand(String bandName);

	Band createBand(ResultSet rs, int rowNum) throws SQLException;


}
