class Solution {
    public int candy(int[] ratings) {
       int n = ratings.length;
       int i = 1;
       int sum = n;
       while(i<n){
        if(ratings[i] == ratings[i-1]){
            i++;
            continue;
        }
        int peak = 0;
        while(i<n && ratings[i]>ratings[i-1]){
            peak++;
            sum += peak;
            i++;
        }
        int valley = 0;
        while(i<n && ratings[i]<ratings[i-1]){
            valley++;
            sum += valley;
            i++;
        }
        sum -= Math.min(peak, valley);
       }
        return sum;
    }
}
