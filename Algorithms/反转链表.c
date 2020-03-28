/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* reverseList(struct ListNode* head) {
	struct ListNode *pre = NULL,* sub = NULL ,*temp = NULL;
	if(!head) return head;
	pre = head;
	sub = head->next;
	head->next =NULL;
	while(sub){
		temp = sub->next;
		sub->next = pre;
		pre = sub;
		sub = temp;
	}
	return pre;
}