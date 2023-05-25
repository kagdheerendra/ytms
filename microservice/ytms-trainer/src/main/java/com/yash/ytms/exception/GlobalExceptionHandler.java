package com.yash.ytms.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import feign.FeignException;

/**
 * This class will handle the exception
 * 
 * @author dheerendra.kag
 *
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
	
	/**
	 * This method will handle the bad request exception
	 * 
	 * @param ex predefine argument not valid exception
	 * @return the handler message
	 */
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
		Map<String, String> map = new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(e -> {
			map.put(e.getField(), e.getDefaultMessage());
		});
		return map;
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(TrainerNotFound.class)
	private ResponseEntity<Object> resourceNotFoundException(TrainerNotFound ex) {

		Map<String, String> map = new HashMap<String, String>();
		map.put("error", ex.getMessage());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(FeignException.NotFound.class)
	private ResponseEntity<Object> feignExceptionHandler(FeignException.NotFound ex) {

		Map<String, String> map = new HashMap<String, String>();
		map.put("error", ex.getMessage());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
	}
}