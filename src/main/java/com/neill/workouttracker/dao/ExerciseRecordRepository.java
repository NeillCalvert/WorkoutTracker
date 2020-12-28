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
	@Query("SELECT r FROM ExerciseRecord r INNER JOIN Exercise e ON r.exercise.id = e.id WHERE e.id = :id ORDER BY date DESC")
	List<ExerciseRecord> getAllExerciseRecordsForExercise(long id);

}
