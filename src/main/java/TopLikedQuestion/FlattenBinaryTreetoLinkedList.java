package TopLikedQuestion;
/**
 * 114. Flatten Binary Tree to Linked List

 * Example 1:
 *
 *
 * Input: root = [1,2,5,3,4,null,6]
 * Output: [1,null,2,null,3,null,4,null,5,null,6]
 * Example 2:
 *
 * Input: root = []
 * Output: []
 * Example 3:
 *
 * Input: root = [0]
 * Output: [0]*/
public class FlattenBinaryTreetoLinkedList {
	public void flatten(TreeNode root) {
		getFlatten(root);
	}

	//solution 1, return TreeNode array,[0]-> first node ,[1]-> last node,time complex O(n)
	private TreeNode[] getFlatten(TreeNode root){
		if(root==null){return null;}
		TreeNode[] result=new TreeNode[2];
		if(root.left==null&&root.right==null){
			result[0]=root;
			result[1]=root;
			return result;
		}else if(root.left==null){
			TreeNode[] Temp=getFlatten(root.right);
			result[0]=root;
			root.right=Temp[0];
			result[1]=Temp[1];
			return result;
		}else if(root.right==null){
			TreeNode[] Temp=getFlatten(root.left);
			result[0]=root;
			root.right=Temp[0];
			result[1]=Temp[1];
			root.left=null;
			return result;
		}else{
			TreeNode[] LeftTemp=getFlatten(root.left);
			TreeNode[] RightTemp=getFlatten(root.right);
			result[0]=root;
			root.left=null;
			root.right=LeftTemp[0];
			LeftTemp[1].right=RightTemp[0];
			result[1]=RightTemp[1];
			return result;
		}
	}

	//solution 2, get the first node, then traverse to the end, time complex O(n*n)
	private TreeNode getFlatten1(TreeNode root){
		if(root==null){return null;}

		TreeNode left=getFlatten1(root.left);
		TreeNode right=getFlatten1(root.right);
		if(left!=null){
			root.right=left;
			getLastNode(left).right=right;
			root.left=null;
		}
		return root;
	}

	private TreeNode getLastNode(TreeNode root){
		if(root.right==null){
			return root;
		}
		return getLastNode(root.right);
	}
}
