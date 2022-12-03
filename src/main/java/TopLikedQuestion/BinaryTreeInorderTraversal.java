package TopLikedQuestion;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
	/**
	 * 94. Binary Tree Inorder Traversal
	 *
	 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
	 *
	 *
	 *
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode() {}
	 *     TreeNode(int val) { this.val = val; }
	 *     TreeNode(int val, TreeNode left, TreeNode right) {
	 *         this.val = val;
	 *         this.left = left;
	 *         this.right = right;
	 *     }
	 * }
	 */
	class Solution {
		ArrayList<Integer> arr=new ArrayList<Integer>();
		public List<Integer> inorderTraversal(TreeNode root) {
			if(root==null){
				return arr;
			}
			inorderTraversal(root.left);
			arr.add(root.val);
			inorderTraversal(root.right);
			return arr;
		}
	}
}
