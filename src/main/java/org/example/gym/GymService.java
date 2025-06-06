package org.example.gym;

import com.t4a.annotations.Action;
import com.t4a.annotations.Agent;
import com.t4a.detect.ActionCallback;
import com.t4a.processor.AIProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Agent(groupName = "gymOperations", groupDescription = "Manage gym operations like finding trainers and workouts")
@Slf4j
public class GymService {

    /**
     * Each action has access to AIProcessor and ActionCallback which are autowired by tools4ai
     */
    private ActionCallback callback;

    /**
     * Each action has access to AIProcessor and ActionCallback which are autowired by tools4ai
     */
    private AIProcessor processor;

    public GymService() {
        log.info("Created Gym Service");
    }

    @Action(description = "Find a trainer for a specific workout")
    public String findTrainer(String workoutType) {
        log.info("Finding trainer for workout type '{}'", workoutType);
        // Simulate trainer lookup
        if ("Yoga".equalsIgnoreCase(workoutType)) {
            return "Trainer: Alice";
        } else if ("Weightlifting".equalsIgnoreCase(workoutType)) {
            return "Trainer: Bob";
        } else {
            return "No trainer available for the specified workout type";
        }
    }

    @Action(description = "Find a workout plan based on fitness goals")
    public String findWorkout(String fitnessGoal) {
        log.info("Finding workout plan for fitness goal '{}'", fitnessGoal);
        // Simulate workout plan lookup
        if ("Lose Weight".equalsIgnoreCase(fitnessGoal)) {
            return "Workout Plan: Cardio and HIIT";
        } else if ("Build Muscle".equalsIgnoreCase(fitnessGoal)) {
            return "Workout Plan: Strength Training and Protein Diet";
        } else {
            return "No workout plan available for the specified fitness goal";
        }
    }

    @Action(description = "Get the best biceps workouts")
    public String bestBicepsWorkouts() {
        log.info("Fetching best biceps workouts");
        return "Best Biceps Workouts: Barbell Curls, Hammer Curls, Concentration Curls";
    }

    @Action(description = "Get calorie information for a specific workout")
    public String getCalorieInfo(String workoutType) {
        log.info("Getting calorie information for workout type '{}'", workoutType);
        // Simulate calorie information lookup
        if ("Running".equalsIgnoreCase(workoutType)) {
            return "Calories burned per hour: 600";
        } else if ("Cycling".equalsIgnoreCase(workoutType)) {
            return "Calories burned per hour: 500";
        } else {
            return "Calorie information not available for the specified workout type";
        }
    }
}
