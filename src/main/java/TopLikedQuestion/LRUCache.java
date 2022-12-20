package TopLikedQuestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU Cache

 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 *
 * Implement the LRUCache class:
 *
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 * The functions get and put must each run in O(1) average time complexity.
 *
 *
 * */
public class LRUCache {

	public static void main(String[] args) {
		ArrayList<DLinkedNode> test=new ArrayList<>();
		Arrays.sort(test.toArray());
	}
	class DLinkedNode {
		int key;
		int value;
		DLinkedNode prev;
		DLinkedNode next;
	}

	private void addNode(DLinkedNode node) {
		/**
		 * Always add the new node right after head.
		 */
		node.prev = head;
		node.next = head.next;

		head.next.prev = node;
		head.next = node;
	}

	private void removeNode(DLinkedNode node){
		/**
		 * Remove an existing node from the linked list.
		 */
		DLinkedNode prev = node.prev;
		DLinkedNode next = node.next;

		prev.next = next;
		next.prev = prev;
	}

	private void moveToHead(DLinkedNode node){
		/**
		 * Move certain node in between to the head.
		 */
		removeNode(node);
		addNode(node);
	}

	private DLinkedNode popTail() {
		/**
		 * Pop the current tail.
		 */
		DLinkedNode res = tail.prev;
		removeNode(res);
		return res;
	}

	private Map<Integer, DLinkedNode> cache = new HashMap<>();
	private int size;
	private int capacity;
	private DLinkedNode head, tail;

	public LRUCache(int capacity) {
		this.size = 0;
		this.capacity = capacity;

		head = new DLinkedNode();
		// head.prev = null;

		tail = new DLinkedNode();
		// tail.next = null;

		head.next = tail;
		tail.prev = head;
	}

	public int get(int key) {
		DLinkedNode node = cache.get(key);
		if (node == null) return -1;

		// move the accessed node to the head;
		moveToHead(node);

		return node.value;
	}

	public void put(int key, int value) {
		DLinkedNode node = cache.get(key);

		if(node == null) {
			DLinkedNode newNode = new DLinkedNode();
			newNode.key = key;
			newNode.value = value;

			cache.put(key, newNode);
			addNode(newNode);

			++size;

			if(size > capacity) {
				// pop the tail
				DLinkedNode tail = popTail();
				cache.remove(tail.key);
				--size;
			}
		} else {
			// update the value.
			node.value = value;
			moveToHead(node);
		}
	}
}
