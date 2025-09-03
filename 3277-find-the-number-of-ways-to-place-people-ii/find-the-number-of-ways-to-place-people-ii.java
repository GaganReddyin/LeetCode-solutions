import java.util.*;

class Solution {
  public static boolean comp(int[] a, int[] b) {
      if (a[0] == b[0]) return a[1] > b[1];
      return a[0] < b[0];
  }

  public int numberOfPairs(int[][] arr) {
      int n = arr.length;

      Arrays.sort(arr, (a, b) -> {
          if (a[0] == b[0]) return b[1] - a[1];
          return a[0] - b[0];
      });

      int cnt = 0;
      for (int i = 0; i < n; i++) {
          int top = arr[i][1];
          int bot = Integer.MIN_VALUE;
          for (int j = i + 1; j < n; j++) {
              int y = arr[j][1];
              if (bot < y && y <= top) {
                  cnt++;
                  bot = y;
                  if (bot == top) break;
              }
          }
      }
      return cnt;
  }
}