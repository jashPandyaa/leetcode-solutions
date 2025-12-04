class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Base case: if strs array is empty then return empty arraylist
        if (strs.length == 0)
            return new ArrayList();

        // Create HashMap with String type key (pattern) and List type values (anagram group)
        // Key = character frequency pattern, Value = list of strings with that pattern
        Map<String, List> map = new HashMap<>();

        // Array to count frequency of each letter (a-z = 26 letters)
        int[] count = new int[26];

        // Traverse through given array of strings
        for (String s : strs) {
            // Reset count array to all 0s for each new string
            // This prepares fresh counting for current string
            Arrays.fill(count, 0);

            // Count frequency of each character in current string
            // Example: "eat" → count[4]=1, count[0]=1, count[19]=1
            for (char c : s.toCharArray()) {
                count[c - 'a']++; // 'c - 'a'' converts char to index (a=0, b=1, ..., z=25)
            }

            // Build a unique key based on character frequencies
            // StringBuilder is used for efficient string concatenation
            StringBuilder sb = new StringBuilder("");

            // Create pattern string from frequency array
            // Example: if count = [1,0,0,0,1,0,...,1,0] → "#1#0#0#0#1#0...#1#0"
            // '#' acts as separator to avoid ambiguity (e.g., "12" vs "1,2")
            for (int i = 0; i < 26; i++) {
                sb.append("#"); // Add separator
                sb.append(count[i]); // Add frequency count
            }

            // Convert StringBuilder to String - this becomes our unique key
            // All anagrams will have the same key pattern
            String key = sb.toString();

            // If this pattern doesn't exist in map, create new entry with empty list
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList());
            }

            // Add current string to the list corresponding to its pattern key
            // This groups all anagrams together
            map.get(key).add(s);
        }

        // Return all grouped anagram lists (we don't need the keys, just the values)
        return new ArrayList(map.values());
    }
}