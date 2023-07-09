package battleship;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.filechooser.FileSystemView; 
/**

The View class represents the graphical user interface of the Battleship game.
It implements the GraphicalInterface interface.
*/

public class View implements GraphicalInterface{
	
	

	
	
	private Icon newIcon;
	private Icon solutionIcon;
	private Icon exitIcon;
	private Icon colorsIcon;
	private Icon aboutIcon;
	private ColorMenu colorMenu;
	private Icon saveIcon;
	private Icon loadIcon;
	private Color unselectedColor= new Color(0x7400b8);
	private Color waterColor= Color.green;
	private Color shipColor= Color.red;
	
	
	/**
	 * Getters for Unselectedcolor.
	 * @return
	 */
	
  public Color getUnselectedColor()
  {
	return unselectedColor;
	  
  }
  /**
   * getters for watercolor.
 * @return
 */
public Color getWaterColor()
  {
	return waterColor;
	  
  }
  /**
   * getters for ship color.
 * @return
 */
public Color getShipColor()
  {
	return shipColor;
	  
  }
  /**
   * Setters for Unselected color.
 * @param color Color of unselected place.
 */
public void setUnselectedColor(Color color)
  {
	  unselectedColor=color;
	  
  }
  /**
   * Setter for water color.
 * @param color Color of water.
 */
public void setWaterColor(Color color)
  {
	 waterColor=color;
	  
  }
  /**
   * setter for ship color.
 * @param color color of ship.
 */
public void setShipColor(Color color)
  {
     shipColor=color;
	  
  }
/**
 * Constructs a View object and initializes the graphical user interface.
 */

	public View()
	
	{
		designButton.setActionCommand("Design");
		randButton.setActionCommand("Rand");
		playButton.setActionCommand("Play");
		resetButton.setActionCommand("Reset");
		
		newIcon = new ImageIcon("iconnew.gif");
		solutionIcon = new ImageIcon("iconsol.gif");
		exitIcon = new ImageIcon("iconext.gif");
		colorsIcon = new ImageIcon("iconcol.gif");
		aboutIcon = new ImageIcon("iconabt.gif");
		saveIcon=new ImageIcon("icondes.gif");
		loadIcon=new ImageIcon("iconload.gif");
		timeField.setMinimumSize(new Dimension(200,100));
		
		
		newItem.setIcon(newIcon);
		solutionItem.setIcon(solutionIcon);
		exitItem.setIcon(exitIcon);
		colorsItem.setIcon(colorsIcon);
		aboutItem.setIcon(aboutIcon);
		saveItem.setIcon(saveIcon);
		loadItem.setIcon(loadIcon);
		
		
		newItem.addActionListener(controller);
		solutionItem.addActionListener(controller);
		exitItem.addActionListener(controller);
		colorsItem.addActionListener(controller);
		aboutItem.addActionListener(controller);
		saveItem.addActionListener(controller);
		loadItem.addActionListener(controller);
		
		
		gameMenu.add(newItem);
		gameMenu.add(loadItem);
		gameMenu.add(saveItem);
		gameMenu.add(solutionItem);
		gameMenu.add(exitItem);
		menuBar.add(gameMenu);
		helpMenu.add(colorsItem);
		helpMenu.add(aboutItem);
		menuBar.add(helpMenu);
		frame.setJMenuBar(menuBar);
		colorMenu=new ColorMenu(this);
		
	   icon = new ImageIcon("Battleship1.gif");
	   
	// Initialize and set properties of GUI components
	   topButton=new JButton(icon);
		for(int i=4;i<=7;i++)
		{
			dimensions.addItem(i);
			
		}
		leftProgressBar.setValue(0);
		leftProgressBar.setForeground(new Color(0x9a031e));
		leftBottomPanel.add(leftLifeLabel);
		leftBottomPanel.add(leftProgressBar);
		
		//rightProgressBar.setValue(70);
		rightProgressBar.setForeground(new Color(0x9a031e));
		rightBottomPanel.add(rightLifeLabel);
		rightBottomPanel.setBackground(backgroundColor);
		rightBottomPanel.add(rightProgressBar);

		
		leftPanel.setLayout(new BorderLayout());
		leftPanel.add(leftBottomPanel,BorderLayout.SOUTH);
		leftBottomPanel.setBackground(backgroundColor);
		rightPanel.setLayout(new BorderLayout());
		rightPanel.add(rightBottomPanel,BorderLayout.SOUTH);
				//dimensions.setSelectedIndex(0);
		System.out.println(dimensions.getSelectedItem());
		dimensions.addActionListener(controller);
		int dimension=(Integer)dimensions.getSelectedItem();
		leftBoardPanel=new JPanel();
		leftBoardPanel.setLayout(new GridLayout(dimension,dimension));
		leftBoardPanel.setBackground(backgroundColor);
		rightBoardPanel=new JPanel();
		rightBoardPanel.setLayout(new GridLayout(dimension,dimension));
		rightBoardPanel.setBackground(backgroundColor);
		
		
		topPanel.setLayout(new BoxLayout(topPanel,BoxLayout.Y_AXIS));
		topPanel.setBackground(color1);
		languages.setActionCommand("Languages");
		
		languages.addItem("English");
		languages.addItem("French");
		languages.addActionListener(controller);
		languages.setBackground(color3);
		topButton.addActionListener(controller);
		designButton.addActionListener(controller);
		designButton.setBackground(color3);
		randButton.addActionListener(controller);
		randButton.setBackground(color3);
		playButton.addActionListener(controller);
		playButton.setBackground(color3);
		resetButton.addActionListener(controller);
		resetButton.setBackground(color3);
		
		
		
		topPanel.add(topButton);
		topButton.setBackground(color3);
		topButton.setActionCommand("About");
		languagePanel.add(languageLabel);
		languagePanel.add(languages);
		languagePanel.setBackground(color1);
		topPanel.add(languagePanel);
		buttonPanel.add(designButton);
		buttonPanel.add(randButton);
		
		topPanel.add(buttonPanel);
		topPanel.setPreferredSize(new Dimension(400,170));
		buttonPanel.setBackground(color1);
		dimensionPanel.add(dimensionLabel);
		dimensionPanel.add(dimensions);
		dimensions.setBackground(color3);
		dimensions.setActionCommand("Dimensions");
		dimensionPanel.setBackground(color1);
		topPanel.add(dimensionPanel);
		timePanel.add(timeLabel);
		timePanel.add(timeField);
		timeField.setBackground(color3);
		timePanel.setBackground(color1);
		scorePanel.add(scoreLabel);
		scorePanel.add(scoreField);
		scoreField.setBackground(color3);
		scorePanel.setBackground(color1);
		bottomPanel.setLayout(new BoxLayout(bottomPanel,BoxLayout.Y_AXIS));
		bottomPanel.add(scorePanel);
		bottomPanel.add(timePanel);
		bottomPanel.add(resetButton);
		bottomPanel.add(Box.createVerticalStrut(5));
		bottomPanel.add(playButton);
		bottomPanel.setBackground(color1);
		resize(dimension);
		
		
		
		
		topButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		resetButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		playButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		//playButton.setMargin(new Insets(50,50,50,50));
		centerPanel.setLayout(new BorderLayout());
		centerPanel.add(topPanel,BorderLayout.NORTH);
		messagesPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		messagesPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		optionPanel.setLayout(new BorderLayout());
		
		designPanel.add(lengthOfShips);
		groupButton.add(vertical);
		groupButton.add(horizontal);
		vertical.setSelected(true);
		designPanel.add(vertical);
		designPanel.add(horizontal);
		optionPanel.add(designPanel,BorderLayout.SOUTH);
		designPanel.setVisible(false);

		
		optionPanel.add(messagesPane,BorderLayout.CENTER);
		centerPanel.add(optionPanel,BorderLayout.CENTER);
		//centerPanel.add(messagesPane,BorderLayout.CENTER);
		messagesArea.setBackground(color3);
		centerPanel.add(bottomPanel,BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout());
		panel.add(leftPanel,BorderLayout.WEST);
		panel.add(centerPanel,BorderLayout.CENTER);
		panel.add(rightPanel,BorderLayout.EAST);

		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setSize(500+80*dimension,400+30*dimension);
		frame.setVisible(true);
	}
	/**
	 * Writes the specified text to the messages area.
	 *
	 * @param text The text to write.
	 */
	public void write(String text)
	{
		messagesArea.append(text+"\n");
	}
	JFileChooser saveBoard=new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
	/**
	 * Displays a file chooser dialog for saving a file and returns the selected file.
	 *
	 * @return The selected file.
	 */
	public File displayChooser()
	{
	

		int returnValue = saveBoard.showSaveDialog(null);
		// int returnValue = jfc.showSaveDialog(null);

		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = saveBoard.getSelectedFile();
			System.out.println(selectedFile.getAbsolutePath());
			return selectedFile;
		}
		return null;

	}
	/**
	 * Displays a file chooser dialog for loading a file and returns the selected file.
	 *
	 * @return The selected file.
	 */
	public File displayLoadChooser()
	{
	

		int returnValue = saveBoard.showOpenDialog(null);
		// int returnValue = jfc.showSaveDialog(null);

		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = saveBoard.getSelectedFile();
			System.out.println(selectedFile.getAbsolutePath());
			return selectedFile;
		}
		return null;

	}
	
	/**
	 * Draws the game board on the specified panel using the provided array and dimension.
	 *
	 * @param boardPanel The panel to draw the game board on.
	 * @param panel1 The panel to add the board panel to.
	 * @param array The array representing the game board.
	 * @param dimension The dimension of the game board.
	 * @param comp A flag indicating whether the board is for the computer or not.
	 * @param b A 2D character array representing the game board.
	 */
	
	private void drawBoard(JPanel boardPanel,JPanel panel1,Square[][] array,int dimension,boolean comp,char b[][])
	{
		
		if(boardPanel!=null)
		{
			boardPanel.removeAll();
			boardPanel.setLayout(new GridLayout(dimension,dimension));
		}
		
		
		boardPanel.add(new JLabel(""));
		for(int i=0;i<dimension-1;i++)
		{
			JLabel label=new JLabel(""+(char)('a'+i));
			label.setFont(myFont);
			label.setForeground(new Color(0x00509d));
			label.setHorizontalAlignment(JLabel.CENTER);
			label.setVerticalAlignment(JLabel.BOTTOM);
			boardPanel.add(label);
		}
		for(int y=0;y<dimension-1;y++)
		{
			JLabel label=new JLabel(""+(char)('A'+y));
			label.setFont(myFont);
			label.setForeground(new Color(0x00509d));
			label.setHorizontalAlignment(JLabel.CENTER);
			label.setVerticalAlignment(JLabel.TOP);

			boardPanel.add(label);
			

						for(int x=0;x<dimension-1;x++)
			{
				JPanel panel=new JPanel();	
				panel.setBackground(new Color(0x8ecae6));
			    Square button;
			    if(comp) {
			    	button=new Square(x,y,controller,true);
			    	
			    	
			    }
			    else {
			    	button=new Square(x,y,controller,false);
			    }
			    /*if(b[x][y]=='*')
		    	{
		    		button.setBackground(Color.black);
		    	}*/
			    panel.add(button);
			    button.setPreferredSize(new Dimension(40,40));
			    array[x][y]=button;
			    boardPanel.add(panel);
			}
						
			
			
		}
		panel1.add(boardPanel,BorderLayout.CENTER);

	}
	/**
	 * Places a ship on the player's board at the specified coordinates.
	 *
	 * @param x The x-coordinate of the ship's position.
	 * @param y The y-coordinate of the ship's position.
	 * @return 0
	 */
	public int placeShip(int x, int y) {
		// TODO Auto-generated method stub
		if(lengthOfShips.getSelectedItem()!=null)
		{
		model.placeShips(x, y,(Integer)lengthOfShips.getSelectedItem(),vertical.isSelected());
		}
		return 0;
	}
	/**
	 * Displays the colors of the game board on the GUI based on the provided array.
	 *
	 * @param array The array representing the game board.
	 * @param b A 2D character array representing the game board.
	 */
	private void displayColors(Square[][] array,char b[][])

	{
		for(int x=0;x<array.length;x++)
		{
			for(int y=0;y<array[x].length;y++)
			{
				if(b[x][y]=='*')
		    	{
		    		array[x][y].setBackground(Color.black);
		    	}
				else {
					array[x][y].setBackground(unselectedColor);
				}
			}
		}
	}
	/**
	 * Generates a random player board and updates the GUI to display the new board.
	 */
	public void randomPlayerBoard() {
		
		model.randomPlayerBoard();
		drawPlayerBoard();
		model.setReadyToPlay(true);
		
	}
	/**
	 * Redraws the player's board on the GUI based on the current player board state.
	 */
	public void drawPlayerBoard()
	{
		displayColors(playerButton,model.getPlayerBoard());
	}

	/**
	 * Resets the game by resizing the board, stopping the game, and clearing the messages area.
	 */
	public void reset()
	{
		resize((Integer)dimensions.getSelectedItem());
		model.stopGame();
		scoreField.setText("     0");
		
		messagesArea.setText("");

	}
	/**
	 * Shows the solution view if the game is in progress and a solution view exists.
	 */
	public void showSolution()
	{
		if(model!=null && model.getPlaying())
		{
			solutionView.resize((Integer)dimensions.getSelectedItem());
			solutionView.displaySolution();
			solutionView.setVisible();
		}
		
		
	}
	/**
	 * Shows the color menu if it exists.
	 */
	public void showColorMenu()
	{
		if(colorMenu!=null)
		{
		  colorMenu.setVisible();
		}
		
		
	}
	/**
	 * Resizes the game board to the specified dimension and updates the GUI accordingly.
	 *
	 * @param dimension The new dimension of the game board.
	 */
	public void resize(int dimension) {
		// TODO Auto-generated method stub
		model=new Model(dimension,this);
		solutionView=new SolutionView(model,controller);
		controller.setModel(model);
		leftProgressBar.setMaximum(model.getTotalShips());
		rightProgressBar.setMaximum(model.getTotalShips());
		leftProgressBar.setValue(model.getTotalShips());
		rightProgressBar.setValue(model.getTotalShips());
		dimension=2*dimension;
		playerButton=new Square[dimension][dimension];
		compButton=new Square[dimension][dimension];
		
		dimension++;
		drawBoard(leftBoardPanel,leftPanel,playerButton,dimension,false,model.getPlayerBoard());
		drawBoard(rightBoardPanel,rightPanel,compButton,dimension,true,model.getComputerBoard());
		System.out.println(dimension);
		lengthOfShips.removeAllItems();
		System.out.println((Integer)dimensions.getSelectedItem()+"Dimension");
		for(int i=1;i<=(Integer)dimensions.getSelectedItem();i++)
		{
			lengthOfShips.addItem(i);
		}
		lengthOfShips.setSelectedIndex(lengthOfShips.getItemCount()-1);
		
		frame.setSize(500+80*dimension,400+40*dimension);
		frame.setVisible(false);
		frame.setVisible(true);
		
		

		
		
	}
	/**
	 * Updates the labels on the GUI based on the selected language.
	 */
	public void updateLables()
	{
		System.out.println(languages.getSelectedItem());
		ResourceBundle resource=null;
		if(languages.getSelectedItem().equals("English"))
		{
			resource=englishBundle;
		}
		else if(languages.getSelectedItem().equals("French"))
		{
			resource=frenchBundle;
			
		}
		
		languageLabel.setText(resource.getString("languages"));
		
		designButton.setText(resource.getString("design"));
		randButton.setText(resource.getString("rand"));
		dimensionLabel.setText(resource.getString("dimensions"));
		scoreLabel.setText(resource.getString("score"));
		timeLabel.setText(resource.getString("time"));
		resetButton.setText(resource.getString("reset"));
		playButton.setText(resource.getString("play"));
		leftLifeLabel.setText(resource.getString("life"));
		rightLifeLabel.setText(resource.getString("life"));
		
	}
	private Color color1=new Color(0xff9770);
	private Color backgroundColor=new Color(0x8ecae6);
	private Color color3=new Color(0xcce3de);
	private Font myFont=new Font("Ink Free",Font.BOLD,35);
	private Controller controller=new Controller(this);
	private SolutionView solutionView;
	private Model model;
	

	private JFrame frame=new JFrame("Battleship (Abhi Patel & RominKumar Patel)");
	private JPanel panel=new JPanel();
	private JPanel leftPanel=new JPanel();
	private JPanel leftBoardPanel;
	private JPanel leftBottomPanel=new JPanel();
	private JPanel rightPanel=new JPanel();
	private JPanel rightBoardPanel;
	private JPanel rightBottomPanel=new JPanel();
	private JPanel centerPanel=new JPanel();
    
	private JTextArea messagesArea=new JTextArea();
	private JScrollPane messagesPane=new  JScrollPane(messagesArea);
	private JPanel topPanel=new JPanel();
	private JPanel bottomPanel=new JPanel();
	private ImageIcon icon;
	
	private JButton topButton;
	private JComboBox<String> languages=new JComboBox<>();
	private JPanel languagePanel=new JPanel();
	private JLabel languageLabel=new JLabel("Languages: "); 
	private JPanel buttonPanel=new JPanel();
	private JButton designButton=new JButton("Design");
	private JButton randButton=new JButton("Rand");
	private JPanel dimensionPanel=new JPanel();
	private JLabel dimensionLabel=new JLabel("Dimensions: ");
	private JComboBox<Integer> dimensions=new JComboBox<>();
	
	private JPanel timePanel=new JPanel();
	private JLabel timeLabel=new JLabel("Time: ");
	private JPanel scorePanel=new JPanel();
	private JLabel scoreLabel=new JLabel("Score: ");
	private JTextField timeField=new JTextField("     0");
	private JTextField scoreField=new JTextField("         0");

	private JButton resetButton =new JButton("Reset");
	private JButton playButton =new JButton("Play");
	private JLabel leftLifeLabel=new JLabel("Life: ");
	private JLabel rightLifeLabel=new JLabel("Life: ");
	private JProgressBar leftProgressBar=new JProgressBar();
	private JProgressBar rightProgressBar=new JProgressBar();
	private Square[][] playerButton;
	private Square[][] compButton;
	private Locale englishLocale = new Locale("en", "CA");
	private ResourceBundle englishBundle = ResourceBundle.getBundle("locale/resource", englishLocale);
    private Locale frenchLocale = new Locale("fr", "CA");
	private ResourceBundle frenchBundle = ResourceBundle.getBundle("locale/resource", frenchLocale);
	private JPanel designPanel=new JPanel();
	private JPanel optionPanel=new JPanel();
	private JRadioButton vertical=new JRadioButton("Vertical");
	private JRadioButton horizontal=new JRadioButton("Horizontal");
	private ButtonGroup groupButton=new ButtonGroup();
	//private JPanel allignmentPanel=new JPanel();
    private JComboBox<Integer> lengthOfShips=new JComboBox<>();
    private JMenuBar menuBar=new JMenuBar();
    private JMenu gameMenu = new JMenu("Game");
    private JMenuItem newItem = new JMenuItem("New");
    private JMenuItem solutionItem = new JMenuItem("Solution");
    private JMenuItem exitItem = new JMenuItem("Exit");
    
    private JMenu helpMenu = new JMenu("Help");
    private JMenuItem colorsItem = new JMenuItem("Colors");
    private JMenuItem aboutItem = new JMenuItem("About");
    private JMenuItem saveItem=new JMenuItem("Save");
    private JMenuItem loadItem=new JMenuItem("Load");
    
    
	

	//String[] data = {"one", "two", "three", "four"};
	 //JList<String> myList = new JList<String>(data);
	
	
	

	
	
    
	
	
    /**
     * The main method to start the Battleship game.
     *
     * @param args The command line arguments.
     */
	public static void main(String[] args){
		// TODO Auto-generated method stub
		Splashscreen splashscreen=new Splashscreen();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		splashscreen.setInvisible();
		View game=new View();
		
		
		

	}
	 /**
     * Displays an about message dialog with information about the Battleship game.
     */
	public void showAbout() {
		// TODO Auto-generated method stub
		 JOptionPane.showMessageDialog(frame,
	             "A Battleship game\nAbhi Patel\n041048533\nRominKumar Patel\n041063127\n","Battleship", JOptionPane.INFORMATION_MESSAGE);
		
	}
	
	@Override
	public void selectComputer(int x, int y) {
		// TODO Auto-generated method stub
		char square=model.getComputerBoard()[x][y];
		if(square=='@')
		{
			compButton[x][y].setBackground(shipColor);
			rightProgressBar.setValue(model.getTotalShips()-model.getComputerShipsHit());
			if(model.getTotalShips()-model.getComputerShipsHit()==0)
			{
				model.stopGame();
				JOptionPane.showMessageDialog(frame,
			             "Player WON the game.","Player WON", JOptionPane.INFORMATION_MESSAGE);
				
			}
		}
		else if(square=='x') {
			compButton[x][y].setBackground(waterColor);
			
		}
		scoreField.setText(Integer.toString((int)model.getScore()));
	}
	
	@Override
	public void selectPlayer(int x, int y) {
		// TODO Auto-generated method stub
		char square=model.getPlayerBoard()[x][y];
		if(square=='@')
		{
			playerButton[x][y].setBackground(shipColor);
			 System.out.println(model.getTotalShips()-model.getPlayerShipsHit());
			leftProgressBar.setValue(model.getTotalShips()-model.getPlayerShipsHit());
			if(model.getTotalShips()-model.getPlayerShipsHit()==0)
			{
				model.stopGame();
				JOptionPane.showMessageDialog(frame,
			             "Computer WON the game.","Opponent WON", JOptionPane.INFORMATION_MESSAGE);
				
			}
		   
		}
		
		else if(square=='x') {
			playerButton[x][y].setBackground(waterColor);
			
		}
		
	}
	 /**
     * Toggles the visibility of the design panel.
     */
	public void design() {
		// TODO Auto-generated method stub
		if(designPanel.isVisible())
		{
			designPanel.setVisible(false);
			
		}
		else {
			designPanel.setVisible(true);
		}
		
	}
	@Override
	public void allShipsPlaced() {
		// TODO Auto-generated method stub
		int index=lengthOfShips.getSelectedIndex();
		lengthOfShips.removeItemAt(index);
		if(lengthOfShips.getItemCount()<=0)
		{
			model.setReadyToPlay(true);
			designPanel.setVisible(false);
		}
		
	}
	/**
     * Increments the game time by one second and updates the time field on the GUI.
     */
	public void second() {
		// TODO Auto-generated method stub
		if(model!=null)
		{
			model.incrementSecond();
			updateTimeField();
			
		}
		
	}
	
	/**
	 * This method updates the timeField.
	 */
	private void updateTimeField()
	{
		if(timeField!=null)
		{
		
		timeField.setText(Integer.toString(model.getSecond()));
		}
		
		
	}
	

}

