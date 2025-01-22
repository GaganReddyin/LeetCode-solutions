class Solution {
    public long maxSpending(int[][] values) {

        List<Stack<Integer>> list= new ArrayList<>();
        for(int i=0;i<values.length;i++){
            Stack<Integer> st= new Stack<>();
            for(int j=0;j<values[i].length;j++){
                st.push(values[i][j]);
            }
            list.add(st);
        }
        long ans=0;
        long day=1;

        while(list.size()>0){
            int idx=0;
            long mini=Integer.MAX_VALUE;
            boolean flag=true;
            for(int i=0;i<list.size();i++){
                if(list.get(i).isEmpty()){
                    list.remove(i);
                    flag=false;
                    break;
                }
                if(list.get(i).peek()<mini){
                    mini=list.get(i).peek();
                    idx=i;
                }
            }
           if(flag==true){ 
               list.get(idx).pop();
            ans+= mini*day;
            day++;
            }

        }
        return ans;
        
    }
}