package com.restdatabase.manytomany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restdatabase.manytomany.model.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, Integer>{

//	Publisher findOne(int id);

}
