// Thelma Andrews,CSC526,Homework2 (Part2)
public class ScheduleConflictException extends Exception{
    public ScheduleConflictException(Course course1,Course course2){
        if(course1==null){
            System.out.print("Course 1 is not null");
        }
        if(course2==null){
            System.out.print("Course 2 is not null");
        }
    }
}
