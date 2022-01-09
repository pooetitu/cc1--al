package com.al.cc2.domain.models;

import com.al.cc2.domain.ids.SkillID;
import com.al.cc2.kernel.Entity;

public class Skill implements Entity<SkillID> {
    private SkillID skillID;

    @Override
    public SkillID id() {
        return skillID;
    }
}
