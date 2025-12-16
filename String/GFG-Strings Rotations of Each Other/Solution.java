class Solution {
    public boolean areRotations(String s1, String s2) {
        // code here
        StringBuilder sb = new StringBuilder(s1);
        sb.append(s1);
        return sb.lastIndexOf(s2) >=0;
    }
}
