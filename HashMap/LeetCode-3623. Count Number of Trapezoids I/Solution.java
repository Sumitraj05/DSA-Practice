class Solution {
    public int countTrapezoids(int[][] points) {
        int M = 1000000007;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int[] i : points){
            map.put(i[1], map.getOrDefault(i[1], 0)+1);
        }
        long result = 0;
        long sum = 0;
        for(int value : map.values()){
            long edge = ((long) value * (value-1))/2;
            result = (result+edge*sum)%M;
            sum = (sum+edge)%M;
        }
        return (int) result%M;
    }
}
