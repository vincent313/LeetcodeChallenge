package TopLikedQuestion;
/**
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 *
 * A valid BST is defined as follows:
 *
 * The left
 * subtree
 *  of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
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
public class ValidateBinarySearchTree {
	boolean flag=true;
	public boolean isValidBST(TreeNode root) {
		if(root.left!=null){searchLeft(root.left,root.val,null);}
		if(root.right!=null){searchRight(root.right,null,root.val);}
		return flag;
	}

	//need smaller than leftvalue
	private void searchLeft(TreeNode root,Integer leftvalue,Integer rightvalue){
		if(!flag){return;}
		if(rightvalue!=null&&root.val<=rightvalue){
			flag=false;
			return;
		}

		if(root.val>=leftvalue){
			flag=false;
			return;
		}

		if(root.right!=null) {
			searchRight(root.right,leftvalue,root.val);
		}

		if(root.left!=null){
			searchLeft(root.left,root.val,rightvalue);
		}

	}

	//bigger than rightvalue
	private void searchRight(TreeNode root,Integer leftvalue,Integer rightvalue){
		if(!flag){return;}
		if(root.val<=rightvalue){
			flag=false;
			return;
		}
		if(leftvalue!=null&&root.val>=leftvalue){

			flag=false;
			return;
		}

		if(root.right!=null) {
			searchRight(root.right,leftvalue,root.val);
		}

		if(root.left!=null){
			searchLeft(root.left,root.val,rightvalue);
		}
	}

}
