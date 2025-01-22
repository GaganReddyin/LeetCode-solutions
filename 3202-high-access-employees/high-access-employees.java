class Solution {
    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
        
        List<String>ans = new ArrayList<>();
        for(int i=0;i<access_times.size();i++){
            
            String accessChar = access_times.get(i).get(0);
            String accessTime = access_times.get(i).get(1);
            int currAccessTime = Integer.parseInt(accessTime)+2400;
            int cnt = 0;
            
            for(int j=0;j<access_times.size();j++){
                String accessInnerChar = access_times.get(j).get(0);
                if((i!=j) && (accessChar.equals(accessInnerChar))){
                    String Time =  access_times.get(j).get(1);
                    int numTime = Integer.parseInt(Time)+2400;
                    if((numTime>=currAccessTime) && (Math.abs(currAccessTime-numTime)<100)) cnt++;
                }
            }
            
            if(cnt>=2 && ans.indexOf(accessChar)==-1) ans.add(accessChar);
        }
        
        return ans;
    }
}