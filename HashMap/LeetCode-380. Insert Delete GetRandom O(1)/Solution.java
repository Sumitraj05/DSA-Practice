class RandomizedSet {
    ArrayList<Integer> ans;
    HashMap<Integer, Integer> map;
    public RandomizedSet() {
        ans = new ArrayList<>();
        map = new HashMap<>();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        ans.add(val);
        map.put(val, ans.size()-1);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        int idx = map.get(val);
        ans.set(idx, ans.get(ans.size()-1));
        map.put(ans.get(idx), idx);
        ans.remove(ans.size()-1);
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
        Random rand = new Random();
        return ans.get(rand.nextInt(ans.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
