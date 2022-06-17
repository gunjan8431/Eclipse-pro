package com.Bitwise.TimeSheet.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.Bitwise.TimeSheet.exception.ResourceNotFound;
import com.Bitwise.TimeSheet.model.Resource;
import com.Bitwise.TimeSheet.model.TimeSheet;

import com.Bitwise.TimeSheet.repository.ResourceRepository;
import com.Bitwise.TimeSheet.repository.TimeSheetRepository;

import com.Bitwise.TimeSheet.service.TimeSheetService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TimeSheetServiceImpl implements TimeSheetService {

	@Autowired
	ResourceRepository resourceRepo;
	@Autowired
	TimeSheetRepository timesheetrepo;

	@Transactional
	@Override
	public Resource saveData(Resource resource) {
		try {
			for (TimeSheet timesheet : resource.getTimesheet()) {
				String f = timesheet.getMonth().toLowerCase();
				timesheet.setMonth(f);
				int sum = timesheet.getWeek1() + timesheet.getWeek2() + timesheet.getWeek3() + timesheet.getWeek4() + timesheet.getWeek5();
				timesheet.setTotal(sum);
				timesheet.setResource(resource);
				timesheetrepo.save(timesheet);
			}
		} catch (Exception e) {
			return null;
		}

		return resourceRepo.save(resource);
	}

	@Override
	public List<TimeSheet> getbymonth(String month) {
		String h = month.toLowerCase();
		return timesheetrepo.findByMonth(h);
	}

	@Override
	public TimeSheet updatedata(int timeSheetId, TimeSheet timesheet) {
		try {
			timesheet.setTimeSheetId(timeSheetId);
			log.info(timesheet.getResource().getResourceName());
			int sum = timesheet.getWeek1() + timesheet.getWeek2() + timesheet.getWeek3() + timesheet.getWeek4() + timesheet.getWeek5();
			timesheet.setTotal(sum);
			Optional<Resource> resource = resourceRepo.findById(timesheet.getResource().getResourceId());
			resource.get().setTeam(timesheet.getResource().getTeam());
			resource.get().setResourceName(timesheet.getResource().getResourceName());
			timesheet.setResource(resource.get());
		} catch (Exception e) {
			return null;
		}

		return timesheetrepo.save(timesheet);
	}

	@Override
	public Optional<TimeSheet> getsingledata(int timeSheetId) {

		return timesheetrepo.findById(timeSheetId);
	}

	@Override
	public Integer getsum(String month) {
		String h = month.toLowerCase();
		Integer g = timesheetrepo.totalSum(h);
		log.info("sum " + g);
		return g;
	}

	@Override
	public String deleteByid(int timeSheetId) {

		timesheetrepo.deleteById(timeSheetId);
		return "deleted";
	}
}
