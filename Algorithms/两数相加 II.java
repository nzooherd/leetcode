/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
return intToList(sum(listToInt(l1),listToInt(l2))); 
    }
	public int[] listToInt(ListNode l1){
		int len1=0,index=0;
		ListNode temp;
		temp=l1;
		while(temp != null) {
			temp=temp.next;
			len1++;
		}
		int[] a=new int[len1];
		temp = l1;
		while(temp != null){
			a[index++] = temp.val;
			temp = temp.next;
		}
		return a;
	}
	public int[] sum(int[] l1,int[] l2){
		int[] r=new int[(l1.length>l2.length?l1.length:l2.length)+1];
		int i =0,temp;
		for(i=0;i<l1.length/2;i++){
			temp = l1[i];
			l1[i] = l1[l1.length-1-i];
			l1[l1.length-i-1] = temp;
		}
		for(i=0;i<l2.length/2;i++){
			temp = l2[i];
			l2[i] = l2[l2.length-1-i];
			l2[l2.length-i-1] = temp;
		}
		for(i=0;i<(l1.length>l2.length?l1.length:l2.length);i++){
			if(i<l1.length&&i<l2.length){
				r[i] +=	l1[i]+l2[i];
				r[i+1] += r[i]/10;
				r[i] %= 10;
			}
			else if(i >= l1.length){
				r[i] += l2[i];
				r[i+1] += r[i]/10;
				r[i] %= 10;
			}
			else{
				r[i] += l1[i];
				r[i+1] += r[i]/10;
				r[i] %= 10;
			}
		}
		return r;
	}
	public ListNode intToList(int[] r){
		ListNode q=new ListNode(r[0]);
		int i=0;
		for(i=1;i<r.length-1||(i == r.length-1&&r[i]!=0);i++)	{
			ListNode p=new ListNode(r[i]);
			p.next=q;
			q = p;					
		}
		return q;
	}
	
}