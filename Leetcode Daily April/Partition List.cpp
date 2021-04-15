/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* partition(ListNode* head, int x) {
    ListNode* temp=head;
    ListNode * l_s=NULL; ListNode * l_e=NULL; 
    ListNode * r_s=NULL; ListNode * r_e=NULL; 
    
    while(temp!=NULL){
      if(temp->val<x){
        if(l_s==NULL){
          l_s=temp;
          l_e=temp;
        } 
        else{
          l_e->next=temp;
          l_e=l_e->next;
        }
      }
      else{
        if(r_s==NULL){
          r_s=temp;
          r_e=temp;
        } 
        else{
          r_e->next=temp;
          r_e=r_e->next;
        }
      }
      temp=temp->next;
    }
    
    if(l_s==NULL) return r_s;
    if(r_s) r_e->next=NULL;
    l_e->next=r_s;
    return l_s;
      
    }
};