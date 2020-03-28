int majorityElement(int* nums, int numsSize) {
		int i=0,flag=1,r=nums[0];
		for(i=1;i<numsSize;i++){
			if(!flag) {
				r=nums[i];
				flag=1;
				continue;
			}
			if(nums[i]==r){
				flag++;
			}
			else flag--;
		}
		return r;
}