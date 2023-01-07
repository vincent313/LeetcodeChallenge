package TopLikedQuestion;
/**
 * 148. Sort List
 * Medium

 * Given the head of a linked list, return the list after sorting it in ascending order.
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class SortList {

	public ListNode sortList(ListNode head) {
		if(head==null||head.next==null){return head;}
		ListNode mid=getMidNode(head);
		ListNode right=sortList(mid.next);
		mid.next=null;
		ListNode left=sortList(head);
		ListNode result=new ListNode(0);
		ListNode temp=result;
		while (left!=null||right!=null){
			if(right==null){
				temp.next=left;
				left=left.next;
				temp=temp.next;
				continue;
			}else if(left==null){
				temp.next=right;
				right=right.next;
				temp=temp.next;
				continue;
			}

			if(left.val<=right.val){
				temp.next=left;
				left=left.next;
				temp=temp.next;
			}else{
				temp.next=right;
				right=right.next;
				temp=temp.next;
			}
		}
		return result.next;
	}

	private ListNode getMidNode(ListNode head){
		ListNode slow=head;
		ListNode quick=head;
		while(quick.next!=null&&quick.next.next!=null){
			slow=slow.next;
			quick=quick.next.next;
		}
		return slow;
	}
}
