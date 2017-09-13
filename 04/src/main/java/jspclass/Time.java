package jspclass;

import java.util.Calendar;
import java.util.Date;

public class Time {
    protected String r = null;
    private Calendar calendar;
    protected Date date = new Date();

    public Time(Calendar calendar){
        this.calendar = calendar;
    }

    public Time(){
        this.calendar = Calendar.getInstance(); // ?
    }

    public Integer getHour(){
        return ((Integer)calendar.get(Calendar.HOUR_OF_DAY));
    }
}
