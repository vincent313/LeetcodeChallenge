/*
import TopLikedQuestion.ListNode;

import java.util.ArrayList;
*/
/**
 * 160. Intersection of Two Linked Lists
 * Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.
 *
 * For example, the following two linked lists begin to intersect at node c1:
 * *//*

public class IntersectionOfTwoLinkedList {
	*/
/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) {
	 *         val = x;
	 *         next = null;
	 *     }
	 * }
	 *//*

	public class Solution {
		ArrayList<Integer> edgeNum=new ArrayList<Integer>();
		public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
			ListNode endA=getLastNode(headA);
			ListNode endB=getLastNode(headB);
			if(endA!=endB){return null;}
			ListNode longList;
			ListNode shortList;
			int edgeDiff;
			if(edgeNum.get(0)>=edgeNum.get(1)){
				longList=headA;
				shortList=headB;
				edgeDiff=edgeNum.get(0)-edgeNum.get(1);
			}else{
				longList=headB;
				shortList=headA;
				edgeDiff=edgeNum.get(1)-edgeNum.get(0);
			}

			for(int i=0;i<edgeDiff;i++){
				longList=longList.next;
			}

			ListNode result=null;

			while(longList!=null){
				if(longList==shortList){
					result=longList;
					break;
				}
				longList=longList.next;
				shortList=shortList.next;
			}
			return result;


		}
		public ListNode getLastNode(ListNode head)
		{   int edge=0;
			while(head.next!=null){
				head=head.next;
				edge++;
			}
			edgeNum.add(edge);
			return head;
		}

	}
}
*/
