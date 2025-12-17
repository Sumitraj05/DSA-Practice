class Solution {
    public ArrayList<int[]> mergeOverlap(int[][] arr) {
        // Code here
        Arrays.sort(arr, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });
        
        ArrayList<int[]> ans = new ArrayList<>();
        int first = arr[0][0];
        int second = arr[0][1];
        for(int[] a : arr){
            if(a[0] <= second){
                second = Math.max(second, a[1]);
            }else{
                ans.add(new int[] {first, second});
                first = a[0];
                second = a[1];
            }
        }
        ans.add(new int[] {first, second});
        return ans;
    }
}
