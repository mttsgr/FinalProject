package com.promineotech.band.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.promineotech.band.entity.Album;
import com.promineotech.band.entity.Band;
import com.promineotech.band.entity.BandGenre;

public class DefaultGenreDao implements GenreDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public List<Object> genreDescription(BandGenre genre) {
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
						.genreDescription(rs.getString("genre_description"))
						.genrePK(rs.getLong("genre_pk"))
				//@formatter:on
			}});
	}
	
}
