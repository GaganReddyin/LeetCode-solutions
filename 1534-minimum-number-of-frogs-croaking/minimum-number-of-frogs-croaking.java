class Solution {
    public int minNumberOfFrogs(String s) {
        int[][]f=new int[s.length()][26];
        int[][]l=new int[s.length()][2];
        if(s.charAt(0)=='c'){
            f[0][s.charAt(0)-'a']++;
            l[0][0]++;
        }
        else return -1;
        for(int i=1;i<s.length();i++){
             char ch=s.charAt(i);
             int x=ch-'a';
             if(ch=='c'){
                l[i][0]++;

             }
             else if(ch=='k')l[i][1]++;
             for(int j=0;j<26;j++){
                if(j==x){
                    f[i][j]=f[i-1][j]+1;
                }
                else f[i][j]=f[i-1][j];
             }
             if(!ff(f[i])){
              //   System.out.println("hi"+" "+i);
                return -1;
             }
        }
        int xx=s.length()/5;
        if(s.length()%5!=0)return -1;

       if(f[s.length()-1]['a'-'a']!=xx)return -1;
        if(f[s.length()-1]['c'-'a']!=xx)return -1;
       if(f[s.length()-1]['r'-'a']!=xx)return -1;
        if(f[s.length()-1]['o'-'a']!=xx)return -1;
        if(f[s.length()-1]['k'-'a']!=xx)return -1;
        int ans=0;
        int ss=0;
        for(int i=0;i<s.length();i++){
          //  System.out.println(l[i][0]+" "+l[i][1]+" "+i);
    //   if(i==s.length()-1)   System.out.println(ff(f[i])+" "+i);
           ss+=l[i][0];
           ans=Math.max(ans,ss);
           ss-=l[i][1];
        }
        return ans;

    }
    public boolean ff(int[]f){
        int c=f['c'-'a'];
        int r=f['r'-'a'];
        int o=f['o'-'a'];
        int a=f['a'-'a'];
        int k=f['k'-'a'];
      //  System.out.println(c+" "+r+" "+o+" "+a+" "+k);
        if(r>c)return false;
        if(o>c)return false;
        if(a>c)return false;
        if(k>c)return false;
         if(o>r)return false;
        if(a>r)return false;
        if(k>r)return false;
         if(a>o)return false;
        if(k>o)return false;
        if(k>a)return false;
       
       return true;
    }
}