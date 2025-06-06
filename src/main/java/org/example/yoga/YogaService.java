package org.example.yoga;

import com.t4a.annotations.Action;
import com.t4a.annotations.Agent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Agent(groupName = "yogaOperations", groupDescription = "Manage yoga operations like finding asanas, meditation techniques and breathing exercises")
@Slf4j
public class YogaService {

    public YogaService() {
        log.info("Created Yoga Service");
    }

    @Action(description = "Get a list of beginner yoga poses")
    public String getBeginnerPoses() {
        log.info("Fetching beginner yoga poses");
        return "Beginner Yoga Poses: Mountain Pose (Tadasana), Child's Pose (Balasana), Cat-Cow Stretch (Marjaryasana-Bitilasana), Downward Dog (Adho Mukha Svanasana)";
    }

    @Action(description = "Get meditation techniques")
    public String getMeditationTechniques() {
        log.info("Fetching meditation techniques");
        return "Meditation Techniques: Mindfulness Meditation, Transcendental Meditation, Body Scan Meditation, Loving-Kindness Meditation";
    }

    @Action(description = "Get breathing exercises")
    public String getBreathingExercises() {
        log.info("Fetching breathing exercises");
        return "Breathing Exercises: Anulom Vilom (Alternate Nostril Breathing), Kapalbhati (Skull Shining Breath), Bhramari (Bee Breath), Ujjayi (Ocean Breath)";
    }

    @Action(description = "Find yoga sequence for specific goal")
    public String findYogaSequence(String goal) {
        log.info("Finding yoga sequence for goal: '{}'", goal);
        if ("stress relief".equalsIgnoreCase(goal)) {
            return "Stress Relief Sequence: Child's Pose → Cat-Cow Stretch → Forward Fold → Legs Up the Wall → Savasana";
        } else if ("flexibility".equalsIgnoreCase(goal)) {
            return "Flexibility Sequence: Sun Salutations → Warrior Series → Triangle Pose → Pigeon Pose → Forward Folds";
        } else if ("strength".equalsIgnoreCase(goal)) {
            return "Strength Sequence: Chaturanga → Warrior Series → Chair Pose → Plank Variations → Crow Pose";
        } else {
            return "No specific sequence available for the specified goal. Try: stress relief, flexibility, or strength";
        }
    }
}
