class Solution 
{
    public int longestCommonSubsequence(String s, String t) 
    {
        if(s=="" || t=="")
			return 0;
		else if(s.equals(t))
			return s.length();
		int n=s.length(), m=t.length(); // n rows, m cols
		int prevRow[]=new int[m+1];
		for(int i=0;i<=m;i++)
		{
			prevRow[i]=0;
		}
		for(int idx1=1;idx1<=n;idx1++)
		{
			int row[]=new int[m+1];
			row[0]=0;
			for(int idx2=1;idx2<=m;idx2++)
			{
				if(s.charAt(idx1-1)==t.charAt(idx2-1))
					row[idx2]=1+prevRow[idx2-1];
				else
					row[idx2]=Math.max(prevRow[idx2],row[idx2-1]);
			}
			prevRow=row;
		}
		return prevRow[m];
    }
    public int minDistance(String word1, String word2) 
    {
        int len_lcs=longestCommonSubsequence(word1,word2);
        int l1=word1.length();
        int l2=word2.length();
        if(len_lcs==0)
            return l1+l2;
        return (l1-len_lcs)+(l2-len_lcs);
    }
}