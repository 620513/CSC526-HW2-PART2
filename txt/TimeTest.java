// Thelma Andrews,CSC526,Homework2 (Part2)
import org.junit.Assert;
import org.junit.Test;

public class TimeTest {

    @Test
    public void testcaseTimeFromString() throws CloneNotSupportedException{
        Time time = Time.fromString("04:20 PM");
        Assert.assertEquals(time.clone().hashCode(), time.hashCode());
    }
    @Test
    public void testcaseTimeCloneObject() throws CloneNotSupportedException{
        Time t1 = Time.fromString("10:30 AM");
        Time t2 = (Time)t1.clone();
        Assert.assertTrue(t1.equals(t2));
        Assert.assertTrue(t2.equals(t1));
        Assert.assertEquals(t1.hashCode(), t2.hashCode());
    }
    @Test
    public void testcaseTimeFields(){
        Time t1 = Time.fromString("10:30 AM");
        Assert.assertEquals(10,t1.getHour());
        Assert.assertEquals(30,t1.getMinute());
        Assert.assertEquals(false,t1.isPM());
    }
    @Test
    public void testcaseTimeShiftMinutes(){
        Time t1 = Time.fromString("10:30 AM");
        t1.shift(20);
        Assert.assertEquals("10:50 AM", t1.toString());
    }
    @Test
    public void testcaseCloneAndHashCose() throws CloneNotSupportedException{
        Time t1 = new Time(6, 6, false);
        Time t2 = (Time)t1.clone();
        Assert.assertTrue(t1.equals(t2));
        Assert.assertTrue(t1 == t2);
        Assert.assertEquals(t1.getClass(), t2.getClass());
    }
    @Test
    public void testcaseTimeToString(){
        Time t1 = Time.fromString("10:30 AM");
        Time t2 = new Time(10, 30, false);
        Assert.assertEquals(t1.toString(), t2.toString());
    }
}
