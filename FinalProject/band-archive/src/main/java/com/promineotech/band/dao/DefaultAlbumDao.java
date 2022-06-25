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
public class DefaultAlbumDao implements AlbumDao{
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public List<Album> createAlbum(String albumName) {
		log.debug("DAO: albumName= {}");
		
		
		//@formatter:off
		String sql = ""
				+ "SELECT * "
				+ "FROM album "
				+ "WHERE album_id = :album_id";
		//@formatter:on
		
		Map<String, Object> params = new HashMap<>();
		params.put("album_id", album.toString());
		
		return jdbcTemplate.query(sql, params, new RowMapper<>() {

			@Override
			public Album mapRow(ResultSet rs, int rowNum) throws SQLException {
				//@formatter:off
				return Album.builder()
						.albumName(rs.getString("album_name"))
						.albumPK(rs.getLong("album_pk"))
						.genreId(BandGenre.valueOf(rs.getString("genre1_fk")))
						.albumLength(rs.getString("album_length"))
						.build();
				
				//@formatter:on
			}});
	}
}
