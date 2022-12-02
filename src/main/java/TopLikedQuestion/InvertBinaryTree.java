package TopLikedQuestion;
/**
 * 226. Invert Binary Tree
 * Given the root of a binary tree, invert the tree, and return its root.*/
public class InvertBinaryTree {
public TreeNode226 invertTree(TreeNode226 root) {
			if(root==null){return null;}
			if(root.left==null&&root.right==null){return root;}
			invertTree(root.left);
			invertTree(root.right);
			TreeNode226 temp=root.left;
			root.left=root.right;
			root.right=temp;
			return root;
		}
}

   class TreeNode226 {
      int val;
	  TreeNode226 left;
	  TreeNode226 right;
	  TreeNode226() {}
	  TreeNode226(int val) { this.val = val; }
	  TreeNode226(int val, TreeNode226 left, TreeNode226 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
