package org.football.league.management.controller;

import java.io.FileNotFoundException;
import java.util.List;

import org.football.league.management.entity.Country;
import org.football.league.management.service.LeagueService;
import org.football.league.management.util.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping(value = "/league")
public class LeagueController {

	@Autowired
	LeagueService<Object, String, Action> leagueService;

	@PostMapping(value = "/add")
	public Country addCountry(@RequestBody Country country) {
		return null;
	}
	
	@GetMapping(value = "/getAll")
	public ResponseEntity<List<Object>> getAll(@RequestParam("action") Action action, @RequestParam("country_id") String country_id) {
		return ResponseEntity.status(HttpStatus.OK).body(leagueService.getAll(action, country_id));

	}

	@GetMapping(value = "/getById")
	public ResponseEntity<Country> getById(@RequestParam("id") String Id) throws FileNotFoundException {
		throw new FileNotFoundException();
	}
	
	public String fallBack() {
		return "doone";
	}
	
	@HystrixCommand(fallbackMethod = "fallBack", commandKey = "ckey", groupKey = "gKey")
	@GetMapping(value = "/getB")
	public String get() throws FileNotFoundException {
		throw new FileNotFoundException();
	}
	
	
}
