package TopLikedQuestion;
/**
 * You are given the heads of two sorted linked lists list1 and list2.
 *
 * Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
 *
 * Return the head of the merged linked list.
 * */
public class MergeTwoSortedList {
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode() {}
	 *     ListNode(int val) { this.val = val; }
	 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 * }
	 */
	class Solution {
		public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
			if (list1==null&&list2==null){
				return null;
			}else if(list1==null&&list2!=null){
				return list2;
			}else if(list1!=null&&list2==null){
				return list1;
			}

			ListNode l1=list1;
			ListNode l2=list2;
			ListNode result;
			ListNode temp;
			ListNode newLinkedList;
			if(l1.val<=l2.val){
				newLinkedList=l1;
				result=l1;
				l1=l1.next;
			}else{
				newLinkedList=l2;
				result=l2;
				l2=l2.next;
			}
			while(l1!=null||l2!=null){
				if(l1==null){
					result.next=l2;
					result=result.next;
					l2=l2.next;
				}else if(l2==null) {
					result.next=l1;
					result=result.next;
					l1=l1.next;
				}else if(l1.val<=l2.val){
					result.next=l1;
					result=result.next;
					l1=l1.next;
				}else{
					result.next=l2;
					result=result.next;
					l2=l2.next;
				}
			}
			return newLinkedList;
		}
	}
}
