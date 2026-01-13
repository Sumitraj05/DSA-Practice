class Solution {
    public boolean canServe(int[] arr) {
        // code here
        int five = 0;
        int ten = 0;
        for(int i : arr){
            if(i == 10){
                if(five > 0){
                    five--;
                }else{
                    return false;
                }
                ten++;
            }else if(i == 20){
                if(ten > 0 && five > 0){
                    ten--;
                    five--;
                }else if(five >= 3){
                    five -= 3;
                }else{
                    return false;
                }
            }else{
                five++;
            }
        }
        return true;
    }
}
