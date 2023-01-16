package TopLikedQuestion;
/**
 * 200. Number of Islands
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 *
 *
 * Example 1:
 *
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
 * Example 2:
 *
 * Input: grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * Output: 3
 *  */
public class NumberofIslands {
	int [][] memo;
	int row;
	int column;
	public int numIslands(char[][] grid) {
		int result=0;
		memo=new int[grid.length][grid[0].length];
		row=grid.length-1;
		column=grid[0].length-1;
		System.out.println(row);
		System.out.println(column);
		for(int i=0;i<=row;i++){
			for(int j=0;j<=column;j++){
				if(grid[i][j]=='1'&&memo[i][j]==0){
					result++;
					isPartOfLand(grid,i,j);
				}
			}
		}
		return result;
	}

	private void isPartOfLand(char[][] grid,int rowIndex,int columnIndex){
		if(rowIndex<0||columnIndex<0||rowIndex>row||columnIndex>column){return;}
		if(grid[rowIndex][columnIndex]=='0'){return;}
		if(memo[rowIndex][columnIndex]==1){return;}
		memo[rowIndex][columnIndex]=1;
		isPartOfLand(grid,rowIndex+1,columnIndex);
		isPartOfLand(grid,rowIndex-1,columnIndex);
		isPartOfLand(grid,rowIndex,columnIndex+1);
		isPartOfLand(grid,rowIndex,columnIndex-1);
	}
}
