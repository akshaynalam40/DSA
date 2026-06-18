class Solution {
    public double angleClock(int hour, int minutes) {
        if(hour==12){
             hour= 0;
        }
        double large=30*(hour%12)+0.5*minutes;
        double small=6*minutes;

        double angle=Math.abs(large-small);

        return Math.min(angle,360.0-angle);
        
        
    }
}