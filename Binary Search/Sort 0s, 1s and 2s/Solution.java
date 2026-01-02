// Uisng three Variables - O(n)
class Solution {
    public void sort012(int[] arr) {
        // code here
        int zero = 0;
        int one = 0;
        int two = 0;
        for(int i : arr){
            if(i == 0){
                zero++;
            }else if(i == 1){
                one++;
            }else{
                two++;
            }
        }
        int i = 0;
        while(zero > 0){
            arr[i++] = 0;
            zero--;
        }
        while(one > 0){
            arr[i++] = 1;
            one--;
        }
        while(two > 0){
            arr[i++] = 2;
            two--;
        }
    }
}
// Using mid variable similar to upper one
class Solution {
    // Function to sort an array of 0s, 1s, and 2s
    public void sort012(int[] arr) {
        // code here
        int n = arr.length;
        if(n == 1){
            return;
        }
        int i = 0;
        int j = n-1;
        int mid = 0;
        while(mid<=j){
            if(arr[mid] == 0){
                int temp = arr[i];
                arr[i] = arr[mid];
                arr[mid] = temp;
                i++;
                mid++;
                
            }
            else if(arr[mid] == 2){
                int temp = arr[j];
                arr[j] = arr[mid];
                arr[mid] = temp;
                j--;
            } else{
                mid++;
            }
        }
        
    }
}
