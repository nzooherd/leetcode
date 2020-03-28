public class Solution {
	public int calculateMinimumHP(int[][] dungeon) {
		int m = dungeon.length, n = dungeon[0].length;
		int[][] hp = new int[m][n];
		hp[m-1][n-1] = Math.max(1, 1 - dungeon[m-1][n-1]);
		for(int i = m-2; i >= 0 ; i--) {
			hp[i][n-1] = Math.max(1, 0 - dungeon[i][n-1] + hp[i+1][n-1]);
		}
		for(int i = n-2; i >= 0 ; i--) {
			hp[m-1][i] = Math.max(1, 0 - dungeon[m-1][i] + hp[m-1][i+1]);
		}
		for(int i = m-2; i >= 0; i--) {
			for(int j = n-2; j >= 0; j--) {
				hp[i][j] = Math.max(1, 0 - dungeon[i][j] + Math.min(hp[i][j+1], hp[i+1][j]));
			}
		}
		return hp[0][0];
	}
}