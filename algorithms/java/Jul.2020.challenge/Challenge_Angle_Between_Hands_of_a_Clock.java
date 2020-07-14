class Solution {
    public double angleClock(int hour, int minutes) {
        if(hour == 12)
            hour = 0;
        
        double diff = Math.abs(hour*5 + minutes/12.0 - minutes)*6;
        
        return diff < 180 ? diff : 360 - diff;
    }
}
