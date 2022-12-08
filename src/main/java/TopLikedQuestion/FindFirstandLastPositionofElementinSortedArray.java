package TopLikedQuestion;
/**34. Find First and Last Position of Element in Sorted Array

 Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

 If target is not found in the array, return [-1, -1].

 You must write an algorithm with O(log n) runtime complexity.


 * */
public class FindFirstandLastPositionofElementinSortedArray {
	int[] result=new int[2];
	boolean isFirstLoop=true;
	public int[] searchRange(int[] nums, int target) {
		result[0]=-1;
		result[1]=-1;
		if(nums==null||nums.length==0){return result;}
		getElement(0,nums.length-1,nums,target);
		return result;
	}

	public int getElement(int left,int right,int[] nums,int target){
		boolean isHigh=true;
		if(left==0){isHigh=false;}
		int mid=0;
		while(right>=left){
			mid=(left+right)/2;
			if(nums[mid]==target){
				break;
			}
			if(nums[mid]<target){
				left=mid+1;
			}else{
				right=mid-1;
			}
		}
		if (nums[mid]!=target){
			return -1;
		}


		if(isFirstLoop){
			isFirstLoop=false;
			result[0]=mid;
			result[1]=mid;
			int lowIndex=-1;
			int highIndex=-1;
			if(mid!=0){lowIndex=getElement(0,mid-1,nums,target);}
			if(mid!=nums.length-1){highIndex=getElement(mid+1,nums.length-1,nums,target);}
			if(lowIndex!=-1){result[0]=lowIndex;}
			if(highIndex!=-1){result[1]=highIndex;}
			return -1;
		}

		if(isHigh){
			if(mid==nums.length-1){return mid;}
			int temp=getElement(mid+1,nums.length-1,nums,target);
			if (temp==-1){return mid;}
			return temp;
		}else{
			if(mid==0){return mid;}
			int temp=getElement(0,mid-1,nums,target);
			if(temp==-1){return mid;}
			return temp;
		}
	}
}
