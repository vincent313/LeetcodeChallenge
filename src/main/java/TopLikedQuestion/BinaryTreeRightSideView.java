package TopLikedQuestion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 199. Binary Tree Right Side View
 * Medium

 * Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 * Example 1:
 * Input: root = [1,2,3,null,5,null,4]
 * Output: [1,3,4]
 * Example 2:
 *
 * Input: root = [1,null,3]
 * Output: [1,3]
 * Example 3:
 *
 * Input: root = []
 * Output: []
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
public class BinaryTreeRightSideView {

	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> result=new ArrayList<Integer>();
		Queue<TreeNode> queue=new LinkedList<TreeNode>();
		if(root==null){
			return result;
		}
		int pollCount=1;
		int offerCount=0;
		queue.offer(root);
		while(!queue.isEmpty()){
			pollCount--;
			TreeNode temp=queue.poll();
			if(temp.left!=null){
				queue.offer(temp.left);
				offerCount++;
			}
			if(temp.right!=null){
				queue.offer(temp.right);
				offerCount++;
			}
			if(pollCount==0){
				result.add(temp.val);
				pollCount=offerCount;
				offerCount=0;
			}
		}
		return result;
	}
}
