class Solution {

    private static final long MOD = 1000000007;
    private static final long[][] pascal_tringle = BuildPascalsTriangle();

    public int numOfWays(int[] nums) {
        List<Integer> arr = Arrays.stream(nums).boxed().collect(Collectors.toList()) ;
        
        return (int)((NumsOfWays(arr)-1) % MOD);
    }

    private long NumsOfWays(List<Integer> nums) {
        int n = nums.size();
        if (n <= 2) return 1;

        List<Integer> leftNodes = new ArrayList<>();
        List<Integer> rightNodes = new ArrayList<>();

        int root = nums.get(0);
        for (int i=1; i<n; i++) {
            if (nums.get(i) < root) {
                leftNodes.add(nums.get(i));
            } else {
                rightNodes.add(nums.get(i));
            }
        }

        return (((NumsOfWays(leftNodes) % MOD * NumsOfWays(rightNodes) % MOD) % MOD) * 
        pascal_tringle[n-1][leftNodes.size()]) % MOD;
    }

    private static long[][] BuildPascalsTriangle() {
        int n=1000;
        long[][] pascal_tringle = new long[n][n];

        for (int i=0; i<n; i++) {
            pascal_tringle[i][0] = pascal_tringle[i][i] = 1;
        }
        for (int i=2; i<n; i++) {
            for (int j=1; j<i; j++) {
                pascal_tringle[i][j] =
                 (pascal_tringle[i-1][j] + pascal_tringle[i-1][j-1]) % MOD;
            }
        }
        return pascal_tringle;
    }
}