package battleship;
import java.io.PrintWriter;
import java.security.SecureRandom;
import java.util.Scanner;

/**
 * @author abhip
 * The Model class represents the game model and contains the game logic.It manages the game boards, ship placement, player moves, and game status.
 * The model interacts with the graphical interface to update the views and receive user inputs.
 * It provides methods to control the game flow and retrieve game information.
 * The Model class includes methods for placing ships, selecting positions, starting and stopping the game,
   and accessing the game boards and statistics.
 * The model also supports the design mode, where the player can manually place ships on the board,
   and the play mode, where the player can play against the computer.


 *
 */
public class Model {
	private SecureRandom random=new SecureRandom();
	private int dimension;
	private int board;
	
	private char playerShips[][];
	private int[] shipsToPlace;
	private char computerShips[][];
	private char computerSolution[][];
	private char savePlayerBoard[][];
	private GraphicalInterface window;
	private int totalShips;
	private int playerShipsHit;
	private int computerShipsHit;
	private boolean design;
	private boolean readyToPlay;
	private int playerSquare;
	private int seconds;
	
	private int compSquare;
	private boolean playing;
	
	
	/**
	 *Constructs a Model object with the specified dimension.
     *Initializes the game boards, ships, and random generator.
	 * @param dimension The dimension of the game board.
	 */
	public Model(int dimension)
	
	{
		
		readyToPlay=false;
		random.reseed();
		
		newGame(dimension);
		
		
		shipsToPlace=new int [dimension];
		for(int i=dimension-1,j=1;i>=0;i--,j++)
		{
			shipsToPlace[i]=j;
		}
		for(int i=0;i<dimension;i++)
		{
			System.out.println("Ship length "+(i+1)+"  shipstoPlace "+shipsToPlace[i]);
		}
		initializeBoard(playerShips);
		System.out.println("Hyy"+ isSpace(0,0,3,true));
		savePlayerBoard=new char [board][board];
		copyBoard(savePlayerBoard,playerShips);
		
		
		
		

		
	}
/**
 * Constructs a Model object with the specified dimension and graphical interface.
 * Initializes the game boards, ships, random generator, and graphical interface.
 * @param dimension The dimension of the game board.
 * @param window The graphical interface associated with the model.
 */
public Model(int dimension,GraphicalInterface window)
	
	{
		this(dimension);
		this.window=window;
		
		

		
	}
/**
 * Retrieves the score of the computer player.
 * The score is calculated based on the number of hits on the player's ships
 * @return The score of the computer player.
 */
public double getScore()
{
	if(compSquare==0)
	{
		return 0;
	}
	return computerShipsHit*computerShipsHit*100.0/compSquare;
}
/**
 * Getter when user press Play button.
 * @return boolean 
 */
public boolean getReadyToPlay()
{
	return readyToPlay;
	}
/**
 * Setter when user press play button.
 * @param readyToPlay boolean for readyToPlay.
 */
public void setReadyToPlay(boolean readyToPlay)
{
	this.readyToPlay=readyToPlay;
	if(readyToPlay)
	{
		savePlayerBoard=new char [board][board];
		copyBoard(savePlayerBoard,playerShips);
	}
	}
/**
 * This method will execute when user press design and they want to place the ships manually.
 * @param x row of the board.
 * @param y column of the board.
 * @param length length of the ships.
 * @param vertical Vertical position of the ships.
 * @return space to place the ship.
 */
public boolean placeShips(int x,int y,int length,boolean vertical)
{
	if(shipsToPlace[length-1]<=0)
	{
		return false;
	}
	boolean space=isSpace(x,y,length,vertical);
	System.out.println("Space "+space);
	if(space)
	{
		int xPlus,yPlus;
		if(vertical)
		{
			xPlus=0;
			yPlus=1;		
		}
		else {
			xPlus=1;
			yPlus=0;
		}
		for(int i=0;i<length;i++)
		{
			playerShips[x][y]='*';
			x+=xPlus;
			y+=yPlus;
		}
		shipsToPlace[length-1]--;
		if(shipsToPlace[length-1]<=0)
		{
			window.allShipsPlaced();
		}
		window.drawPlayerBoard();
	}
	
	return space;
}
/**
 * Checks if there is enough space on the game board to place a ship of the given length.
 *
 * @param x        The x-coordinate of the starting position.
 * @param y        The y-coordinate of the starting position.
 * @param length   The length of the ship.
 * @param vertical A boolean value indicating if the ship is placed vertically or horizontally.
 * @return {@code true} if there is enough space to place the ship, {@code false} otherwise.
 */
private boolean isSpace(int x,int y,int length,boolean vertical)
{
	int xPlus,yPlus;
	System.out.println("Hello "+board);
	if(vertical)
	{
		if(y+length-1>=board)
		{
			return false;
		}
		xPlus=0;
		yPlus=1;
		
	}
	else {
		if(x+length-1>=board)
		{
			return false;
		}
		xPlus=1;
		yPlus=0;
		
	}
	int currentX=x;
	int currentY=y;
	for(int i=0;i<length;i++)
	{
		if(playerShips[currentX][currentY]!='_')
		{
			return false;
		}
		currentX+=xPlus;
		currentY+=yPlus;
	}
	return true;
	
}
/**
 * Retrieves the playing status of the game.
 *
 * @return {@code true} if the game is currently being played, {@code false} otherwise.
 */
public boolean getPlaying() {
	// TODO Auto-generated method stub
	
	return playing;
}
/**
 * Starts the game by setting the playing status to {@code true}.
 */
public void startGame()
{
	playing=true;
	computerSolution=new char[board][board];
	copyBoard(computerSolution,computerShips);
	savePlayerBoard=new char [board][board];
	copyBoard(savePlayerBoard,playerShips);
}
/**
 * Stops the game by setting the playing status to {@code false}.
 */
public void stopGame()
{
	playing=false;
}
/**
 * Generates a random move for the computer player.
 *
 * @return An array of size 2 containing the x-coordinate and y-coordinate of the computer's move.
 */
public int[] computerMove()
{
	int x;
	int y;
	do
	{
		x=random.nextInt(board);
		y=random.nextInt(board);
		System.out.println(x+","+y);
		System.out.println(playerShips[x][y]);
	}while(playerShips[x][y]=='@'||playerShips[x][y]=='x');
	
	
	return new int[] {x,y};
}
/**
 * Executes the computer's move by selecting the specified position on the player's board.
 *
 * @param x The x-coordinate of the selected position.
 * @param y The y-coordinate of the selected position.
 */
public void computerMakesMove()
{
	int computerMove[]=computerMove();
	selectPlayer(computerMove[0],computerMove[1]);
}
/**
 * Retrieves the total number of ships in the game.
 *
 * @return The total number of ships.
 */
public int getTotalShips()
{
	return totalShips;
}
/**
 * Retrieves the number of hits on the computer's ships by the player.
 *
 * @return The number of hits on the computer's ships.
 */
public int getComputerShipsHit()
{
	return computerShipsHit;
}
/**
 * Retrieves the number of hits on the player's ships by the computer.
 *
 * @return The number of hits on the player's ships.
 */
public int getPlayerShipsHit()
{
	return playerShipsHit;
}
/**
 * Generates a random player board by placing ships randomly on the game board.
 */
public void randomPlayerBoard()
{
	initializeBoard(playerShips);
	placeShips(playerShips);
	savePlayerBoard=new char [board][board];
	copyBoard(savePlayerBoard,playerShips);
}
/**
 * Initializes the specified board with empty spaces.
 *
 * @param b The board to be initialized.
 */
	public void initializeBoard(char b[][])
	{
		for(int x=0;x<board;x++)
		{
			for(int y=0;y<board;y++)
			{
				b[x][y]='_';
			}
		}
		
	}
	/**
	 * Copies the contents of one board to another.
	 *
	 * @param b The destination board.
	 * @param c The source board.
	 */
	public void copyBoard(char b[][],char c [][])
	{
		for(int x=0;x<board;x++)
		{
			for(int y=0;y<board;y++)
			{
				b[x][y]=c[x][y];
			}
		}
		
	}
	/**
	 * Saves the specified board to a PrintWriter.
	 *
	 * @param b           The board to be saved.
	 * @param printWriter The PrintWriter to write the board to.
	 */
	public void saveBoard(char b[][], PrintWriter printWriter)
	{
		System.out.print(dimension+"Q");
		printWriter.print(dimension+"Q");
		for(int y=0;y<board;y++)
		{
			for(int x=0;x<board;x++)
			{
				System.out.print(b[x][y]);
				printWriter.print(b[x][y]);
			}
			System.out.print("W");
			printWriter.print("W");
		}
		System.out.println();
		printWriter.println();
		
	}
	/**
	 * Loads the game board from the specified Scanner object.
	 *
	 * @param scanner The Scanner object used to read the game board.
	 */
	public void loadBoard(Scanner scanner)
	{
		String text=scanner.nextLine();
		String board1[]=text.split("Q");
		int dimension=Integer.parseInt(board1[0]);
		newGame(dimension);
		String board2[]=board1[1].split("W");
		for(int y=0;y<board;y++)
		{
			for(int x=0;x<board;x++)
			{
				char a=board2[y].charAt(x);
				System.out.print(a);
				playerShips[x][y]=a;
				//printWriter.print(b[x][y]);
				
			}
			System.out.println();
			//printWriter.print("!");
		}
		System.out.println();
		//printWriter.println();
		setReadyToPlay(true);
		
	}
	/**
	 * Starts a new game with the specified dimension.
	 *
	 * @param dimension The dimension of the game board.
	 */
	public void newGame(int dimension)
	{
		this.dimension=dimension;
		board=2*dimension;
		playerShips=new char[board][board];
		computerShips=new char[board][board];
		totalShips=dimension*(dimension+1)*(dimension+2)/6;
		seconds=0;
		
		
		
		initializeBoard(computerShips);
		placeShips(computerShips);
	}
	/**
	 * Saves the player's board to the specified PrintWriter.
	 *
	 * @param printWriter The PrintWriter to write the player's board to.
	 */
	public void savePlayerBoard(PrintWriter printWriter)
	{
		saveBoard(savePlayerBoard,printWriter);
	}
	
	/**
	 * Executes a move on the computer's board at the specified position.
	 *
	 * @param x The x-coordinate of the selected position.
	 * @param y The y-coordinate of the selected position.
	 * @return The result of the move: 0 for a miss, 1 for a hit, 2 for a repeated move.
	 */
	
	public int selectComputer(int x,int y)
	{
		int select=select(computerShips,x,y);
		compSquare++;
		if(select==1)
		{
			computerShipsHit++;
		}
		
		window.selectComputer(x, y);
		
		return select;
			
	}
	/**
	 * Executes a move on the player's board at the specified position.
	 *
	 * @param x The x-coordinate of the selected position.
	 * @param y The y-coordinate of the selected position.
	 * @return The result of the move: 0 for a miss, 1 for a hit, 2 for a repeated move.
	 */
	public int selectPlayer(int x,int y)
	{
		int select=select(playerShips,x,y);
		playerSquare++;
		System.out.println(select);
		if(select==1)
		{
			playerShipsHit++;
			System.out.println(select);
		}
		
		window.selectPlayer(x, y);
		
		return select;
			
	}
	/**
	 * Executes a move on the specified board at the specified position.
	 *
	 * @param b The board on which to execute the move.
	 * @param x The x-coordinate of the selected position.
	 * @param y The y-coordinate of the selected position.
	 * @return The result of the move: 0 for a miss, 1 for a hit, 2 for a repeated move.
	 */
  public  int select(char b[][],int x,int y)
	{
		if(b[x][y]=='x'||b[x][y]=='@')
			
		{
			return 0;
		}
		if(b[x][y]=='*')
		{
			b[x][y]='@';
			return 1;
			
		}
		else {
			b[x][y]='x';
			return 2;
			
		}
	}
  /**
   * Places a ship on the specified board at the specified position with the given length, vertical flag, and direction.
   *
   * @param b        The board on which to place the ship.
   * @param length   The length of the ship.
   * @param x        The x-coordinate of the starting position.
   * @param y        The y-coordinate of the starting position.
   * @param vertical A flag indicating if the ship is placed vertically (1) or horizontally (0).
   * @param direction The direction of the ship placement (0 for left/up, 1 for right/down).
   * @return {@code true} if the ship is successfully placed, {@code false} otherwise.
   */
	private boolean placeShip(char b[][],int length,int x,int y,int vertical,int direction)
	
	{
		int x1=x;
		int y1=y;
		int length1=length;
		
		if(direction==0)
		{
			direction=-1;
			
		}
		for(;;) {
			if(x<0||x>=board)
			   {
				   return false;
			   }
			   if(y<0||y>=board)
			   {
				   return false;
			   }
		   if(b[x][y]!='_')
		   {
			   return false;
		   }
		   
		   if(length<=0)
		   {
			   break;
		   }
		   if(vertical==1)
		   {
			   y+=direction;
		   }
		   else {
			   x+=direction;
			   
		   }
		   length--;
		   System.out.println(x+" "+y);
		}
		
		x=x1;
		y=y1;
		length=length1;
		
		
		for(;;) {

			   if(length<=0)
			   {
				   
				   return true;
			   }
			   b[x][y]='*';
			   length--;
			   
				   
			   
			  
			   if(vertical==1)
			   {
				   y+=direction;
			   }
			   else {
				   x+=direction;
			   }
			}
		
		
		
	}
	/**
	 * Places the ships on the specified board.
	 *
	 * @param b The board on which to place the ships.
	 */
	private void placeShips(char b[][])
	{
		int length=dimension;
		int total=1;
		int created;
		int x;
		int y;
		int vertical;
		int direction;
		
		while(length>0)
		{
		    created=0;
		    
		    while(created<total)
		    {
		    	do {
		    	x=random.nextInt(board);
		    	y=random.nextInt(board);
		    	vertical=random.nextInt(2);
		    	direction=random.nextInt(2);
		    	System.out.println("creating ship of length "+length+" at "+x+","+y);
		    	}while(!placeShip(b,length,x,y,vertical,direction));
		    	System.out.println("created ship of length "+length+" at "+x+","+y);
		    	created++;
		    	System.out.println("Created"+created);
		    	System.out.println("Total"+total);
		    	
		    	
		    	
		    }
		    total++;
		    length--;
		}
	}
	/**
	 * Prints the specified board.
	 *
	 * @param b The board to print.
	 */
	public void printBoard(char b[][])
	{
		for(int y=0;y<board;y++)
		{
			for(int x=0;x<board;x++)
			{
				System.out.print(b[x][y]);
			}
			System.out.println();
		}
	}
	/**
	 * Retrieves the computer's game board.
	 *
	 * @return The computer's game board.
	 */	
	public char[][] getComputerBoard()
	{
		return computerShips;
		
	}
	/**
	 * Retrieves the computer's solution board.
	 *
	 * @return The computer's solution board.
	 */
	public char[][] getComputerSolution()
	{
		return computerSolution;
		
	}
	/**
	 * Retrieves the player's game board.
	 *
	 * @return The player's game board.
	 */
	public char[][] getPlayerBoard()
	{
		return playerShips;
		
	}
	/**
	 * The main method for testing the Model class.
	 *
	 * @param args The command-line arguments.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Model m=new Model(3);
		
		m.printBoard(m.playerShips);
         
	}
	/**
	 * Retrieves the flag indicating if the game is in design mode.
	 *
	 * @return {@code true} if the game is in design mode, {@code false} otherwise.
	 */
	public boolean getDesign() {
		// TODO Auto-generated method stub
		return design;
	}
	/**
	 * Sets the design mode flag.
	 *
	 * @param design The value to set for the design mode flag.
	 */
	public void setDesign(boolean design)
	{
		this.design=design;
		
	}
	/**
	 * Increments the number of seconds.
	 * This method is used to track the game duration.
	 */
	public void incrementSecond()
	{
		if(playing)
		{
			seconds++;
		}
		
	}
	/**
	 * Retrieves the number of seconds elapsed in the game.
	 *
	 * @return The number of seconds elapsed.
	 */
	public int getSecond()
	{
		return seconds;
		
	}
	

}
