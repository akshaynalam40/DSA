class Solution {
    public int minSetSize(int[] arr) {
        int n=arr.length;
        if(n==1 || n==2){
            return 1;
        }
        HashMap<Integer,Integer>hm = new HashMap<>();
        PriorityQueue<Integer>pq= new PriorityQueue<>((a,b)->b-a);
        for(int i=0;i<n;i++){
            hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
        }
        for(int key:hm.keySet()){
            pq.add(hm.get(key));
        }
        int remove=0;
        int size=n/2;
        int count=0;
        while(remove<size &&pq.size()>0){
           remove+=pq.poll();
           count++;
        }
        return count;  
    }
}