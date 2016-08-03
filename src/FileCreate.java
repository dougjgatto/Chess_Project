import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class FileCreate {
	private int row;
	private int col;
	private int temp;
	Board board = new Board();
	File inputFile = new File("C:\\dev\\Chess\\Lab01.txt");
	FileInputStream inputfile;
	
	public void MakeInputStream(){
		try{
			inputfile = new FileInputStream(inputFile);
		}
		catch(IOException e){
			System.out.println("input stream isn't working");
		}
	}
	
	public FileInputStream getInputStreams1(){
		return inputfile;
	}
	
	public void processPage(InputStream in){
		String movePattern = "\\s*[a-h][1-8]\\s[a-h][1-8]\\**\\s*";
		String placePattern = "\\s*[A-Z&&[KNQPBR]][ld][a-h][1-8]";
		String DoubmovePattern = "\\s*[a-h][1-8]\\s[a-h][1-8]\\s[a-h][1-8]\\s[a-h][1-8]";
		
		
	    BufferedReader buffReader = new BufferedReader(new InputStreamReader(in));
	    String temp;
	    Pattern p1 = Pattern.compile(movePattern);
	    Pattern p2 = Pattern.compile(placePattern);
	    Pattern p3 = Pattern.compile(DoubmovePattern);
	        try {
	        	
				while((temp = buffReader.readLine()) != null)
				{
					boolean movechk = true;
					Matcher m3 = p3.matcher(temp);
					boolean match3 = m3.find();
					//double move here
					if(match3 && movechk){
						DoubleMovePiece(temp);
						movechk = false;
					}
					
					Matcher m1 = p1.matcher(temp);
					boolean match1 = m1.find();
					//move piece here
					//and take piece here
					if(match1 && movechk){
						MovePiece(temp);
						movechk = false;
					}
					Matcher m2 = p2.matcher(temp);
					boolean match2 = m2.find();
					//place piece here
					if(match2){
						PlacePiece(temp);					
					}
					
					else{
						//System.out.println("Command not valid.");
					}
				}
	        } 
	        catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public void PlacePiece(String place){
			String placed = "";
			place = place.trim();
			switch(place.charAt(1)){
			case 'l':
				placed += "White ";
				temp = 4;
				break;
			case 'd':
				placed += "Black ";
				temp = 2;
				break;
			default:
				break;
			}
			switch(place.charAt(0)){
			case 'K':
				placed += "King ";
				break;
			case 'Q':
				placed += "Queen ";
				break;
			case 'B':
				placed += "Bishop ";
				break;
			case 'R':
				placed += "Rook ";
				break;
			case 'N':
				placed += "Knight ";
				break;
			case 'P':
				placed += "Pawn ";
				break;
			default:
				System.out.println("");
				break;
			}
//			char piece; 
//			if(temp > 3){
//				piece = Character.toLowerCase(place.charAt(0));
//			}
//			else if(temp < 3){
//				piece = Character.toUpperCase(place.charAt(0));
//			}
			
			//board.PlacePiece(letter, number, piece);
			System.out.print("placed at " + place.charAt(2) + place.charAt(3) + "\n");
			
	}
	
	public void MovePiece(String move){
		move = move.trim();
		System.out.println("Moved piece from " + move.charAt(0) + move.charAt(1) + " to " + move.charAt(3) + move.charAt(4));
		if(move.contains("*")){
			System.out.println("Captured piece that was on " + move.charAt(3) + move.charAt(4));
		}
		
	}
	public void DoubleMovePiece(String dMove){
		dMove = dMove.trim();
		System.out.println("Moved piece from " + dMove.charAt(0) + dMove.charAt(1) + " to " + dMove.charAt(3) + dMove.charAt(4) + " and the piece at " + dMove.charAt(6) + dMove.charAt(7) +" moved to " + dMove.charAt(9) + dMove.charAt(10));
	}
	
public static void main(String[] args) {
		FileCreate fl = new FileCreate();
		//need the file here
		fl.MakeInputStream();
		fl.processPage(fl.inputfile);
		//Board board = new Board();
		//board.Displayboard();
	}
}
