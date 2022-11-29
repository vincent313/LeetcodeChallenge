package TopLikedQuestion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Implement the RandomizedSet class:
 *
 * RandomizedSet() Initializes the RandomizedSet object.
 * bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
 * bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
 * int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.
 * You must implement the functions of the class such that each function works in average O(1) time complexity.
*/
public class InsertDeleteGetRandomO1 {
}
/**
 *  1.Some data structure insert timeO(1)
 *    HashSet,HashMap,ArrayList
 *  2.HashSet Hashmap has insert and delete time O(1),but get random is O(N)-> get random number then get random element
 *  4.ArrayList get random O(1),but find the value and delete time O(n)
 *  5.HashMap Key-> input value ;
 *    HashMap Value-> index of ArrayList;
 *    HashMap for insert and delete value,ArrayList use for get random value
 * */
class RandomizedSet {

	int size;
	ArrayList<Integer> arr;
	Map<Integer,Integer> map;
	public RandomizedSet() {
		this.size=0;
		arr=new ArrayList<Integer>();
		map=new HashMap<Integer,Integer>();
	}

	public boolean insert(int val) {
		if (map.get(val)==null){
			map.put(val,size);
			arr.add(val);
			size++;
			return true;
		}
		return false;
	}

	public boolean remove(int val) {
		if(map.get(val)==null){
			return false;
		}

		int index=map.get(val);
		map.remove(val);
		if  (index==(size-1))
		{   arr.remove(index);
			size--;
		}else{
			arr.set(index,arr.get(size-1));
			map.put(arr.get(size-1),index);
			arr.remove(size-1);

			size--;
		}
		return true;
	}

	public int getRandom() {
		if(size==0){
			return 0;
		}
		int i;
		if(size==1){
			i=0;
		}else{
			Random r=new Random();
			i=r.nextInt(size);
		}
		return arr.get(i);
	}
}
