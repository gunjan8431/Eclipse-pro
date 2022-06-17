package com.Bitwise.TimeSheet.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Bitwise.TimeSheet.model.Resource;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Integer> {

	@Transactional
	public Resource save(Resource resource);



}
