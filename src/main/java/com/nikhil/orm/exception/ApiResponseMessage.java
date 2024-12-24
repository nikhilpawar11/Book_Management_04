package com.nikhil.orm.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponseMessage {
	
	private String message;
	
	private boolean success;
	
	private HttpStatus status;

}
