package com.yash.ytms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.yash.ytms.entity.TrainingRequestForm;
import com.yash.ytms.exception.TRFNotFound;

/**
 * This class will responsible to declare the operation which will going to perform with database table
 * @author dheerendra.kag
 * @version 1.0
 * @since 05/05/2023
 */
@Service
public interface TRFService {

	public TrainingRequestForm createTRF(TrainingRequestForm form);
	public List<TrainingRequestForm> getAllTrf();
	public TrainingRequestForm getById(Long Id) throws TRFNotFound;
	public TrainingRequestForm updateTRF(Long id, TrainingRequestForm form) throws TRFNotFound;
}
