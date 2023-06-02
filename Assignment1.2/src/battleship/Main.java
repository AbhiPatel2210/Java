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

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants; 


 /**
 * The Main class represents the main entry point of the Battleship game application.
 * It contains the GUI components and event handlers for user interactions.
 */
 
public class Main {
	
	
	/**
	 * The Languages class implements the ActionListener interface to handle language selection events from a JComboBox.
	 * It provides a method to retrieve the selected language and display it in the associated Main window.
	 */
	class Languages implements ActionListener
	{
		
		private Main window;
		/**
	     * Constructs a Languages object with a reference to the Main window.
	     *
	     * @param window the Main window associated with the Languages object
	     */
		Languages(Main window)
		{
			this.window=window;
		}
          

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			@SuppressWarnings("unchecked")
			JComboBox <String>button=(JComboBox <String>)e.getSource();
			window.write("Language: "+(String)button.getSelectedItem());
			   //System.out.println((Integer)button.getSelectedItem());
			
		}
		
	}
	/**
	 * The Buttons class implements the ActionListener interface to handle button and JComboBox events.
	 * It provides methods to handle different types of button events, such as Square buttons, JButtons,
	 * and JComboBox selections, and perform corresponding actions in the associated Main window.
	 */
	class Buttons implements ActionListener
	{
		private Main window;
		/**
	     * Constructs a Buttons object with a reference to the Main window.
	     *
	     * @param window the Main window associated with the Buttons object
	     */
		Buttons(Main window)
		{
			this.window=window;
		}
          
		@Override
		/**
	     * Invoked when an action occurs. Determines the source of the event and performs the corresponding action.
	     *
	     * @param e the ActionEvent representing the button or JComboBox event
	     */
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println(e.getSource().getClass());
			if(e.getSource() instanceof Square)
			{
				Square button=(Square)e.getSource();
			    System.out.println(button);
			    window.write("User Pressed "+button.toString());
			    window.progress();
			    
			}
			else if(e.getSource() instanceof JButton)
			{
			   JButton button=(JButton)e.getSource();
			   System.out.println(button.getText());
			   String text=button.getText();
			   if(button.getActionCommand()=="About")
			   {
				   System.out.println("About");
				   JOptionPane.showMessageDialog(frame,
				             "A Battleship game\n Abhi Patel\n 041048533\nRominKumar Patel\n 041063127\n","Battleship", JOptionPane.INFORMATION_MESSAGE);
				   
			   }
			   else if(text.equals("Design"))
					   {
				           window.write("User is Placing ships");
					   }
			   else if(text.equals("Rand"))
			   {
				   window.write("ships are being Place by computers randomly.");
			   }
			   else if(text.equals("Reset"))
			   {
				   window.write("Resetting the game.");
			   }
			   else if(text.equals("Play"))
			   {
				   window.write("Starting the game.");
			   }
			   
			   
			}
			else if(e.getSource()instanceof JComboBox<?>) {
				@SuppressWarnings("unchecked")
				JComboBox <Integer>button=(JComboBox <Integer>)e.getSource();
				window.resize((Integer)button.getSelectedItem());
				   //System.out.println((Integer)button.getSelectedItem());
			}
			
		}
		
	}
	/**
	   * Method to update the progress of the left progress bar by incrementing its value by 10.
	   */
	public void progress()
	{
		leftProgressBar.setValue(leftProgressBar.getValue()+10);
	}
	/**
	   * Main method that initializes and configures the GUI components for the Battleship game.
	   * It creates buttons, progress bars, panels, and adds them to the frame.
	   */
	public Main()
	
	{
		
	   icon = new ImageIcon("Battleship1.gif");
	   
		
	   topButton=new JButton(icon);
		for(int i=4;i<=9;i++)
		{
			dimensions.addItem(i);
			
		}
		leftProgressBar.setValue(0);
		leftProgressBar.setForeground(new Color(0x9a031e));
		leftBottomPanel.add(leftLifeLabel);
		leftBottomPanel.add(leftProgressBar);
		
		rightProgressBar.setValue(70);
		rightProgressBar.setForeground(new Color(0x9a031e));
		rightBottomPanel.add(rightLifeLabel);
		rightBottomPanel.setBackground(color2);
		rightBottomPanel.add(rightProgressBar);

		
		leftPanel.setLayout(new BorderLayout());
		leftPanel.add(leftBottomPanel,BorderLayout.SOUTH);
		leftBottomPanel.setBackground(color2);
		rightPanel.setLayout(new BorderLayout());
		rightPanel.add(rightBottomPanel,BorderLayout.SOUTH);
				//dimensions.setSelectedIndex(0);
		System.out.println(dimensions.getSelectedItem());
		dimensions.addActionListener(buttons);
		int dimension=(Integer)dimensions.getSelectedItem();
		leftBoardPanel=new JPanel();
		leftBoardPanel.setLayout(new GridLayout(dimension,dimension));
		leftBoardPanel.setBackground(color2);
		rightBoardPanel=new JPanel();
		rightBoardPanel.setLayout(new GridLayout(dimension,dimension));
		rightBoardPanel.setBackground(color2);
		resize(dimension);
		
		topPanel.setLayout(new BoxLayout(topPanel,BoxLayout.Y_AXIS));
		topPanel.setBackground(color1);
		languages.addItem("English");
		languages.addItem("French");
		languages.addActionListener(languagesListener);
		languages.setBackground(color3);
		topButton.addActionListener(buttons);
		designButton.addActionListener(buttons);
		designButton.setBackground(color3);
		randButton.addActionListener(buttons);
		randButton.setBackground(color3);
		playButton.addActionListener(buttons);
		playButton.setBackground(color3);
		resetButton.addActionListener(buttons);
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
		dimensionPanel.setBackground(color1);
		topPanel.add(dimensionPanel);
		timePanel.add(timeLabel);
		timePanel.add(timeField);
		timeField.setBackground(color3);
		timePanel.setBackground(color1);
		bottomPanel.setLayout(new BoxLayout(bottomPanel,BoxLayout.Y_AXIS));
		bottomPanel.add(timePanel);
		bottomPanel.add(resetButton);
		bottomPanel.add(Box.createVerticalStrut(5));
		bottomPanel.add(playButton);
		bottomPanel.setBackground(color1);
		
		
		
		
		topButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		resetButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		playButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		//playButton.setMargin(new Insets(50,50,50,50));
		centerPanel.setLayout(new BorderLayout());
		centerPanel.add(topPanel,BorderLayout.NORTH);
		messagesPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		messagesPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		centerPanel.add(messagesPane,BorderLayout.CENTER);
		
		messagesArea.setBackground(color3);
		centerPanel.add(bottomPanel,BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout());
		panel.add(leftPanel,BorderLayout.WEST);
		panel.add(centerPanel,BorderLayout.CENTER);
		panel.add(rightPanel,BorderLayout.EAST);

		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		resize((Integer)dimensions.getSelectedItem());
		//frame.setSize(500+80*dimension,400+30*dimension);
		frame.setVisible(true);
	}
	/**
	   * Method to write text to the messages area by appending it to the existing text.
	   * @param text The text to be written.
	   */
	public void write(String text)
	{
		messagesArea.append(text+"\n");
	}
	/**
	 * This class represents a Square button in a Battleship game. It extends the JButton class and
	 * adds additional functionality and properties specific to the game.
	 */
	class Square extends JButton
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private int x;
		private int y;
		private boolean comp;
		/**
		   * Constructs a Square object with the given x and y coordinates.
		   * @param x The x-coordinate of the Square.
		   * @param y The y-coordinate of the Square.
		   */
		Square(int x,int y)
		{
			this.x=x;
			this.y=y;
			this.setBackground(new Color(0x7400b8));
			
			
		}
		/**
		   * Constructs a Square object with the given x and y coordinates, and adds an ActionListener.
		   * @param x       The x-coordinate of the Square.
		   * @param y       The y-coordinate of the Square.
		   * @param buttons The ActionListener for the Square.
		   */
		Square(int x,int y,Buttons buttons)
		{
			
			this(x,y);
			this.addActionListener(buttons);
			
			
		}
		/**
		   * Constructs a Square object with the given x and y coordinates, adds an ActionListener,
		   * and specifies whether it represents a computer or user.
		   * @param x       The x-coordinate of the Square.
		   * @param y       The y-coordinate of the Square.
		   * @param buttons The ActionListener for the Square.
		   * @param comp    A boolean indicating if the Square represents the computer (true) or user (false).
		   */
		Square(int x,int y,Buttons buttons,boolean comp)
		{
			
			this(x,y,buttons);
			this.comp=comp;
			
			
			
		}
		@Override
		/**
		   * Returns a string representation of the Square.
		   * @return A string representation of the Square in the format: "Player x, y" or "Computer x, y".
		   */
		public String toString()
		{
			String text;
			if(comp)
			{
				text="computer";
			}
			else {
				text="User";
			}
			return text+" "+(x+1)+", "+(y+1);
			
		}
	}
	/**
	 * This method is responsible for drawing the game board on the specified panel. It creates and
	 * configures the necessary components, such as labels, buttons, and panels, and adds them to the
	 * board panel. The board represents a Battleship game board with a specific dimension.
	 *
	 * @param boardPanel The panel on which the game board will be drawn.
	 * @param panel1     The parent panel containing the board panel.
	 * @param array      The two-dimensional array representing the Squares of the game board.
	 * @param dimension  The dimension of the game board.
	 * @param comp       A boolean indicating if the game board represents the computer (true) or user (false).
	 */
	private void drawBoard(JPanel boardPanel,JPanel panel1,Square[][] array,int dimension,boolean comp)
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
			    	button=new Square(x,y,buttons,true);
			    }
			    else {
			    	button=new Square(x,y,buttons,false);
			    }
			    panel.add(button);
			    button.setPreferredSize(new Dimension(40,40));
			    array[x][y]=button;
			    boardPanel.add(panel);
			}
						
			
			
		}
		panel1.add(boardPanel,BorderLayout.CENTER);

	}
	/**
	 * Resizes the game board to the specified dimension. This method updates the size of the game board
	 * and redraws the board panels accordingly. It also adjusts the size of the JFrame window to fit
	 * the new board size.
	 *
	 * @param dimension The new dimension of the game board.
	 */
	
	public void resize(int dimension) {
		// TODO Auto-generated method stub
		dimension=dimension*2;
		playerButton=new Square[dimension][dimension];
		compButton=new Square[dimension][dimension];
		
		dimension++;
		drawBoard(leftBoardPanel,leftPanel,playerButton,dimension,false);
		drawBoard(rightBoardPanel,rightPanel,compButton,dimension,true);
		System.out.println(dimension-1);
		frame.setSize(500+80*dimension,400+30*dimension);
		frame.setVisible(false);
		frame.setVisible(true);
	}
	private Color color1=new Color(0xff9770);
	private Color color2=new Color(0x8ecae6);
	private Color color3=new Color(0xcce3de);
	private Font myFont=new Font("Ink Free",Font.BOLD,35);
	private Buttons buttons=new Buttons(this);
	private Languages languagesListener=new Languages(this);

	private JFrame frame=new JFrame("Battleship (Abhi Patel & RominKumar Patel)");
	private JPanel panel=new JPanel();
	private JPanel leftPanel=new JPanel();
	private JPanel leftBoardPanel;
	private JPanel rightBoardPanel;
	private JPanel leftBottomPanel=new JPanel();
	private JPanel rightBottomPanel=new JPanel();
	private JPanel centerPanel=new JPanel();
	private JPanel rightPanel=new JPanel();
	private JTextArea messagesArea=new JTextArea();
	private JScrollPane messagesPane=new  JScrollPane(messagesArea);
	private JPanel topPanel=new JPanel();
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
	private JPanel bottomPanel=new JPanel();
	private JPanel timePanel=new JPanel();
	private JLabel timeLabel=new JLabel("Time: ");
	private JTextField timeField=new JTextField("     0");
	private JButton resetButton =new JButton("Reset");
	private JButton playButton =new JButton("Play");
	private JLabel leftLifeLabel=new JLabel("Life: ");
	private JLabel rightLifeLabel=new JLabel("Life: ");
	private JProgressBar leftProgressBar=new JProgressBar();
	private JProgressBar rightProgressBar=new JProgressBar();
	private Square[][] playerButton;
	private Square[][] compButton;
	
	
	

	
	
    
	
	

	/**
	 * The main method is the entry point for the program. It creates an instance of the Main class,
	 * initializing and starting the game.
	 *
	 * @param args The command-line arguments passed to the program (not used in this implementation).
	 */
	public static void main(String[] args){
		// TODO Auto-generated method stub
		Main game=new Main();
		
		

	}

}

