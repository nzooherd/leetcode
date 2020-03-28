class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int minCol = 0x8ffffff, minRow = 0x8ffffff;
        if(ops.length <= 0) return m * n; 
        for(int i = 0; i < ops.length; i++){
            minCol = Math.min(minCol, ops[i][0]);
            minRow = Math.min(minRow, ops[i][1]);    
        }
        return minCol * minRow;
    }
}