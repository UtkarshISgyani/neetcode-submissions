class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        Map<String , List<String>> map = new HashMap<>();
        for(String s : strs){
            int [] freq = new int[26];
            for(char c : s.toCharArray()){
                freq[c -'a']++;
            }
            String str = Arrays.toString(freq);
            if(!map.containsKey(str)){
                map.put(str, new ArrayList<>());
            }
            map.get(str).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
