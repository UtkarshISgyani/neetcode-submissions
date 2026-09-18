class Solution {

    public String encode(List<String> strs) {
        StringBuilder str = new StringBuilder();
          for(String s : strs){
             str.append(s.length()).append('#').append(s);
          }
          System.out.println(str);
          return str.toString();
          
    }

    public List<String> decode(String strs) {
       
        List<String> list = new ArrayList<>();
        int i=0;
        while(i<strs.length()){
            int j = i;
            while(strs.charAt(j)!='#'){
                j++;
            }
            int l = Integer.parseInt(strs.substring(i,j));
            j++;
            String st  =  strs.substring(j,j+l);
            list.add(st);
            i = j+l;
        }
        return list;
    }
}
