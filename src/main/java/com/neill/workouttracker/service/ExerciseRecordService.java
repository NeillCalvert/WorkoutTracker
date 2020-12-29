/**
 * 
 */
package com.neill.workouttracker.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
		if (getExerciseRecordById(id, request) != null) {
			exerciseRecordRepository.deleteById(id);
		}
	}

	public Double getPersonalBestWeight(List<ExerciseRecord> records) {
		Double personalBest = 0.0;
		Double retrievedWeight;
		for (ExerciseRecord record : records) {
			retrievedWeight = record.getWeight();
			if (retrievedWeight > personalBest) {
				personalBest = retrievedWeight;
			}
		}
		return personalBest;
	}

	public Date[] getExerciseDates(List<ExerciseRecord> records) {
		Date[] exerciseDates = new Date[records.size()];
		for (int i = 0; i < records.size(); i++) {
			exerciseDates[i] = records.get(i).getDate();
		}
		
		Arrays.sort(exerciseDates);
		return exerciseDates;
	}

	public Double[] getExerciseWeights(List<ExerciseRecord> records) {
		Double[] exerciseWeights = new Double[records.size()];
		for(int i = 0; i < records.size(); i++) {
			exerciseWeights[i] = records.get(i).getWeight();
		}		
		Collections.reverse(Arrays.asList(exerciseWeights)); 
		
		return exerciseWeights;	
	}
	


}
