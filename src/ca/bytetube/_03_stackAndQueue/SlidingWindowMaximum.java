package ca.bytetube._03_stackAndQueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/sliding-window-maximum/
 * @author dal
 */
public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {

        if (nums == null || nums.length == 0 || k < 1)  return new int[0];
        if (k == 1) return nums;

        int[] maxes = new int[nums.length - k + 1];

        Deque<Integer> deque = new LinkedList<>();

        //只要nums[tail] <= nums[i],就删除队尾
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]){
                    deque.removeLast();
            }

            //能来到这，说明队尾的那些<=nums[i]的值都被删除了
            //将i加入队尾
            deque.addLast(i);

            //检查窗口索引是否合法
            int w = i - k + 1;
            if (w < 0) continue;

            //检查窗口队头元素是否过期
            if (deque.peekFirst() < w) {//已经过期
                deque.removeFirst();
            }

            //设置窗口的最大值
            maxes[w] = nums[deque.peekFirst()];

        }

        return maxes;
    }

}
