class Solution {
    public class Pair{
        String first;
        int second;
        public Pair(String first, int second){
            this.first = first;
            this.second = second;
        }
    }
    public int wordLadderLength(String startWord, String targetWord,
                                String[] wordList) {
        // Code here
        HashSet<String> set = new HashSet<>();
        int n = wordList.length;
        for(int i = 0; i<n; i++){
            set.add(wordList[i]);
        }
        Queue<Pair> q = new LinkedList<>();
        set.remove(startWord);
        q.add(new Pair(startWord, 1));
        while(!q.isEmpty()){
            String word = q.peek().first;
            int stage = q.peek().second;
            if(word.equals(targetWord)) return stage;
            q.remove();
            int len = word.length();
            for(int i = 0; i<len; i++){
                for(char ch = 'a'; ch <= 'z'; ch++){
                    char[] replacedCharArray = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);
                    if(set.contains(replacedWord)){
                        set.remove(replacedWord);
                        q.add(new Pair(replacedWord, stage+1));
                    }
                }
            }
        }
        return 0;
    }
}
