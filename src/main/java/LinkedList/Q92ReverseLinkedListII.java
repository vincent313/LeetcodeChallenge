package LinkedList;

public class Q92ReverseLinkedListII {
	public ListNode reverseBetween(ListNode head, int left, int right) {
		if(left==right){return head;}
		int currentIndex=1;
		ListNode currentNode=head;
		ListNode startNode=null;

		while(currentIndex<left){
			startNode=currentNode;
			currentNode=currentNode.next;
			currentIndex++;
		}

		if(right-left==1){
			ListNode temp=currentNode;
			currentNode=currentNode.next;
			temp.next=currentNode.next;
			currentNode.next=temp;
			if(startNode==null){
				return currentNode;
			}else{
				startNode.next=currentNode;
			}
			return head;
		}

		ListNode nextNode=currentNode.next;

		while(currentIndex<right){
			currentIndex++;
			ListNode temp=currentNode;
			currentNode=nextNode;
			nextNode=nextNode.next;
			currentNode.next=temp;
		}

		ListNode result;
		ListNode temp;
		if(startNode==null){
			result=currentNode;
			temp=head;
		}else{
			temp=startNode.next;
			result=head;
			startNode.next=currentNode;
		}

		if(nextNode!=null){
			temp.next=nextNode;
		}else{temp.next=null;}

		return result;

	}
}
