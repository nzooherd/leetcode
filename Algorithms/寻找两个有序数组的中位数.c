double findMedianSortedArrays(int* nums1, int nums1Size, int* nums2, int nums2Size) {
	int* nums;
	int i,a=0,b=0;
	nums=(int*)malloc(sizeof(int)*(nums1Size+nums2Size));
	for(i=0;i<nums1Size+nums2Size;i++){
		if(b>=nums2Size||a<nums1Size&&nums1[a]<=nums2[b]){
			nums[i]=nums1[a];
			a++;
		}
		else {
			nums[i]=nums2[b];
			b++;
		}
		if(i==(nums1Size+nums2Size)/2) break;
	}
	if(i*2==nums1Size+nums2Size){
		return (nums[i]+nums[i-1])*1.0/2;
	}
	else return nums[i]*1.0;
}