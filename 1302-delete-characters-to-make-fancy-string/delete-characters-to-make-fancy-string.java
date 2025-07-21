class Solution {
    public String makeFancyString(String s) {
        int l = s.length();
        if(l < 3) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int continous = 1;
        sb.append(s.charAt(0));
        for (int i = 1; i < l; i ++) {
            char ch = s.charAt(i);
            if (ch == s.charAt(i-1)) {
                if (continous < 2) {
                    continous += 1;
                } else {
                    continue;
                }
            } else {
                continous = 1;
            }
            sb.append(ch);
        }
        return sb.toString();
    }
}