class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int i = 0; 
        int j = n-1;
        int max = 0;
        while(i<j){
            int res = Math.min(height[j], height[i]);
            max = Math.max(max, (j-i)*res);
            if(height[i] <= height[j]){
                i += 1;
            }else{
                j -= 1;
            }
        }
        return max;
    }
}
