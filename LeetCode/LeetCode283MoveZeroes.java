package LeetCode;

public class LeetCode283MoveZeroes {
    public void moveZeroes(int[] nums) {
        int left=0;
        int right=0;
        while (right<nums.length){
            if(nums[right]!=0){
                int temp=nums[left];
                nums[left]=nums[right];
                nums[right]=temp;
                left++;
            }
            right++;//右指针向右移动一位，寻找非零元素
        }
    }
}
