package ca.bytetube._03_stackAndQueue;

import java.util.Arrays;
import java.util.Stack;

public class ParentIndex {


    public static int[] parentIndex(int[] nums){
        if (nums == null || nums.length == 0) return null;

        //1.从头扫描一遍所有的元素
        //2.保持栈从栈底到栈顶始终单调递减
        int[] lis = new int[nums.length];//存左边第一个比它大的数索引
        int[] ris = new int[nums.length];//存右边第一个比它大的数索引
        Stack<Integer> stack = new Stack<>();

        //初始化
        for (int i = 0; i < nums.length; i++) {
            ris[i] = -1;
            lis[i] = -1;
        }
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]){
                //右边第一个比栈顶大的元素的下标i
                ris[stack.pop()] = i;

            }
            //陷阱：有可能在弹栈的过程中，没有弹空，
            if (!stack.isEmpty()) {
                lis[i] = stack.peek();
            }
            stack.push(i);//第一次压栈
        }

        System.out.println(Arrays.toString(lis));
        System.out.println(Arrays.toString(ris));

        int[] pis = new int[nums.length];
        for (int i = 0; i < pis.length; i++) {
            if (lis[i] == -1 && ris[i] == -1) {
                pis[i] = -1;
                continue;
            }

            if(lis[i] == -1){
                pis[i] = ris[i];
            }else if (ris[i] == -1){
                pis[i] = lis[i];
            }else if (nums[lis[i]] < nums[ris[i]]) {
                pis[i] = lis[i];
            }else {
                pis[i] = ris[i];
            }

        }

        return pis;

    }


    public static void main(String[] args) {
        int[] arr = {3,2,1,6,0,5};
        parentIndex(arr);
        System.out.println(Arrays.toString( parentIndex(arr)));

    }

}
