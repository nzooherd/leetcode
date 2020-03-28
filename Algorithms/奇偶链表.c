/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
 typedef struct ListNode ListNode;
struct ListNode* oddEvenList(struct ListNode* head) {
	if(!head || !head->next) ;
	else{
		ListNode* odd = (ListNode*)malloc(sizeof(ListNode));
		ListNode* even = (ListNode*)malloc(sizeof(ListNode));
		ListNode* temp = (ListNode*)malloc(sizeof(ListNode));
		odd = head; 
		temp = head->next;
		even = head->next;
		while(odd&&even&&even->next){
			odd->next = even->next;
			odd = odd->next;
			even->next = odd->next;
			even = even->next;
		}
		odd->next = (ListNode*)malloc(sizeof(ListNode));
		odd->next = temp;
		
	}
	return head;

}