package com.example.getdiamond.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.getdiamond.exception.ResourceNotFoundException;
import com.example.getdiamond.models.ExchangeModel;
import com.example.getdiamond.models.JewelryModel;
import com.example.getdiamond.models.UserModel;
import com.example.getdiamond.repository.ExchangeRepository;
import com.example.getdiamond.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class ExchangeController {

	@Autowired
	ExchangeRepository exchangeRepository;
	
	@Autowired
	UserRepository userRepository;
	
	//get all
	@GetMapping("/exchange")
	public List<ExchangeModel> getAll() {
		return exchangeRepository.findAll();
	}
	
	//get single

	//GetMapping single
	@ GetMapping("/exchange/{id}")
	public ExchangeModel getById(@PathVariable (value = "id") Long exchangeId) {
		return exchangeRepository.findById(exchangeId)
				.orElseThrow(() -> new ResourceNotFoundException("ExchangeModel", "id", exchangeId));
	}
	
	//create
	@PostMapping("/exchange/asker/{asker_id}/receiver/{receiver_id}")
	public ExchangeModel create(@PathVariable (value= "asker_id") Long askerId,
			@PathVariable (value= "receiver_id") Long receiverId,
			@Valid @RequestBody ExchangeModel exchange) {
		
		UserModel asker = userRepository.findById(askerId)
				.orElseThrow(() -> new ResourceNotFoundException("UserModel", "asker_id", askerId));
		UserModel receiver = userRepository.findById(receiverId)
				.orElseThrow(() -> new ResourceNotFoundException("UserModel", "receiver_id", receiverId));
		
		exchange.setAsker(asker);
		exchange.setReceiver(receiver);
		return exchangeRepository.save(exchange);
	}
	
	@PutMapping("/exchange/{id}")
	public ExchangeModel update(@PathVariable (value = "id") Long exchangeId,
			@Valid @RequestBody ExchangeModel exchangeDetails) {
		
		ExchangeModel exchange = exchangeRepository.findById(exchangeId)
				.orElseThrow(() -> new ResourceNotFoundException("ExchangeModel", "id", exchangeId));
	
		exchange.setCreateDate(exchangeDetails.getCreateDate());
		exchange.setAccepted(exchangeDetails.isAccepted());
		exchange.setAsker(exchangeDetails.getAsker());
		exchange.setOpalAsker(exchangeDetails.getOpalAsker());
		exchange.setEmeraldAsker(exchangeDetails.getEmeraldAsker());
		exchange.setDiamondAsker(exchangeDetails.getDiamondAsker());
		exchange.setRubyAsker(exchangeDetails.getRubyAsker());
		exchange.setReceiver(exchangeDetails.getReceiver());
		exchange.setOpalReceiver(exchangeDetails.getOpalReceiver());
		exchange.setEmeraldReceiver(exchangeDetails.getEmeraldReceiver());
		exchange.setDiamondReceiver(exchangeDetails.getDiamondReceiver());
		exchange.setRubyReceiver(exchangeDetails.getRubyReceiver());
		
		
		ExchangeModel update = exchangeRepository.save(exchange);
		return update;
	}
			
	// Delete 
		@DeleteMapping("/compteurs/{id}")
		public ResponseEntity<?> delete(@PathVariable(value = "id") Long exchangeId) {
			ExchangeModel exchange = exchangeRepository.findById(exchangeId)
					.orElseThrow(() -> new ResourceNotFoundException("ExchangeModel", "id", exchangeId));

			exchangeRepository.delete(exchange);

			return ResponseEntity.ok().build();
		}
	
}
