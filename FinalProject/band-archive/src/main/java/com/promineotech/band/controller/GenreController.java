package com.promineotech.band.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;

import com.promineotech.band.entity.Band;
import com.promineotech.band.entity.BandGenre;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

public interface GenreController {
	@RequestMapping("/bands")
	@OpenAPIDefinition(info = @Info(title = "Band Archive Service"), servers = {
			@Server(url = "http://localhost:8080", description = "Local server.")})
	public interface BandArchiveController {
		//formatter:off
		@Operation(
				summary = "Updates genre description",
				description= "Updates genre description",
				responses = {
						@ApiResponse(responseCode = "200", 
							description = "Description has been updated", 
							content = @Content(mediaType = "application/json", 
							schema = @Schema (implementation = Band.class))),
						@ApiResponse(responseCode = "400", 
							description = "The request parameters are invalid", 
							content = @Content(mediaType = "application/json")),
						@ApiResponse(responseCode = "404", 
							description = "Bad input criteria", 
							content = @Content(mediaType = "application/json")),
						@ApiResponse(responseCode = "500", 
							description = "An unplanned error occurred", 
							content = @Content(mediaType = "application/json"))
				},
				parameters = {
						@Parameter(name = "genre", 
								allowEmptyValue = false, 
								required = false,
								description  = "The genre name (i.e., 'Punk')")
				}
			)
}

	BandGenre updateGenreDescription(String genreDescription);
