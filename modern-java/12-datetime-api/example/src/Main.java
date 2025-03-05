import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
//        testLocalDate();
//        testInstant();
//        testDuration();
//        testModifyLocalDate();
        testFormatAndParse();
    }

    private static void testLocalDate() {
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

    private static void testInstant() {
        // Instant는 기계 전용
        Instant instant1 = Instant.ofEpochSecond(3);
        Instant instant2 = Instant.ofEpochSecond(3, 0);
        Instant instant3 = Instant.ofEpochSecond(2, 1_000_000_000);
        Instant instant4 = Instant.ofEpochSecond(4, -1_000_000_000);

        System.out.println("instant1: " + instant1);
        System.out.println("instant2: " + instant2);
        System.out.println("instant3: " + instant3);
        System.out.println("instant4: " + instant4);
        System.out.println("--------------------------------");

    }

    private static void testDuration() {
        LocalTime time1 = LocalTime.of(14, 20, 10);
        LocalTime time2 = LocalTime.of(15, 20, 10);
        Duration d1 = Duration.between(time1, time2);
        System.out.println("d1: " + d1);

        LocalDateTime dateTime1 = LocalDateTime.of(2025, Month.SEPTEMBER, 02, 14, 20, 10);
        LocalDateTime dateTime2 = LocalDateTime.of(2025, Month.SEPTEMBER, 02, 15, 20, 10);
        Duration d2 = Duration.between(dateTime1, dateTime2);
        System.out.println("d2: " + d2);

        Instant instant1 = Instant.ofEpochSecond(3);
        Instant instant2 = Instant.ofEpochSecond(4);
        Duration d3 = Duration.between(instant1, instant2);
        System.out.println("d3: " + d3);

        Period tenDays = Period.between(LocalDate.of(2025, 3,02),
                LocalDate.of(2025, 3,12));

        System.out.println(tenDays);


        Duration threeMinutes = Duration.ofMinutes(3);
        System.out.println(threeMinutes);
        Duration threeMinutes2 = Duration.of(3, ChronoUnit.MINUTES);
        System.out.println(threeMinutes2);

        Period tenDays2 = Period.ofDays(10);
        Period threeWeeks = Period.ofWeeks(3);
        Period twoYearsSixMonthsOneDay = Period.of(2, 6, 1);
        System.out.println(tenDays2);
        System.out.println(threeWeeks);
        System.out.println(twoYearsSixMonthsOneDay);

    }

    private static void testModifyLocalDate() {

        // 절대적 방식으로 LocalDate 속성 변경
        LocalDate date1 = LocalDate.of(2023, 9, 21);
        LocalDate date2 = date1.withYear(2021);
        LocalDate date3 = date2.withDayOfMonth(25);
        LocalDate date4 = date3.with(ChronoField.MONTH_OF_YEAR, 2);

        System.out.println("date1: " + date1);
        System.out.println("date2: " + date2);
        System.out.println("date3: " + date3);
        System.out.println("date4: " + date4);
        System.out.println("--------------------------------");

        // 상대적 방식으로 LocalDate 속성 변경
        LocalDate date11 = LocalDate.of(2023, 9, 21);
        LocalDate date21 = date11.plusWeeks(1);
        LocalDate date31 = date21.minusYears(1);
        LocalDate date41 = date31.plus(6, ChronoUnit.MONTHS);

        System.out.println("date11: " + date11);
        System.out.println("date22: " + date21);
        System.out.println("date31: " + date31);
        System.out.println("date41: " + date41);
    }

    private static void testFormatAndParse() {
        LocalDate date = LocalDate.of(2025, 03, 02);
        String s1 = date.format(DateTimeFormatter.BASIC_ISO_DATE);
        String s2 = date.format(DateTimeFormatter.ISO_LOCAL_DATE);

        System.out.println("BASIC ISO DATE: "+ s1);
        System.out.println("ISO LOCAL DATE: "+ s2);
        System.out.println("----------------------");

        LocalDate date1 = LocalDate.parse("20250302", DateTimeFormatter.BASIC_ISO_DATE);
        LocalDate date2 = LocalDate.parse("2025-03-02", DateTimeFormatter.ISO_LOCAL_DATE);

        System.out.println("date1: " + date1);
        System.out.println("date2: " + date2);
        System.out.println("----------------------");

        DateTimeFormatter italianFormatter = DateTimeFormatter.ofPattern("d MMMM yyyy", Locale.ITALIAN);
        LocalDate date3 = LocalDate.of(2025, 3, 18);
        String formattedDate = date3.format(italianFormatter);
        LocalDate date4 = LocalDate.parse(formattedDate, italianFormatter);
        System.out.println("date3: " + date3);
        System.out.println("formattedDate: " + formattedDate);
        System.out.println("date4: " + date4);
        System.out.println("----------------------");

        DateTimeFormatter italianFormatter2 = new DateTimeFormatterBuilder()
                .appendText(ChronoField.DAY_OF_MONTH)
                .appendLiteral(". ")
                .appendText(ChronoField.MONTH_OF_YEAR)
                .appendLiteral(" ")
                .appendText(ChronoField.YEAR)
                .parseCaseInsensitive()
                .toFormatter(Locale.ITALIAN);

        System.out.println("italianFormatter2: " + italianFormatter2);

    }
}