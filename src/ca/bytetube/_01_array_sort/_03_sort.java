package ca.bytetube._01_array_sort;

public class _03_sort {

    public static int[] sort(int[] nums){
        if (nums.length == 0) return  new int[]{-1,-1};

        //从左向右扫描，得到数组的最右逆序对
        int max = nums[0];
        //最大逆序对的右区间
        int r = -1;
        for (int cur = 1; cur < nums.length; cur++) {
            if (nums[cur]>= max) {
                max = nums[cur];
            }else {
                //当前是产生逆序对的时候，记录
                r = cur;
            }
        }

        //从右向左扫描，得到数组的最左逆序对
        int min = nums[nums.length - 1];
        //最大逆序对的左区间
        int l = -1;
        for (int cur = nums.length - 2 ; cur >= 0; cur--) {
            if (nums[cur]<= min) {
                min = nums[cur];
            }else {
                //当前是产生逆序对的时候，记录
                l = cur;
            }
        }

        return new int[]{l,r};


    }

    public static void main(String[] args) {
        int[] arr = {1,5,4,3,2,6,7,2,9};
        int[] sort = sort(arr);
        System.out.println(sort[0]);
        System.out.println(sort[1]);
    }


}
