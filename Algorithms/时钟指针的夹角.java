class Solution {
    public double angleClock(int hour, int minutes) {
       	double  hourAngle = 0, minAngle = 0;
       	minAngle = minutes * 1.0 / 60 * 360;

       	hour = hour % 12;
       	hourAngle = hour * 1.0 / 12 * 360 + (minutes  * 1.0) / 60 * 30;

       	double diffAngle = Math.abs(minAngle - hourAngle);
       	if(diffAngle >= 180){
       		diffAngle = 360 - diffAngle;
       	}
       	return diffAngle;


    }
}