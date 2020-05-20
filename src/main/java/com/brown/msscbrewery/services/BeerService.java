package com.brown.msscbrewery.services;

import com.brown.msscbrewery.web_model.BeerDto;

import java.util.UUID;

public interface BeerService {
	BeerDto getBeerById(UUID id);

	BeerDto saveNewBeer(BeerDto beerDto);

	void updateBeer(UUID beerId, BeerDto beerDto);

	void deleteBeerById(UUID beerId);
}
