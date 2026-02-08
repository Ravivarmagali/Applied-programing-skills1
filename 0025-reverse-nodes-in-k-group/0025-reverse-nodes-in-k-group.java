
class Solution { 
    /** 
*	Reverses nodes in k-group 
*	Given a linked list, reverse the nodes of a linked list k at a time 
*	@param head The head of the linked list 
*	@param k The group size for reversal 
*	@return The new head of the modified linked list 
     */ 
    public ListNode reverseKGroup(ListNode head, int k) { 

        
        ListNode dummy = new ListNode(0); 
        dummy.next = head; 
       
        
        ListNode previousGroupTail = dummy; 
       
        while (previousGroupTail != null) { 
            ListNode currentNode = previousGroupTail;             for (int i = 0; i < k; i++) {                 currentNode = currentNode.next; 
                if (currentNode == null) { 
                                   return dummy.next; 
                } 
            } 
           
           
                       ListNode groupStart = previousGroupTail.next;  
                          ListNode nextGroupStart = currentNode.next;      
           
                     currentNode.next = null; 
              previousGroupTail.next = reverse(groupStart); 
           
                       groupStart.next = nextGroupStart; 
           
                       previousGroupTail = groupStart; 
        } 
       
        return dummy.next; 
    } 
   
    /** 
*	Helper method to reverse a linked list 
*	@param head The head of the linked list to reverse 
*	@return The new head of the reversed linked list 
     */ 
    private ListNode reverse(ListNode head) { 
       
        ListNode dummy = new ListNode(); 
        ListNode current = head; 
       
                 while (current != null) { 

            ListNode nextNode = current.next;  
            current.next = dummy.next;        
                dummy.next = current;                    current = nextNode;                  
        } 
       
        return dummy.next; 
    } 
} 
 
