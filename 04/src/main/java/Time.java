import java.util.Date;

public class Time {
    private Date date = new Date();

    public Date getDate() {
        System.out.println("Date now: " + date);
        return date;
    }
}
