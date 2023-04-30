import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TimeConversionByCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
       
        System.out.print("Enter a date and time in this format yyyy-MM-dd HH:mm:ss: ");
        String dateTimeString = scanner.nextLine();
        
        System.out.print("Enter a timezone (e.g. America/New_York): ");
        String timezoneString = scanner.nextLine();
        
        
        LocalDateTime localDateTime = LocalDateTime.parse(dateTimeString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        
      
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.of(timezoneString));
        
       
        ZonedDateTime utcZonedDateTime = zonedDateTime.withZoneSameInstant(ZoneId.of("UTC"));
        String utcTimeString = utcZonedDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss 'UTC'"));
        System.out.println("UTC Time: " + utcTimeString);
        
        
        ZonedDateTime newYorkZonedDateTime = zonedDateTime.withZoneSameInstant(ZoneId.of("America/New_York"));
        String newYorkTimeString = newYorkZonedDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z"));
        System.out.println("New York Time: " + newYorkTimeString);
        
        
        ZonedDateTime londonZonedDateTime = zonedDateTime.withZoneSameInstant(ZoneId.of("Europe/London"));
        String londonTimeString = londonZonedDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z"));
        System.out.println("London Time: " + londonTimeString);
        
        scanner.close();
    }
}
