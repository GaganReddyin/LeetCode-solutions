class Solution {
    public String getHappyString(int n, int k) {
        
        /*
         * happyStrings list that stores the happy Strings
         * sb StringBuilder that stores the current word
         * alphabet, this is to make it more flexible, so this function will work for any
         *     alphabet just by changing this variable
         */
        List<String> happyStrings = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        char[] alphabet = new char[]{'a', 'b', 'c'};
        
        dfs(n, sb, happyStrings, alphabet);
        
        if(k > happyStrings.size())
            return "";
        
        return happyStrings.get(k - 1);
    }
    
    private void dfs(int n, StringBuilder current, List<String> happyStrings, char[] alphabet){
        
        if(n == 0){
            happyStrings.add(current.toString());
            return;
        }
        
        for(int i = 0; i < alphabet.length; i++){
            /*
             * I make sure that i only append happy strings 
             * (no contiguos characters are the same)
             */
            if(current.length() == 0 || current.charAt(current.length() - 1) != alphabet[i]){
                /*
                 * Backtracing principle
                 *
                 * Do
                 * Recurse
                 * Undo
                 */
                current.append(alphabet[i]);
                dfs(n - 1, current, happyStrings, alphabet);
                current.setLength(current.length() - 1);
            }
        }        
    }

}