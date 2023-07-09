package battleship;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * The ColorMenu class represents a color selection menu in the Battleship game.
 * It allows the user to choose colors for unselected squares, water squares, and ship squares.
 * The ColorMenu class creates a separate JFrame to display the color selection menu.
 * It uses JColorChooser to provide a color selection interface for the user.
 * The selected colors are updated in the View class and used for rendering the game board.
 * The ColorMenu class includes methods for updating and displaying the color selection menu.
 * 
 * @param window The view window associated with the color menu.
 */
public class ColorMenu {
	 private JFrame splash=new JFrame();
	// private JLabel label=new JLabel("Battleship");
	// private ImageIcon icon = new ImageIcon("game_about.jpg");
	
	 private View window;
	 private JButton unselectedButton=new JButton("Unselected");
	 private JButton waterButton=new JButton("Water");
	 private JButton shipButton=new JButton("Ship");
	 
	 private JLabel unselectedLabel=new JLabel();
	 private JLabel waterLabel=new JLabel();
	 private JLabel shipLabel=new JLabel();
	 
	 private JPanel colorPanel=new JPanel();
	 private Color unselectedColor;
	 private Color shipColor;
	 private Color waterColor;
	 
	 
	
	   
	 /**
	     * Constructs a ColorMenu object with the specified view window.
	     * Initializes the color selection panel and sets the initial colors.
	     *
	     * @param window The view window associated with the color menu.
	     */
	public ColorMenu(View window)
	{
		this.window=window;
		colorPanel.setLayout(new GridLayout(2,3));
		unselectedColor=window.getUnselectedColor();
		waterColor=window.getWaterColor();
		shipColor=window.getShipColor();
		
		updateColors();
		
		colorPanel.add(unselectedLabel);
		colorPanel.add(waterLabel);
		colorPanel.add(shipLabel);
		colorPanel.add(unselectedButton);
		colorPanel.add(waterButton);
		colorPanel.add(shipButton);
		
		unselectedButton.addActionListener(e->{
			System.out.println("Unselected");
			Color color=JColorChooser.showDialog(null,"Select a color",unselectedColor);    
            if(color!=null)
            {
            	unselectedColor=color;
            	updateColors();
            }
            
			});
		shipButton.addActionListener(e->{
			System.out.println("Ship");
			Color color=JColorChooser.showDialog(null,"Select a color",shipColor);    
            if(color!=null)
            {
            	shipColor=color;
            	updateColors();
            }
			});
		
		waterButton.addActionListener(e->{
			System.out.println("Water");
			Color color=JColorChooser.showDialog(null,"Select a color",waterColor);    
            if(color!=null)
            {
            	waterColor=color;
            	updateColors();
            }
			;});
		splash.add(colorPanel,BorderLayout.CENTER);
		splash.setSize(new Dimension(600,300));
		
		splash.setVisible(false);
		
		
	}
	 /**
     * Updates the colors of the color buttons and sets the selected colors in the view window.
     */
	private void updateColors()
	{
		unselectedButton.setBackground(unselectedColor);
		waterButton.setBackground(waterColor);
		shipButton.setBackground(shipColor);
		window.setUnselectedColor(unselectedColor);
		window.setWaterColor(waterColor);
		window.setShipColor(shipColor);
		
	}
	 /**
     * Displays the color selection menu.
     */
	public void setVisible()
	{
		splash.setVisible(true);
	}
}

