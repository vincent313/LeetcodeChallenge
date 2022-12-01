package TopLikedQuestion;

import java.util.ArrayList;
import java.util.List;
/** 118. Pascal's Triangle
 * 1. First row alway 1, and second row always 1, 1. If numrows is 1 or 2, return.
 * 2. From 3th row, row element need to caculate (numrows-2) times. 3->1, 4->2, 5->3 ....
 * 3. Get previous array, current array need to caculate current[1]... current[i-2](current[j])
 * 4. current[1]=previous[j]+prevuous[j-1]
 * 5. add current in to result list*/
public class PascalsTriangle {
	public List<List<Integer>> generate(int numRows) {
		ArrayList<List<Integer>> result=new ArrayList<List<Integer>>();


		for(int i=1;i<=numRows;i++){
			ArrayList<Integer> element=new ArrayList<Integer>();
			if(i==1){
				element.add(1);
				result.add(element);
				continue;}
			if(i==2){
				element.add(1);
				element.add(1);
				result.add(element);
				continue;
			}

			element.add(1);
			for(int j=1;j<=(i-2);j++){
				List<Integer> previous=result.get(i-2);
				element.add(previous.get(j-1)+previous.get(j));
			}
			element.add(1);
			result.add(element);
		}

		return result;
	}
}
