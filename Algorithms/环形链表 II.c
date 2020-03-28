/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode *detectCycle(struct ListNode *head) {
        int flag=0;
        struct ListNode* r=NULL;
        struct ListNode *p1,*p2;
        p1=head;p2=head;
        while(p1&&p2){
            p1=p1->next;
            p2=p2->next;
            if(!p2) break;
            p2=p2->next;
            if(p1==p2) {
                flag=1;
                break;
            }
        }
        if(flag){
            p1=head;
            while(p1!=p2){
                p1=p1->next;
                p2=p2->next;
            }
            return p1;
     
        }
        return r;

}