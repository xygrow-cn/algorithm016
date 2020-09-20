class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] freqs = new int[26];
        for (char c: s.toCharArray()) freqs[c-'a']++;
        for (char c: t.toCharArray()) if (--freqs[c-'a']<0) return false;
        return true;
    }
}