class Solution {
    public String[] reorderLogFiles(String[] logs) {
        
        //List for digit logs
        ArrayList<String> digitLogsList = new ArrayList<>();
        
        PriorityQueue<String> pq = new PriorityQueue<>(
            
            new Comparator<String>() {
                
                public int compare(String log1, String log2) {
                    
                    //Split on " " in only 2 parts
                    String[] log1Split = log1.split(" ", 2); 
                    String[] log2Split = log2.split(" ", 2);
                    
                    // if the content is equal then compare the ids
                    if(log1Split[1].compareTo(log2Split[1]) == 0) {
                        return log1Split[0].compareTo(log2Split[0]);
                    }
                    
                    return log1Split[1].compareTo(log2Split[1]);
                }
            }                                      
        );
        
        for(String log : logs) {
            
            //Fetching only the content to check if it is a digit or an identifier log
            String content = log.substring(log.indexOf(' ')+1);
            
            if(Character.isDigit(content.charAt(0))) {
                digitLogsList.add(log);
            } else {
                pq.offer(log);
            }     
        }
        
        String[] result = new String[logs.length];
        int index = 0;
       
        //Adding the letter logs
        while(!pq.isEmpty()) {
            result[index++] = pq.poll();
        }
        
        //Add the digit logs to the result
        int i = 0;
        while(index < result.length) {
            result[index++] = digitLogsList.get(i);
            i ++;
        }
        
        return result;
    }
               
}