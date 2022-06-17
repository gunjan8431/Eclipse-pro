package com.Bitwise.TimeSheet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.Bitwise.TimeSheet.exception.ResourceNotFound;
import com.Bitwise.TimeSheet.model.Resource;
import com.Bitwise.TimeSheet.model.TimeSheet;


public interface TimeSheetService {

	public Resource saveData(Resource resource);


	public List<TimeSheet> getbymonth(String month);


	public TimeSheet updatedata(int timeSheetId, TimeSheet timesheet);


	public Optional<TimeSheet> getsingledata(int timeSheetId);


	public Integer getsum(String month);


	public String deleteByid(int timeSheetId);


	
	
}
