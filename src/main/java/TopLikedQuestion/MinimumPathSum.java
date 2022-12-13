package TopLikedQuestion;

/**
 * 64. Minimum Path Sum

 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 * */
public class MinimumPathSum {
	int[][] menory;

	public static void main(String[] args) {
		MinimumPathSum mps=new MinimumPathSum();
		//int[][] test={{1,3,1},{1,5,1},{4,2,1}};
				//[[1,3,1],[1,5,1],[4,2,1]]
		int[][] test={{1,2,3},{4,5,6}};
	mps.minPathSum(test);
	mps.printresult();

	}
	public int minPathSum(int[][] grid) {
		if(grid.length==1){
			int n=0;
			for(int i:grid[0]){
				n=n+i;
			}
			return n;
		}else if(grid[0].length==1){
			int n=0;
			for(int[] i:grid){
				n=n+i[0];
			}
			return n;
		}
		menory=new int[grid.length][grid[0].length];
		for(int i=0;i< menory.length;i++){
				for(int j=0;j< menory[0].length;j++){
					menory[i][j]=-1;
				}
		}
		return recursion(grid,0,0);
	}

	private int recursion(int[][] grid,int m,int n){
		if(menory[m][n]!=-1){
			return menory[m][n];
		}
		if(m==grid.length-1){
			int temp=0;
			for(int i=n;i<grid[m].length-1;i++){
				temp=temp+grid[m][i];
			}
			menory[m][n]=temp+grid[grid.length-1][grid[0].length-1];
			return menory[m][n];
		}else if(n==grid[0].length-1){
			int temp=0;
			for(int i=m;i<grid.length-1;i++){
				temp=temp+grid[i][n];
			}
			menory[m][n]=temp+grid[grid.length-1][grid[0].length-1];
			return menory[m][n];
		}

		int temp1=recursion(grid,m+1,n);
		int temp2=recursion(grid,m,n+1);
		int tempRes=Math.min(temp1,temp2);
		menory[m][n]=grid[m][n]+tempRes;
		System.out.println("m:"+m+"  n:"+n+"  value:"+menory[m][n]);
		return menory[m][n];
	}

	public void printresult(){
		for(int i=0;i< menory.length;i++){
			for(int j=0;j< menory[0].length;j++){
				System.out.print(menory[i][j]+" ");
			}
			System.out.println();
		}
	}
}
