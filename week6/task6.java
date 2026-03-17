class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length())
            return res;

        int[] sCount = new int[26];
        int[] pCount = new int[26];

        for (int i = 0; i < p.length(); i++) {
            sCount[s.charAt(i) - 'a']++;
            pCount[p.charAt(i) - 'a']++;
        }

        if (Arrays.equals(pCount, sCount))
            res.add(0);

        for (int i = p.length(); i < s.length(); i++) {

            sCount[s.charAt(i) - 'a']++;

            // remove character freqeuency which is at i-p.length index bczz its not needed anymore in current window
            sCount[s.charAt(i - p.length()) - 'a']--;

            if (Arrays.equals(pCount, sCount))
                res.add(i - p.length() + 1);

        }
        return res;
    }
}
