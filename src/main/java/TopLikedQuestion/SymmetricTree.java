package TopLikedQuestion;

import java.util.ArrayList;

/**
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 * */

/**public class SymmetricTree {

	ArrayList<Integer> leftNoodArr=new ArrayList<Integer>();
	ArrayList<Integer> rightNoodArr=new ArrayList<Integer>();
	public boolean isSymmetric(TreeNode101 root) {

		leftFirst(root.left);
		rightFirst(root.right);
		if(leftNoodArr.size()!=rightNoodArr.size()){return false;}
		for(int i=0;i<leftNoodArr.size();i++){
			if(!leftNoodArr.get(i).equals(rightNoodArr.get(i))){
				return false;
			}
		}
		return true;
	}
	public void leftFirst(TreeNode101 left){
		if(left==null){
			leftNoodArr.add(null);
			return;
		}
		leftNoodArr.add(left.val);
		if (left.left==null&&left.right==null){return;}
		leftFirst(left.left);
		leftFirst(left.right);
	}

	public void rightFirst(TreeNode101 right){
		if(right==null){
			rightNoodArr.add(null);
			return;
		}
		rightNoodArr.add(right.val);
		if(right.right==null&&right.left==null){return;}
		rightFirst(right.right);
		rightFirst(right.left);
	}
}
 class TreeNode101 {
      int val;
      TreeNode left;
      TreeNode right;
	 TreeNode101() {}
	 TreeNode101(int val) { this.val = val; }
	 TreeNode101(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 */
