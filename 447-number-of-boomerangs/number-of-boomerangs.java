class Solution {
    public int numberOfBoomerangs(int[][] points) {

        int counter = 0;

        Map<Integer, Integer>[] map = new HashMap[points.length];
        for (int i = 0; i < points.length; i++) {
            map[i] = new HashMap<>(); // Initialize each map
        }

        // Iterate over all points
        for (int i = 0; i < points.length; i++) {

            for (int j = 0; j < points.length; j++) {
                if (i == j) continue; // Skip comparing the point to itself

                int distance = helper(points[i], points[j]);

                counter += map[i].getOrDefault(distance, 0) * 2;

                map[i].put(distance, map[i].getOrDefault(distance, 0) + 1);
            }
        }

        return counter;
    }

    // Helper method to calculate squared distance between two points
    private int helper(int[] first, int[] second) {
        int dx = first[0] - second[0];
        int dy = first[1] - second[1];
        return dx * dx + dy * dy;
    }
}