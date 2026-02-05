class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalCost = 0;
        int totalGas = 0;
        int currentCost = 0;
        int startIdx = 0;
        int n = gas.length;
        for(int i = 0; i<n; i++){
            totalCost += cost[i];
            totalGas += gas[i];

            currentCost += (gas[i]-cost[i]);
            if(currentCost < 0){
                currentCost = 0;
                startIdx = i+1;
            }
        }
        return totalGas >= totalCost ? startIdx : -1;
    }
}
