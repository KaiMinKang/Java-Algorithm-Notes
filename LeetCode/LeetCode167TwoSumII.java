package LeetCode;

class LeetCode167TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        /*
        采用了双指针，从最左端和最右端开始计算
        对于有序数组，相当于目前是最小的＋最大的
        如果和小于目标值，需要将小的数据变大，则左指针右移
        如果和大于目标值，则右指针左移，直到找到目标值或两个指针相遇
         */
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                return new int[] { left + 1, right + 1 };
            } else if (numbers[left] + numbers[right] < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[] {};
    }
}