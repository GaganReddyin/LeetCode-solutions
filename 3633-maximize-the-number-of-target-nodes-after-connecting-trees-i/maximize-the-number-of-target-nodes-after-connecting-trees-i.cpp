class Solution {
    vector<vector<int>> createGraph(int N , vector<vector<int>> & edges){
        vector<vector<int>> graph(N+1) ; 
        for(auto & e : edges){
            int u = e[0] ; 
            int v = e[1] ; 
            graph[u].push_back(v) ; 
            graph[v].push_back(u) ; 
        }
        return graph ;
    }
public:
    vector<int> maxTargetNodes(vector<vector<int>>& edges1, vector<vector<int>>& edges2, int k) {
        int n = edges1.size() ; 
        int m = edges2.size() ; 
        vector<vector<int>> g1 = createGraph(n , edges1) ;
        vector<vector<int>> g2 = createGraph(m , edges2) ; 
        int mx = 0 ; 
        for(int node = 0 ; node <= m ; node++){
            int cnt = 0 ;
            queue<pair<int,int>> q ; 
            q.push({node , 0}) ; 
            vector<bool> visited(m+1 , false) ; 
            visited[node] = true ; 
            while(!q.empty()){
                int nd = q.front().first ; 
                int dist = q.front().second ; 
                q.pop() ; 
                if(dist > k-1){
                    continue; 
                }
                cnt++ ; 
                for(auto & nbr : g2[nd]){
                    if(!visited[nbr]){
                        q.push({nbr , dist + 1}) ; 
                        visited[nbr] = true ; 
                    }
                }
            }
            mx = max(mx , cnt) ; 
        }   
        vector<int> res(n+1, 0) ; 
        for(int node = 0 ; node <= n ; node++){
            int cnt = 0 ; 
            queue<pair<int,int>> q ; 
            q.push({node , 0}) ; 
            vector<bool> visited(n+1 , false) ; 
            visited[node] = true ; 
            while(!q.empty()){
                int nd = q.front().first; 
                int dist = q.front().second;
                q.pop() ;
                if(dist > k){
                    continue; 
                } 
                cnt++ ; 
                for(auto & nbr : g1[nd]){
                    if(!visited[nbr]){
                        visited[nbr] = true ; 
                        q.push({nbr , dist + 1}) ; 
                    }
                }
            }
            res[node] = cnt + mx ; 
        }
        return res ; 
    } 
};