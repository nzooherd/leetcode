/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
		int  left = 0,right = n;
		int r = 0;
		r = result(left,right);
		return r;
    }
	int result(int left,int right) {
		int r = 0,mid = (right-left)/2+left;
		if(guess(mid) == -1) {
			right = mid-1;
			r = result(left,right);
		}
		else if(guess(mid) == 1) {
			left = mid+1;
			r = result(left,right);
		}
		else {
			r = mid;
		}
		return r;
	}
}