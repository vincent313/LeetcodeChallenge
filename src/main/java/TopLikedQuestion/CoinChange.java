package TopLikedQuestion;

import java.util.HashMap;

/**
 * 322. Coin Change
 * Medium
 * 15.4K
 * 358
 * company
 * TikTok
 * company
 * Amazon
 * company
 * Bloomberg
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 *
 * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * You may assume that you have an infinite number of each kind of coin.
 *
 *
 *
 * Example 1:
 *
 * Input: coins = [1,2,5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 *
 * Input: coins = [2], amount = 3
 * Output: -1
 * Example 3:
 *
 * Input: coins = [1], amount = 0
 * Output: 0
 *
 *
 * Constraints:
 *
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 * */
public class CoinChange {
	public int coinChange(int[] coins, int amount) {
		if(amount==0){return 0;}
		int[] memo=new int[amount+1];
		return recursive(coins,memo,amount);

	}

	private int recursive(int[] coins,int[] memo,int amount){
		if(memo[amount]!=0){
			return memo[amount];
		}
		int min=-1;
		for(int i:coins){
			if(amount==i){
				memo[amount]=1;
				return 1;
			}
			if(amount>i){
				int temp=recursive(coins,memo,amount-i);
				if(temp!=-1){
					if(min==-1){
						min=temp;
					};
					if(temp<min){
						min=temp;
					}
				}
			}

		}


		if(min!=-1){
			memo[amount]=min+1;
			return min+1;
		}
		else{
			memo[amount]=-1;
			return -1;}
	}
}
