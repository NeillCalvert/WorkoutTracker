/**
 * 
 */
package com.neill.workouttracker.controller;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neill.workouttracker.model.Exercise;
import com.neill.workouttracker.model.ExerciseRecord;
import com.neill.workouttracker.model.Workout;
import com.neill.workouttracker.service.ExerciseRecordService;
import com.neill.workouttracker.service.ExerciseService;
import com.neill.workouttracker.service.WorkoutService;

/**
 * @author neill
 *
 */
@Controller
public class ExerciseController {
	
	@Autowired
	private WorkoutService workoutService;
	
	@Autowired
	private ExerciseService exerciseService;
	
	@Autowired
	private ExerciseRecordService exerciseRecordService;

	/**
	 * 
	 */
	public ExerciseController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping("/addExercise/{id}")
	public String addExercise(@PathVariable("id") long id, Model model, HttpServletRequest request){
		Workout workout = workoutService.getWorkoutById(id, request);
		Exercise exercise = new Exercise();

		model.addAttribute("workout", workout);
		model.addAttribute("exercise", exercise);
		return "addExercise";
	}
	
	@RequestMapping("/saveExercise/{id}")
	public String saveExercise(@PathVariable("id") long id, Exercise exercise, HttpServletRequest request) {
		Workout workout = workoutService.getWorkoutById(id, request);
		
		exercise.setWorkout(workout);
		exerciseService.addNewExercise(exercise);
		return "redirect:../workoutDetails/" + id;
	}
	
	@RequestMapping("/deleteExercise/{workoutId}/{exerciseId}")
	public String deleteExercise(@PathVariable("workoutId")long workoutId, @PathVariable("exerciseId")long exerciseId, HttpServletRequest request) {		
		exerciseService.deleteExercise(exerciseId, request);
		return "redirect:../../workoutDetails/" + workoutId;
	}
	
	@RequestMapping("/exerciseDetails/{id}")
	public String getExerciseDetails(@PathVariable("id") long id, Model model, HttpServletRequest request) {
		Exercise exercise = exerciseService.getExerciseById(id,request);
		List<ExerciseRecord> exerciseRecords = exerciseRecordService.getAllExerciseRecordsByExercise(id, request);
		Double personalBestWeight = exerciseRecordService.getPersonalBestWeight(exerciseRecords);
		Date[] exerciseDates = exerciseRecordService.getExerciseDates(exerciseRecords);
		Double[] exerciseWeights = exerciseRecordService.getExerciseWeights(exerciseRecords);
		
		model.addAttribute("exercise", exercise);
		model.addAttribute("exerciseRecordList", exerciseRecords);
		model.addAttribute("personalBestWeight", personalBestWeight);
		model.addAttribute("label", exerciseDates);
		model.addAttribute("data", exerciseWeights);
		return "exerciseDetails";
	}
	
	@RequestMapping("/addExerciseDetails/{id}")
	public String addExerciseRecord(@PathVariable("id") long id, Model model, HttpServletRequest request){
		Exercise exercise = exerciseService.getExerciseById(id, request);
		ExerciseRecord exerciseRecord = new ExerciseRecord();
		
		model.addAttribute("exercise", exercise);
		model.addAttribute("exerciseRecord", exerciseRecord);
		return "addExerciseDetails";
	}
	
	@RequestMapping("/saveExerciseDetails/{id}")
	public String saveExerciseDetails(@PathVariable("id") long id, ExerciseRecord exerciseRecord, HttpServletRequest request) {
		Exercise exercise = exerciseService.getExerciseById(id, request);
		java.util.Date javaDate = new java.util.Date();
		Date date = new Date(javaDate.getTime());
		
		exerciseRecord.setDate(date);
		exerciseRecord.setExercise(exercise);
		exerciseRecordService.addNewExerciseRecord(exerciseRecord);
		
		return "redirect:/exerciseDetails/" + id;
	}
	
	@RequestMapping("/deleteExerciseRecord/{exerciseId}/{exerciseRecordId}")
	public String deleteExerciseDetails(@PathVariable("exerciseId")long exerciseId, @PathVariable("exerciseRecordId")long exerciseRecordId, HttpServletRequest request) {
		exerciseRecordService.deleteExerciseRecordById(exerciseRecordId, request);
		return "redirect:../../exerciseDetails/" + exerciseId;
	}
	
	

}