// Thelma Andrews,CSC526,Homework2 (Part2)
import java.util.Comparator;


public class CourseNameComparator implements Comparator<Course>{
    @Override
    public int compare(Course course1, Course course2) {
        return course1.getName().compareTo(course2.getName());
    }
}
