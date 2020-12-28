/**
 * 
 */
package com.neill.workouttracker.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neill.workouttracker.model.Workout;
import com.neill.workouttracker.service.ExerciseService;
import com.neill.workouttracker.service.WorkoutService;

/**
 * @author neill
 *
 */
@Controller
public class WorkoutController {
	
	 Logger log = LoggerFactory.getLogger(WorkoutController.class);

	@Autowired
	private WorkoutService workoutService;
	
	@Autowired
	private ExerciseService exerciseService;
	
	/**
	 * 
	 */
	public WorkoutController() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping("/workouts")
	public String listWorkouts(Model model, HttpServletRequest request) {
		model.addAttribute("workoutList", workoutService.getAllWorkouts(request.getUserPrincipal().getName()));
		return "workouts";
	}

	@RequestMapping("/saveWorkout")
	public String saveWorkout(@ModelAttribute("workout") Workout workout, HttpServletRequest request) {
		Principal principal = request.getUserPrincipal();
		
		workoutService.addNewWorkout(workout, principal.getName());
		return "redirect:/workouts";
	}

	@RequestMapping("/newWorkout")
	public String showNewForm(Model model) {
		Workout workout = new Workout();
		model.addAttribute("workout", workout);
		return "addWorkout";
	}
	
	@RequestMapping("/workoutDetails/{id}")
	public String showWorkoutDetails(@PathVariable("id")long id, Model model) {
		
		
		model.addAttribute("workout", workoutService.getWorkoutById(id));
		model.addAttribute("exerciseList", exerciseService.getExerciseByWorkout(id));
		return "workoutDetails";
	}
	
	@RequestMapping("/deleteWorkout/{id}")
	public String deleteWorkout(@PathVariable("id")long id) {
		workoutService.deleteWorkoutById(id);
		return  "redirect:/workouts";
	}
}
