package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode15ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        /*
        给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]]
        满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。
        请你返回所有和为 0 且不重复的三元组。
        注意：答案中不可以包含重复的三元组。

        思路：排序+固定一位遍历，双指针法
        1. 首先对数组进行排序
        2. 固定一个数，使用双指针法在剩余数组中寻找两个数（转换为两数之和问题），使得它们的和等于固定数的相反数
        3. 为了避免重复解，需要跳过重复的数,判断nums[i] == nums[i-1]
         */
        Arrays.sort(nums);
        int left;
        int right;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {//遍历数组，固定一个数,只遍历到倒数第三个数
            if (i > 0 && nums[i] == nums[i - 1]) {//如果当前数字跳过重复的数
                continue;
            }
            /*
            此题的两个可优化的小点
            1.如果nums[i]+nums[i+1]+nums[i+2]>0（最小的三个数字之和都大于0）
            则nums[i]之后的数不可能找到满足条件的三元组
            2.如果nums[i]+nums[n-2]+nums[n-1]<0（第一个数字固定后，最大的两个数字与他相加小于0）
            则nums[i]现在这一次肯定不可能找到满足条件的三元组，但i+1后就不一定了
             */
            if (nums[i] + nums[i + 1] + nums[i + 2] > 0){
                break;
            }
            if (nums[i] + nums[nums.length - 2] + nums[nums.length - 1] < 0){
                continue;//这里不是break，因为break会退出循环，而continue只是跳过当前循环的剩余部分，进入下一次循环
            }
            left = i + 1;//左指针从固定数的下一个数开始
            right = nums.length - 1;//右指针从数组最后一个数开始
            while (left < right) {
                if (nums[left] + nums[right] < -nums[i]) {//如果两数之和小于目标值，则左指针右移
                    left++;//左指针右移
                } else if (nums[left] + nums[right] > -nums[i]) {//如果两数之和大于目标值，则右指针左移
                    right--;
                } else {
                    //Arrays.asList() 是工具方法：
                    //接收多个值，自动包装成一个 List 集合。
                    // 等价于生成一个 List<Integer>：[nums[i], nums[left], nums[right]]
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 添加结果到列表之后，更新left和right指针
                    left++;
                    right--;
                    // 注意更新完才能跳过重复的数
                    while (left < right && nums[left] == nums[left -1]) {
                        //注意这里对比的是left更新后，与上一个数字是不是相同，而不是下一个
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        //注意这里对比的是right更新后，与上一个数字是不是一样，而不是下一个
                        right--;
                    }
                }
            }
        }
        return result;//注意如果遍历完数组还没有返回结果，则返回空列表
    }
}
