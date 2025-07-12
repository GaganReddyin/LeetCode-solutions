class Solution {

    private HashMap<String, int[]> memo = new HashMap<>();
    
    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        return solve(n , firstPlayer - 1, secondPlayer - 1);
    }

    private int[] solve (int n, int firstPlayer, int secondPlayer) {
        if (firstPlayer + secondPlayer == n - 1) {
            return new int[]{1, 1};
        }

        String key = n + "," + firstPlayer + "," + secondPlayer;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int earliest = Integer.MAX_VALUE;
        int latest = Integer.MIN_VALUE;

        List<List<Integer>> allOutcomes = generateAllOutcomes(n , firstPlayer, secondPlayer);
        
        for (List<Integer> winners : allOutcomes) {
            int nN = winners.size();
            int nFirst = winners.indexOf(firstPlayer);
            int nSecond = winners.indexOf(secondPlayer);
            int[] result = solve(nN, nFirst, nSecond);
            earliest = Math.min(earliest, result[0] + 1);
            latest = Math.max(latest, result[1] + 1);
        }
        
        int[] result = new int[]{earliest, latest};
        memo.put(key, result);
        return result;
    }

    private List<List<Integer>> generateAllOutcomes(int n, int firstPlayer, int secondPlayer) {
        List<List<Integer>> outcomes = new ArrayList<>();
        List<Integer> winners = new ArrayList<>();

        if (n % 2 == 1) {
            winners.add(n / 2);
        }

        backtrack(n , firstPlayer, secondPlayer, 0, winners, outcomes);
        return outcomes;
    }

    private void backtrack(int n, int firstPlayer, int secondPlayer, int pairIndex, List<Integer> winners, List<List<Integer>> outcomes) {
        int pairs = n / 2;
        if (pairIndex == pairs) {
            List<Integer> sorted = new ArrayList<>(winners);
            Collections.sort(sorted);
            outcomes.add(sorted);
            return;
        }
        int left = pairIndex;
        int right = n - 1 - pairIndex;
        
        if (left == firstPlayer || right == firstPlayer) {
            winners.add(firstPlayer);
            backtrack(n, firstPlayer, secondPlayer, pairIndex + 1, winners, outcomes);
            winners.remove(winners.size() - 1);
        } else if (left == secondPlayer || right == secondPlayer) {
            winners.add(secondPlayer);
            backtrack(n, firstPlayer, secondPlayer, pairIndex + 1, winners, outcomes);
            winners.remove(winners.size() - 1);
        } else {
            winners.add(left);
            backtrack(n, firstPlayer, secondPlayer, pairIndex + 1, winners, outcomes);
            winners.remove(winners.size() - 1);
            winners.add(right);
            backtrack(n, firstPlayer, secondPlayer, pairIndex + 1, winners, outcomes);
            winners. remove(winners.size() - 1);
        }
      
    }
}