package battleship;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
/**
 * Represents a splash screen for the Battleship game.
 */
public class Splashscreen {
	 private JFrame splash=new JFrame();
	// private JLabel label=new JLabel("Battleship");
	 private ImageIcon icon = new ImageIcon("game_about.jpg");
	 private JButton button = new JButton(icon);
	
	   
	 /**
	     * Constructs a splash screen for the Battleship game.
	     * The splash screen contains a button with an image icon.
	     */
	public Splashscreen()
	{
		
		splash.add(button,BorderLayout.CENTER);
		splash.setSize(new Dimension(600,300));
		splash.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		splash.setVisible(true);
		
	}
	 /**
     * Sets the splash screen to be invisible.
     */
	public void setInvisible()
	{
		splash.setVisible(false);
	}
}
