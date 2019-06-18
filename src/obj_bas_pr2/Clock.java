package obj_bas_pr2;

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
        setClock(seconds);
    }
    Clock(int hours, int minutes, int seconds){
        int allSeconds = seconds+minutes*SIM + hours*SIH;
        setClock(allSeconds);
    }
    protected void setClock(int seconds)
    {
        if(seconds >= 0){
            if(seconds >= SIH*HID){
                //out.println("Time must have less than (24:00:00)" +
                //        " so we set clock after midnight");
            }
            int userHours = (seconds - seconds%SIH)/(SIH);
            this.hours = (userHours)%HID;//после полуночи
            this.seconds = seconds%SIM;
            this.minutes = (seconds - this.seconds - userHours*SIH)/60;
        }
        else{
            do{
                seconds +=SIH*HID;
            }
            while(seconds < 0);
            setClock(seconds);
        }
    }
    protected void tick(){
        addClock(new Clock(0,0,1));
    }
    protected void tickDown(){
        addClock(new Clock(23,59,59));
    }
    protected void addClock(Clock clock){
        int hoursToSeconds = (this.hours+clock.hours)*SIH;
        int minutesToSeconds = (this.minutes+clock.minutes)*SIM;
        int allSeconds = (this.seconds+clock.seconds) + hoursToSeconds + minutesToSeconds;
        setClock(allSeconds);
    }
    protected Clock subtractClock(Clock secondClock){
        Clock firstClock = new Clock(this.hours, this.minutes, this.seconds);
        int hoursToSeconds = (firstClock.hours - secondClock.hours)*SIH;
        int minutesToSeconds = (firstClock.minutes - secondClock.minutes)*SIM;
        int allSeconds = (firstClock.seconds - secondClock.seconds) + hoursToSeconds + minutesToSeconds;
        firstClock.setClock(Math.abs(allSeconds));
        return firstClock;
    }
    protected void clockRepresentation(){
        System.out.println( "(" + ((this.hours>9)?this.hours:("0"+this.hours)) + ":"
                + ((this.minutes>9)?this.minutes:("0"+this.minutes)) + ":"
                + ((this.seconds>9)?this.seconds:("0"+this.seconds)) + ")");
    }
}