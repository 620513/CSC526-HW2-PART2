// Thelma Andrews,CSC526,Homework2 (Part2)
import java.util.Comparator;


public class CourseTimeComparator implements Comparator<Course> {
    @Override
    public int compare(Course course1, Course course2) {
        return course1.getStartTime().compareTo(course2.getStartTime());
    }
}
