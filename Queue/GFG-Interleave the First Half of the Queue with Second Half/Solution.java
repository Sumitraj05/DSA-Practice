class Solution {
    public void rearrangeQueue(Queue<Integer> q) {
        // code here
        int n = q.size();
        int m = n/2;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for(int i = 0; i<m; i++){
            q1.add(q.poll());
        }
        while(!q.isEmpty()){
            q2.add(q.poll());
        }
        while(!q1.isEmpty()){
            q.add(q1.poll());
            q.add(q2.poll());
        }
    }
}
