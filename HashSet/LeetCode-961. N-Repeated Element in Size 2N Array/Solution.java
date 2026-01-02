// Using HashSet
class Solution {
    public int repeatedNTimes(int[] nums) {
       Set<Integer> s = new HashSet<>();
        for(int i:nums)
        {
            if(s.contains(i))
              return i;
            s.add(i);
        }
        return nums[nums.length-1];

    }
}

// Using Maths because the repeated no. always exit in the maximum subarray or length 4
class Solution {
    public int repeatedNTimes(int[] A) {
        for (int k = 1; k <= 3; ++k)
            for (int i = 0; i < A.length - k; ++i)
                if (A[i] == A[i+k])
                    return A[i];

        throw null;
    }
}
