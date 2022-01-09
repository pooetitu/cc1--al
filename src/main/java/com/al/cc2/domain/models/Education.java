package com.al.cc2.domain.models;

import com.al.cc2.domain.ids.EducationID;
import com.al.cc2.kernel.Entity;

public class Education implements Entity<EducationID> {
    private EducationID educationID;
    private String name;

    @Override
    public EducationID id() {
        return educationID;
    }
}
