package TopLikedQuestion;

import java.util.ArrayList;
import java.util.HashSet;
/**
 * 73. Set Matrix Zeroes

 * Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
 *
 * You must do it in place.
 * */
public class SetMatrixZeroes {
	public void setZeroes(int[][] matrix) {
		HashSet<Integer> rowSet=new HashSet<Integer>();
		HashSet<Integer> columnSet=new HashSet<Integer>();
		int rowSize=matrix.length;
		int columnSize=matrix[0].length;
		for(int i=0;i<rowSize;i++){
			for(int j=0;j<columnSize;j++){
				if(matrix[i][j]==0){
					rowSet.add(i);
					columnSet.add(j);
				}
			}
		}

		for(int i:rowSet){
			for(int j=0;j<columnSize;j++){
				matrix[i][j]=0;
			}
		}

		for(int i:columnSet){
			for(int j=0;j<rowSize;j++){
				matrix[j][i]=0;
			}
		}

	}
}
