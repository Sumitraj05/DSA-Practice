class Solution {
    public void solve(int ind, int[] candidates, List<List<Integer>> ans, List<Integer> ds, int target, int curr){
        if(ind == candidates.length){
            return;
        }
         if(curr == target){
            ans.add(new ArrayList<>(ds));
            return;
         }
        if(curr <= target){
            ds.add(candidates[ind]);
            solve(ind, candidates, ans, ds, target, target+candidates[ind]);
            ds.remove(candidates[ind]);
        }
        solve(ind+1, candidates, ans, ds, target, target);

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<ArrayList<>>();
        List<Integer> ds = new ArrayList<>();
        solve(0, candidates, ans, ds, target, 0);
        return ans;
    }
}
