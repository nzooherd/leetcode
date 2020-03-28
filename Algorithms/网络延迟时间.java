class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        int[][] time = new int[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                time[i][j] = (i == j ? 0 : -1);
            }
        }
        for(int i = 0; i < times.length; i++){
            time[times[i][0]-1][times[i][1]-1] = times[i][2];
        }

        boolean[] vis = new boolean[N];
        int[] dis = new int[N];
        vis[K - 1] = true;
        int size = 1, ret = 0;
        for(int i = 0; i < N; i++){
            dis[i] = time[K-1][i] == -1 ? Integer.MAX_VALUE : time[K-1][i];
        }

        dis[K - 1] = 0;
        int node = K - 1;
        while(size < N){
            int min = Integer.MAX_VALUE, temp = 0;
            int dd = dis[node];
            for(int i = 0; i < N; i++){
                if(!vis[i]){
                    if(time[node][i] != -1 && time[node][i] + dd < dis[i]){
                        dis[i] = time[node][i] + dd;
                    }
                    if(min > dis[i]){
                        min = dis[i];
                        temp = i;
                    }
                }
            }
            if(min == Integer.MAX_VALUE ) break;

            vis[temp] = true;
            node = temp;
            size++;
        }
        if(size < N) return -1;
        for(int i = 0; i < N; i++){
            ret = Math.max(ret, dis[i]);
        }
        return ret;
    }
}