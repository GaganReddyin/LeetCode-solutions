class Solution {
public:
    int maxCandies(vector<int>& status, vector<int>& candies, vector<vector<int>>& keys, vector<vector<int>>& containedBoxes, vector<int>& initialBoxes) {
        set<pair<int,int>> s;

        int n=initialBoxes.size();
        for(int i=0;i<n;i++)
        {
            s.insert({status[initialBoxes[i]],initialBoxes[i]});
        }
       int ans=0;
      
      
           
       
        while(!s.empty())
        {
           auto box=s.end();
           box--;
           if((*box).first==0){break;}
          int b=(*box).second;
          s.erase(box);
           ans+=candies[b];
           
           for(int j:keys[b])
           {
               
               if(s.find({0,j})!=s.end())
               {
                   auto it=s.find({0,j});
                   s.erase(it);
                   s.insert({1,j});
                   
               }
               status[j]=1;
           }

           for(int j:containedBoxes[b])
           {
                s.insert({status[j],j});
           }
        }
        return ans;
    }
};