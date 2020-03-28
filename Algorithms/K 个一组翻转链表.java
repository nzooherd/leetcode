/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k <= 1) return head;
        ListNode p = head, flag = head, ret = head;
        int i = 0;
        for(; i < k; i++){
            if(flag != null) flag = flag.next;
            else break;
        }
        if(i != k) return head;
        ListNode q = p.next;
        while(q != flag){
            ListNode temp = q.next;
            q.next = p;
            p = q;
            q = temp;
        }
        ret = p;
        head.next = reverseKGroup(flag, k);
        return ret;
    }
}