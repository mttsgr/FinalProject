package com.promineotech.band.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Album {
	private Long albumPK;
	private Band bandId;
	private BandGenre genreId;
	private String albumName;
	private String albumLength;
}
