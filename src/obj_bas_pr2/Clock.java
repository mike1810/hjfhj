package obj_bas_pr2;

import static java.lang.System.out;

class Clock{
    private int hours;
    private int minutes;
    private int seconds;
    static final int HID = 24;//hours in day
    static final int SIM = 60;//seconds in minute
    static final int SIH = 3600;//seconds in hour
    {
    }
    Clock(){
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
        out.println((allSeconds > 0) ? "Clock ":"");
        setClockNotAfterMorning(allSeconds);
    }
    void clockRepresentation(){
        System.out.println( "(" + ((this.hours>9)?this.hours:("0"+this.hours)) + ":"
                + ((this.minutes>9)?this.minutes:("0"+this.minutes)) + ":"
                + ((this.seconds>9)?this.seconds:("0"+this.seconds)) + ")");
    }
}