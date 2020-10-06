package ca.bytetube._01_array_sort;

/**
 * https://leetcode.com/problems/sort-colors/
 * @author dal
 */
public class _02_sort_colors {

    public void sortColors(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int cur = 0;

        while (cur <= r){
            if (nums[cur] == 0) {
                swap(nums,cur++,l++);

            }else if (nums[cur] == 1) {
                cur++;
            }else {
                swap(nums,cur,r--);

            }

        }


    }

    private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
    }


}
