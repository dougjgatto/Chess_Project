public class Board {
char[][] board = new char [9][9];
private final int MaxRow = 9;
private final int Maxcol = 9;

public Board() {
	for (int row = 0; row < MaxRow; row++){
		for(int col = 0; col < Maxcol; col++){
			board[row][col] = ' ';
		}
	}
}

public char[][] getBoard() {
	return board;
	
}
public char None(){
	
	return None();
}
public int PlacePiece(int letter, int number, char piece){
	if(board[letter][number] == ' '){
		board[letter][number] = piece;
		int fuckmeharder = 0;
		return fuckmeharder;
}
	else{
		System.out.println("Invalid");
		int fuck = 1;
		return fuck;
	}
	
}
public void Displayboard()
{
	int j = 1;
	int fakeRow = MaxRow;
	fakeRow = fakeRow - 1;
	int FakeCol = Maxcol;
	FakeCol = FakeCol - 1;
	System.out.println("   A   B   C   D   E   F   G   H");
	System.out.println(" +---+---+---+---+---+---+---+---+");
	for(int rows  = 0; rows < fakeRow; rows++)
	{
		System.out.print(j++);
		System.out.print("| ");
		for (int col = 0; col < FakeCol; col++)
		{
			System.out.print(getBoard()[rows][col] + " | ");
			
		}	
		
	
		System.out.println();
				
		System.out.println(" +---+---+---+---+---+---+---+---+");
		
	}
}

}
