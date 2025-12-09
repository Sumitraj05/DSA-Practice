class Solution {
    public ArrayList<Integer> findDuplicates(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for(int i : arr){
            if(set.contains(i)){
                ans.add(i);
            }else{
                set.add(i);
            }
        }
        return ans;
    }
}
