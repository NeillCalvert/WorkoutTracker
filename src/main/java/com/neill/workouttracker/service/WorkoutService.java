package com.neill.workouttracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.neill.workouttracker.dao.WorkoutRepository;
import com.neill.workouttracker.model.Workout;

@Component
public class WorkoutService {

	public WorkoutService() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	private WorkoutRepository workoutRepository;
	
	@Autowired 
	private UserDetailsServiceImpl userDetailsService;
	
	public List<Workout> getAllWorkouts(String userName){
		return workoutRepository.findAllWorkoutsForUser(userName);
	}
	
	public Workout getWorkoutById(long id) {
		return workoutRepository.getOne(id);
	}
	
	public Workout addNewWorkout(Workout newWorkout, String userName) {
		newWorkout.setUser(userDetailsService.findUserByUserName(userName));
		return workoutRepository.save(newWorkout);
	}
	
	public void deleteWorkoutById(long id) {
		workoutRepository.deleteById(id);
	}

}
