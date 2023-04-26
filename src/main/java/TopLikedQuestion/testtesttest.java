package TopLikedQuestion;

import java.util.*;

public class testtesttest {
	int result;
	public static void main(String[] args) {
int[] tes=new int[5];

		System.out.println(tes[0]);

}

	public testtesttest(int result) {
		this.result = result;
	}

	private static node changeObj(node n){
	return n.next;
	}
	private node newObj(int a,int b){
	return  new node(a,new node(b,null));
	}
	private  class node{
		int val;
		node next;
		node(int val,node next){
			this.val=val;
			this.next=next;
		}

	}
}
