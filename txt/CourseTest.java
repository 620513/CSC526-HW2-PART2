// Thelma Andrews,CSC526,Homework2 (Part2)
import org.junit.Assert;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.*;

public class CourseTest {
    @Test
    public void courseObjectTestCase(){
        Time testtime = new Time (2, 0, true);
        Set<Weekday> testdays  =  EnumSet.of(Weekday.MONDAY, Weekday.WEDNESDAY, Weekday.FRIDAY);
        Course testcourse = new Course("MATH 126", 1, testdays, testtime, 60);
        Assert.assertEquals("MATH 126,1,MWF,02:00 PM,60", testcourse.toString());
    }
    @Test
    public void courseConflictWithAnotherCourseTestCase(){
        Set<Weekday> testdays  =  EnumSet.of(Weekday.MONDAY, Weekday.WEDNESDAY, Weekday.FRIDAY);
        Course testcourse = new Course("MATH 126", 2, testdays, Time.fromString("06:00 PM"), 25);
        Course conflictcourse = new Course("FREN 428", 2, testdays, Time.fromString("06:00 PM"), 25);
        Assert.assertEquals("conflict check btw [" + testcourse + "] and [" + conflictcourse + "] should return " + true,
                true, testcourse.conflictsWith(conflictcourse));
    }
    @Test
    public void courseContainsMatchDaysAndTimeTestCase(){
        Set<Weekday> testdays  =  EnumSet.of(Weekday.MONDAY, Weekday.WEDNESDAY, Weekday.FRIDAY);
        Course testcourse = new Course("MATH 126", 1, testdays, Time.fromString("06:00 PM"), 60);
        String message = "should";
        if(!false)
            message = "should not";
        Assert.assertEquals("Course " + testcourse + " " + message + " contain " + new Time(10, 0, false), true, testcourse.contains(Weekday.FRIDAY, new Time(10, 0, false)));
    }
    @Test
    public void courseEqualsStringTestCase(){
        Time testtime = new Time (2, 0, true);
        Set<Weekday> testdays  =  EnumSet.of(Weekday.MONDAY, Weekday.WEDNESDAY, Weekday.FRIDAY);
        Course testcourse = new Course("MATH 126", 1, testdays, testtime, 60);
        Course equalscourse = new Course("MATH 126", 1, testdays, testtime, 60);
        Assert.assertTrue(testcourse.toString().equals(equalscourse.toString()));
    }
    @Test
    public void courseEndTimeTestCase(){
        Time testtime = new Time (2, 0, true);
        Set<Weekday> testdays  =  EnumSet.of(Weekday.MONDAY, Weekday.WEDNESDAY, Weekday.FRIDAY);
        Course testcourse = new Course("MATH 126", 1, testdays, testtime, 60);
        Assert.assertTrue(testcourse.getEndTime().toString().equals("03:00 PM"));
        testcourse.starttime.shift(30);
        Assert.assertTrue(testcourse.getEndTime().toString().equals("03:30 PM"));
    }
    @Test
    public void courseObjectToStringTestCase(){
        Time testtime = new Time (2, 0, true);
        Set<Weekday> testdays  =  EnumSet.of(Weekday.MONDAY, Weekday.WEDNESDAY, Weekday.FRIDAY);
        Course testcourse = new Course("MATH 126", 1, testdays, testtime, 60);
        Assert.assertEquals("MATH 126,1,MWF,02:00 PM,60", testcourse.toString());
    }
}
