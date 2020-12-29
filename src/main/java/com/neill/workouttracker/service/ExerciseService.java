/**
 * 
 */
package com.neill.workouttracker.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.neill.workouttracker.dao.ExerciseRepository;
import com.neill.workouttracker.model.Exercise;

/**
 * @author neill
 *
 */
@Component
public class ExerciseService {

	/**
	 * 
	 */
	public ExerciseService() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	private ExerciseRepository exerciseRepository;

	public List<Exercise> getAllExercise() {
		return exerciseRepository.findAll();
	}

	public Exercise getExerciseById(long id, HttpServletRequest request) {
		return exerciseRepository.getOne(id, request.getUserPrincipal().getName());
	}

	public Exercise addNewExercise(Exercise newExercise) {
		return exerciseRepository.save(newExercise);
	}

	public void deleteExercise(long id, HttpServletRequest request) {
		if(getExerciseById(id, request) != null) {
			exerciseRepository.deleteById(id);
		}
	}
	
	public List<Exercise> getExerciseByWorkout(long id){
		return exerciseRepository.getExercisesByWorkout(id);
	}
}
