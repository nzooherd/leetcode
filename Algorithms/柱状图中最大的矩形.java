public class Solution {
	class p{
		int index;
		int height;
	}
	public int largestRectangleArea(int[] heights){
		if(heights.length < 1) return 0;
		int max = heights[0];
		p[] node = new p[heights.length];
		for(int  i = 0; i < heights.length; i++) {
		    node[i] = new p();
			node[i].index = i;
			node[i].height = heights[i];
		}
        Stack<p> stack = new Stack<p>();
		stack.push(node[0]);
		for(int i = 1; i < heights.length; i++) {
			while(!stack.empty() && stack.peek().height > heights[i]) {
				p temp = stack.pop();
				max = Math.max(max, temp.height * (stack.empty() ? i : i - stack.peek().index -1));
			}
			stack.push(node[i]);
		}
		int right = stack.peek().index;
		while(!stack.empty()) {
			p temp = stack.pop();
			if(!stack.empty()) max = Math.max(temp.height * (right - stack.peek().index), max);
			else {
				for(int i = temp.index; i >= 0; i--) {
					if(heights[i] < temp.height ) {
						max = Math.max(max, temp.height * (right - i));
						break;
					}
					if(i == 0) max = Math.max(max, temp.height * (right + 1));
				}
			}
		}
		return max;
	}
}