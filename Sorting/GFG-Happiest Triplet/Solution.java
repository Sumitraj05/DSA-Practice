class Solution {
    int[] smallestDiff(int a[], int b[], int c[]) {
        // write code here
        int n = a.length;
        int i = 0, j = 0, k = 0;
        int diff = Integer.MAX_VALUE;
        int[] triplet = new int[3];
        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);
        while(i<n && j<n && k<n){
            int min = Math.min(a[i], Math.min(b[j], c[k]));
            int max = Math.max(a[i], Math.max(b[j], c[k]));
            if(max-min<diff){
                triplet[0] = a[i];
                triplet[1] = b[j];
                triplet[2] = c[k];
                diff = max-min;
            }
            if(a[i] == min) i++;
            else if(b[j] == min) j++;
            else k++;
        }
        Arrays.sort(triplet);
        reverse(triplet, 0, triplet.length-1);
        return triplet;
    }
    void reverse(int[] triplet, int start, int end){
        while(start<end){
            int temp = triplet[start];
            triplet[start] = triplet[end];
            triplet[end] = temp;
            start++;
            end--;
        }
    }
}

