class Solution {
    
    int time = 1;
    public int[] findRedundantConnection(int[][] edges) {

        int n = edges.length;
        int[] low = new int[n + 1];
        int[] disc = new int[n + 1];
        
        List<List<Integer>> adjList = buildGraph(edges);
        dfs(adjList, 1, low, disc, -1);
        
        for (int i = n - 1; i >= 0; i--) {
            int[] edge = edges[i];
            int u = edge[0];
            int v = edge[1];
            
            // Swap since u must always be the earlier node during our check
            if (disc[u] > disc[v]) {
                int temp = u;
                u = v;
                v = temp;
            }
            
            if (low[v] > disc[u]){
                // We have bridge
                continue;
            } else {
                return edge;
            }
        }
        
        return null;
    }
    
    private List<List<Integer>> buildGraph(int[][] edges) {
        int n = edges.length;
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }
        
        for (int[] edge: edges) {
            int src = edge[0];
            int dst = edge[1];
            adjList.get(src).add(dst);
            adjList.get(dst).add(src);
        }
        
        return adjList;
    }
    
    private void dfs(List<List<Integer>> adjList, int u, int[] low, int[] disc, int parent) {
        if (disc[u] != 0) {
            return;
        }
        
        disc[u] = time;
        low[u] = time;
        time++;
        
        for (int v: adjList.get(u)) {
            if (v == parent) {
                continue;
            }
            if (disc[v] == 0) {
                dfs(adjList, v, low, disc, u);
                low[u] = Math.min(low[u], low[v]);
            } else {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }
}