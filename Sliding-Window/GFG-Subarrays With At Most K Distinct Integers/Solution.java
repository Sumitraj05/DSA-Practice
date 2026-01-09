class Solution {
    public int countAtMostK(int arr[], int k) {
        // code here
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        int n = arr.length;
        int i = 0;
        for(int j = 0; j<n; j++){
            map.put(arr[j], map.getOrDefault(arr[j], 0)+1);
            while(map.size() > k){
                map.put(arr[i], map.get(arr[i])-1);
                if(map.get(arr[i]) == 0){
                    map.remove(arr[i]);
                }
                i++;
            }
            ans += j-i+1;
        }
        return ans;
    }
}
