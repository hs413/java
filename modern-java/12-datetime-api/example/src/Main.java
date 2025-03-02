import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoField;

public class Main {

    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2025, 03, 02);
        int year = date.getYear();
        Month month = date.getMonth();
        int day = date.getDayOfMonth();
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        int len = date.lengthOfMonth();
        boolean leap = date.isLeapYear();

        LocalDate today = LocalDate.now();

        System.out.println("date: " + date);
        System.out.println("year: " + year);
        System.out.println("month: " + month);
        System.out.println("day: " + day);
        System.out.println("dayOfWeek: " + dayOfWeek);
        System.out.println("len: " + len);
        System.out.println("leap: " + leap);
        System.out.println("today: " + today);
        System.out.println("--------------------------------");

        // TemporalField
        int y = date.get(ChronoField.YEAR);
        int m = date.get(ChronoField.MONTH_OF_YEAR);
        int d = date.get(ChronoField.DAY_OF_MONTH);

        System.out.println(y);
        System.out.println(m);
        System.out.println(d);
        System.out.println("--------------------------------");

        // LocalTime
        LocalTime time = LocalTime.of(14, 20, 10);
        int hour = time.getHour();
        int minute = time.getMinute();
        int second = time.getSecond();
        System.out.println("hour: " + hour);
        System.out.println("minute: " + minute);
        System.out.println("second: " + second);
        System.out.println("--------------------------------");

        // string to date
        LocalDate date2 = LocalDate.parse("2025-03-02");
        LocalTime time2 = LocalTime.parse("14:20:10");
        System.out.println(date2);
        System.out.println(time2);
        System.out.println("--------------------------------");

        // LocalDateTime
        LocalDateTime dt1 = LocalDateTime.of(2025, Month.SEPTEMBER, 02, 14, 20, 10);
        LocalDateTime dt2 = LocalDateTime.of(date, time);
        LocalDateTime dt3 = date.atTime(20, 15, 20);
        LocalDateTime dt4 = date.atTime(time);
        LocalDateTime dt5 = time.atDate(date);

        System.out.println("dt1: " + dt1);
        System.out.println("dt2: " + dt2);
        System.out.println("dt3: " + dt3);
        System.out.println("dt4: " + dt4);
        System.out.println("dt5: " + dt5);
        System.out.println("--------------------------------");

    }
}