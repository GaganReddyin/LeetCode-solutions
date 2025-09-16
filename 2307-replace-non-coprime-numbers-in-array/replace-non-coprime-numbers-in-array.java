import java.util.*;

class Solution {
    // Helper function to calculate GCD
    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    // Helper function to calculate LCM
    private long lcm(long a, long b) {
        if (a == 0 || b == 0) return 0;
        return (a * b) / gcd(a, b);
    }

    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Long> stack = new ArrayList<>();
        
        for (int num : nums) {
            stack.add((long) num);
            
            // Keep merging the last two elements as long as they are non-coprime
            while (stack.size() > 1) {
                long a = stack.get(stack.size() - 1);
                long b = stack.get(stack.size() - 2);
                long g = gcd(a, b);
                
                if (g == 1) break;  // Coprime, stop merging
                
                stack.remove(stack.size() - 1);
                stack.remove(stack.size() - 1);
                stack.add(lcm(a, b));
            }
        }
        
        // Convert result back to Integer list
        List<Integer> ans = new ArrayList<>();
        for (long val : stack) {
            ans.add((int) val);
        }
        return ans;
    }
}