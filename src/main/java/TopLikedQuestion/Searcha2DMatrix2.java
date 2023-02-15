package TopLikedQuestion;
/**
 * 240. Search a 2D Matrix II

 * Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:
 *
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 * Output: true
 * Example 2:
 *
 *
 * Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
 * Output: false
 *
 *
 * Constraints:
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= n, m <= 300
 * -109 <= matrix[i][j] <= 109
 * All the integers in each row are sorted in ascending order.
 * All the integers in each column are sorted in ascending order.
 * -109 <= target <= 109
 * */
public class Searcha2DMatrix2 {

	public boolean searchMatrix(int[][] matrix, int target) {
		int rowStart=0;
		int rowEnd=matrix.length-1;
		int columnStart=0;
		int columnEnd=matrix[0].length-1;
		return recursive(rowStart,rowEnd,columnStart,columnEnd,matrix,target);
	}

	public boolean recursive(int rowStart,int rowEnd,int columnStart,int columnEnd,int[][] matrix,int target){
		int currRowStart=rowStart;
		int currRowEnd=rowEnd;
		int currColumStart=columnStart;
		int currColumnEnd=columnEnd;
		for(int i=currRowStart;i<=currRowEnd;i++){
			if(matrix[i][currColumnEnd]<target){
				currRowStart++;
			}else{
				break;
			}
		}
		for(int i=currRowEnd;i>=currRowStart;i--){
			if(matrix[i][currColumStart]>target){
				currRowEnd--;
			}else if(matrix[i][currColumStart]==target){
				return true;
			}else{
				break;
			}
		}

		if(currRowEnd<currRowStart){return false;}

		for(int i=currColumStart;i<=currColumnEnd;i++){
			if(matrix[currRowEnd][i]<target){
				currColumStart++;
			}else if(matrix[currRowEnd][i]==target){
				return true;
			}
			else{
				break;
			}
		}

		for(int i=currColumnEnd;i>=currColumStart;i--){
			if(matrix[currRowStart][i]>target){
				currColumnEnd--;
			}else if(matrix[currRowStart][i]==target){
				return true;
			}else{
				break;
			}
		}

		if(currColumnEnd<currColumStart){
			return false;
		}

		return recursive(currRowStart,currRowEnd,currColumStart,currColumnEnd,matrix,target);
	}
}
