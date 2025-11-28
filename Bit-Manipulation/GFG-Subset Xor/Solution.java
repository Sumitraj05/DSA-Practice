class Solution {
    public static ArrayList<Integer> subsetXOR(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        int sum = 0;
        for(int i = 1; i<=n; i++){
            sum ^= i;
        }
        int missing = -1;
        if(sum != n){
            missing = (sum^n);
        }
        for(int i = 1; i<=n; i++){
            if(i != missing){
                result.add(i);
            }
        }
        return result;
    }
}
