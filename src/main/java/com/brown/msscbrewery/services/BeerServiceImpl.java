package com.brown.msscbrewery.services;

import com.brown.msscbrewery.web_model.BeerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService {
	@Override
	public BeerDto getBeerById(UUID id) {
		return BeerDto.builder().id(UUID.randomUUID()).beerName("Galaxy Cat").beerStyle("Pale Ale").build();
	}

	@Override
	public BeerDto saveNewBeer(BeerDto beerDto) {
		return BeerDto.builder().id(UUID.randomUUID()).build();
	}

	@Override
	public void updateBeer(UUID beerId, BeerDto beerDto) {
		//todo: would have to add real method to update beer
	}

	@Override
	public void deleteBeerById(UUID beerId) {
		//todo; implement delete method
	}
}
