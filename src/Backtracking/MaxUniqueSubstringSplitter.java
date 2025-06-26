package backtracking;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem: 1593. Split a String Into the Max Number of Unique Substrings (Medium)
 *
 * Description:
 * Given a string `s`, split it into the **maximum number** of **non-empty unique substrings**.
 * The substrings must be **non-overlapping** and **concatenated** to form the original string.
 *
 * Example:
 * Input: "ababccc"
 * Output: 5
 * Explanation: One possible split is ["a","b","ab","c","cc"]
 *
 * Approach:
 * This is solved using **backtracking**:
 * - At each index, we try all possible substrings starting from that index.
 * - If the substring is not already used (tracked via a HashSet), we add it and recurse.
 * - After exploring that path, we backtrack by removing the substring from the set.
 * - The goal is to maximize the count of unique substrings.
 */
public class MaxUniqueSubstringSplitter {

    /**
     * Public method to initiate the unique substring splitting.
     *
     * @param s the input string
     * @return the maximum number of unique substrings
     */
    public int maxUniqueSplit(String s) {
        return backtrack(s, 0, new HashSet<>());
    }

    /**
     * Recursive backtracking function to explore all valid splits.
     *
     * @param s     the input string
     * @param index current index to start the next substring
     * @param used  set of substrings used so far
     * @return max number of unique substrings from this index onward
     */
    private int backtrack(String s, int index, Set<String> used) {
        if (index == s.length()) {
            return used.size();
        }

        int maxCount = 0;

        for (int i = index + 1; i <= s.length(); i++) {
            String candidate = s.substring(index, i);

            if (!used.contains(candidate)) {
                used.add(candidate);
                maxCount = Math.max(maxCount, backtrack(s, i, used));
                used.remove(candidate);  // backtrack
            }
        }

        return maxCount;
    }
}
