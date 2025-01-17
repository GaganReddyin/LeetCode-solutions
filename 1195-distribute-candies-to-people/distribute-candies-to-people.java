class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int[] arr = new int[num_people];
        int c = 0;
        int candi = 1;

        while (candies > 0) {
            if (c == arr.length){
                c = 0;
            }

            if (candies - candi > 0) {
                arr[c] += candi;
            }else{
                arr[c] += candies;
            }
            candies -= candi;
            candi++;
            c++;
        }

        return arr;
    }
}