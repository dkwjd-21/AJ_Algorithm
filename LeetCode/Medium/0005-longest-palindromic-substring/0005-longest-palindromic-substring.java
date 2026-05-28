class Solution {
    public String longestPalindrome(String s) {
        for (int len = s.length(); len >= 1; len--) {
            for (int i = 0; i + len <= s.length(); i++) {
                if (isPalindrome(s, i, i + len - 1)) {
                    return s.substring(i, i + len);
                }
            }
        }
        return "";
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true; 
    }
}