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
import com.example.getdiamond.models.UserModel;
import com.example.getdiamond.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	//get all
	@GetMapping("/users")
	public List<UserModel> getAll() {
		return userRepository.findAll();
	}
	
	//GetMapping single
	@ GetMapping("/users/{id}")
	public UserModel getById(@PathVariable (value = "id") Long userId) {
		return userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("UserModel", "id", userId));
	}
	
	//create
	@PostMapping("/users")
	public UserModel create(@Valid @RequestBody UserModel user) {
		return userRepository.save(user);
	}
	
	@PutMapping("/users/{id}")
	public UserModel update(@PathVariable (value = "id") Long userId,
			@Valid @RequestBody UserModel userDetails) {
		
		UserModel userModel = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("UserModel", "id", userId));
	
		userModel.setId(userDetails.getId());
		userModel.setName(userDetails.getName());
		userModel.setPassword(userDetails.getPassword());
		userModel.setMoney(userDetails.getMoney());
		userModel.setDiamond(userDetails.getDiamond());
		userModel.setEmerald(userDetails.getEmerald());
		userModel.setRuby(userDetails.getRuby());
		userModel.setOpal(userDetails.getOpal());
		userModel.setLastMining(userDetails.getLastMining());
		userModel.setIndent1(userDetails.getIndent1());
		userModel.setIndent2(userDetails.getIndent2());
		userModel.setIndent3(userDetails.getIndent3());
		userModel.setTotalBuilt(userDetails.getTotalBuilt());
		userModel.setTotalExchange(userDetails.getTotalExchange());
		
		UserModel update = userRepository.save(userModel);
		return update;
	}
	
	//delete
	@DeleteMapping("/users/{id}")
	public ResponseEntity<?> delete(@PathVariable(value="id") Long userId) {
		UserModel userModel = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("UserModel", "id", userId));

		userRepository.delete(userModel);
		
		return ResponseEntity.ok().build();
	}

}
