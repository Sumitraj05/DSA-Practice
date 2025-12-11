class Solution {
    public ArrayList<Integer> constructArr(int[] arr) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        int m = arr.length;
        if(m == 1){
            res.add(arr[0]-1);
            res.add(1);
            return res;
        }

       int n = (int) (Math.sqrt(arr.length*2)) + 1;
       res.add((arr[0]+arr[1]-arr[n-1])/2);
        for(int i = 1; i<n; i++){
            res.add(arr[i-1]-res.get(0));
        }
        return res;
    }
}
