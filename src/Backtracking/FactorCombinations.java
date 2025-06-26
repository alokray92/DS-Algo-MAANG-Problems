package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: 254. Factor Combinations (Medium)
 *
 * Description:
 * Given an integer n, return all possible combinations of its factors (excluding 1 and n).
 * Each combination should have at least two factors and be sorted in ascending order.
 *
 * Example:
 * Input: 16
 * Output: [[2, 8], [2, 2, 4], [2, 2, 2, 2], [4, 4]]
 *
 * Approach:
 * This uses a backtracking approach, exploring all factor pairs starting from 2 up to sqrt(n).
 * For each valid factor, it recursively continues the search while building up the current combination.
 */
public class FactorCombinations {

    /**
     * Generates all factor combinations for the given number.
     *
     * @param n the number to factor
     * @return list of all factor combinations
     */
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(n, 2, new ArrayList<>(), result);
        return result;
    }

    /**
     * Helper method to perform backtracking for factor combinations.
     *
     * @param remaining  the current value to factor
     * @param start      the starting factor to check
     * @param path       the current combination of factors
     * @param result     the master list of all valid combinations
     */
    private void backtrack(int remaining, int start, List<Integer> path, List<List<Integer>> result) {
        for (int i = start; i <= Math.sqrt(remaining); i++) {
            if (remaining % i == 0) {
                path.add(i);
                // Add the current combination along with its complementary factor
                List<Integer> combination = new ArrayList<>(path);
                combination.add(remaining / i);
                result.add(combination);

                // Continue factoring the quotient
                backtrack(remaining / i, i, path, result);

                // Backtrack
                path.remove(path.size() - 1);
            }
        }
    }
}
