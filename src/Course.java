// Thelma Andrews,CSC526,Homework2 (Part2)
import java.text.SimpleDateFormat;
import java.util.*;


public class Course {
    String coursename;
    int coursecredits;
    Set<Weekday> weekDays;
    Time starttime;
    int duration;
    public Course(String name, int credits, Set<Weekday> days, Time startTime, int duration){
        coursename=name;
        coursecredits=credits;
        weekDays=days;
        starttime=startTime;
        this.duration=duration;
        if(coursename==null || (coursename!=null && coursename.equalsIgnoreCase(""))){
            throw new IllegalArgumentException("Empty name or null name should be invalid");
        }
        if(coursename!=null && coursename.indexOf(" ")==-1){
            throw new IllegalArgumentException("Name should contain space");
        }
        if(coursecredits<=0 || coursecredits>=6){
            throw new IllegalArgumentException("0 credit should be invalid or more than 6 credit should be invalid");
        }
        if(weekDays==null){
            throw new IllegalArgumentException("null days should be invalid");
        }
        if(starttime==null){
            throw new IllegalArgumentException("null time should be invalid");
        }
        if(this.duration<=0){
            throw new IllegalArgumentException("duration should be greater than 0");
        }
    }
    public boolean conflictsWith(Course course){
        try {
            Iterator iterator = weekDays.iterator();
            boolean conflictCourse = false;
            for (;iterator.hasNext();) {
                Weekday weekday = (Weekday) iterator.next();
                if (course.weekDays.contains(weekday)) {
                    conflictCourse = true;
                    break;
                }
            }
            if (conflictCourse && (toString().indexOf(course.starttime.toString()) != -1)) {
                return true;
            }
            SimpleDateFormat mytimeformat = new SimpleDateFormat("HH:mm a");
            Date courststarttime = mytimeformat.parse(starttime.toString());
            Date anothercoursestarttime = mytimeformat.parse(course.starttime.toString());
            long timedifference = (anothercoursestarttime.getTime() - courststarttime.getTime());
            long gapinminutes = (timedifference / (60 * 1000));
            if (conflictCourse && gapinminutes>0 && gapinminutes < duration) {
                return true;
            }
            course.starttime.shift(course.duration);
            if(conflictCourse && starttime.toString().equals(course.starttime.toString())){
                return false;
            }
            starttime.shift(duration);
            if(conflictCourse && starttime.toString().equals(course.starttime.toString())){
                return true;
            }
        }catch (Exception e){}
        return false;
    }
    public boolean contains(Weekday day, Time startTime){
        try {
            if (weekDays.contains(day) && (toString().indexOf(startTime.toString()) != -1)) {
                return true;
            }
            SimpleDateFormat format = new SimpleDateFormat("HH:mm a");
            Date date1 = format.parse(startTime.toString());
            Date date2 = format.parse(startTime.toString());
            long difference = date2.getTime() - date1.getTime();
            long diffMinutes = difference / (60 * 1000);
            if (weekDays.contains(day) && diffMinutes<duration) {
                return true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public boolean equals(Object o){
        return (this==o);
    }
    public int getCredits(){
        return coursecredits;
    }
    public int getDuration(){
        return duration;
    }
    public String getName(){
        return coursename;
    }
    public Time getStartTime(){
        return starttime;
    }
    public Time getEndTime(){
        try{
            Calendar mycalendar = Calendar.getInstance();
            if(starttime.pmamcheck==false){
                mycalendar.set(Calendar.AM_PM,0);
            }else {
                mycalendar.set(Calendar.AM_PM,1);
            }
            mycalendar.set(Calendar.HOUR,starttime.getHour());
            mycalendar.set(Calendar.MINUTE,starttime.getMinute());
            mycalendar.set(Calendar.SECOND,0);
            mycalendar.add(Calendar.MINUTE,duration);
            int timehour=mycalendar.get(Calendar.HOUR);
            if(timehour==0){
                timehour=12;
            }
            if(timehour>12){
                timehour=timehour-12;
            }
            int timeminute=mycalendar.get(Calendar.MINUTE);
            if(mycalendar.get(Calendar.AM_PM)==1){
                return new Time(timehour,timeminute,true);
            }else{
                return new Time(timehour,timeminute,false);
            }
        }catch (Exception e){}
        return null;
    }
    public String toString(){
        String shortNames="";
        Iterator iterator=weekDays.iterator();
        for(;iterator.hasNext();){
            Weekday weekday=(Weekday)iterator.next();
            shortNames+=weekday.toShortName();
        }
        return coursename+","+coursecredits+","+shortNames+","+starttime+","+duration;
    }
}
