package LeetCode;

public class LeetCode41FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int temp;
        for (int i = 0; i < nums.length; i++) {
            //如果x不在x-1下标的位置（在i的位置）
            //则交换i下标位置的值和x-1下标位置的值
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
