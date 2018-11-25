import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Pick a year to start the creation of a calendar;
        System.out.println("Pick a year for your calendar");
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();

        System.out.println();
        System.out.println("Calendar " + year);
        //Calendar object is created by passing the chosen year
        Calendarcreation calendar = new Calendarcreation(year);
        calendar.createCalendar();
    }
}
