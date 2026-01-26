class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int min = Integer.MAX_VALUE;
        int n = arr.length;
        HashSet<Integer> set = new HashSet<>();
        Arrays.sort(arr);
        for(int i = 0; i<n-1; i++){
            set.add(arr[i]);
            min = Math.min(min, Math.abs(arr[i]-arr[i+1]));
        }
        set.add(arr[n-1]);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i<n; i++){
            int v1 = arr[i];
            if(set.contains(v1+min)){
                int v2 = v1+min;
                ans.add(Arrays.asList(v1, v2)); 
            }
        }
        return ans;
    }
}
