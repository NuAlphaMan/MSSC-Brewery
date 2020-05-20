package com.brown.msscbrewery.services;

import com.brown.msscbrewery.web_model.BeerDto;
import com.brown.msscbrewery.web_model.CustomerDTO;

import java.util.UUID;

public interface CustomerService {
	CustomerDTO getCustomerById(UUID id);

	CustomerDTO saveNewCustomer(CustomerDTO dto);

	void updateCustomer(UUID customerId, CustomerDTO customerDto);

	void deleteCustomerById(UUID customerId);
}
