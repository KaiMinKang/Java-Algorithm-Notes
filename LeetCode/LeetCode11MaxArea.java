package LeetCode;

import java.lang.Math;

public class LeetCode11MaxArea {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int currentArea = (right - left) * Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, currentArea);
            // 双指针移动
            //if (height[left] < height[right]) {
            //      left++;
            //} else {
            //      right--;
            //}

            //剪枝优化版双指针移动
            int hLeft = height[left];// 当前左柱子高度
            int hRight = height[right];// 当前右柱子高度

            if (hLeft < hRight) {
                // 从当前左柱子向右跳过所有 <= 当前短板高度的左柱子，直到找到第一个高度大于当前短板高度的左柱子（新hLeft）
                while (left < right && height[left] <= hLeft) {
                    left++;
                }
            } else {
                // 从当前右柱子向左跳过所有 <= 当前短板高度的右柱子，直到找到第一个高度大于当前短板高度的右柱子（新hRight）
                while (left < right && height[right] <= hRight) {
                    right--;
                }
            }
        }
        return maxArea;
    }
}
