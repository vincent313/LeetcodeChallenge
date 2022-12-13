package TopLikedQuestion;
/**
 * 74. Search a 2D Matrix

 * Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:
 *
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 *  */
public class Searcha2DMatrix {
	int matrixRowSize;
	int matrixColumnSize;
	public boolean searchMatrix(int[][] matrix, int target) {
		matrixRowSize=matrix.length;
		matrixColumnSize=matrix[0].length;
		if(target<matrix[0][0]||target>matrix[matrixRowSize-1][matrixColumnSize-1]){return false;}
		int row=searchRow(matrix,0,matrix.length-1,target);
		if(row==-1){return false;}
		return searchInRow(matrix[row],0,matrixColumnSize-1,target);

	}

	private int searchRow(int[][] matrix,int up,int down,int target){
		if(up==down){return up;}
		int mid=(up+down)/2;
		if(target>matrix[mid][matrixColumnSize-1]){
			return searchRow(matrix,mid+1,down,target);
		}else if(target<matrix[mid][0]){
			return searchRow(matrix,up,mid,target);
		}else{
			return mid;
		}

	}

	private boolean searchInRow(int[] row,int left,int right,int target){

		if(target<row[left]||target>row[right]){
			return false;
		}
		int mid=(left+right)/2;
		if(row[mid]==target){return true;}
		if(target>row[mid]){
			return searchInRow(row,mid+1,right,target);
		}else{
			return searchInRow(row,left,mid-1,target);

		}

	}
}
