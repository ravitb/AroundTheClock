package com.ravit.android.aroundtheclock;

import java.util.Calendar;
import java.util.UUID;

/**
 * Created by ravit on 19/09/15.
 */
public class Workday {

    private UUID mId;
    private Calendar mCalendar;
    private Calendar mTimeArrival;
    private Calendar mTimeLeft;

    public Calendar getTimeLeft() {
        return mTimeLeft;
    }

    public void setTimeLeft(Calendar timeLeft) {
        mTimeLeft = timeLeft;
    }

    public Calendar getTimeArrival() {
        return mTimeArrival;
    }

    public void setTimeArrival(Calendar timeArrival) {
        mTimeArrival = timeArrival;
    }

    public Calendar getDate() {
        return mCalendar;
    }

    public UUID getId() {
        return mId;
    }


    public Workday(Calendar calendar) {
        mId = UUID.randomUUID();
        mCalendar = calendar;
    }
}
