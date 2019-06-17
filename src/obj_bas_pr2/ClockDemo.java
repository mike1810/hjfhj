package obj_bas_pr2;

import java.util.Scanner;
import static java.lang.System.*;

public class ClockDemo {

    static final int S_CLOCK_TIME_MAX = (59 + 59*60 + 23*3600);//max for clock with 1 parameter(seconds)
    static final int HMS_HOURS_MAX = 23;  //max hours for clock with 3 parameters(hours,minutes,seconds)
    static final int HMS_MINUTES_MAX = 59;//max minutes for clock with 3 parameters(hours,minutes,seconds)
    static final int HMS_SECONDS_MAX = 59;//max seconds for clock with 3 parameters(hours,minutes,seconds)

    public static void main(String[] args) {
        //

        Clock qwe = new Clock();
        qwe.clockRepresentation();
        Clock firstClock = new Clock(getSecondsForSecondsConstructor());
        firstClock.clockRepresentation();
        Tick(10, firstClock);
        Clock secondClock = new Clock(getHoursForTimeConstructor(),getMinutesForTimeConstructor(),getSecondsForTimeConstructor());
        secondClock.clockRepresentation();
        TickDown(10, secondClock);

    }
    static int getSecondsForSecondsConstructor(){
        Scanner scan = new Scanner(in);
        int clockTime = -1;
        out.println("Setting time for clock:");
        do{
            out.println("Enter seconds since midnight which in [0;"+ S_CLOCK_TIME_MAX +"] for your first clock:");
            clockTime = scan.nextInt();
        }
        while(clockTime < 0 | clockTime > S_CLOCK_TIME_MAX);
        return clockTime;
    }
    static int getHoursForTimeConstructor(){
        Scanner scan = new Scanner(in);
        int clockHours = -1;
        out.println("Setting time for clock:");
        do{
            out.println("Enter hours which in [0;"+ HMS_HOURS_MAX +"] for your clock:");
            clockHours = scan.nextInt();
        }
        while(clockHours < 0 | clockHours > HMS_HOURS_MAX);
        return clockHours;
    }
    static int getMinutesForTimeConstructor(){
        Scanner scan = new Scanner(in);
        int clockMinutes = -1;
        do{
            out.println("Enter minutes which in [0;"+ HMS_MINUTES_MAX +"] for your clock:");
            clockMinutes = scan.nextInt();
        }
        while(clockMinutes < 0 | clockMinutes > HMS_MINUTES_MAX);
        return clockMinutes;
    }
    static int getSecondsForTimeConstructor(){
        Scanner scan = new Scanner(in);
        int clockSeconds = -1;
        do{
            out.println("Enter seconds which in [0;"+ HMS_SECONDS_MAX +"] for your clock:");
            clockSeconds = scan.nextInt();
        }
        while(clockSeconds < 0 | clockSeconds > HMS_SECONDS_MAX);
        return clockSeconds;
    }
    static void Tick(int tickForSoManySeconds, Clock clock){
        out.println("We will set clock " + tickForSoManySeconds + " seconds ahead");
        for(int i = 0; i < tickForSoManySeconds; i++){
            clock.tick();
            out.print((i+1) + " tick time:"); clock.clockRepresentation();
        }
        out.println("After " + tickForSoManySeconds + " seconds, time o` clock is:");
        clock.clockRepresentation();
    }
    static void TickDown(int tickForSoManySeconds, Clock clock){
        out.println("We will set clock " + tickForSoManySeconds + " seconds back");
        for(int i = 0; i < tickForSoManySeconds; i++){
            clock.tickDown();
            out.print((i+1) + " tick back time:"); clock.clockRepresentation();
        }
        out.println(tickForSoManySeconds + " seconds back, time o` clock was:");
        clock.clockRepresentation();
    }
}