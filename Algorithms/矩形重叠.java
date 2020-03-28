class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int[][] rec = new int[4][2];
        rec[0][0] = rec1[0];
        rec[0][1] = rec1[2];
        rec[1][0] = rec1[1];
        rec[1][1] = rec1[3];

        rec[2][0] = rec2[0];
        rec[2][1] = rec2[2];
        rec[3][0] = rec2[1];
        rec[3][1] = rec2[3];
        if(judgeNode(rec[0], rec[2]) && 
            judgeNode(rec[1], rec[3])) return true;
       return false;

    }
    public boolean judgeNode(int[] rec1, int []rec2){
        if(rec1[1] < rec2[1]) return rec1[1] > rec2[0];
        if(rec1[1] > rec2[1]) return rec1[0] < rec2[1];
        if(rec1[1] == rec2[1]) return true;
        return false;
    }
}