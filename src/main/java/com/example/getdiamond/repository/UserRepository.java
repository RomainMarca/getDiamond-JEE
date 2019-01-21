package com.example.getdiamond.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.getdiamond.models.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

}
