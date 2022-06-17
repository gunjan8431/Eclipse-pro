package com.Bitwise.TimeSheet.exception;


import java.util.Date;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiError {
	
	private Date tdate;
	private HttpStatus error;
	private String path;
	private String message;

}
