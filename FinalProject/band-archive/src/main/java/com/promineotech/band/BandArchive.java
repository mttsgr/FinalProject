package com.promineotech.band;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.promineotech.ComponentScanMarker;

@SpringBootApplication(scanBasePackageClasses = {ComponentScanMarker.class})
public class BandArchive {

	public static void main(String[] args) {
		SpringApplication.run(BandArchive.class, args);
	}

}
