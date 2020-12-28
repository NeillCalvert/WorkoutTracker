/**
 * 
 */
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

/**
 * @author neill
 *
 */
@Entity
public class Workout {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "WORKOUT_ID")
	@NotNull
	private long workoutId;
	// private Date workoutDate;
	@NotNull
	private String workoutName;
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private User user;

	/**
	 * 
	 */
	public Workout() {
		// TODO Auto-generated constructor stub
	}

	public Workout(String workoutName) {

		this.workoutName = workoutName;
	}

//	public Date getWorkoutDate() {
//		return workoutDate;
//	}
//
//	public void setWorkoutDate(Date workoutDate) {
//		this.workoutDate = workoutDate;
//	}
	
	public long getWorkoutId() {
		return workoutId;
	}

	public void setWorkoutId(long workoutId) {
		this.workoutId = workoutId;
	}

	public String getWorkoutName() {
		return workoutName;
	}

	public void setWorkoutName(String workoutName) {
		this.workoutName = workoutName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
