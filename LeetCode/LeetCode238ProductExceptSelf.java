package LeetCode;

public class LeetCode238ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] ans =new int[nums.length];

        /*
        从前往后遍历记录左边数组乘积
        对左边数组第一个元素单独处理,第0位左边没有元素，左边乘积=1
        */
        ans[0]=1;
        for (int i = 1; i < nums.length; i++) {
            ans[i]=ans[i-1]*nums[i-1];//ans[i]表示第i位左边所有元素的乘积
        }


        //注意这个right指的是nums[i]右边所有元素的乘积
        //刚开始最右边元素的右边没有元素，右侧乘积=1
        int right=1;
        for (int i = nums.length - 1; i >= 0; i--) {//从最后一个元素开始
            ans[i]=ans[i]*right;//最终的结果=i左边乘积*i右边乘积
            right=right*nums[i];//更新右边乘积=原来右边乘上当前元素
        }
        return ans;
    }
}
