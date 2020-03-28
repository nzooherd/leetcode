public class Solution {
    public int hIndex(int[] citations) {
		if(citations == null || citations.length == 0) return 0; 
		if(citations[citations.length-1] < citations.length) {
			for(int i = citations.length-1; i >= 0; i--) {
				if(citations.length - i >= citations[i]) {
				return citations[i];
				}
			}
		}
		else{
			int j =citations.length-1,count = 0;
			for(int i = citations.length; i >=0; i--) {
				for(j = j; j >= 0; j--) {
					if(citations[j] >= i) {
						count++;
						if(count >= i) return i;
					}
					else break;
				}
				if(count >= i) return i;
			}
		}
		return 0;

    }
}