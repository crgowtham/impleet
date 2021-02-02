/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
*/

/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public Ideone left;
    public Ideone right;
    public int val;

    public Ideone(int val)
    {
        this.val=val;
    }

    public void printNode()
    {
        System.out.println(val);
    }
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		
		Ideone root = new Ideone(3);
        Ideone n1 = new Ideone(1);
        Ideone n2 = new Ideone(4);
        Ideone n3 = new Ideone(2);
        Ideone n4 = new Ideone(5);

        root.left = n1;
        root.right = n2;
        root.right.left = n3;
        root.right.right = n4;
        
        
		List<List<Integer>> lOrder = levelOrder(root);
		int i = 0;
		for(List<Integer> level : lOrder) {
			for(Integer l : level) {
				System.out.println("level :"+ i + "Number : " +  l);
			}
			i++;
		} 
	}
	
	static public List<List<Integer>> levelOrder(Ideone root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        levelHelper(res, root, 0);
        return res;
    }
    
    static public void levelHelper(List<List<Integer>> res, Ideone root, int height) {
        if (root == null) return;
        if (height >= res.size()) {
            res.add(new LinkedList<Integer>());
        }
        res.get(height).add(root.val);
        levelHelper(res, root.left, height+1);
        levelHelper(res, root.right, height+1);
    }
}
