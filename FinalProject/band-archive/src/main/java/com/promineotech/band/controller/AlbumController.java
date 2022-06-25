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

	@RequestMapping("/bands")
	@OpenAPIDefinition(info = @Info(title = "Band Archive Service"), servers = {
			@Server(url = "http://localhost:8080", description = "Local server.")})
	public interface AlbumController {
		//formatter:off
		@Operation(
				summary = "Create Album",
				description= "Returns Bands given an optional genre",
				responses = {
						@ApiResponse(responseCode = "201", 
							description = "Album is created", 
							content = @Content(mediaType = "application/json", 
							schema = @Schema (implementation = Band.class))),
						@ApiResponse(responseCode = "400", 
							description = "The request parameters are invalid", 
							content = @Content(mediaType = "application/json")),
						@ApiResponse(responseCode = "404", 
							description = "No bands were found with the input criteria", 
							content = @Content(mediaType = "application/json")),
						@ApiResponse(responseCode = "500", 
							description = "An unplanned error occurred", 
							content = @Content(mediaType = "application/json"))
				},
				parameters = {
						@Parameter(name = "albumName", 
								allowEmptyValue = false, 
								required = false,
								description  = "The album name")
				}
			
	}
	}

	List<Band> createAlbum(String bandName, String albumName, BandGenre genre);
	
	}
