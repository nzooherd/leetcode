public class Solution {
	public String toHex(int num) {
	    if(num == 0) return "0";
			char[] dir = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
			String result = new String();
			while(num != 0) {
				result = dir[(num & 15)] + result;
				num >>>= 4;
			}
			return result;
	}

}