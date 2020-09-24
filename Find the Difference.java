public char findTheDifference(String s, String t) {
    int[] counts = new int[26];
    for (char ch : s.toCharArray()) {
        ++counts[ch-'a'];
    }
    for (char ch : t.toCharArray()) {
        --counts[ch - 'a'];
        if (counts[ch - 'a'] < 0)
            return ch;
    }
    return ' ';
}