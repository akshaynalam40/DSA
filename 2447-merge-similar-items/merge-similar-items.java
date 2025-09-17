class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
      int m=items1.length;
      int n=items2.length;
      HashMap<Integer,Integer>hm= new HashMap<>();
      HashMap<Integer,Integer>map= new HashMap<>();
      HashSet<Integer>hs= new HashSet<>();
      ArrayList<Integer>al;
      for(int i=0;i<m;i++){
        hs.add(items1[i][0]);
        hm.put(items1[i][0],items1[i][1]);
      }
      for(int i=0;i<n;i++){
        hs.add(items2[i][0]);
        map.put(items2[i][0],items2[i][1]);
      }
      al= new ArrayList<>(hs);
      Collections.sort(al);
      List<List<Integer>>list=new ArrayList<>();
      for(int i=0;i<al.size();i++){
        ArrayList<Integer>list1= new ArrayList<>();
        int key=al.get(i);
        int ans1=0;
        if(hm.containsKey(key)){
            ans1+=hm.get(key);
        }
        if(map.containsKey(key)){
            ans1+=map.get(key);
        }
        list1.add(key);
        list1.add(ans1);
        list.add(list1);
      }
   return list;
        
    }
}