package TopLikedQuestion;

import java.util.ArrayList;
import java.util.List;
/**
 * 54. Spiral Matrix
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 * */
public class SpiralMatrix {
	List<Integer> result=new ArrayList<Integer>();
	public List<Integer> spiralOrder(int[][] matrix) {
		int[] m={0,matrix.length-1};
		int[] n={0,matrix[0].length-1};
		recursion(matrix,m,n,1);
		return result;
	}

	private void recursion(int[][] matrix,int[] m,int[] n,int direction){

		while(true){
			if (direction==1){
				for(int i=n[0];i<=n[1];i++){
					result.add(matrix[m[0]][i]);
				}
				m[0]++;
				if(m[0]>m[1]){break;}
				direction=2;
			}else if(direction==2){
				for(int i=m[0];i<=m[1];i++){
					result.add(matrix[i][n[1]]);
				}
				n[1]--;
				if(n[0]>n[1]){break;}
				direction=3;
			}else if(direction==3){
				for(int i=n[1];i>=n[0];i--){
					result.add(matrix[m[1]][i]);
				}
				m[1]--;
				if(m[1]<m[0]){break;}
				direction=4;
			}else{
				for(int i=m[1];i>=m[0];i--){
					result.add(matrix[i][n[0]]);
				}
				n[0]++;
				if(n[0]>n[1]){break;}
				direction=1;
			}
		}


		//direction: 1:left->right 2:up->bottom 3:right->left 4.bottom->up

	}
}
