package TopLikedQuestion;

import java.util.LinkedList;
import java.util.Queue;
/**
 *437. Path Sum III
 * Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.
 *
 * The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
 * Output: 3
 * Explanation: The paths that sum to 8 are shown.
 * Example 2:
 *
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * Output: 3
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 1000].
 * -109 <= Node.val <= 109
 * -1000 <= targetSum <= 1000
 *
 * */
public class PathSumIII {
	int result=0;
	public int pathSum(TreeNode root, int targetSum) {
		if(root==null){return 0;}
		Queue<TreeNode> queue=new LinkedList<TreeNode>();
		queue.offer(root);
		while(!queue.isEmpty()){
			TreeNode node=queue.poll();
			if(node.left!=null){
				queue.offer(node.left);
			}
			if(node.right!=null){
				queue.offer(node.right);
			}
			traverseNode(node,Double.valueOf(targetSum));
		}

		return result;
	}

	private void traverseNode(TreeNode node,Double target){


		if(node.val==target){
			result++;
		}
		if(node.left!=null){
			traverseNode(node.left,target-(node.val));
		}

		if(node.right!=null){
			traverseNode(node.right,target-(node.val));
		}
	}
}
