public class Solution {
    public boolean validUtf8(int[] data) {
		for(int i = 0; i < data.length; i++) {
			if(data[i] <= 127) ;
			else if(data[i] < 224 && i+1 < data.length) {
				if(data[++i] < 128 || data[i] >= 192) return false;
			}
			else if(data[i] < 240 && i+2 < data.length) {
				if(data[++i] < 128 || data[i] >= 192) return false;
				if(data[++i] < 128 || data[i] >= 192) return false;
			}
			else if(data[i] < 248 && i+3 < data.length) {
				if(data[++i] < 128 || data[i] >= 192) return false;
				if(data[++i] < 128 || data[i] >= 192) return false;
				if(data[++i] < 128 || data[i] >= 192) return false;
			}
			else return false;			
		}
		return true;  
    }
}