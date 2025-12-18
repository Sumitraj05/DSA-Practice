class Solution {
    public void sortIt(int[] arr) {
        // code here
        ArrayList<Integer> even = new ArrayList<>();
        ArrayList<Integer> odd = new ArrayList<>();
        for(int i : arr){
            if(i % 2 == 0){
                even.add(i);
            }else{
                odd.add(i);
            }
        }
        Collections.sort(even);
        Collections.sort(odd, Collections.reverseOrder());
        int i = 0;
        for(int j = 0; j<odd.size(); j++){
            arr[i] = odd.get(j);
            i++;
        }
        for(int j = 0; j<even.size(); j++){
            arr[i] = even.get(j);
            i++;
        }
        
    }
}
