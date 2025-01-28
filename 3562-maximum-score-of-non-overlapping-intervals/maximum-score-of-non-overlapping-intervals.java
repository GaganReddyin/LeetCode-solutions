class Solution {
    /** Similar to interval scheduling problem */
    
    /** Helper class: store initial index before sorting */
    class Pair {
        int idx;
        List<Integer> interval;
        Pair(int idx, List<Integer> interval) {
            this.idx = idx;
            this.interval = interval;
        }
    }

    public int[] maximumWeight(List<List<Integer>> intervals) {
        // Sort intervals by finishing time
        List<Pair> intervalsWithIndex = new ArrayList<>();
        int n = intervals.size();
        for (int i = 0; i < n; i++) {
            Pair pair = new Pair(i, intervals.get(i));
            intervalsWithIndex.add(pair);
        }
        Collections.sort(intervalsWithIndex, (a, b) -> (a.interval.get(1) - b.interval.get(1)));

        long[][] dp = new long[n][5];
        int[] piTable = new int[n];
        piTable[0] = -1;
        // Compute max score
        for (int r = 1; r <= 4; r++) {
            dp[0][r] = intervalsWithIndex.get(0).interval.get(2);
        }
        for (int i = 1; i < n; i++) {
            List<Integer> interval = intervalsWithIndex.get(i).interval;
            int startTime = interval.get(0);
            int pi = binarySearch(intervalsWithIndex, startTime, 0, i - 1);
            piTable[i] = pi;
            for (int r = 1; r <= 4; r++) {
                long preOpt = (pi >= 0)? dp[pi][r - 1] : 0;
                dp[i][r] = Math.max(dp[i - 1][r], interval.get(2) + preOpt);
            }
        }
        // backtracking to get intervals selected
        List<Integer> current = new LinkedList<>();
        List<List<Integer>> results = new ArrayList<>();
        backtracking(n - 1, 4, piTable, dp, intervalsWithIndex, current, results);

        // Get the lexicographically smallest array
        List<Integer> smallestList = Collections.min(results, (list1, list2) -> {
            int size1 = list1.size();
            int size2 = list2.size();
            for (int i = 0; i < Math.min(size1, size2); i++) {
                if (!list1.get(i).equals(list2.get(i))) {
                    return list1.get(i) - list2.get(i);
                }
            }
            return size1 - size2; // If all elements are equal, the shorter list is smaller
        });
        int[] maxScoreArr = new int[smallestList.size()];
        for (int i = 0; i < smallestList.size(); i++) {
            maxScoreArr[i] = smallestList.get(i);
        }
        return maxScoreArr;
    }

    private void backtracking(int idx, int r, int[] piTable, long[][] dp, List<Pair> intervalsWithIndex, List<Integer> current, List<List<Integer>> results) {
        if (idx < 0 || r <= 0) {
            List<Integer> res = new ArrayList<>(current);
            Collections.sort(res);
            results.add(res);
            return;
        }
        if (idx == 0) {
            current.addLast(intervalsWithIndex.get(idx).idx);
            List<Integer> res = new ArrayList<>(current);
            Collections.sort(res);
            results.add(res);
            current.removeLast();
            return;
        }
        long score1 = dp[idx - 1][r];
        int pi = piTable[idx];
        long preOpt = (piTable[idx] == -1)? 0 : dp[pi][r - 1];
        long score2 = intervalsWithIndex.get(idx).interval.get(2) + preOpt;
        if (score1 > score2) {
            backtracking(idx - 1, r, piTable, dp, intervalsWithIndex, current, results);
        } else if (score1 < score2) {
            current.addLast(intervalsWithIndex.get(idx).idx);
            backtracking(pi, r - 1, piTable, dp, intervalsWithIndex, current, results);
            current.removeLast();
        } else {
            backtracking(idx - 1, r, piTable, dp, intervalsWithIndex, current, results);
            current.addLast(intervalsWithIndex.get(idx).idx);
            backtracking(pi, r - 1, piTable, dp, intervalsWithIndex, current, results);
            current.removeLast();
        }
    }

    /** Find pi, which is the largest index before j + 1 whose finishing time does not overlap with j + 1's start time.  */
    private int binarySearch(List<Pair> intervalsWithIndex, int startTime, int i, int j) {
        // base case
        if (j < 0) return -1;
        if (j - i <= 1) {
            Pair p = intervalsWithIndex.get(j);
            if (p.interval.get(1) < startTime) {
                return j;
            } else if (j - i == 1) {
                p = intervalsWithIndex.get(i);
                if (p.interval.get(1) < startTime) {
                    return i;
                } else {
                    return -1;
                }
            } else {
                return -1;
            }
        }
        // recursive case
        int mid = (j - i) / 2 + i; //prevent overflow
        Pair p = intervalsWithIndex.get(mid);
        if (p.interval.get(1) < startTime) {
            return binarySearch(intervalsWithIndex, startTime, mid, j);
        } else {
            return binarySearch(intervalsWithIndex, startTime, i, mid - 1);
        }
    }
}