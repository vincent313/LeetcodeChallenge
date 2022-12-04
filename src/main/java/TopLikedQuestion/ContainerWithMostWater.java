package TopLikedQuestion;
/**
 * 11. Container With Most Water
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 *
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 *
 * Return the maximum amount of water a container can store.
 *
 * Notice that you may not slant the container.
 * */
public class ContainerWithMostWater {
	public static void main(String[] args) {
		int[] ix={1,8,6,2,5,4,8,3,7};
		System.out.println(maxArea(ix));
	}
	public static int maxArea(int[] height) {
		int size=height.length;
		int max=0;
		int left=0;
		int right=size-1;
		int currentHigh=0;
		while(right>left){
			if(height[left]>=height[right]){
				int temp=height[right]*(right-left);
				if(temp>max){max=temp;}
				right--;
				continue;
			}

			int temp=height[left]*(right-left);
			if(temp>max){max=temp;}
			left++;
			continue;

		}
		return max;
	}
}
