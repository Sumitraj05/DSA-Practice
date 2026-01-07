class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<k; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }
        ans.add(map.size());
        int i = 0;
        int j = k;
        int n = arr.length;
        while(j<n){
            map.put(arr[j], map.getOrDefault(arr[j], 0)+1);
            map.put(arr[i], map.get(arr[i])-1);
            if(map.get(arr[i]) == 0){
                map.remove(arr[i]);
            }
            ans.add(map.size());
            i++;
            j++;
        }
        return ans;
    }
}
