package TopLikedQuestion;

public class ClimbingStairs {
}

//bottom up的方式,Fibonacci sequence
class ClimbingStairsSolution {

	public int climbStairs(int n) {
		if(n==1){return 1;}
		if(n==2){return 2;}
		int result;
		int left=1;
		int right=1;
		for(int i=n-2;i>0;i--){
			int temp=left;
			left=left+right;
			right=temp;
		}
		return left+right;
	}

}

/***
 //Recursion and Memoization

 class Solution {
 int[] arr;
 public int climbStairs(int n) {
 if(n==1){
 return 1;
 }
 if(n==2){
 return 2;
 }
 arr=new int[n];
 for(int i=0;i<n;i++){
 arr[i]=-1;
 }
 return climbStairs(0,n);
 }
 public int climbStairs(int current,int n){
 if(arr[current]!=-1){return arr[current];}
 if(current>n){return 0;}
 if(n-current==1){return 1;}
 if(n-current==2){return 2;}
 int res=climbStairs(current+1,n)+climbStairs(current+2,n);
 arr[current]=res;
 return res;
 }
 }
 */