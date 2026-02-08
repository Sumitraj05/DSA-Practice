class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int n = words.length;
        int i = 0;
        while(i<n){
            int wordCount = words[i].length();
            int j = i+1;
            int spaceCount = 0;
            while(j<n && spaceCount+wordCount+1+words[j].length()<=maxWidth){
                wordCount += words[j].length();
                spaceCount += 1;
                j++;
            }
            int spaces = maxWidth-wordCount;
            int evenlySpaces = spaceCount == 0 ? 0 : spaces/spaceCount;
            int extraSpaces = spaceCount == 0 ? 0 : spaces%spaceCount;

            if(j == n){
                evenlySpaces = 1;
                extraSpaces = 0;
            }
            ans.add(findList(words, i, j, evenlySpaces, extraSpaces, maxWidth));
            i = j; 
        }
        return ans;
    }
    public String findList(String[] words, int i, int j, int evenlySpaces, int extraSpaces, int maxWidth){
        StringBuilder res = new StringBuilder();
        for(int k = i; k<j; k++){
            res.append(words[k]);
            if(k == j-1) continue;
            for(int l = 0; l<evenlySpaces; l++){
                res.append(" ");
            }
            if(extraSpaces > 0){
                res.append(" ");
                extraSpaces--;
            }
        }
        while(res.length()<maxWidth){
            res.append(" ");
        }
        return res.toString();
    } 
}
