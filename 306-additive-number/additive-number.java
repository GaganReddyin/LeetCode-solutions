class Solution {
  
    // Main function to check if a number is an additive number
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
      
        // The first number should be less than n - 1 digits and not have leading zeroes
        // Limit to 19 digits to avoid parsing numbers larger than Long.MAX_VALUE
        for (int firstNumEndIndex = 1; firstNumEndIndex < Math.min(n - 1, 19); ++firstNumEndIndex) {
            // The second number should start after the first and also avoid leading zeroes
            for (int secondNumStartIndex = firstNumEndIndex + 1; secondNumStartIndex < Math.min(n, firstNumEndIndex + 19); ++secondNumStartIndex) {
                if (firstNumEndIndex > 1 && num.charAt(0) == '0') {
                    // Exclude numbers with leading zeroes
                    break;
                }
                if (secondNumStartIndex - firstNumEndIndex > 1 && num.charAt(firstNumEndIndex) == '0') {
                    continue; // Skip if second number has leading zeroes
                }
                long firstNum = Long.parseLong(num.substring(0, firstNumEndIndex));
                long secondNum = Long.parseLong(num.substring(firstNumEndIndex, secondNumStartIndex));
                // Use a helper function to recursively check the rest of the sequence
                if (isAdditiveSequence(firstNum, secondNum, num.substring(secondNumStartIndex))) {
                    return true;
                }
            }
        }
        return false;
    }

    // Helper function to recursively check the additive sequence
    private boolean isAdditiveSequence(long firstNum, long secondNum, String remainingNum) {
        // If there's no more characters left to check, we've found an additive sequence
        if ("".equals(remainingNum)) {
            return true;
        }
        // Exclude checks where the next number starts with '0' unless it's just '0'
        if (firstNum + secondNum > 0 && remainingNum.charAt(0) == '0') {
            return false;
        }
      
        // Loop through potential next numbers in the sequence
        for (int nextNumEndIndex = 1; nextNumEndIndex < Math.min(remainingNum.length() + 1, 19); ++nextNumEndIndex) {
            long sum = firstNum + secondNum;
            String sumStr = remainingNum.substring(0, nextNumEndIndex);
            // Parse the next number and compare it against the sum
            if (sum == Long.parseLong(sumStr)) {
                // If the sum matches the next number, continue checking the sequence
                if (isAdditiveSequence(secondNum, sum, remainingNum.substring(nextNumEndIndex))) {
                    return true;
                }
            }
        }
        // If no valid additive sequence is found
        return false;
    }
}