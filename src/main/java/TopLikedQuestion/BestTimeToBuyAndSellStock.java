package TopLikedQuestion;

import java.util.Stack;

/**
 * 121. Best Time to Buy and Sell Stock
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 *
 *  */

class BestTimeToBuyAndSellStock {

	public  int maxProfit(int[] prices) {
		int min=prices[0];
		int maxProfit=0;
		for(int i:prices){
			if(i<min){
				min=i;
			}
			if(i-min>maxProfit){
				maxProfit=(i-min);
			}
		}
		return maxProfit;
	}
}