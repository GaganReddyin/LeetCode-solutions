class Solution {
    public int minimumTime(int n, int[][] rs, int[] t) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int d[] = new int[n+1], res = 0;
        for (int[] r : rs) {
            d[r[1]]++;
            map.computeIfAbsent(r[0], x -> new ArrayList<>()).add(r[1]);
        }
        
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b)->(a[1]-b[1]));
        for (int i = 1; i <= n; i++) if (d[i] == 0) q.offer(new int[]{i, t[i-1]});
        
        while (!q.isEmpty()) {
            int cur[] = q.poll();
            res = Math.max(res, cur[1]);

            for (int next : map.getOrDefault(cur[0], new ArrayList<>())) {
                if (--d[next] == 0) q.offer(new int[]{next, cur[1]+t[next-1]});
            }
            
        }
        
        return res;
    }

}