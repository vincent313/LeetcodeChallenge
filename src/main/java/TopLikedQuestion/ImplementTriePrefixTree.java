package TopLikedQuestion;

import java.util.HashMap;
import java.util.HashSet;
/**
 * 208. Implement Trie (Prefix Tree)
 * A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.
 *
 * Implement the Trie class:
 *
 * Trie() Initializes the trie object.
 * void insert(String word) Inserts the string word into the trie.
 * boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
 * boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
 *
 *
 * Example 1:
 *
 * Input
 * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
 * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 * Output
 * [null, null, true, false, true, null, true]
 *
 * Explanation
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // return True
 * trie.search("app");     // return False
 * trie.startsWith("app"); // return True
 * trie.insert("app");
 * trie.search("app");     // return True
 * */
public class ImplementTriePrefixTree {
	class TrieNode{
		HashMap<Character,TrieNode> hashMap=new HashMap<>();
		boolean getStartWith(String str,int lastIndex,int index){
			if(index>lastIndex){return true;}
			char target=str.charAt(index);
			if(!hashMap.containsKey(target)){
				return false;
			}
			return hashMap.get(target).getStartWith(str,lastIndex,index+1);
		}

		void insertWord(String str,int lastIndex,int index){

			if(index>lastIndex){return;}
			char c=str.charAt(index);
			if(!hashMap.containsKey(c)){
				hashMap.put(c,new TrieNode());

			}
			hashMap.get(c).insertWord(str,lastIndex,index+1);
		}
	}

	TrieNode node;
	HashSet<String> hashset;
	public ImplementTriePrefixTree() {
		this.node=new TrieNode();
		this.hashset=new HashSet<>();
	}

	public void insert(String word) {
		if(hashset.contains(word)){return;}
		hashset.add(word);
		node.insertWord(word,word.length()-1,0);
	}

	public boolean search(String word) {
		if(hashset.contains(word)){return true;}
		return false;
	}

	public boolean startsWith(String prefix) {
		return node.getStartWith(prefix,prefix.length()-1,0);
	}
}
