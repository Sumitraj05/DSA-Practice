class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        int result = 0;
        int sign = 1;
        int number = 0;
        int n = s.length();
        for(int i = 0; i<n; i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                number = number*10+(c-'0');
            }
            else if(c == '+'){
                result += (number*sign);
                number = 0;
                sign = 1;
            }
            else if(c == '-'){
                result += (number*sign);
                sign = -1;
                number = 0;
            }
            else if(c == '('){
                st.push(result);
                st.push(sign);
                result = 0;
                sign = 1;
                number = 0;
            }
            else if(c == ')'){
                result += (number*sign);
                int st_sign = st.pop();
                int st_last = st.pop();
                result *= st_sign;
                result += st_last;
                number = 0;
            }
        }
        result += (number*sign);
        return result;
    }
}
