class Solution {
    public long distributeCandies(int n, int limit) {
        long res=0;

        for(int i=0; i<=Math.min(n,limit); i++){
            //i is the amount of candies given to 1st child
            //rem is the amount of candies remaining fro rest two child distribute
            long rem= n-i;
            //if remaining candies are greater than 2 times the limit, continue 
            //bcoz distribution under limit isn't possible
            if(rem > 2*limit) continue;

            //Taking out the maximum amount of candies that can be given to 2nd child
            long maxi=Math.min(rem,limit);
            //now the rem is the amount of candy that can be given to 3rd child
            rem=rem-maxi;

            //Computing the possible number of combitions
            long temp= maxi-rem+1;
            //EDGE CASE: if possible number of combition is negative, then add 0
            //else temp
            res+=Math.max(0,temp);
        }

        return res;
    }
}