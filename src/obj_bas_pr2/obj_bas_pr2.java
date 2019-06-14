package obj_bas_pr2;

public class obj_bas_pr2 {
}

class clock{
    int hours;
    int minutes;
    int seconds;

    static final int MID = 60;//hours in day
    static final int MIH = 60;//minutes in hour
    static final int SIM = 60;//seconds in minute
    static final int SIH = 3600;//seconds in hour
    {
        hours = 12;
        minutes = 0;
        seconds = 0;
    }
    clock(int seconds){
        //hours = ((seconds - seconds%SIH)/(SIH))%24;
        //minutes = (seconds - seconds%MIH)/%MIH;
        //seconds -=(hours*SIH + minutes*SIM);
    }
    clock(int hours, int minutes, int seconds){
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }
}