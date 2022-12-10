package TopLikedQuestion;
/**
 * 45. Jump Game II
 * Medium

 * You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
 *
 * Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:
 *
 * 0 <= j <= nums[i] and
 * i + j < n
 * Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].
 *
 *Example 1:
 *
 * Input: nums = [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 *
 * Input: nums = [2,3,0,1,4]
 * Output: 2
 * */
import java.util.Stack;

public class JumpGame2 {
	public static void main(String[] args) {
		JumpGame2 jg=new JumpGame2();
		int[] test={2,3,0,1,4};
		int result= jg.BottomUp(test);
		System.out.println(result);
	}

	// my owm solution, 55ms-70ms
	public int BottomUp(int[] nums) {
		Stack<Integer> stack=new Stack<Integer>();
		int targetIndex=nums.length-1;
		stack.push(targetIndex);
		for(int currentIndex=targetIndex-1;currentIndex>=0;currentIndex--){
			int previousIndex;
			if(currentIndex+nums[currentIndex]<stack.peek())
			{
				continue;
			}

			while(stack.peek()!=targetIndex){
				previousIndex=stack.pop();
				if(currentIndex+nums[currentIndex]<stack.peek()){
					stack.push(previousIndex);
					stack.push(currentIndex);
					break;
				}
			}

			if(stack.peek()==targetIndex){stack.push(currentIndex);};
		}
		return stack.size()-1;
	}

	//someone solution,1-3ms
	public int TopToBottom(int[] nums) {
		int maxLength=nums.length-1;
		int currEnd=0;
		int nextEnd=0;
		int step=0;
		//top to bottom
		for(int i=0;i<maxLength;i++){
//current end为0,nextEnd就是从i开始,到current end结束时候,第二步可以到达的最大的地方,这个数字一直更新,直到到达current为止
			nextEnd=Math.max(nextEnd,nums[i]+i);

			//如果i到达currend了,那就说明上一步的最近点到最远点,可以到达的所有地方的最高的下一步已经存为nextEnd了
			//这就说明步数要增加了,并且把currend设置为nextend,下一轮接着遍历,到达currend之前可以到的最远的距离
			if(i==currEnd){
				step++;
				currEnd=nextEnd;
			}
		}
		return step;
	}
}
