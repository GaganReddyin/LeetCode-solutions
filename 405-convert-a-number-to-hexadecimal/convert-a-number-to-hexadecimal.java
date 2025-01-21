class Solution {
    public String toHex(int num) {
        if (num == 0) return "0";
        
        boolean isNegative = num < 0;
        
        num = isNegative ? (num + 1) * -1 : num;
        
        var sb = new StringBuilder();
        while (num > 0) {
            int r = num % 16;
            if (isNegative) r = 15 - r;
            char c = (char) (r < 10 ? r + '0' : r - 10 + 'a');
            sb.append(c);
            num /= 16;
        }
        
        if (isNegative) {
            while (sb.length() < 8) {
                sb.append('f');
            }
        }
        
        return sb.reverse().toString();
    }
}