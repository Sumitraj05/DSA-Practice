class Solution {
    public int getLastMoment(int n, int left[], int right[]) {
        // code here
        int leftMax = 0;
        int rightMin = n;
        int l = left.length;
        int m = right.length;
        for(int i = 0; i<l; i++){
            leftMax = Math.max(leftMax, left[i]);
        }
        for(int j = 0; j<m; j++){
            rightMin = Math.min(rightMin, right[j]);
        }
        if(n-rightMin >= leftMax){
            return n-rightMin;
        }
        return leftMax;
    }
}
