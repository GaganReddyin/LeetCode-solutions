import java.util.*;

public class Solution {
    
    public boolean hasValidPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        LinkedList<int[]> bfs = new LinkedList<>();
        bfs.add(new int[] { 0, 0 });
        visited[0][0] = true;
        
        while (!bfs.isEmpty()) {
            int[] current = bfs.remove();
            int r = current[0];
            int c = current[1];
            if (r == m - 1 && c == n - 1) {
                return true;
            }
            int street = grid[r][c];
            Set<Integer> allowedDirections = transitions.get(street);
            
            for (int direction : allowedDirections) {
                int nr = r + MOVES[direction][0];
                int nc = c + MOVES[direction][1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc]) {
                    int nextStreet = grid[nr][nc];
                    Set<Integer> nextAllowed = transitions.get(nextStreet);
                    if (nextAllowed.contains(OPPOSITE[direction])) {
                        bfs.add(new int[] { nr, nc });
                        visited[nr][nc] = true;
                    }
                }
            }
        }
        return visited[m - 1][n - 1];
    }

    private static final int[][] MOVES = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };
    private static final int[] OPPOSITE = { 3, 2, 1, 0 };
    private static Map<Integer, Set<Integer>> transitions = new HashMap<>();
    static {
        transitions.put(1, new HashSet<>(Arrays.asList(1, 2)));
        transitions.put(2, new HashSet<>(Arrays.asList(0, 3)));
        transitions.put(3, new HashSet<>(Arrays.asList(1, 3)));
        transitions.put(4, new HashSet<>(Arrays.asList(2, 3)));
        transitions.put(5, new HashSet<>(Arrays.asList(0, 1)));
        transitions.put(6, new HashSet<>(Arrays.asList(0, 2)));
    }
}