class Solution {
    public static void solve(int[] arr, ArrayList<ArrayList<Integer>> ans, int idx, int n, ArrayList<Integer> res){
        if(idx == n){
            ans.add(new ArrayList<>(res));
            return;
        }
        for(int i = 0; i<n; i++){
            if(!res.contains(arr[i])){
                res.add(arr[i]);
                solve(arr, ans, idx+1, n, res);
                res.remove(res.size()-1);
            }
        }
        
    }
    public static ArrayList<ArrayList<Integer>> permuteDist(int[] arr) {
        // code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>();
        solve(arr, ans, 0, n, res);
        return ans;
    }
};
