/**
 * 
 */
package com.neill.workouttracker.service;

import java.util.List;

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
	
	public List<ExerciseRecord> getAllExerciseRecordByExercise(long id) {
		return exerciseRecordRepository.getAllExerciseRecordsForExercise(id);
	}
	
	public ExerciseRecord addNewExerciseRecord(ExerciseRecord exerciseRecord) {
		return exerciseRecordRepository.save(exerciseRecord);
	}
	
	public void deleteExerciseRecordById(long id) {
		exerciseRecordRepository.deleteById(id);
	}

}
