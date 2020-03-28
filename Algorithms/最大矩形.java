class Solution {
    public int maximalRectangle(char[][] matrix){
        if(matrix == null || matrix.length == 0) return 0;
        int[][] tempMatrix = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j< matrix[0].length; j++){
                if(matrix[i][j] == '0') {
                    tempMatrix[i][j] = 0;
                } else {
                    tempMatrix[i][j] = 1 + (i == 0 ? 0 : tempMatrix[i-1][j]);
                }
            }
        }
        int ret = 0;
        for(int i = 0; i< matrix.length; i++){
            int temp = findMax(tempMatrix[i]);
            ret = Math.max(ret, temp);
        }
        return ret;

    }
    public int findMax(int[] rectangle){
        int max = 0;
        LinkedList<Integer> stack = new LinkedList<>();
        stack.addLast(0);
        for(int i = 1; i < rectangle.length; i++){
            while(!stack.isEmpty() && rectangle[stack.peek()] > rectangle[i]){
                int right = i;
                int val = rectangle[stack.poll()];
                int left = stack.isEmpty() ? -1 : stack.peek();
                max = Math.max(max, val * (right - left - 1));
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int val = rectangle[stack.poll()];
            int left = stack.isEmpty() ? -1 : stack.peek();
            max = Math.max(max, val * (rectangle.length - left - 1));
        }
        return max;
    }
}