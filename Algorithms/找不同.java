public class Solution {
    public char findTheDifference(String s, String t) {
			int chars = 0, chart = 0;
			for(int i = 0; i < s.length(); i++)
				chars += (int)s.charAt(i);
			for(int i = 0; i < t.length(); i++)
				chart += (int)t.charAt(i);
			return (char)(chart - chars);
    }
}