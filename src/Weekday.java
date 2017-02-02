// Thelma Andrews,CSC526,Homework2 (Part2)
public enum Weekday{
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY;

    public static Weekday fromString(String name) {
        if(name!=null && name.trim().length()!=0 && (name.equalsIgnoreCase("MONDAY")|| name.equalsIgnoreCase("M"))) {
            return Weekday.MONDAY;
        }
        if(name!=null && name.trim().length()!=0 && (name.equalsIgnoreCase("TUESDAY") || name.equalsIgnoreCase("T"))) {
            return Weekday.TUESDAY;
        }
        if(name!=null && name.trim().length()!=0 && (name.equalsIgnoreCase("WEDNESDAY")  || name.equalsIgnoreCase("W"))) {
            return Weekday.WEDNESDAY;
        }
        if(name!=null && name.trim().length()!=0 && (name.equalsIgnoreCase("THURSDAY") || name.equalsIgnoreCase("R"))) {
            return Weekday.THURSDAY;
        }
        if(name!=null && name.trim().length()!=0 && (name.equalsIgnoreCase("FRIDAY") || name.equalsIgnoreCase("F"))) {
            return Weekday.FRIDAY;
        }
        return Weekday.MONDAY;
    }
    public String toShortName() {
        switch (this) {
            case MONDAY:
                return "M";
            case TUESDAY:
                return "T";
            case WEDNESDAY:
                return "W";
            case THURSDAY:
                return "R";
            default:
                return "F";
        }
    }
    public String toString() {
        switch (this) {
            case MONDAY:
                return "Monday";
            case TUESDAY:
                return "Tuesday";
            case WEDNESDAY:
                return "Wednesday";
            case THURSDAY:
                return "Thursday";
            default:
                return "Friday";
        }
    }
}
