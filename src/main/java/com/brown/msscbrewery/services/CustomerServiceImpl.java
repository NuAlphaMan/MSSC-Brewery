package com.brown.msscbrewery.services;

import com.brown.msscbrewery.web_model.BeerDto;
import com.brown.msscbrewery.web_model.CustomerDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Override
	public CustomerDTO getCustomerById(UUID id) {
		return CustomerDTO.builder().id(UUID.randomUUID()).name("John Doe").build();
	}

	@Override
	public CustomerDTO saveNewCustomer(CustomerDTO dto) {
		return CustomerDTO.builder().id(UUID.randomUUID()).build();
	}

	@Override
	public void updateCustomer(UUID customerId, CustomerDTO customerDto) {

	}

	@Override
	public void deleteCustomerById(UUID customerId) {

	}
}
