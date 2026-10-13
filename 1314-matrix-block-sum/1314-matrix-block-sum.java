class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        
        // Step 1: Create a 2D prefix sum array with 1-based padding
        int[][] pref = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                pref[i + 1][j + 1] = mat[i][j] + pref[i][j + 1] + pref[i + 1][j] - pref[i][j];
            }
        }
        
        int[][] answer = new int[m][n];
        
        // Step 2: Calculate the block sum for each cell using inclusion-exclusion
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int r1 = Math.max(0, i - k);
                int c1 = Math.max(0, j - k);
                int r2 = Math.min(m - 1, i + k);
                int c2 = Math.min(n - 1, j + k);
                
                // Convert to 1-based indices for the prefix sum matrix
                r1++; c1++; r2++; c2++;
                
                answer[i][j] = pref[r2][c2] - pref[r1 - 1][c2] - pref[r2][c1 - 1] + pref[r1 - 1][c1 - 1];
            }
        }
        
        return answer;
    }
}