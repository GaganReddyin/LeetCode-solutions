 class Solution {
public int[] maxDepthAfterSplit(String s) {
    
    int[] arr = new int[s.length()];
    int a=0;
    Stack st1 = new Stack();
    Stack st2 = new Stack();
    for(int i=0;i<s.length();i++)
    {
        if(s.charAt(i)=='(')
        {
           if(st1.size()<=st2.size())
           {
               st1.push('(');
               arr[a]=0;
               a++;
           }
           else
           {
              st2.push('(');
               arr[a]=1;
               a++;    
           }
        }

        
        if(s.charAt(i)==')')
        {
            if(st1.size()>=st2.size())
            {
               st1.pop();
               arr[a]=0;
               a++;
            }
            else
            {
                st2.pop();
                arr[a]=1;
                a++;             
            }
            
        }
    }
   
    return arr;
    
 }
}