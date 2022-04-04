package leetcode;

public class SwappingNodesInALinkedList_1721 {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode tempNode=null;
        int tempVal=0;
        ListNode iterable=head;
        int totalLen=1;
        if(totalLen==k){
            tempNode=iterable;
        }
        while(iterable.next!=null){
            iterable=iterable.next;
            totalLen++;
            if(totalLen==k){
                tempNode=iterable;
            }
        }
        iterable=head;
        int len=1;
        if(len==totalLen-k+1){
            int temp=iterable.val;
            iterable.val=tempNode.val;
            tempNode.val=temp;
        }
        while(iterable.next!=null){
            iterable=iterable.next;
            len++;
            if(len==totalLen-k+1){
                int temp=iterable.val;
                iterable.val=tempNode.val;
                tempNode.val=temp;
            }
        }
        return head;
    }
}
