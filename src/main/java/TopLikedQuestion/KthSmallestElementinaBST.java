package TopLikedQuestion;

import java.util.PriorityQueue;

/**
 * 230. Kth Smallest Element in a BST
 * Medium
 * 9.2K
 * 165
 * company
 * Uber
 * company
 * Amazon
 * company
 * Expedia
 * Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
 * */

/**
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
class KthSmallestElementinaBST {
	PriorityQueue<TreeNode> queue;
	int target;
	int current=0;
	int result;
	public int kthSmallest(TreeNode root, int k) {
		target=k;
		traverseBST(root);
		return result;
	}

	private void traverseBST(TreeNode node){


		if (node.left!=null){
			traverseBST(node.left);
		}

		current++;
		if(current==target){
			result=node.val;
			return;
		}

		if(current>target){
			return;
		}
		if(node.right!=null){
			traverseBST(node.right);
		}

	}
}