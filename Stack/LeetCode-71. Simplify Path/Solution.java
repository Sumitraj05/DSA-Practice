class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        String[] s = path.split("/");
        for(String i : s){
            if(i.equals("..")){
                if(!st.isEmpty()) st.pop();
            }else if(!i.equals(".") && !i.equals("")){
                st.push(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.insert(0, st.pop());
            sb.insert(0, '/');
        }
         return sb.length() == 0 ? "/" : sb.toString();
    }
}
