/*
Given a nested list of integers, return the sum of all integers in the list weighted by their depth.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Different from the previous question where weight is increasing from root to leaf, now the weight is defined from bottom up. i.e., the leaf level integers have weight 1, and the root level integers have the largest weight.

Example 1:

Input: [[1,1],2,[1,1]]
Output: 8 
Explanation: Four 1's at depth 1, one 2 at depth 2.
Example 2:

Input: [1,[4,[6]]]
Output: 17 
Explanation: One 1 at depth 3, one 4 at depth 2, and one 6 at depth 1; 1*3 + 4*2 + 6*1 = 17.
*/

//Inspired by lzb700m's solution and one of mine. Instead of multiplying by depth, add integers multiple times (by going level by level and adding the unweighted sum to the weighted sum after each level).

public int depthSumInverse(List<NestedInteger> nestedList) {
    int unweighted = 0, weighted = 0;
    while (!nestedList.isEmpty()) {
        List<NestedInteger> nextLevel = new ArrayList<>();
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger())
                unweighted += ni.getInteger();
            else
                nextLevel.addAll(ni.getList());
        }
        weighted += unweighted;
        nestedList = nextLevel;
    }
    return weighted;
}
