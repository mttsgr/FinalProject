package com.promineotech.band.entity;

import java.util.Comparator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Band implements Comparable<Band>{
	private Long bandPK;
	private BandGenre genre1Id;
	private BandGenre genre2Id;
	private String bandName;
	private String startYear;
	private String endYear;
	private boolean isBandActive;
	private String cityOfOrigin;
	
	@JsonIgnore
	public Long getBandPK() {
		return bandPK;
	}

	@Override
	public int compareTo(Band that) {
		return Comparator
				.comparing(Band::getGenre1Id)
				.thenComparing (Band::getBandName)
				.compare(this, that);
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
}
