// User function Template for Java

class Solution {
    public ArrayList<ArrayList<String>> findSequences(String startWord,
                                                      String targetWord,
                                                      String[] wordList) {
        // Code here
        HashSet<String> set = new HashSet<>();
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        int n = wordList.length;
        for(int i = 0; i<n; i++){
            set.add(wordList[i]);
        }
        Queue<ArrayList<String>> q = new LinkedList<>();
        set.remove(startWord);
        ArrayList<String> ls = new ArrayList<>();
        ls.add(startWord);
        q.add(ls);
        ArrayList<String> OnUsedWord = new ArrayList<>();
        OnUsedWord.add(startWord);
        int level = 0;
        while(!q.isEmpty()){
            ArrayList<String> vec = q.poll();
            if(vec.size() > level){
                level++;
                for(String s : OnUsedWord){
                    set.remove(s);
                }
            }
            String word = vec.get(vec.size()-1);
            if(word.equals(targetWord)){
                if(ans.size() == 0){
                    ans.add(vec);
                }else if(ans.get(0).size() == vec.size()){
                    ans.add(vec);
                }
            }
            int len = word.length();
            for(int i = 0; i<len; i++){
                for(char ch = 'a'; ch <= 'z'; ch++){
                    char[] replacedCharArray = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);
                    if(set.contains(replacedWord)){
                        vec.add(replacedWord);
                        ArrayList<String> temp = new ArrayList<>(vec);
                        q.add(temp);
                        OnUsedWord.add(replacedWord);
                        vec.remove(vec.size()-1);
                    }
                }
            }
        }
        return ans;
    }
}
