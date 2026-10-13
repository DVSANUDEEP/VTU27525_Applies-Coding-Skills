class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> s = new Stack<>();
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && nums2[i] >= s.peek()) {
                s.pop();
            }
            if (s.isEmpty()) {
                m.put(nums2[i], -1);
            } else {
                m.put(nums2[i], s.peek());
            }
            s.push(nums2[i]);
        }
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = m.get(nums1[i]);
        }
        return result;
    }
}
