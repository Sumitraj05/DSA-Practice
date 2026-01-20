class Solution {
    StringBuilder s = new StringBuilder();
    StringBuilder r = new StringBuilder();
    public void append(char x) {
        // append x into document
        s.append(x);
    }

    public void undo() {
        // undo last change
        int idx = s.length()-1;
        r.append(s.charAt(idx));
        s.deleteCharAt(idx);
    }

    public void redo() {
        // redo changes
        int n = r.length();
        if(n > 0){
            s.append(r.charAt(n-1));
            r.deleteCharAt(n-1);
        }
    }

    public String read() {
        // read the document
        return s.toString();
    }
}
