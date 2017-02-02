// Thelma Andrews,CSC526,Homework2 (Part2)
import org.junit.Assert;
import org.junit.Test;

public class WeekdayTest {
    @Test
    public void testWeekDaysFromStrings(){
        Assert.assertNotNull(Weekday.MONDAY);
        Assert.assertEquals(Weekday.MONDAY,Weekday.fromString("MONDAY"));
        Assert.assertNotEquals(Weekday.THURSDAY,Weekday.fromString("TUESDAY"));
        Assert.assertNotEquals(Weekday.TUESDAY,Weekday.fromString("R"));
        Assert.assertEquals(Weekday.FRIDAY,Weekday.fromString("F"));
        Assert.assertEquals(Weekday.TUESDAY,Weekday.fromString("T"));
    }
    @Test
    public void testWeekDaysToString(){
        Assert.assertEquals("Monday",Weekday.MONDAY.toString());
        Assert.assertEquals("Tuesday",Weekday.TUESDAY.toString());
        Assert.assertEquals("Wednesday",Weekday.WEDNESDAY.toString());
        Assert.assertEquals("Thursday",Weekday.THURSDAY.toString());
        Assert.assertEquals("Friday",Weekday.FRIDAY.toString());
        Assert.assertNotNull(Weekday.MONDAY.toString());
    }
    @Test
    public void testWeekDaysToShortName(){
        Assert.assertEquals("M",Weekday.MONDAY.toShortName());
        Assert.assertEquals("T",Weekday.TUESDAY.toShortName());
        Assert.assertEquals("W",Weekday.WEDNESDAY.toShortName());
        Assert.assertEquals("R",Weekday.THURSDAY.toShortName());
        Assert.assertEquals("F",Weekday.FRIDAY.toShortName());
        Assert.assertNotNull(Weekday.MONDAY.toShortName());
    }
}
