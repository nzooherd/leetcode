/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
    	if (head == null || head.next == null){
    		return head;
    	}

    	ListNode slow = head;
    	ListNode quick = head.next;
    	while(quick != null){
    		quick = quick.next;
    		if(quick == null){
    			break;
    		}
    		quick = quick.next;
            slow = slow.next;
    	}
    	quick = slow.next;
    	slow.next = null;
    	slow = head;


    	slow = sortList(slow);
    	quick = sortList(quick);

    	if(slow.val < quick.val){
    		head = slow;
    		slow = slow.next;
    	} else{
    		head = quick;
    		quick = quick.next;
    	}
    	ListNode cur = head;

    	while(slow != null && quick != null){
    		if(slow.val < quick.val){
    			cur.next = slow;
    			slow = slow.next;
    		} else{
    			cur.next = quick;
    			quick = quick.next;
    		}
    		cur = cur.next;
    	}
    	if(slow != null){
    		cur.next  = slow;
    	}else{
    		cur.next = quick;
    	}

    	return head;
    }
}