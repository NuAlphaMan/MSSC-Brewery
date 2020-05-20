package com.brown.msscbrewery.web_controller;

import com.brown.msscbrewery.services.BeerService;
import com.brown.msscbrewery.web_model.BeerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {
	public BeerController(BeerService beerService) {
		this.beerService = beerService;
	}

	private final BeerService beerService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<BeerDto> getBeer(@PathVariable UUID id) {
		return ResponseEntity.ok(beerService.getBeerById(id));
	}

	@PostMapping()
	public ResponseEntity handlePost(@RequestBody BeerDto beerDto) {
		BeerDto savedDto = beerService.saveNewBeer(beerDto);

		HttpHeaders headers = new HttpHeaders();
//		Todo: add hostname to URL
		headers.add("Location", "/api/v1/beer/" + savedDto.getId().toString());
		return new ResponseEntity(savedDto.getId(), headers, HttpStatus.CREATED);
	}

	@PutMapping(value = "/{beerId}")
	public ResponseEntity updateBeer(@PathVariable UUID beerId, @RequestBody BeerDto beerDto) {
		beerService.updateBeer(beerId, beerDto);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping(value = "/{beerId}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deleteBeer(@PathVariable UUID beerId) {
		beerService.deleteBeerById(beerId);
	}
}
