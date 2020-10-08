package ca.bytetube._02_list;


public class PartitionList {

    /*
     * 主旋律：构建全新链表
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;

        ListNode lHead = new ListNode(0);
        ListNode lTail = lHead;
        ListNode rHead = new ListNode(0);
        ListNode rTail = rHead;

        while (head != null){
            if (head.val < x) {
                lTail = lTail.next = head;
            }else {
                rTail = rTail.next = head;
            }

            head = head.next;
        }

        rTail.next = null;
        lTail.next = rHead.next;


        return lHead.next;
    }
}
