package com.neill.workouttracker.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.sun.istack.NotNull;

@Entity
public class ExerciseRecord {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EXERCISERECORD_ID")
	@NotNull
	private long id;
	private int sets;
	private int reps;
	private double weight;
	@ManyToOne
	@JoinColumn(name = "EXERCISE_ID")
	private Exercise exercise;
	private Date date;

	public ExerciseRecord() {
		// TODO Auto-generated constructor stub
	}
	
	public ExerciseRecord(int sets, int reps, double weight) {

		this.sets = sets;
		this.reps = reps;
		this.weight = weight;
	}

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public int getSets() {
		return sets;
	}


	public void setSets(int sets) {
		this.sets = sets;
	}


	public int getReps() {
		return reps;
	}


	public void setReps(int reps) {
		this.reps = reps;
	}


	public double getWeight() {
		return weight;
	}


	public void setWeight(double weight) {
		this.weight = weight;
	}

	public Exercise getExercise() {
		return exercise;
	}

	public void setExercise(Exercise exercise) {
		this.exercise = exercise;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
