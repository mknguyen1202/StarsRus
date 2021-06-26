package cs174.starsrus.repositories;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SystemDateRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;
    
    public String getCurrentDateFromDBAsString() throws SQLException
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
    public int setCurrentDateFromDBAsString(String date) throws SQLException
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

    /**
     * 
     * @param before: in "yyyy-MM-dd"
     * @param after:  in "yyyy-MM-dd"
     * @return
     */
    public  long getNumberOfDaysBetweenTwoDates(String before, String after) {

        //Parsing the date
        LocalDate dateBefore = LocalDate.parse(before);
        LocalDate dateAfter = LocalDate.parse(after);
            
        //calculating number of days in between
        long noOfDaysBetween = ChronoUnit.DAYS.between(dateBefore, dateAfter);
        return noOfDaysBetween;
    }

    public  int addDefaultSystemDate(String defaultDate) {
        try {
            String QUERY = "INSERT INTO TodaysDate VALUES(?)";
            jdbcTemplate.update(QUERY, defaultDate);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }
}
