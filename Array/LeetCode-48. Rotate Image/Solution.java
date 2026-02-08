class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i<n-1; i++){
            for(int j = i+1; j<n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int i = 0; i<n; i++){
            reverse(matrix, i, n-1);
        }
    }
    public void reverse(int[][] matrix, int row, int end){
        int start = 0;
        while(start<end){
            int temp = matrix[row][start];
            matrix[row][start] = matrix[row][end];
            matrix[row][end] = temp;
            start++;
            end--;
        }
    }
}
