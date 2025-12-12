class Solution {
    public ArrayList<ArrayList<Integer>> transpose(int[][] mat) {
        // code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int n = mat.length;
        for(int i = 0; i<n; i++){
            ArrayList<Integer> res = new ArrayList<>();
            for(int j = 0; j<n; j++){
                res.add(mat[j][i]);
            }
            ans.add(res);
        }
        return ans;
    }
}
