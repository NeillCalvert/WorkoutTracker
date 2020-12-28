/**
 * 
 */
package com.neill.workouttracker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.sun.istack.NotNull;

/**
 * @author neill
 *
 */
@Entity
public class Exercise {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EXERCISE_ID")
	@NotNull
	private long exerciseId;
	@NotNull
	private String exerciseName;
	@ManyToOne
	@JoinColumn(name = "WORKOUT_ID")
	private Workout workout;
	

	/**
	 * 
	 */
	public Exercise() {
		// TODO Auto-generated constructor stub
	}
	
	public Exercise(String exerciseName, Workout workout) {
		this.exerciseName = exerciseName;
		this.workout = workout;
	}

	public long getExerciseId() {
		return exerciseId;
	}

	public void setExerciseId(long exerciseId) {
		this.exerciseId = exerciseId;
	}

	public String getExerciseName() {
		return exerciseName;
	}

	public void setExerciseName(String exerciseName) {
		this.exerciseName = exerciseName;
	}

	public Workout getWorkout() {
		return workout;
	}

	public void setWorkout(Workout workout) {
		this.workout = workout;
	}

}
