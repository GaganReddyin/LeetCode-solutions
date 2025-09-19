class Spreadsheet {
    int[][] matrix;
    public Spreadsheet(int rows) {
        matrix = new int[26][rows+1];
    }
    
    public void setCell(String cell, int value) {
        int row = cell.charAt(0)-'A';
        int col = Integer.valueOf(cell.substring(1));
        matrix[row][col] = value;
    }
    
    public void resetCell(String cell) {
        int row = cell.charAt(0)-'A';
        int col = Integer.valueOf(cell.substring(1));
        matrix[row][col] = 0;
    }
    
    public int getValue(String formula) {
        int index=0;
        for(int i=0;i<formula.length();i++){
            if(formula.charAt(i)=='+'){
                index = i;
                break;
            }
        }
        int val1=0;
        int val2=0;
        String str1 = formula.substring(1,index);
        String str2 = formula.substring(index+1);
        if(isNumeric(str1)) val1 = Integer.valueOf(str1);
        else{
             int row = str1.charAt(0)-'A';
             int col = Integer.valueOf(str1.substring(1));
            val1 = matrix[row][col];
        }
        if(isNumeric(str2)) val2 = Integer.valueOf(str2);
        else{
            int row = str2.charAt(0)-'A';
            int col = Integer.valueOf(str2.substring(1));
            val2 = matrix[row][col];
        }
    return val1 + val2;
    }
    public boolean isNumeric(String str){
        if (str == null || str.isEmpty()) return false;
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
    return true;
    }
}