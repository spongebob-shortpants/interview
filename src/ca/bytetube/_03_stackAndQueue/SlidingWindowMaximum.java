package ca.bytetube._03_stackAndQueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/sliding-window-maximum/
 * @author dal
 */
public class SlidingWindowMaximum {

    public int[] maxSlidingWindow2(int[] nums, int k) {

        if (nums == null || nums.length == 0 || k < 1) return new int[0];
        if (k == 1) return nums;

        int[] maxes = new int[nums.length - k + 1];

        //记录当前窗口中的最大值索引
        int maxIndex = 0;

        //先求出第一个窗口中k个元素的最大值索引
        for (int i = 1; i < k; i++) {
            if (nums[i] > nums[maxIndex]) maxIndex = i;
        }

        for (int li = 0; li < maxes.length; li++) {
            //li驱动ri的移动
            int ri = li + k - 1;
            if (maxIndex < li) { //最大值索引已经过期
                //需要老老实实的求出li～ri之间最大值索引
                maxIndex = li;
                for (int i = li+1; i <= ri ; i++) {
                    if (nums[i] > nums[maxIndex]) maxIndex = i;
                }
            }

            //最大值索引仍旧在窗口合法范围内（最大值索引没有过期）
            else if (nums[ri] >= nums[maxIndex]) {
                maxIndex = ri;
            }

            maxes[li] = nums[maxIndex];

        }

        return maxes;

    }
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
