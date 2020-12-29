package com.neill.workouttracker.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.neill.workouttracker.dao.WorkoutRepository;
import com.neill.workouttracker.model.Workout;

@Component
public class WorkoutService {
	
	Logger logger = LoggerFactory.getLogger(WorkoutService.class);

	public WorkoutService() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	private WorkoutRepository workoutRepository;
	
	@Autowired 
	private UserDetailsServiceImpl userDetailsService;
	
	public List<Workout> getAllWorkouts(HttpServletRequest request){
		
		return workoutRepository.findAllWorkoutsForUser(request.getUserPrincipal().getName());
	}
	
	public Workout getWorkoutById(long id, HttpServletRequest request) {
		return workoutRepository.getOne(id, request.getUserPrincipal().getName());
	}
	
	public Workout addNewWorkout(Workout newWorkout, HttpServletRequest request) {
		
		newWorkout.setUser(userDetailsService.findUserByUserName(request.getUserPrincipal().getName()));
		return workoutRepository.save(newWorkout);
	}
	
	public void deleteWorkoutById(long id, HttpServletRequest request) {
		if(getWorkoutById(id, request) != null) {
			workoutRepository.deleteById(id);
		}
	}

}
