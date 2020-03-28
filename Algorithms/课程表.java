public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
    	int[][] map = new int[numCourses][numCourses];
    	int[] pre = new int[numCourses];
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i = 0; i < prerequisites.length; i++){
			pre[prerequisites[i][1]]++;
			map[prerequisites[i][0]][prerequisites[i][1]] = 1;

		}
		for(int i = 0; i < numCourses; i++) {
			if(pre[i] == 0) q.offer(i);
		}
		int count = 0, now = 0;
		while(q.size() != 0) {
			now = q.poll();
			count++;
			for(int j = 0; j < numCourses; j++) {
				if(map[now][j] == 1) {
					pre[j]--;
					if(pre[j] == 0) q.offer(j);	
				}
			}
		}
		if(count == numCourses) return true;
		else return false;
    }
}