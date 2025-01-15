class Solution {
    public int findContentChildren(int[] greed, int[] cookieSize) {
        Arrays.sort(greed);
        Arrays.sort(cookieSize);
        int i = 0, j = 0, count = 0;
        while(j<cookieSize.length && i<greed.length){
            if(greed[i]<=cookieSize[j]){
                count++;
                i++;
            }
            j++;
        }
        return count;
    }
}