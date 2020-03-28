public class Solution {
	public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
		int[] side = new int[6];
		side[0] = length(p1, p2);
		side[1] = length(p1, p3);
		side[2] = length(p1, p4);
		side[3] = length(p2, p3);
		side[4] = length(p2, p4);
		side[5] = length(p3, p4);
		Arrays.sort(side);
		for(int i = 1; i < 4; i++) {
		    if(side[i] == 0) return false;
			if(side[i] != side[i-1]) return false;
		}
		if(side[5] != side[4]) return false;
		if(side[5] != side[0] + side[1]) return false;
		return true;

	}
	public int length(int[] p1, int[] p2){
		int a = (int)(Math.pow(p1[0]-p2[0], 2) + Math.pow(p1[1]-p2[1], 2));
		System.out.println(a);
		return a;
	}
}