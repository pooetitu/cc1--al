package com.al.cc2.domain.models;

import com.al.cc2.domain.ids.ProjectID;
import com.al.cc2.kernel.Entity;
import com.al.cc2.use_cases.location.domain.Location;

import java.util.List;

public class Project implements Entity<ProjectID> {
    private ProjectID projectID;
    private List<Skill> neededSkills;
    private Location location;
    private float dailyCost;
    private int duration;

    @Override
    public ProjectID id() {
        return projectID;
    }

    public List<Skill> getNeededSkills() {
        return neededSkills;
    }

    public Location getLocation() {
        return location;
    }

    public float getDailyCost() {
        return dailyCost;
    }

    public int getDuration() {
        return duration;
    }
}
