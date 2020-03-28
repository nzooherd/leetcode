/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;
        RandomListNode p = head, q;
        while(p != null){
            q = p.next;
            p.next = new RandomListNode(p.label);
            System.out.print(p.label + " ");
            p.next.next = q;
            p = q;
        }
        p = head;
        while(p != null) {
            q = p.next.next;
            p.next.random = p.random == null ? null : p.random.next;
            p = q;
        }
        RandomListNode ret = head.next;
        q = head;
        p = ret;
        while(p != null){
            q.next = p.next;
            p.next = p.next == null ? null : p.next.next;
            q = q.next;
            p = p.next;
        }
        return ret;
    }
}