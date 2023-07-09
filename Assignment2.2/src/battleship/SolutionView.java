package battleship;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * Represents the solution view for the Battleship game.
 */
public class SolutionView {
	Model model;
	private Square[][] compButton;
	private JPanel rightBoardPanel;
	private Color color2=new Color(0x8ecae6);
	private JPanel rightPanel=new JPanel();
	private JFrame frame=new JFrame("Battleship (Abhi Patel & RominKumar Patel)");
	private Font myFont=new Font("Ink Free",Font.BOLD,35);
	private Controller controller;
	 /**
     * Constructs a solution view for the Battleship game.
     *
     * @param model      The model representing the game data.
     * @param controller The controller for handling user input.
     */
	public SolutionView(Model model ,Controller controller)
	{
		this.model=model;
		this.controller=controller;
		rightBoardPanel=new JPanel();
		rightPanel.setLayout(new BorderLayout());
		rightBoardPanel.setLayout(new GridLayout(3,3));
		rightBoardPanel.setBackground(color2);
		frame.add(new JLabel("Solution"),BorderLayout.NORTH);
        rightPanel.add(rightBoardPanel,BorderLayout.CENTER);
		frame.add(rightPanel,BorderLayout.CENTER);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setSize(500+80*dimension,400+30*dimension);
		frame.setVisible(false);
	}
	 /**
     * Displays the solution on the solution board.
     */
	public void displaySolution()
	{
		displayColors(compButton,model.getComputerSolution());
	}
	
	 // Helper method to draw the solution board
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
			    
			    panel.add(button);
			    button.setPreferredSize(new Dimension(40,40));
			    array[x][y]=button;
			    boardPanel.add(panel);
			}
						
			
			
		}
		panel1.add(boardPanel,BorderLayout.CENTER);

	}
	
	
	 /**
     * Resizes the solution view based on the provided dimension.
     *
     * @param dimension The dimension of the solution view.
     */
	public void resize(int dimension) {
		// TODO Auto-generated method stub
		
		
		dimension=2*dimension;
		
		compButton=new Square[dimension][dimension];
		
		dimension++;
		
		drawBoard(rightBoardPanel,rightPanel,compButton,dimension,true,model.getComputerSolution());
		System.out.println(dimension);
		
		
		
		
		
		frame.setSize(500+80*dimension,400+40*dimension);
		frame.setVisible(false);
		frame.setVisible(true);
		
		

		
		
	}
	
	/**
	 * Helper method to display colors on the solution board
	 * @param array array of the squares.
	 * @param b board to be display.
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
					array[x][y].setBackground(new Color(0x7400b8));
				}
			}
		}
	}
	 /**
     * Displays the solution view.
     */
	public void  setVisible()
	{
		frame.setVisible(true);
	}

}
