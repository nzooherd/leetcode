class Solution {
    public int findCircleNum(int[][] M) {
        int[] parents = new int[M.length];
        for(int i = 0; i < M.length; i++){
            parents[i] = -1;
        }
        for(int i = 0; i < M.length; i++){
            for(int j = 0; j < M.length; j++){
               if(i != j && M[i][j] == 1){
                   union(i, j, parents);
               }
            }
        }
        int ret = 0;
        for(int i = 0; i < parents.length; i++){
            if(parents[i] == -1) ret++;
        }
        return ret;
    }

    public void union(int x, int y, int[] parents){
        int px = findSet(x, parents);
        int py = findSet(y, parents);
        if(px < py){
            parents[px] = py;
        } else if(px > py){
            parents[py] = px;
        }
    }
    public int findSet(int x, int[] parents){
        if(parents[x] == -1){
            return x;
        }
        parents[x] = findSet(parents[x], parents);
        return parents[x];
    }
}