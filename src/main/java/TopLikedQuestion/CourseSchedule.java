package TopLikedQuestion;

import java.util.ArrayList;
import java.util.HashMap;
/**
 * 207. Course Schedule
 * Medium
 * 12.5K
 * 484
 * company
 * Amazon
 * company
 * Google
 * company
 * Facebook
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 *
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 *
 *
 *
 * Example 1:
 *
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 * Example 2:
 *
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 *  */
public class CourseSchedule {
	private class Node{
		int val;
		int status;
		//0:not visted 1:on progress 2:finished
		ArrayList<Node> nextCourse=new ArrayList<>();
		Node(int val){
			this.val=val;
			this.status=0;
		}
	}
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		HashMap<Integer,Node> map=new HashMap<>();
		for(int[] course:prerequisites){
			Node preCourse;
			Node postCourse;
			if(!map.containsKey(course[0])){
				postCourse=new Node(course[0]);
				map.put(course[0],postCourse);
			}else{
				postCourse=map.get(course[0]);
			}

			if(!map.containsKey(course[1])){
				preCourse=new Node(course[1]);
				map.put(course[1],preCourse);
			}else{
				preCourse=map.get(course[1]);
			}

			preCourse.nextCourse.add(postCourse);
		}

		for(Node n:map.values()){
			if(n.status==0){
				boolean flag=dfsTraverse(n);
				if (!flag){
					return false;
				}
			}
		}

		return true;

	}

	private boolean dfsTraverse(Node node){
		node.status=1;
		if(node.nextCourse.size()==0){
			node.status=2;
			return true;
		}

		for(Node n:node.nextCourse){

			if(n.status==1){
				return false;
			}
			if(n.status==0){
				if(!dfsTraverse(n)){
					return false;

				};
			}
		}
		node.status=2;
		return true;
	}
}
