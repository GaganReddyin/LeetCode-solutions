class Solution {
    public String kthDistinct(String[] arr, int k) {
     Map<String, Integer> map = new HashMap<>();
     
     for(String s : arr) {
         if(map.containsKey(s)) map.put(s, map.get(s) + 1);
         else map.put(s, 1);
     }
     int i = 0;
     for(String s : arr) {
         if(map.get(s) == 1 && ++ i == k)
         return s;
     }
     return "";
    }
}