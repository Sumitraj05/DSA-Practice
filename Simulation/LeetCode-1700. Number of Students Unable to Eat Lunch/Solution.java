class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int one = 0;
        int zero = 0;
        for(int i : students){
            if(i == 1){
                one++;
            }else{
                zero++;
            }
        }
        int i = 0;
        int n = sandwiches.length;
        while(i<n){
            if(sandwiches[i] == 1 && one > 0){
                one--;
            }
            else if(sandwiches[i] == 0 && zero > 0){
                zero--;
            }else{
                return n-i;
            }
            i++;
        }
        return 0;
    }
}
