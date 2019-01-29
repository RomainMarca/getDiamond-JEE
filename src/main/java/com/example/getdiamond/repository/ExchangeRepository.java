package com.example.getdiamond.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.getdiamond.models.ExchangeModel;

@Repository
public interface ExchangeRepository extends JpaRepository<ExchangeModel, Long> {

}
