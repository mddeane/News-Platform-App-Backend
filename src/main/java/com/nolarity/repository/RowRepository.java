package com.nolarity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nolarity.model.Row;

@Repository
public interface RowRepository extends JpaRepository<Row, Long>{
	
}
