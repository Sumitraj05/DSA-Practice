class Solution {
    public ArrayList<Integer> nextFreqGreater(int[] arr) {
        // code here
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : arr){
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] res = new int[n];
        Arrays.fill(res, -1);
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i<n; i++){
            while(!st.isEmpty() && map.get(arr[i]) > map.get(arr[st.peek()])){
                res[st.pop()] = arr[i];
            }
            st.push(i);
        }
        for(int i = 0; i<n; i++){
            ans.add(res[i]);
        }
        return ans;
    }
}
