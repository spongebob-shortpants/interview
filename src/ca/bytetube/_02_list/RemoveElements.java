package ca.bytetube._02_list;

/**
 * https://leetcode.com/problems/remove-linked-list-elements/
 * @author dal
 * 主旋律：构建全新链表
 */
public class RemoveElements {

    public ListNode removeElements(ListNode head, int val) {//head 是当前节点
        if (head == null) return null;

        //0.创建dummyNode
        //1.创建newHead,newTail
        ListNode newHead = new ListNode(0);//dummyNode
        ListNode newTail = newHead;

        while (head != null){
            if (head.val != val) {
                newTail = newTail.next = head;
                }
            head = head.next;
        }
            //处理尾节点 把tail.next清空
            newTail.next = null;
        return newHead.next;
    }



    public ListNode removeElements1(ListNode head, int val) {//head 是当前节点
        if (head == null) return null;
        //主旋律：构建全新链表
        //1。创建newHead,newTail
        ListNode newHead = null;
        ListNode newTail = null;

        while (head != null){
            if (head.val != val) {
                if (newTail == null) {
                    newHead = head;
                    newTail = head;
                }else {
                    newTail.next = head;
                    newTail = head;
                }
            }
            head = head.next;
        }
        if (newTail == null) {
           return null;
        }else {

            //处理尾节点 把tail.next清空
            newTail.next = null;
        }
        return newHead;
    }

}
