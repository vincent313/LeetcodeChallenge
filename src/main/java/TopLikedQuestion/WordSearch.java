package TopLikedQuestion;
/**
 * 79. Word Search

 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 *
 *
 * Example 1:
 * */
public class WordSearch {
	public static void main(String[] args) {
		WordSearch ws=new WordSearch();
		char [][] test={{'C','A','A'},{'A','A','A'},{'B','C','D'}};
		System.out.println(ws.exist(test,"AAB"));
	}
	boolean [][] set;
	public boolean exist(char[][] board, String word) {
		set=new boolean[board.length][board[0].length];
		//循环遍历
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[0].length;j++){
				if(board[i][j]==word.charAt(0)){
					if(wordSearch(board,word,0,i,j)){return true;}
					set[i][j]=false;
				}
			}
		}
		return false;
	}

	private boolean wordSearch(char[][] board,String word,int index,int i,int j){
		set[i][j]=true;
		if(index==word.length()-1){return true;}
		char target=word.charAt(index+1);

		if(i!=0){
			if(board[i-1][j]==target&&set[i-1][j]==false){
				if(wordSearch(board,word,index+1,i-1,j)){
					return true;
				}
				set[i-1][j]=false;
			}
		}

		if(i!=board.length-1){
			if(board[i+1][j]==target&&set[i+1][j]==false){
				if(wordSearch(board,word,index+1,i+1,j)){
					return true;
				}
				set[i+1][j]=false;
			}
		}

		if(j!=0){
			if(board[i][j-1]==target&&set[i][j-1]==false){
				if(wordSearch(board,word,index+1,i,j-1)){
					return true;
				}
				set[i][j-1]=false;
			}
		}

		if(j!=board[0].length-1){
			if(board[i][j+1]==target&&set[i][j+1]==false){
				if(wordSearch(board,word,index+1,i,j+1)){
					return true;
				}
				set[i][j+1]=false;
			}
		}

		return false;

	}

}
