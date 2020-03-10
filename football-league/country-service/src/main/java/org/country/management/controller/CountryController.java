package org.country.management.controller;

import java.util.List;

import org.country.management.entity.Country;
import org.country.management.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/country")
public class CountryController {

	@Autowired
	CountryService<Country, String> countryService;

	@PostMapping(value = "/add")
	public Country addCountry(@RequestBody Country country) {
		return null;
	}
	
	@GetMapping(value = "/getAll")
	public ResponseEntity<List<Country>> getAllCountries() {
		return ResponseEntity.status(HttpStatus.OK).body(countryService.getAllCountries());
	}

	@GetMapping(value = "/getById")
	public ResponseEntity<Country> getCountryById(@RequestParam("id") String countryId) {
		return ResponseEntity.status(HttpStatus.OK).body(countryService.getCountryById(countryId));
	}
	
	@GetMapping(value = "/getByName")
	public ResponseEntity<Country> getCountryByName(@RequestParam("name") String countryName) {
		return ResponseEntity.status(HttpStatus.OK).body(countryService.getCountryByName(countryName));
	}
}
