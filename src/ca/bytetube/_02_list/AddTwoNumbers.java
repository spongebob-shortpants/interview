package ca.bytetube._02_list;

/**
 * https://leetcode.com/problems/add-two-numbers/
 * @author dal
 */


public class AddTwoNumbers {

    /**
     * 思想：创建新的list
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)  return l2;
        if (l2 == null)  return l1;

        ListNode dummyNode = new ListNode(0);
        ListNode last = dummyNode;
        //进位
        int carry = 0;
        while (l1 != null || l2 != null){
            int v1 = 0;
            if (l1 != null) {
                v1 = l1.val;
                l1 = l1.next;
            }
            int v2 = 0;
            if (l2 != null) {
                v2 = l2.val;
                l2 = l2.next;
            }
            int sum = v1 + v2 + carry;
            //本位加法结束，可能需要更新进位
            carry = sum / 10;
            //sum个位数作为新节点的值
            last = last.next = new ListNode(sum % 10);
        }
        //当l1和l2都遍历完了，需要检查最后的进位值carry
        if (carry > 0) {//carry = 1
            last.next = new ListNode(carry);
        }

        return dummyNode.next;
    }
}
