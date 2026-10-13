class Solution {
    public int[] runningSum(int[] nums) {
        int i;
        for(i=1;i<nums.length;i++){
            nums[i]=nums[i]+nums[i-1];
        }
        return nums;
    }
}