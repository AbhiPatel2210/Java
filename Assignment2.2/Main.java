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

public class Main {
	
	class Languages implements ActionListener
	{
		Main window;
		Languages(Main window)
		{
			this.window=window;
		}
          

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JComboBox <String>button=(JComboBox <String>)e.getSource();
			window.write("Language: "+(String)button.getSelectedItem());
			   //System.out.println((Integer)button.getSelectedItem());
			
		}
		
	}
	class Buttons implements ActionListener
	{
		Main window;
		Buttons(Main window)
		{
			this.window=window;
		}
          
		@Override
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
				             "A Battleship game\n Abhi Patel\n 041048533\nRominKumar Patel\n","Battleship", JOptionPane.INFORMATION_MESSAGE);
				   
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
				JComboBox <Integer>button=(JComboBox <Integer>)e.getSource();
				window.resize((Integer)button.getSelectedItem());
				   //System.out.println((Integer)button.getSelectedItem());
			}
			
		}
		
	}
	public void progress()
	{
		leftProgressBar.setValue(leftProgressBar.getValue()+10);
	}
	Main()
	
	{
		//java.net.URL imgURL = getClass().getResource(path);
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
	public void write(String text)
	{
		messagesArea.append(text+"\n");
	}
	class Square extends JButton
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private int x;
		private int y;
		private boolean comp;
		Square(int x,int y)
		{
			this.x=x;
			this.y=y;
			this.setBackground(new Color(0x7400b8));
			
			
		}
		Square(int x,int y,Buttons buttons)
		{
			
			this(x,y);
			this.addActionListener(buttons);
			
			
		}
		Square(int x,int y,Buttons buttons,boolean comp)
		{
			
			this(x,y,buttons);
			this.comp=comp;
			
			
			
		}
		@Override
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
	public void resize(int dimension) {
		// TODO Auto-generated method stub
		dimension=dimension*2;
		playerButton=new Square[dimension][dimension];
		compButton=new Square[dimension][dimension];
		
		dimension++;
		drawBoard(leftBoardPanel,leftPanel,playerButton,dimension,false);
		drawBoard(rightBoardPanel,rightPanel,compButton,dimension,true);
		System.out.println(dimension);
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
	
	
	

	
	
    
	
	

	public static void main(String[] args){
		// TODO Auto-generated method stub
		Main game=new Main();
		
		

	}

}

