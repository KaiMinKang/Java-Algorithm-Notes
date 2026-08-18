package LeetCode;

public class LeetCode53MaxSubArray {
    public int maxSubArray(int[] nums) {
        int currentSum=nums[0];
        int maxSum=nums[0];
        for (int i = 1; i < nums.length; i++) {//注意下标是从1开始的，不能从0开始不然就算两遍了
            currentSum=Math.max(currentSum+nums[i],nums[i]);
            maxSum=Math.max(maxSum,currentSum);
        }
        return maxSum;
    }
}
