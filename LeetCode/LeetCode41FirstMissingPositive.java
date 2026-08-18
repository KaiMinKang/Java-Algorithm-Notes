package LeetCode;

public class LeetCode41FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int temp;
        for (int i = 0; i < nums.length; i++) {
            //当前下标i内的元素不等于i+1的话，则把nums[i]交换到他的位置nums[nums[i]-1]
            while (nums[i] != i + 1 && nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}
