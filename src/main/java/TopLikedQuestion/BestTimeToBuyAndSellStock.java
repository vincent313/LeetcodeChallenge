package TopLikedQuestion;

import java.util.ArrayList;
import java.util.List;

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

	/**
	 * 119. Pascal's Triangle II
	 *
	 * Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
	 *
	 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
	 * */
	public static class PascalsTriangle2 {
		public List<Integer> getRow(int rowIndex) {
			ArrayList<Integer> result=new ArrayList<Integer>();
			ArrayList<Integer> temp=new ArrayList<Integer>();
			for(int i=1;i<=rowIndex+1;i++){
				result=new ArrayList<Integer>();
				if(i==1){
					result.add(1);
					continue;}
				if(i==2){
					result.add(1);
					result.add(1);
					temp=result;
					continue;
				}
				result.add(1);
				for(int j=1;j<=(i-2);j++){
					result.add(temp.get(j-1)+temp.get(j));

				}
				result.add(1);
				temp=result;
			}

			return result;
		}
	}
}