/**
 * 
 */
package com.neill.workouttracker.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.neill.workouttracker.model.ExerciseRecord;

/**
 * @author neill
 *
 */
@Repository
public interface ExerciseRecordRepository extends JpaRepository<ExerciseRecord, Long>{
	//@Query("SELECT r FROM ExerciseRecord r INNER JOIN Exercise e ON r.exercise.id = e.id WHERE e.id = ?1 ORDER BY date DESC")
	@Query("SELECT r FROM ExerciseRecord r INNER JOIN Exercise e ON r.exercise.id = e.id INNER JOIN Workout w ON e.workout.id = w.id INNER JOIN User u ON w.user.id = u.id WHERE e.id = ?1 AND u.userName = ?2 ORDER BY date DESC")
	List<ExerciseRecord> getAllExerciseRecordsForExercise(long id, String userName);
	
	@Query("SELECT r FROM ExerciseRecord r INNER JOIN Exercise e ON r.exercise.id = e.id INNER JOIN Workout w ON e.workout.id = w.id INNER JOIN User u ON w.user.id = u.id WHERE r.id = ?1 AND u.userName = ?2")
	ExerciseRecord getOne(long id, String userName);
}
