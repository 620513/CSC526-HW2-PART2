// Thelma Andrews,CSC526,Homework2 (Part2)
import java.io.PrintStream;
import java.util.*;


public class Schedule implements Iterable<Course>{
    List<Course> schedulecourses=new Stack<Course>();;
    public Schedule(){}
    public void add(Course course){
        schedulecourses.add(course);
    }
    public Object clone() throws CloneNotSupportedException{
        return this;
    }
    public Course getCourse(Weekday day,Time time){
        Course matchcourse=null;
        for(Course course : schedulecourses){
            if(time.toString().compareTo(course.getStartTime().toString())==0){
                matchcourse=course;
            }
        }
        return matchcourse;
    }
    public void save(PrintStream printStream, Comparator<Course> course){    }
    public int totalCredits(){
        int allcreditsFromCourses=0;
        for(Course course : schedulecourses){
            allcreditsFromCourses=allcreditsFromCourses+course.getCredits();
        }
        return allcreditsFromCourses;
    }
    public void remove(Weekday day,Time time){
        for(Course course : schedulecourses){
            if((course.getStartTime().toString().compareTo(time.toString()))==0){
                schedulecourses.remove(course);
            }
        }
    }
    @Override
    public Iterator<Course> iterator(){
        return (schedulecourses.iterator());
    }
}
