public class Solution {
	public boolean isPalindrome(ListNode head){
		if(head == null || head.next == null) return true;
		if(head.next.next == null ) {
			if(head.val == head.next.val) return true;
			else return false;
		}
		ListNode low = head, fast = head.next.next;
		while(fast != null) {
			low = low.next;
			fast = fast.next;
			if(fast == null) break;
			fast = fast.next;
		}
		ListNode p = low, q = low.next;
		low.next = null;
		ListNode temp;
		while(q != null) {
			temp = q.next;
			q.next = p;
			p = q;
			q = temp;
		}
		while(p.val == head.val){
			if(p == head || p.next == head) return true;
			p = p.next;
			head = head.next;
		}
		return false;
	}
}