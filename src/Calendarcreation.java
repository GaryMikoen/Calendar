import com.sun.xml.internal.bind.v2.TODO;

import java.lang.reflect.Array;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Calendarcreation {
    private int year;

    public Calendarcreation(int year) {
        this.year = year;
    }

    public int seeYear(){
        return year;
    }

    public void seeMonths(){
        System.out.println("Months");
        for(int i = 1; i<= 12; i++) {
            LocalDate month = LocalDate.of(year, i, 1);
            System.out.println(month.getMonth());
        }
    }

    public void createCalendar(){
        int weekStart = 1;
        for (int i = 1; i<= 12; i++){
            createMonth(i, weekStart);
        }
    }

    public void createMonth(int monthNumber, int weekStart){
        LocalDate days = LocalDate.of(year, monthNumber, 1);

        ArrayList<String> mondayArray = new ArrayList<>();
        mondayArray.add("MO");
        ArrayList<String> tuesdayArray = new ArrayList<>();
        tuesdayArray.add("TU");
        ArrayList<String> wednesdayArray = new ArrayList<>();
        wednesdayArray.add("WE");
        ArrayList<String> thursdayArray = new ArrayList<>();
        thursdayArray.add("TH");
        ArrayList<String> fridayArray = new ArrayList<>();
        fridayArray.add("FR");
        ArrayList<String> saturdayArray = new ArrayList<>();
        saturdayArray.add("SA");
        ArrayList<String> sundayArray = new ArrayList<>();
        sundayArray.add("SU");
        ArrayList<Integer> weekArray = new ArrayList<>();

        for (int i = 1; i<=days.lengthOfMonth() ; i++) {
            LocalDate showDays = LocalDate.of(year, monthNumber, i);
            String day = showDays.getDayOfWeek().toString();
            int dayNumber = showDays.getDayOfWeek().getValue();
            String dayString = Integer.toString(showDays.getDayOfMonth());
            if (showDays.getDayOfMonth() < 10) {
                dayString = ("0" + dayString);
            }
            switch (day) {
                case "MONDAY":
                    mondayArray.add(dayString);
                    break;
                case "TUESDAY":
                    tuesdayArray.add(dayString);
                    break;
                case "WEDNESDAY":
                    wednesdayArray.add(dayString);
                    break;
                case "THURSDAY":
                    thursdayArray.add(dayString);
                    break;
                case "FRIDAY":
                    fridayArray.add(dayString);
                    break;
                case "SATURDAY":
                    saturdayArray.add(dayString);
                    break;
                case "SUNDAY":
                    sundayArray.add(dayString);
                    break;
            }
        }
        ArrayList[] dayArrays = {mondayArray, tuesdayArray, wednesdayArray, thursdayArray, fridayArray, saturdayArray, sundayArray};
        formatWeekArray(dayArrays);

        System.out.println("  " + days.getMonth());
        printCalendar(dayArrays[0]);
        printCalendar(dayArrays[1]);
        printCalendar(dayArrays[2]);
        printCalendar(dayArrays[3]);
        printCalendar(dayArrays[4]);
        printCalendar(dayArrays[5]);
        printCalendar(dayArrays[6]);
        System.out.println();

        // stukje voor weken
        /*

        int maxArraysize = 0;
        for (int j = 0 ; j<=(dayArrays[j].size()); j++){
            if (dayArrays[j].size() > maxArraysize){
                maxArraysize = dayArrays[j].size() - 1;
            }
        }
        */

    }

    public void formatWeekArray(ArrayList[] dayArrays){
        for (int i = 0; i<= dayArrays.length - 1; i++) {
            String day = dayArrays[i].get(0).toString();
            String dayNumberString =  (dayArrays[i].get(1).toString());
            int dayNumber = Integer.parseInt(dayNumberString);
            switch (day) {
                case "MO":
                    if (dayNumber > 1){
                        dayArrays[i].add(1, "  ");
                    }
                    break;
                case "TU":
                    if (dayNumber !=1 && dayNumber > 2){
                        dayArrays[i].add(1, "  ");
                    }
                    break;
                case "WE":
                    if (dayNumber !=1 && dayNumber > 3){
                        dayArrays[i].add(1, "  ");
                    }
                    break;
                case "TH":
                    if (dayNumber !=1 && dayNumber > 4){
                        dayArrays[i].add(1, "  ");
                    }
                    break;
                case "FR":
                    if (dayNumber !=1 && dayNumber > 5){
                        dayArrays[i].add(1, "  ");
                    }
                    break;
                case "SA":
                    if (dayNumber !=1 && dayNumber > 6){
                        dayArrays[i].add(1, "  ");
                    }
                    break;
                case "SU":
                    if (dayNumber !=1 && dayNumber > 7){
                        dayArrays[i].add(1, "  ");
                    }
                    break;
            }
        }
    }

    public void printCalendar(ArrayList dayArray){
        StringBuilder result = new StringBuilder(dayArray.size());

        for (int i = 0; i<dayArray.size() ; i++) {
            result.append("  ");
            result.append(dayArray.get(i));
        }
        String output = result.toString();
        System.out.println(output);

    }
}
