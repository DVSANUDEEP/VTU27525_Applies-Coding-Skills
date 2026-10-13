class Solution {
    public int[] dailyTemperatures(int[] temp) {
        Stack<Integer> s = new Stack<>();
        int n = temp.length;
        int[] ans = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && temp[i] >= temp[s.peek()]) {
                s.pop();
            }
            if (s.isEmpty()) {
                ans[i] = 0;
            } else {
                ans[i] = s.peek() - i;
            }
            s.push(i);
        }
        return ans;
    }
}