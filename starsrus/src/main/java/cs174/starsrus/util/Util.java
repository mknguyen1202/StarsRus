package cs174.starsrus.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

import javax.swing.text.DateFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import javax.sql.DataSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class Util {

    public static final String DRIVER = "com.sqlite.jdbc.Driver";
    public static final String JDBC_URL = "jdbc:sqlite:src/main/resources/database/chinook.db";
    // public static final String USERNAME = "root";
    // public static final String PASSWORD = "";

    public static DataSource source;
    public static JdbcTemplate jdbcTemplate;
    
    public static int numDaysInMonth(int year, int month) {
        YearMonth yearMonthObject = YearMonth.of(year, month);
        return yearMonthObject.lengthOfMonth();
    };

    public static String getBackendDirectoryPath() {
        return System.getProperty("user.dir");
    }


    /**
     * 
     * @param before: in "yyyy-MM-dd"
     * @param after:  in "yyyy-MM-dd"
     * @return
     */
    public static long getNumberOfDaysBetweenTwoDates(String before, String after) {

        //Parsing the date
        LocalDate dateBefore = LocalDate.parse(before);
        LocalDate dateAfter = LocalDate.parse(after);
            
        //calculating number of days in between
        long noOfDaysBetween = ChronoUnit.DAYS.between(dateBefore, dateAfter);
        return noOfDaysBetween;
    }

    public static List<List<String>> getCSV_data(String filename, String delimiter) {
        List<List<String>> records = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.trim().split(delimiter);
                records.add(Arrays.asList(values));
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
        return records;

    }

    public static LocalDateTime getTimeNow() {
        return LocalDateTime.now();
    }

    public static LocalDateTime getStartOfTheDate() {
        LocalDate localDate = LocalDate.now();
        return localDate.atStartOfDay();
    }


    public static Calendar getCalendarStartOfTheDate() {
        Calendar date = new GregorianCalendar();
        date.set(Calendar.HOUR_OF_DAY, 0);
        date.set(Calendar.MINUTE, 0);
        date.set(Calendar.SECOND, 0);
        date.set(Calendar.MILLISECOND, 0);
        // System.out.println(date.getTime());
        return date;
    }

    public static Calendar getCalendarNow() {
        Calendar date = new GregorianCalendar();
        return date;
    }

    public static Calendar getCalendarLastWeek() {
        return getCalendarDaysAgo(7);
    }

    public static Calendar getCalendarLastMonth() {
        return getCalendarMonthsAgo(1);
    }

    public static Calendar getCalendarLastYear() {
        return getCalendarYearsAgo(1);
    }

    public static Calendar getCalendarYesterday() {
        Calendar date = new GregorianCalendar();
        date.set(Calendar.HOUR_OF_DAY, 0);
        date.set(Calendar.MINUTE, 0);
        date.set(Calendar.SECOND, 0);
        date.set(Calendar.MILLISECOND, 0);
        date.add(Calendar.DAY_OF_MONTH, -1);
        return date;
    }
    

    public static Calendar getCalendarDaysAgo(int days) {
        Calendar date = new GregorianCalendar();
        date.set(Calendar.HOUR_OF_DAY, 0);
        date.set(Calendar.MINUTE, 0);
        date.set(Calendar.SECOND, 0);
        date.set(Calendar.MILLISECOND, 0);
        date.add(Calendar.DAY_OF_MONTH, -1 * Math.abs(days));
        return date;
    }

    public static Calendar getCalendarMonthsAgo(int months) {
        Calendar date = new GregorianCalendar();
        date.set(Calendar.HOUR_OF_DAY, 0);
        date.set(Calendar.MINUTE, 0);
        date.set(Calendar.SECOND, 0);
        date.set(Calendar.MILLISECOND, 0);
        date.add(Calendar.MONTH, -1 * Math.abs(months));
        return date;
    }

    public static Calendar getCalendarYearsAgo(int years) {
        Calendar date = new GregorianCalendar();
        date.set(Calendar.HOUR_OF_DAY, 0);
        date.set(Calendar.MINUTE, 0);
        date.set(Calendar.SECOND, 0);
        date.set(Calendar.MILLISECOND, 0);
        date.add(Calendar.YEAR, -1 * Math.abs(years));
        return date;
    }

    public static double generateRandomDecimal(double min, double max) {
        Random r = new Random();
        return (r.nextInt((int)((max-min)*10+1))+min*10) / 10.0;
    }

}
