package ca.bytetube._02_list;

public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != curB){
            curA = (curA == null) ? headB : curA.next;
            curB = (curB == null) ? headA :curB.next;
        }

        return curA;
    }
}
