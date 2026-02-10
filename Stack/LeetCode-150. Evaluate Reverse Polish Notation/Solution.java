class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(String str : tokens){
            if(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")){
                int a = st.pop();
                int b = st.pop();
                switch (str){
                    case "+":
                        st.push(b+a);
                        break;
                    case "-":
                        st.push(b-a);
                        break;
                    case "*":
                        st.push(b*a);
                        break;
                    case "/":
                        st.push(b/a);
                        break;
                }
            }else{
                st.push(Integer.parseInt(str));
            }
        }
        return st.pop();
    }
}
