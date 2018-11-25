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
    /*
    Method to create a calender by iterating over the 12 months
    Weekstart is given with the purpose of adding weeknumbers.
    */
    public void createCalendar(){
        int weekStart = 1;
        for (int i = 1; i<= 12; i++){
            createMonth(i, weekStart);
        }
    }

    /*
    Each month is created separately within the calender
     */

    public void createMonth(int monthNumber, int weekStart){
        //Start the calendar by initializing a startdate
        LocalDate days = LocalDate.of(year, monthNumber, 1);

        //Every day(monday to sunday) has its own String Arraylist for storing the daynumbers
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
        /*
        For Loop with a switch statements that says, if the day of the is a monday for example, store it in the monday arraylist
        */
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

        //Store all arraylists in another arraylist (multidimensional arraylist)
        ArrayList[] dayArrays = {mondayArray, tuesdayArray, wednesdayArray, thursdayArray, fridayArray, saturdayArray, sundayArray};
        //Format the weekarrays for cases where the month does not start with a monday we have some nice black spaces
        formatWeekArray(dayArrays);

        //print month of year
        System.out.println("  " + days.getMonth());
        // Turn the arrays into strings so we get rid of those ugly block signs []
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


    /*
    Formatting is done by checking the days which are in the first elements of the week arraylists
    The second element of the array decides if there is need for some black space or not.
    For example; if the month does not start with a monday, the second element is always black
    and is therefore filled with spaces.
     */
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

    //method for turning the arrays into strings
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
