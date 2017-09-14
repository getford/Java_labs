package jspclass;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Time {
    private Calendar calendar = Calendar.getInstance();
    private Date date = new Date();
    private int hour = calendar.get(Calendar.HOUR_OF_DAY);
    private int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
    private int day = calendar.get(Calendar.DAY_OF_MONTH);
    private int dayOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

    private String rc;
    private String[][] listDays = new String[0][];

    public Time() {
    }

    public void PrintHello(int hour) {

        if (hour > 0 && hour <= 5)
            setRc("Good night");
        else if (hour > 5 && hour < 12)
            setRc("Good morning");
        else if (hour >= 12 && hour <= 17)
            setRc("Good afternoon");
        else
            setRc("Good evening");
    }

    public void ArrayDates(int day, int dayOfWeek, int dayOfMonth, Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(".MM.yyyy");
        String formatDate = simpleDateFormat.format(date);

        int ni = 7;
        int nj = 2;
        String arr[][] = new String[ni][nj];

        for (int i = 0; i < ni; i++) {
            for (int j = 0; j < nj; j++) {
                if (j == 0) {
                    if (day > dayOfMonth)
                        day = 1;
                    arr[i][j] = "" + day++ + formatDate;
                }
                if (j == 1) {
                    if (dayOfWeek > 7)
                        dayOfWeek = 1;
                    arr[i][j] = "" + dayOfWeek++;
                }
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
        setListDays(arr);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(int dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getDayOfMonth() {
        return dayOfMonth;
    }

    public void setDayOfMonth(int dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    public String getRc() {
        return rc;
    }

    public void setRc(String rc) {
        this.rc = rc;
    }

    public String[][] getListDays() {
        return listDays;
    }

    public void setListDays(String[][] listDays) {
        this.listDays = listDays;
    }
}
