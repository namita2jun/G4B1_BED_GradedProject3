package com.greatlearning.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.greatlearning.entity.Tickets;

@Repository
public interface TicketsRepository  extends JpaRepository<Tickets, Integer>{
	
	 //Custom query
	 @Query(value = "select * from Tickets t where t.title like %:query% or t.shortDescription like %:query%", nativeQuery = true)
	 List<Tickets> findByKeyword(@Param("query") String query);
	}


