package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Solves the "Combination Sum" problem (LeetCode #39) using a backtracking approach.
 */
public class CombinationSumSolver {

    /**
     * Returns all unique combinations of candidates that sum to the target.
     *
     * @param candidates Array of candidate numbers.
     * @param target     The target sum to achieve.
     * @return List of all valid combinations.
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }

    /**
     * Recursive backtracking helper method.
     */
    private void backtrack(int[] candidates, int start, int target,
                           List<Integer> currentCombination, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(currentCombination));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) continue;

            currentCombination.add(candidates[i]);
            backtrack(candidates, i, target - candidates[i], currentCombination, result);
            currentCombination.remove(currentCombination.size() - 1);
        }
    }
}
