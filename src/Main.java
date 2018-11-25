import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Pick a year for your calendar");
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();

        System.out.println();
        System.out.println("Calendar " + year);
        Calendarcreation calendar = new Calendarcreation(year);
        calendar.createCalendar();
    }
}
