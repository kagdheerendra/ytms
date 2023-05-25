package com.yash.ytms.service.impl;

import java.util.List;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yash.ytms.entity.TrainingRequestForm;
import com.yash.ytms.exception.TRFNotFound;
import com.yash.ytms.repository.TRFRepository;
import com.yash.ytms.service.TRFService;

/**
 * This class will responsible to define the operation which going to perform with database
 * @author dheerendra.kag
 * @version 1.0
 * @since 05/05/2023
 */
@Service
public class TRFServiceImpl implements TRFService{

	/**
	 * This will inject the repository dependency
	 */
	@Autowired
	private TRFRepository trfRepository;

	/**
	 * This method will create and save the training request
	 */
	@Transactional
	@Override
	public TrainingRequestForm createTRF(TrainingRequestForm form) {
		form.setStatus("PENDING");
		return trfRepository.save(form);
	}

	/**
	 * This method will fetch the all training request form data
	 */
	@Override
	public List<TrainingRequestForm> getAllTrf() {
		return trfRepository.findAll();	
	}

	/**
	 * This method will fetch the training request form by id
	 * @throws TRFNotFound will throw not found excpetion
	 */
	@Override
	public TrainingRequestForm getById(Long Id) throws TRFNotFound {
		return trfRepository.findById(Id).orElseThrow(()-> new TRFNotFound("Not Found"));
	}

	/**
	 * This method will update the existing record
	 * @throws TRFNotFound 
	 */
	@Transactional
	@Override
	public TrainingRequestForm updateTRF(Long id, TrainingRequestForm form) throws TRFNotFound {
		TrainingRequestForm rform = trfRepository.findById(id).orElseThrow(()-> new TRFNotFound("Not Found"));
		rform.setAssociates(form.getAssociates());
		rform.setTrainingType(form.getTrainingType());
		rform.setResourceType(form.getResourceType());
		rform.setDuration(form.getDuration());
		rform.setPurposeOfTraining(form.getPurposeOfTraining());
		rform.setInitiatedFrom(form.getInitiatedFrom());
		rform.setProjectName(form.getProjectName());
		rform.setSkillToBeImpartent(form.getSkillToBeImpartent());
		rform.setNoOfParticipants(form.getNoOfParticipants());
		rform.setStartDate(form.getStartDate());
		rform.setEndDate(form.getEndDate());
		return trfRepository.save(rform);
	}
}
