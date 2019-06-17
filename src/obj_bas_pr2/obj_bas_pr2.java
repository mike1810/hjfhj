package obj_bas_pr2;

import java.util.Scanner;
import static java.lang.System.*;

public class obj_bas_pr2 {

    static final int S_CLOCK_TIME_MAX = (59 + 59*60 + 23*3600);//max for clock with 1 parameter(seconds)
    static final int HMS_HOURS_MAX = 23;  //max hours for clock with 3 parameters(hours,minutes,seconds)
    static final int HMS_MINUTES_MAX = 59;//max minutes for clock with 3 parameters(hours,minutes,seconds)
    static final int HMS_SECONDS_MAX = 59;//max seconds for clock with 3 parameters(hours,minutes,seconds)

    public static void main(String[] args) {
        //
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





        for(int i = 0; i < tickForSoManySeconds; i++){
            clock.tickDown();
        }
    }
}
class Clock{
    private int hours;
    private int minutes;
    private int seconds;
    static final int HID = 24;//hours in day
    static final int SIM = 60;//seconds in minute
    static final int SIH = 3600;//seconds in hour
    {
        hours = 12;
        minutes = 0;
        seconds = 0;
    }
    Clock(int seconds){
        setClockNotAfterMorning(seconds);
    }
    Clock(int hours, int minutes, int seconds){
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }
    protected void setClock(int seconds)
    {
        int hours = (seconds - seconds%SIH)/(SIH);
        this.hours = hours%HID;//после полуночи
        this.seconds = seconds%SIM;
        this.minutes = (seconds - this.seconds - hours*SIH)/60;
    }
    protected void setClockNotAfterMorning(int seconds)
    {
        this.hours = (seconds - seconds%SIH)/(SIH);
        this.seconds = seconds%SIM;
        this.minutes = (seconds - this.seconds - this.hours*SIH)/60;
    }
    protected void tick(){
        addClock(new Clock(0,0,1));
    }
    protected void tickDown(){
        if(this.hours > 0 || this.minutes > 0 || this.seconds > 0){
            addClock(new Clock(0,0,-1));
        }
    }
    protected void addClock(Clock clock){
        int hoursToSeconds = (this.hours+clock.hours)*SIH;
        int minutesToSeconds = (this.minutes+clock.minutes)*SIM;
        int allSeconds = (this.seconds+clock.seconds) + hoursToSeconds + minutesToSeconds;
        setClockNotAfterMorning(allSeconds);
    }
    protected void subtractClock(Clock clock){
        int hoursToSeconds = (this.hours - clock.hours)*SIH;
        int minutesToSeconds = (this.minutes - clock.minutes)*SIM;
        int allSeconds = (this.seconds - clock.seconds) + hoursToSeconds + minutesToSeconds;
        setClockNotAfterMorning(allSeconds);
    }
    void clockRepresentation(){
        System.out.println( "(" + ((this.hours>9)?this.hours:("0"+this.hours)) + ":"
                                + ((this.minutes>9)?this.minutes:("0"+this.minutes)) + ":"
                                + ((this.seconds>9)?this.seconds:("0"+this.seconds)) + ")");
    }
}