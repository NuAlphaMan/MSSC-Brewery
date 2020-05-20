package com.brown.msscbrewery.web_controller;

import com.brown.msscbrewery.services.CustomerService;
import com.brown.msscbrewery.web_model.CustomerDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {
	public CustomerController(CustomerService customerService) {
		this.service = customerService;
	}

	private final CustomerService service;

	@GetMapping(value = "/{id}")
	private ResponseEntity<CustomerDTO> getCustomer(@PathVariable UUID id) { return ResponseEntity.ok(service.getCustomerById(id)); }

	@PostMapping()
	public ResponseEntity saveCustomer(@RequestBody CustomerDTO dto) {
		CustomerDTO savedDto = service.saveNewCustomer(dto);

		HttpHeaders headers = new HttpHeaders();
//		Todo: add hostname to URL
		headers.add("Location", "/api/v1/beer/" + savedDto.getId().toString());
		return new ResponseEntity(savedDto.getId(), headers, HttpStatus.CREATED);
	}

	@PutMapping(value = "/{customerId}")
	public ResponseEntity updateCustomer(@PathVariable UUID customerId, @RequestBody CustomerDTO customerDto) {
		service.updateCustomer(customerId, customerDto);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping(value = "/{customerId}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deleteBeer(@PathVariable UUID customerId) {
		service.deleteCustomerById(customerId);
	}
}
