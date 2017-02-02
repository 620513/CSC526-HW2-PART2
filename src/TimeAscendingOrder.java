// Thelma Andrews,CSC526,Homework2 (Part2)
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class TimeAscendingOrder implements Comparator<Time> {
    private DateFormat dateFormat = new SimpleDateFormat("hh:mm a");
    public int courseTimeMS(String time) throws ParseException{
        return courseTimeMS(time, dateFormat);
    }
    private int courseTimeMS(String time, DateFormat dateFormat) throws ParseException{
        Date date = dateFormat.parse(time);
        return (int)date.getTime();
    }
    @Override
    public int compare(Time time1, Time time2){
        try {
            return (courseTimeMS(time1.toString()) - courseTimeMS(time2.toString()));
        }catch (Exception e){
            return 0;
        }
    }
}
