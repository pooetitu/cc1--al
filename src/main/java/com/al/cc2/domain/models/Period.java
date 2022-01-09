package com.al.cc2.domain.models;

import com.al.cc2.domain.ids.PeriodID;
import com.al.cc2.kernel.Entity;

public class Period implements Entity<PeriodID> {
    private PeriodID periodID;
    private int duration;
    private Periodicity periodicity;

    @Override
    public PeriodID id() {
        return periodID;
    }

    public int getDuration() {
        return duration;
    }

    public Periodicity getPeriodicity() {
        return periodicity;
    }
}
