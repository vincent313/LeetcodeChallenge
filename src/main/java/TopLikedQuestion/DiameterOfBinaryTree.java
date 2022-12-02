package TopLikedQuestion;
/**
 * 543. Diameter of Binary Tree
 *
 * Given the root of a binary tree, return the length of the diameter of the tree.
 *
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 *
 * The length of a path between two nodes is represented by the number of edges between them.
 * */


/**
 * Definition for a binary tree node.*/
   class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
     }
  }

public class DiameterOfBinaryTree {
	int diameter=0;
	public int diameterOfBinaryTree(TreeNode root) {
		getDeep(root);
		return diameter;
	}

	public int getDeep(TreeNode node){
		int leftDeep=0;
		int rightDeep=0;
		int maxDeep=0;
		if(node.left!=null){leftDeep=getDeep(node.left);}
		if(node.right!=null){rightDeep=getDeep(node.right);}

		if(leftDeep>=rightDeep){
			maxDeep=leftDeep+1;
		}else{
			maxDeep=rightDeep+1;
		}
		if ((leftDeep+rightDeep)>diameter){
			diameter=leftDeep+rightDeep;
		}

		return maxDeep;

	}
}
