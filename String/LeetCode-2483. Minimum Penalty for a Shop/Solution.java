class Solution {
    public int bestClosingTime(String c) {
        int totalYes = 0;
        for(char i : c.toCharArray()){
            if(i == 'Y') totalYes++;
        }

        int currentY = 0;
        int currentN = 0;
        int res = 0;
        int minPenalty = Integer.MAX_VALUE;
        int len = c.length();

        for(int i = 0; i <= len; i++){
            int currentPenalty = (totalYes - currentY) + currentN;
            
            if(currentPenalty < minPenalty){
                minPenalty = currentPenalty;
                res = i;
            }
            
            if(i < len){
                if(c.charAt(i) == 'Y'){
                    currentY++;
                } else {
                    currentN++;
                }
            }
        }
        return res;
    }
}
