class Solution {
    public boolean solve(ArrayList<Character> list, char[][]mat,int i,int j,String word, int len,int idx){
        if(idx == len) return true;
        list.add(mat[i][j]);
        mat[i][j] = '1';
        int row[] = {-1,0,1,0};
        int col[] = {0,1,0,-1};
        for(int k=0;k<4;k++){
            int r = i+row[k];
            int c = j+col[k];
            if(r>=0 && r<mat.length && c>=0 && c<mat[0].length && idx < len && mat[r][c]==word.charAt(idx) ){
                boolean f = solve(list, mat,r,c,word,len,idx+1);
                if(f) return true;
                
            }
        }
        mat[i][j] = list.remove(list.size()-1);
        return false;
    }
    
    public boolean isWordExist(char[][] mat, String word) {
        // Code here
        int m = mat.length;
        int n = mat[0].length;
        boolean ans = false;
        ArrayList<Character> list = new ArrayList<>();
        for(int i =0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j] == word.charAt(0)){
                    if(solve(list, mat,i,j,word,word.length(),1))return true;
                }
            }
            
        }
        return ans;
    }
}
