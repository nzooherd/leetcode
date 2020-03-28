public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		int sum1 = (D - B) * (C - A);
		int sum2 = (G - E) * (H - F);
		int m, n, x, y;
		x = Math.min(G,C);
		y = Math.min(H,D);
		m = Math.max(A,E);
		n = Math.max(B,F);
		if(x > m && y > n) return sum1 + sum2 - (x - m) * (y - n);
		return sum1 + sum2; 
    }
}