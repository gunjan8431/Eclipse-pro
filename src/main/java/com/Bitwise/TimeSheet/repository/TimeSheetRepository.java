package com.Bitwise.TimeSheet.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Bitwise.TimeSheet.model.Resource;
import com.Bitwise.TimeSheet.model.TimeSheet;
@Repository
public interface TimeSheetRepository extends JpaRepository<TimeSheet, Integer> {
     
	List<TimeSheet> findByMonth(String month);

	@Transactional
	@Query(value = "SELECT SUM(m.total) FROM time_sheet m where m.month=?1", nativeQuery = true)
	Integer totalSum(String month);
}
