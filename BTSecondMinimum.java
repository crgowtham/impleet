/*
Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes. More formally, the property root.val = min(root.left.val, root.right.val) always holds.

Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.

If no such second minimum value exists, output -1 instead.

 

Example 1:


Input: root = [2,2,5,null,null,5,7]
Output: 5
Explanation: The smallest value is 2, the second smallest value is 5.
*/

public int findSecondMinimumValue(TreeNode root) {
    if(root==null)  return -1;
    return findSecondMinValue(root, root.val);
}


public int findSecondMinValue(TreeNode root, int min) {
    if(root==null)  return -1;
    if(root.val>min)   return root.val;
    int leftMin = findSecondMinValue(root.left,min);
    int rightMin = findSecondMinValue(root.right,min);
    return (leftMin==-1 || rightMin==-1) ? Math.max(leftMin,rightMin) : Math.min(leftMin,rightMin);
}

public int findSecondMinimumValue(TreeNode root) {
	if(root==null || root.right==null || root.left==null) return -1;
	Queue<TreeNode> q = new LinkedList<>();
	q.offer(root);
	Integer secondMin = null;
	while(!q.isEmpty()) {
		TreeNode curr = q.poll();
		if(curr.right!=null) q.offer(curr.right);
		if(curr.left!=null) q.offer(curr.left);
		if(curr.val!=root.val) {
			if(secondMin==null) secondMin = curr.val;
			else secondMin = Math.min(secondMin, curr.val);
		}
	}
	return secondMin==null? -1 : secondMin;
}
