package obj_bas_pr2;

import java.util.Scanner;
import static java.lang.System.*;

public class ClockDemo {
    public static void main(String[] args) {
        out.println("Create firstClock:");
        Clock firstClock = new Clock(getSecondsForSecondsConstructor());
        out.println("FirstClock:");
        firstClock.clockRepresentation();

        tick(10, firstClock);

        out.println("\nCreate secondClock:");
        Clock secondClock = new Clock(getHoursForTimeConstructor(),
                                      getMinutesForTimeConstructor(),
                                      getSecondsForTimeConstructor());
        out.println("secondClock:");
        secondClock.clockRepresentation();

        tickDown(10, secondClock);

        out.println("\nfirstClock before adding the secondClock time in firstClock:");
        firstClock.clockRepresentation();
        firstClock.addClock(secondClock);
        out.println("firstClock after adding the secondClock time in firstClock:");
        firstClock.clockRepresentation();
        out.println("secondClock:");
        secondClock.clockRepresentation();

        out.println("Getting the difference of firstClock and secondClock:");
        firstClock.subtractClock(secondClock).clockRepresentation();
    }
    static int getSecondsForSecondsConstructor(){
        Scanner scan = new Scanner(in);
        int clockTime;
        out.println("Setting time for clock:");
        out.println("Enter seconds for clock:");
        String checkEmptyIntValue = scan.nextLine();
        if(checkEmptyIntValue.equals("")){
            out.println("Clock initialized automatically:");
            clockTime = 12*3600;
            return clockTime;
        }
        clockTime = Integer.parseInt(checkEmptyIntValue);
        return clockTime;
    }
    static int getHoursForTimeConstructor(){
        Scanner scan = new Scanner(in);
        int clockHours;
        out.println("Setting time for clock:");
        out.println("Enter hours for clock:");
        String checkEmptyIntValue = scan.nextLine();
        if(checkEmptyIntValue.equals("")){
            out.println("Hours initialized automatically:");
            clockHours = 12;
            return clockHours;
        }
        clockHours = Integer.parseInt(checkEmptyIntValue);
        return clockHours;
    }
    static int getMinutesForTimeConstructor(){
        Scanner scan = new Scanner(in);
        int clockMinutes;
        out.println("Enter minutes for clock:");
        String checkEmptyIntValue = scan.nextLine();
        if(checkEmptyIntValue.equals("")){
            out.println("Seconds Minutes automatically:");
            clockMinutes = 0;
            return clockMinutes;
        }
        clockMinutes = Integer.parseInt(checkEmptyIntValue);
        return clockMinutes;
    }
    static int getSecondsForTimeConstructor(){
        Scanner scan = new Scanner(in);
        int clockSeconds;
        out.println("Enter seconds for clock:");
        String checkEmptyIntValue = scan.nextLine();
        if(checkEmptyIntValue.equals("")){
            out.println("Seconds initialized automatically:");
            clockSeconds = 0;
            return clockSeconds;
        }
        clockSeconds = Integer.parseInt(checkEmptyIntValue);
        return clockSeconds;
    }
    static void tick(int tickForSoManySeconds, Clock clock){
        out.println("\nWe will set clock " + tickForSoManySeconds + " seconds ahead");
        for(int i = 0; i < tickForSoManySeconds; i++){
            clock.tick();
            out.print((i+1) + " tick time: ");clock.clockRepresentation();
        }
    }
    static void tickDown(int tickForSoManySeconds, Clock clock){
        out.println("\nWe will set clock " + tickForSoManySeconds + " seconds back");
        for(int i = 0; i < tickForSoManySeconds; i++){
            clock.tickDown();
            out.print((i+1) + " tick time: ");clock.clockRepresentation();
        }
    }
}