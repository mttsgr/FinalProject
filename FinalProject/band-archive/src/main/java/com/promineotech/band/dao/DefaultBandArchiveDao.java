package com.promineotech.band.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.promineotech.band.entity.Album;
import com.promineotech.band.entity.Band;
import com.promineotech.band.entity.BandGenre;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultBandArchiveDao implements BandArchiveDao{
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public List<Band> fetchBands(BandGenre genre) {
		log.debug("DAO: genre= {}");
		
		
		//@formatter:off
		String sql = ""
				+ "SELECT * "
				+ "FROM genre "
				+ "WHERE genre_id = :genre_id";
		//@formatter:on
		
		Map<String, Object> params = new HashMap<>();
		params.put("genre_id", genre.toString());
		
		return jdbcTemplate.query(sql, params, new RowMapper<>() {

			@Override
			public Band mapRow(ResultSet rs, int rowNum) throws SQLException {
				//@formatter:off
				return Band.builder()
						.bandName(rs.getString("band_name"))
						.bandPK(rs.getLong("band_pk"))
						.genre1Id(BandGenre.valueOf(rs.getString("genre1_fk")))
						.genre2Id(BandGenre.valueOf(rs.getString("genre2_fk")))
						.startYear(rs.getString("start_year"))
						.endYear(rs.getString("end_year"))
						.cityOfOrigin(rs.getString("city_of_origin"))
						.build();
				
				//@formatter:on
			}});
	}
	
	@Override
	public Band createBand(BandGenre genre, String bandName, String cityOfOrigin) {
		log.debug("DAO: band= {}");
		
		
		//@formatter:off
		String sql = ""
				+ "SELECT * "
				+ "FROM band "
				+ "WHERE band_id = :band_id";
		//@formatter:on
		
		Map<String, Object> params = new HashMap<>();
		params.put("band_name", band);
		
		return jdbcTemplate.query(sql, params, new Band) {

			@Override
			public Band createBand(ResultSet rs, int rowNum) throws SQLException {
				//@formatter:off
				return Band.builder()
						.bandName(rs.getString("band_name"))
						.bandPK(rs.getLong("band_pk"))
						.genre1Id(BandGenre.valueOf(rs.getString("genre1_fk")))
						.genre2Id(BandGenre.valueOf(rs.getString("genre2_fk")))
						.startYear(rs.getString("start_year"))
						.endYear(rs.getString("end_year"))
						.cityOfOrigin(rs.getString("city_of_origin"))
						.build();
				
				//@formatter:on
			}}); 
			
			@Override
			public isBandActive updateBandStatus(boolean isBandActive) {
				log.debug("DAO: isBandActive= {}");
				
				
				//@formatter:off
				String sql = ""
						+ "SELECT * "
						+ "FROM band "
						+ "WHERE band_id = :band_id";
				//@formatter:on
				
				Map<String, Object> params = new HashMap<>();
				params.put("isBandActive", isBandActive);
				
				return jdbcTemplate.query(sql, params, new isBandActive) {

					@Override
					public Band isBandActive(ResultSet rs, int rowNum) throws SQLException {
						//@formatter:off
						return Band.builder()
								.isBandActive(rs.getString("isBandActive"))
							
						
						//@formatter:on
					}}); 	

					@Autowired
					private NamedParameterJdbcTemplate jdbcTemplate;

					@Override
					public Band deleteBand(String bandName) {
						log.debug("DAO: genre= {}");
						
						
						//@formatter:off
						String sql = ""
								+ "SELECT * "
								+ "FROM band "
								+ "WHERE band_id = :band_id";
						//@formatter:on
						
						Map<String, Object> params = new HashMap<>();
						params.put("band_id", band.toString());
						
						return jdbcTemplate.query(sql, params, new Band() {

							@Override
							public Band mapRow(ResultSet rs, int rowNum) throws SQLException {
								//@formatter:off
								return Band.builder()
										.bandName(rs.getString("band_name"))
										.bandPK(rs.getLong("band_pk"))
										.genre1Id(BandGenre.valueOf(rs.getString("genre1_fk")))
										.genre2Id(BandGenre.valueOf(rs.getString("genre2_fk")))
										.startYear(rs.getString("start_year"))
										.endYear(rs.getString("end_year"))
										.cityOfOrigin(rs.getString("city_of_origin"))
										.build();
								
								//@formatter:on
							}});					
				
					}
			}
