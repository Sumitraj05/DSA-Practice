class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int n = heights.length;
        int max = 0;
        for(int i = 0; i<=n; i++){
           while(!st.isEmpty() && (i == n || heights[i]<=heights[st.peek()])){
                int h = heights[st.pop()];
                int width;
                if(st.isEmpty()) width = i;
                else{
                    width = i-st.peek()-1;
                } 
                max = Math.max(max, h*width);
           }
           st.push(i);
        }
        
        return max;
    }
    public int maximalRectangle(char[][] mt) {
        int sum = 0;
        int n = mt.length;
        int m = mt[0].length;
        int[][] matrix = new int[n][m];
        for(int i = 0 ; i<m; i++){
            sum = 0;
            for(int j = 0; j<n; j++){
                if(mt[j][i] == '1'){
                    sum += 1;
                }else{
                    sum = 0;
                }
                matrix[j][i] = sum;
            }
        }
        int max = 0;
        for(int[] a : matrix){
            max = Math.max(max, largestRectangleArea(a));
        }
        return max;
    }
}
