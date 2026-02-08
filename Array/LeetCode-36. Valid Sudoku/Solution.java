import java.util.*;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> set = new HashSet<>();

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                char val = board[i][j];
                if(val == '.') continue;

                String row = val + "_row_" + i;
                String col = val + "_col_" + j;
                String box = val + "_box_" + (i/3) + "_" + (j/3);

                if(set.contains(row) || set.contains(col) || set.contains(box))
                    return false;

                set.add(row);
                set.add(col);
                set.add(box);
            }
        }

        return true;
    }
}
