class Solution {
	public void expand(int[] ratings, int[] res, int index){
		int left = index - 1, right = index + 1;
		int cur_num = 1;
		while(left >= 0){
			if(ratings[left] > ratings[left+1]){
				res[left] = Math.max(res[left], cur_num + (ratings[left] > ratings[left+1] ? 1 : 0));
				cur_num = res[left];
			}else{
				break;
			}
            left--;
		}
        cur_num = 1;
		while(right < ratings.length){
			if(ratings[right] > ratings[right-1]){
				res[right] = Math.max(res[right], cur_num + (ratings[right] > ratings[right-1] ? 1 : 0));
				cur_num = res[right];
			}else{
				break;
			}
            right++;
		}
	}


    public int candy(int[] ratings) {
    	if(ratings.length <= 1){
    		return ratings.length;
    	}

    	int[] res = new int[ratings.length];
    	for(int i = 0; i < ratings.length; i++){
    		res[i] = 1;
    	}
    	for(int i = 0; i < ratings.length; i++){
    		if(i != 0 && ratings[i] > ratings[i-1]){
    			continue;
    		}
    		if(i != ratings.length - 1 && ratings[i] > ratings[i + 1]){
    			continue;
    		}

            res[i] = 1;
    		expand(ratings, res, i);
    	}

    	int resSum = 0;
    	for(int num : res){
    		resSum += num;
    	}
    	return resSum;
    }
}