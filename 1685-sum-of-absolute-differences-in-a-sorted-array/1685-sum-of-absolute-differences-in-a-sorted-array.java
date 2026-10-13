class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        
        int leftSum = 0;
        for (int i = 0; i < n; i++) {
            int rightSum = totalSum - leftSum - nums[i];
            
            // Contribution from elements on the left and right
            result[i] = (nums[i] * i - leftSum) + (rightSum - nums[i] * (n - i - 1));
            
            leftSum += nums[i];
        }
        
        return result;
    }
}