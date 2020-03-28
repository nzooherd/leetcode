/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
		if(head == null) return head;
		ListNode ans = new ListNode(head.val);
		ListNode p = head.next;
		ListNode q = ans;
		int temp = head.val;
		while(p != null) {
			if(p.next != null && p.val != p.next.val) {
				if(p.val != temp) {
					q.next = new ListNode(p.val);
					q = q.next;
				}
			}
			if(p.next == null) {
				if(p.val != temp){
					q.next = new ListNode(p.val);
					q = q.next;
				}
			}
			temp = p.val;
			p = p.next;
		}
		if(head.next != null && head.next.val == ans.val) return ans.next;
		return ans;
    }
}