class Solution {
    public int countSubstrings(String s) {
        if (s == null || s.length() <= 0) {
            return 0;
        }
        int res = 0;
        int length = s.length();
        char[] chars = s.toCharArray();

        for (int i = 0; i < length; i++) {
            res += countPalindrome(chars, i, i);
            res += countPalindrome(chars, i, i + 1);
        }

        return res;
    }

    private int countPalindrome(char[] chars, int start, int end) {
        int curRes = 0;
        int length = chars.length;
        while ((start >= 0) && (end < length) && (chars[start--] == chars[end++])) {
            curRes++;
        }
        
        return curRes;
    }
}