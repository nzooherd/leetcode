class Solution {
    public int longestValidParentheses(String s) {
int res = 0;
int start = 0;
int[] stack = new int[s.length()];
int top = -1;
for (int i = 0; i < s.length(); i ++) {
if (s.charAt(i) == '(') {
stack[++top] = i;
} else {
if(top == -1) {
start = i + 1;
} else {
top--;
res = top == -1 ? Math.max(res, i - start + 1) : Math.max(res, i - stack[top]);
}
}
}
return res;
    }
}