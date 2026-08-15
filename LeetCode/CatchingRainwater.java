package LeetCode;

public class CatchingRainwater {
    public int hashCode() {
        return super.hashCode();
    }

    public int trap(int[] height) {
        //总体思路
        //1 首先从左侧遍历记录砖块和雨水的最大和
        //2 然后从右侧遍历记录砖块和雨水的最大和
        //3 将两个数组取重叠部分，即为实际接到的雨水和砖块的总量
        //4 最后将重叠部分与砖块的总量相减即为实际接到的雨水量
//        int[] leftArr = new int[height.length];
//        int[] rightArr = new int[height.length];
//        int maxLeftHeight =0;
//        int maxRightHeight = 0;
//        leftArr[0] = height[0];
//        rightArr[height.length-1] = height[height.length-1];
        //第一版 根据思路两个for循环，一个从左到右，一个从右到左
        //第二版 从左到右遍历，同时记录砖左和右
        //第三版 看完题解，最大值是当前砖块高度使用Math.max对代码进行简化
        //第四版 看完讲解，使用双指针将空间复杂度优化至O(1)
        //第一版------------------------------
//        for (int i = 0; i < height.length; i++) {
//            if (height[i] > maxLeftHeight) {
//                maxLeftHeight = height[i];
//                leftArr[i] = maxLeftHeight;
//            }else{
//                leftArr[i] = maxLeftHeight;
//            }
//        }
//        for (int i = height.length-1; i >= 0; i--) {
//            if (height[i] > maxRightHeight) {
//                maxRightHeight = height[i];
//                rightArr[i] = maxRightHeight;
//            }else{
//                rightArr[i] = maxRightHeight;
//            }
//        }
        //第二版------------------------------
//        for (int i = 0; i < height.length; i++) {
//            if (height[i] > maxLeftHeight) {
//                maxLeftHeight = height[i];
//                leftArr[i] = maxLeftHeight;
//            }else{
//                leftArr[i] = maxLeftHeight;
//            }
//            if (height[height.length-1-i] > maxRightHeight){
//                maxRightHeight = height[height.length-1-i];
//                rightArr[height.length-1-i] = maxRightHeight;
//            }else{
//                rightArr[height.length-1-i] = maxRightHeight;
//            }
//        }
        //第三版------------------------------
//        for (int i = 1; i < height.length; i++) {
//            leftArr[i] = Math.max(leftArr[i-1], height[i]);
//        }
//        for (int i = height.length-2; i >= 0; i--) {
//            rightArr[i] = Math.max(rightArr[i+1], height[i]);
//        }
//        int sum = 0;
        //最开始的合并、计算部分------------------------------
//        int[] leftAndRight = new int[height.length];
//        for (int i = 0; i < height.length; i++) {
//                leftAndRight[i] = Math.min(leftArr[i], rightArr[i]);
//        }
//
//        for (int i = 0; i < height.length; i++) {
//            sum += leftAndRight[i] - height[i];
//        }
        //优化的合并、计算部分------------------------------
//        int[] leftAndRight = new int[height.length];
//        for (int i = 0; i < height.length; i++) {
//                leftAndRight[i] = Math.min(leftArr[i], rightArr[i]);
//                sum+=leftAndRight[i]-height[i];
//        }
        int leftPointer = 0;//左指针
        int rightPointer = height.length-1;//右指针
        int maxLeftHeight = 0;//记录左边最大高度
        int maxRightHeight = 0;//记录右边最大高度
        int sum = 0;//结果
        while(leftPointer<rightPointer){//左指针小于右指针
            if(height[leftPointer]<height[rightPointer]){//比较【左右当前柱子高度】
                //注意先计算后移动指针
                maxLeftHeight = Math.max(maxLeftHeight, height[leftPointer]);//更新左边最大高度
                sum+=maxLeftHeight-height[leftPointer];//接的雨水是左边最大高度减去当前柱子高度
                leftPointer ++;//左指针右移
            }else{
                //注意先计算后移动指针
                maxRightHeight=Math.max(maxRightHeight, height[rightPointer]);
               sum+=maxRightHeight-height[rightPointer];
                rightPointer--;
            }
        }
        return sum;
    }
}
