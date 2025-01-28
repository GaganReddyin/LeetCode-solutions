class Solution {
    public int minAnagramLength(String s) {
        int[] cache = new int[26];

        for (int i = 0; i < s.length() / 2; ++i) {
            ++cache[s.charAt(i) - 'a'];
            if (s.length() % (i + 1) != 0) continue;
            if (isStringByConcat(s, cache, i + 1, i + 1, s.length())) return i + 1;
        } 

        return s.length();
    }

    private boolean isStringByConcat(String originalString, int[] cache, int pos, int substringLen, int totalLen) {
        if (pos == totalLen) return true;
        
        var tmpCache = cache.clone();
        for (int i = pos; i < pos + substringLen; ++i) {
            if (--tmpCache[originalString.charAt(i) - 'a'] < 0) return false;
        }
        return isStringByConcat(originalString, cache, pos + substringLen, substringLen, totalLen);
    }
}