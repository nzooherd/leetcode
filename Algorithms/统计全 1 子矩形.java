class ContinueLength{
	int raw;
	int col;
	public ContinueLength(){
	}

}

class Solution {
    public int numSubmat(int[][] mat) {
    	ContinueLength[][] recordLengths = new ContinueLength[mat.length][mat[0].length];
    	for(int i = 0; i < mat.length; i++){
    		for(int j = 0; j < mat[0].length; j++){
    			recordLengths[i][j] = new ContinueLength();
    		}
    	}

    	for(int i = 0; i < mat.length; i++){
    		int len = 0;
    		for(int j = 0; j < mat[0].length; j++){
    			if(mat[i][j] == 1){
    				len += 1;
    			}else{
    				len = 0;
    			}
    			recordLengths[i][j].raw = len;
    		}
    	}
    	for(int j = 0; j < mat[0].length; j++){
    		int len = 0;
    		for(int i = 0; i < mat.length; i++){
    			if(mat[i][j] == 1){
    				len += 1;
    			}else{
    				len = 0;
    			}
    			recordLengths[i][j].col = len;
    		}
    	}

    	int sum =0;
    	for(int i = 0; i < mat.length; i++){
    		for(int j = 0; j < mat[0].length; j++){
    			if(mat[i][j] == 0){
    				continue;
    			}
    			int raw = recordLengths[i][j].raw, col = recordLengths[i][j].col;
    			int realCol = 0;
                int curSum = 0;
    			for(int a = 0; a < raw; a++){
    				for(realCol = 0; realCol < col; realCol++){
    					if (recordLengths[i-realCol][j].raw < (a+1)){
    						break;
    					}
    				}
                    curSum += realCol;
    			}
                sum += curSum;
    		}
    	}

    	return sum;
    }
}