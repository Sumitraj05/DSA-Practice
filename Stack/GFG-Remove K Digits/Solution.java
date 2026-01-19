class Solution {
    public String removeKdig(String s, int k) {
        // code here
        Stack<Integer> st = new Stack<>();
        int n = s.length();
        st.push(s.charAt(0)-'0');
        int i = 1;
        while(i<n && k>0){
            int v = s.charAt(i)-'0';
            while(!st.isEmpty() && k>0 && st.peek() > v){
                st.pop();
                k--;
            }
            st.push(v);
            i++;
        }
        while(i<n){
            st.push(s.charAt(i)-'0');
            i++;
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        sb = sb.reverse();
        while(k>0 && sb.length() > 0){
            sb.deleteCharAt(sb.length()-1);
            k--;
        }
        while(sb.length() > 0 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }
        if(sb.length() == 0) return "0";
        return sb.toString();
    }   
}
