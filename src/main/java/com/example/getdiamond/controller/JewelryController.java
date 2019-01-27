package com.example.getdiamond.controller;

import java.util.ArrayList;
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
import com.example.getdiamond.models.JewelryModel;
import com.example.getdiamond.repository.JewelryRepository;

@RestController
@RequestMapping("/api")
public class JewelryController {

	
	@Autowired
	JewelryRepository jewelryRepository;
	
		//get all
		@GetMapping("/jewelry")
		public List<JewelryModel> getAll() {
			return jewelryRepository.findAll();
		}
		
		//get all false
		@GetMapping("/jewelryfalse")
		public List<JewelryModel> getAllfalse() {
			ArrayList<JewelryModel> newJewelList = new ArrayList<>();
			ArrayList<JewelryModel> jewerList = (ArrayList<JewelryModel>) jewelryRepository.findAll();
			for (JewelryModel jewel: jewerList) {
				if (!jewel.isBuilt()) {
					newJewelList.add(jewel);
				}
			}
			return newJewelList;
		}
		
		
		
		//GetMapping single
		@ GetMapping("/jewelry/{id}")
		public JewelryModel getById(@PathVariable (value = "id") Long jewelryId) {
			return jewelryRepository.findById(jewelryId)
					.orElseThrow(() -> new ResourceNotFoundException("JewelryModel", "id", jewelryId));
		}
		
		//create
		@PostMapping("/jewelry")
		public JewelryModel create(@Valid @RequestBody JewelryModel jewelry) {
			return jewelryRepository.save(jewelry);
		}
		
		@PutMapping("/jewelry/{id}")
		public JewelryModel update(@PathVariable (value = "id") Long jewelryId,
				@Valid @RequestBody JewelryModel jewelryDetails) {
			
			JewelryModel jewelry = jewelryRepository.findById(jewelryId)
					.orElseThrow(() -> new ResourceNotFoundException("JewelryModel", "id", jewelryId));
		
			jewelry.setName(jewelryDetails.getName());
			//jewelry.setId(jewelryDetails.getId());
			jewelry.setResale(jewelryDetails.getResale());
			jewelry.setGain(jewelryDetails.getGain());
			jewelry.setBuilt(jewelryDetails.isBuilt());
			jewelry.setDiamond(jewelryDetails.getDiamond());
			jewelry.setRuby(jewelryDetails.getRuby());
			jewelry.setOpal(jewelryDetails.getOpal());
			jewelry.setEmerald(jewelryDetails.getEmerald());
			jewelry.setLastBuilt(jewelryDetails.getLastBuilt());
			
			JewelryModel update = jewelryRepository.save(jewelry);
			return update;
		}
		
		//delete
		@DeleteMapping("/jewelry/{id}")
		public ResponseEntity<?> delete(@PathVariable(value="id") Long jewelryId) {
			JewelryModel jewelry = jewelryRepository.findById(jewelryId)
					.orElseThrow(() -> new ResourceNotFoundException("JewelryModel", "id", jewelryId));

			jewelryRepository.delete(jewelry);
			
			return ResponseEntity.ok().build();
		}
	
}
