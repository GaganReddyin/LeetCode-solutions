class MagicDictionary {
    List<String> dict;
    public MagicDictionary() {
        dict=new ArrayList<>();
    }
    
    public void buildDict(String[] dictionary) {
        for(String s:dictionary){   
            dict.add(s);
        }
    }
    
    public boolean search(String str) {
        int cnt=0;
        for(int i=0;i<dict.size();i++){
            if(dict.get(i).length()==str.length()){
                String s=dict.get(i);
                for(int j=0;j<str.length();j++){
                    if(s.charAt(j)!=str.charAt(j)){
                        cnt++;
                        if(cnt>1)
                        break;
                    }
                }
                if(cnt==1){
                    return true;
                }
                cnt=0;
            }
        }
        return false;
    }
}

