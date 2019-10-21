package com.lw.day16;

import java.util.Stack;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
public class D172 {
	/**
	 * 思路： 非递归中序遍历 1. hasNext：当前节点不为null，返回true
	 */

	private Stack<TreeNode> stack = new Stack<TreeNode>();
	private TreeNode root;

	public D172(TreeNode root) {
	    this.root = root;
	}

	/** @return the next smallest number */
	public int next() {
		int val = 0;
		while (root != null) {
			stack.push(root);
			root = root.left;
		}
		if (!stack.isEmpty()) {
			root = stack.pop();
			val = root.val;
			root = root.right;
		}
		return val;
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return root != null || !stack.isEmpty();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(7);
		root.left = new TreeNode(3);
//		root.left.left = new TreeNode(2);
//		root.left.right = new TreeNode(5);
		root.right = new TreeNode(15);
//		root.right.left = new TreeNode(9);
//		root.right.right = new TreeNode(20);
		
		D172 d172 = new D172(root);
		System.out.println(d172.next());
		System.out.println(d172.next());
		System.out.println(d172.hasNext());
		System.out.println(d172.next());
		System.out.println(d172.hasNext());
		
//		System.out.println(d172.next());
//		System.out.println(d172.hasNext());
//		System.out.println(d172.next());
//		System.out.println(d172.hasNext());
	}

}
