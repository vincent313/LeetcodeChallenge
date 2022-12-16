package TopLikedQuestion;
/**
 *105. Construct Binary Tree from Preorder and Inorder Traversal
 * Medium

 * Example 1:
 *
 *
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 * Example 2:
 *
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 *   */
public class ConstructBinaryTree {
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
	class Solution {
		public TreeNode buildTree(int[] preorder, int[] inorder) {
			TreeNode result=build(preorder,inorder,0,inorder.length-1,0,preorder.length-1);
			return result;
		}
		private TreeNode build(int[] preorder,int[] inorder,int inFrom,int inEnd,int preFrom,int preEnd){
			if(inFrom==inEnd){
				return new TreeNode(inorder[inFrom],null,null);
			}else if(inFrom>inEnd){
				return null;
			}
			int rootValue=preorder[preFrom];
			TreeNode root=new TreeNode(rootValue);
			int leftElementNum=0;
			for(int i=inFrom;i<=inEnd;i++){
				if(inorder[i]==rootValue){
					leftElementNum=i-inFrom;
				}
			}

			int leftPreStart=preFrom+1;
			int leftPreEnd=leftPreStart+leftElementNum-1;
			int leftInStart=inFrom;
			int leftInEnd=inFrom+leftElementNum-1;

			int rightPreStart=preFrom+leftElementNum+1;
			int rightPreEnd=preEnd;
			int rightInStart=inFrom+leftElementNum+1;
			int rightInEnd=inEnd;

			root.left=build(preorder,inorder,leftInStart,leftInEnd,leftPreStart,leftPreEnd);
			root.right=build(preorder,inorder,rightInStart,rightInEnd,rightPreStart,rightPreEnd);
			return root;
		}
	}

}
