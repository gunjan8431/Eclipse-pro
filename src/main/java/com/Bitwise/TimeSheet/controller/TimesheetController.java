package com.Bitwise.TimeSheet.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Bitwise.TimeSheet.exception.ResourceNotFound;
import com.Bitwise.TimeSheet.model.Resource;
import com.Bitwise.TimeSheet.model.TimeSheet;

import com.Bitwise.TimeSheet.service.TimeSheetService;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin("*")
@RestController
@Slf4j
public class TimesheetController {
	@Autowired
	TimeSheetService timeSheetService;

	
	@PostMapping("/post")
	public ResponseEntity<Resource> postData(@RequestBody Resource resource) throws ResourceNotFound {
		Resource res=timeSheetService.saveData(resource);
		if(res!=null)
		{
		return new ResponseEntity<Resource>(timeSheetService.saveData(resource), HttpStatus.CREATED);
		}
		else
		{
			throw new ResourceNotFound("not saved");	}
		}
	
	
	@GetMapping("/getbymonth/{month}")
	public ResponseEntity<List<TimeSheet>> getbymonth(@PathVariable String month) throws ResourceNotFound
	{
		List<TimeSheet>l=timeSheetService.getbymonth(month);
		if(!l.isEmpty())
		{
		return new ResponseEntity<List<TimeSheet>>(timeSheetService.getbymonth(month),HttpStatus.OK) ;
	    }
		else
		{
			return new ResponseEntity<List<TimeSheet>>(timeSheetService.getbymonth(month),HttpStatus.NO_CONTENT) ;
		}
	}

	@PutMapping("/update/{timeSheetId}")
	public ResponseEntity<TimeSheet> updatadata(@PathVariable int timeSheetId, @RequestBody TimeSheet timesheet)throws ResourceNotFound
	{ if((timeSheetService.updatedata(timeSheetId,timesheet)!=null))
			{
		return new ResponseEntity<TimeSheet>(timeSheetService.updatedata(timeSheetId,timesheet),HttpStatus.OK) ;
	}
	else
	{
		throw new ResourceNotFound("not saved");	}
	}
	
	@GetMapping("/getsingledata/{timeSheetId}") 
	public ResponseEntity<Optional<TimeSheet>> getsingledata(@PathVariable int timeSheetId)
	{
		if(timeSheetService.getsingledata(timeSheetId).isPresent())
		{
		return   new ResponseEntity<Optional<TimeSheet>>(timeSheetService.getsingledata(timeSheetId),HttpStatus.OK) ;
	}
		else
		{
			return new ResponseEntity<Optional<TimeSheet>>(timeSheetService.getsingledata(timeSheetId),HttpStatus.NO_CONTENT) ;
		}
	}
	
	@GetMapping("/getsum/{month}")
	public ResponseEntity<Integer>  getsum(@PathVariable String month)
	{
		Integer s=timeSheetService.getsum(month);
		if(s!=null)
		{
		return  new ResponseEntity<Integer>(timeSheetService.getsum(month),HttpStatus.OK);
	     }
		else
		{
			return  new ResponseEntity<Integer>(timeSheetService.getsum(month),HttpStatus.NO_CONTENT);
		}
	}
	
	

	
	
}
