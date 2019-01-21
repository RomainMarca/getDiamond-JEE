package com.example.getdiamond.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.getdiamond.models.JewelryModel;

@Repository
public interface JewelryRepository extends JpaRepository<JewelryModel, Long> {

}
