class Solution {
    public int findNthDigit(int n) 
    {
        if(n<=9)
            return n;
        long x=9;
        int d=1,p=n,num=0;
        do
        {   
            p-=x*d;
            num+=x;
            x=x*10;
            d++;
        }while(p>(x*d));
        num+=p/d;
        if(p%d==0)
            return num%10;
        else
        {
            num++;
            p=p%d;
            x=(int)Math.pow(10,(d-p));
            num/=x;
            return num%10;
        }
    }
}