/**
 * 
 */
package com.neill.workouttracker.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.neill.workouttracker.model.ExerciseRecord;

import com.neill.workouttracker.dao.ExerciseRecordRepository;

/**
 * @author neill
 *
 */
@Component
public class ExerciseRecordService {
	
	@Autowired
	private ExerciseRecordRepository exerciseRecordRepository;

	/**
	 * 
	 */
	public ExerciseRecordService() {
		// TODO Auto-generated constructor stub
	}
	
	public List<ExerciseRecord> getAllExerciseRecordsByExercise(long id, HttpServletRequest request) {
		return exerciseRecordRepository.getAllExerciseRecordsForExercise(id, request.getUserPrincipal().getName());
	}
	
	public ExerciseRecord addNewExerciseRecord(ExerciseRecord exerciseRecord) {
		return exerciseRecordRepository.save(exerciseRecord);
	}
	
	public ExerciseRecord getExerciseRecordById(long id, HttpServletRequest request) {
		return exerciseRecordRepository.getOne(id, request.getUserPrincipal().getName());
	}
	
	public void deleteExerciseRecordById(long id, HttpServletRequest request) {
		if(getExerciseRecordById(id, request) != null) {
			exerciseRecordRepository.deleteById(id);
		}
	}

}
