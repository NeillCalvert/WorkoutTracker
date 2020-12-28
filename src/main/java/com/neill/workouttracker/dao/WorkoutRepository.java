/**
 * 
 */
package com.neill.workouttracker.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.neill.workouttracker.model.Workout;

/**
 * @author neill
 *
 */
@Repository
public interface WorkoutRepository extends JpaRepository<Workout, Long>{
	@Query("SELECT w FROM Workout w INNER JOIN User u ON w.user.id = u.id WHERE u.userName = ?1")
	List<Workout> findAllWorkoutsForUser(String userName);
}
