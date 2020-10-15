package ca.bytetube._02_list;

/**
 * https://leetcode.com/problems/palindrome-linked-list/
 * @author dal
 */
public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)  return true;
        if (head.next.next == null) return head.val == head.next.val;
        //1.找到中间节点
        ListNode mid = middleNode(head);
        //2。翻转右半部分（中间节点右半部分）
        ListNode rHead = reverseList(mid.next);
        ListNode oldRHead = rHead;
        ListNode lHead = head;
        //3.lHead，rHead分别从list两端出发，依次进行对比，判断list是否是回文
        boolean res = true;
        while (rHead != null){
            if (lHead.val != rHead.val) {
                res = false;
                break;
            }
            rHead = rHead.next;
            lHead = lHead.next;
        }
        //4.恢复右半部分（中间节点右半部分）
        reverseList(oldRHead);
        return res;
    }


    private ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //头插
    private ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head!= null){
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        return newHead;
    }



}
