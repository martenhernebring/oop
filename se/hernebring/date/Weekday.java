package se.hernebring.date;
import java.lang.EnumConstantNotPresentException;

public enum Weekday {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

    @Override
    public String toString() {
        switch(this) {
            case MONDAY: return "måndag";
            case TUESDAY: return "tisdag";
            case WEDNESDAY: return "onsdag";
            case THURSDAY: return "torsdag";
            case FRIDAY: return "fredag";
            case SATURDAY: return "lördag";
            case SUNDAY: return "söndag";
            default: throw new EnumConstantNotPresentException(null, this.name());
        }
    }
}
