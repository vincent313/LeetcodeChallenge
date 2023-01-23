package TopLikedQuestion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
/**
 * 207. Course Schedule

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
 *
 *
 * Constraints:
 *
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= 5000
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * All the pairs prerequisites[i] are unique.*/

public class CourseScheduleBFS {

	private class Node{
		int val;
		int status;
		int in;
		//0:not visted 1:on progress 2:finished
		ArrayList<Node> nextCourse=new ArrayList<>();
		Node(int val){
			this.val=val;
			this.status=0;
			this.in=0;
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

			postCourse.in++;

			if(!map.containsKey(course[1])){
				preCourse=new Node(course[1]);
				map.put(course[1],preCourse);
			}else{
				preCourse=map.get(course[1]);
			}

			preCourse.nextCourse.add(postCourse);
		}

		LinkedList<Node> list=new LinkedList<>();
		for(Node n:map.values()){
			if(n.in==0){
				list.offer(n);
			}
		}

		int count=0;
		while(!list.isEmpty()){
			count++;
			Node temp=list.poll();
			System.out.println(temp.val);
			if(temp.nextCourse.size()!=0){
				for(Node n:temp.nextCourse){
					n.in--;
					if(n.in==0){
						list.offer(n);
					}
				}
			}
		}

		if(count==map.size()){return true;}
		return false;

	}
}
