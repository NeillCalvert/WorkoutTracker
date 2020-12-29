/**
 * 
 */
package com.neill.workouttracker.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.neill.workouttracker.model.Exercise;

/**
 * @author neill
 *
 */
@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long>{
	@Query("SELECT e FROM Exercise e INNER JOIN Workout w ON e.workout.id = w.id WHERE w.id = ?1")
	List<Exercise> getExercisesByWorkout(long id);
	
	@Query("SELECT e FROM Exercise e INNER JOIN Workout w ON e.workout.id = w.id INNER JOIN User u ON w.user.id = u.id WHERE e.id = ?1 AND u.userName = ?2")
	Exercise getOne(long id, String userName);
	
}
