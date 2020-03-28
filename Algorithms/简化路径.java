public class Solution {
	public String simplifyPath(String path) {
		Deque<String> stack = new LinkedList<String>();
		Set<String> skip = new HashSet<String>(Arrays.asList("..",".",""));
		for(String s : path.split("/")) {
		    System.out.println(s);
			if(s.equals("..") && !stack.isEmpty()) stack.pop();
			else if(!skip.contains(s)) stack.push(s);
		}
		String ans = "";
		for(String s : stack) ans = "/" + s + ans;
		System.out.println(ans);
		if(ans.length() == 0) return "/";
		else return ans;

	}
}