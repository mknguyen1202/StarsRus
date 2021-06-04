package cs174.starsrus;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

import javax.swing.text.DateFormatter;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class Util {

    

    @Autowired
    public static JdbcTemplate jdbcTemplate;
    
    public static int numDaysInMonth(int year, int month) {
        YearMonth yearMonthObject = YearMonth.of(year, month);
        return yearMonthObject.lengthOfMonth();
    };

    public static String getCurrentDateFromDBAsString() throws SQLException
    {
        String QUERY = "SELECT todays_date FROM TodaysDate";
        String date = jdbcTemplate.queryForObject(QUERY, new Object[] {},
        	            new BeanPropertyRowMapper<String>(String.class));
        return date;
    }

    /**
     * 
     * @param date: in YYYY-MM-DD format
     * @return 
     * @throws SQLException
     */
    public static int setCurrentDateFromDBAsString(String date) throws SQLException
    {
        try {
            String QUERY = "INSERT INTO TodaysDate VALUES(?)";
            

            if (date.equalsIgnoreCase("now")) {
                LocalDate myDateObj = LocalDate.now();
                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
                date = myDateObj.format(myFormatObj);  
            } 
                
            LocalDateTime datetime = LocalDateTime.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));             
            

            jdbcTemplate.update(QUERY, datetime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            return 1;
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
            return 0;
        }
    }
}
