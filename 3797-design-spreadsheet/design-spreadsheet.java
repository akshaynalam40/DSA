class Spreadsheet {
    HashMap<String, Integer> map;

    public Spreadsheet(int rows) {
        map = new HashMap<>();
    }

    public void setCell(String cell, int value) {
        map.put(cell, value);
    }

    public void resetCell(String cell) {
        map.remove(cell); 
    }

    public int getValue(String formula) {
        int i = formula.indexOf('+');
        String cell1 = formula.substring(1, i);
        String cell2 = formula.substring(i + 1);
          int value1=0;
         if(Character.isLetter(cell1.charAt(0))){
             value1= map.getOrDefault(cell1, 0);
         }
         else{
            value1=Integer.parseInt(cell1);
         }

        int value2 =0;
         if(Character.isLetter(cell2.charAt(0))){
            value2=map.getOrDefault(cell2, 0);
         }
         else{
            value2=Integer.parseInt(cell2);
         }

        return value1 + value2;
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */