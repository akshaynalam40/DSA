class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<String>al = new ArrayList<>();
        
        List<String>electronics=new ArrayList<>();
        List<String>grocery=new ArrayList<>();
        List<String>pharmacy= new ArrayList<>();
        List<String>restaurant= new ArrayList<>();
          int n=isActive.length;
         for(int i=0;i<n;i++){
            if(isActive[i]){
                if(businessLine[i].equals("electronics") || businessLine[i].equals("grocery")
                    || businessLine[i].equals("pharmacy")
                  || businessLine[i].equals("restaurant")){
                    if(code[i].length()==0){
                        continue;
                    }
                    boolean flag=true;
                    for(int k=0;k<code[i].length();k++){
                        char ch=code[i].charAt(k);
                        if(!Character.isLetterOrDigit(ch)&&ch!='_') {
                            flag=false;
                            break;
                        }
                    }
                    if(flag){
            if(businessLine[i].startsWith("e"))electronics.add(code[i]);
            if(businessLine[i].startsWith("g"))grocery.add(code[i]);
            if(businessLine[i].startsWith("p"))pharmacy.add(code[i]);
            if(businessLine[i].startsWith("r"))restaurant.add(code[i]);
                 }
                  }

            }
         }
            
        Collections.sort(electronics);
        Collections.sort(grocery);
        Collections.sort(pharmacy);
        Collections.sort(restaurant);
        al.addAll(electronics);
        al.addAll(grocery);
        al.addAll(pharmacy);
        al.addAll(restaurant);
        return al;
    }
}