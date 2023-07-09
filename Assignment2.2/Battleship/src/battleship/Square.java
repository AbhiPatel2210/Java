package battleship;
import java.awt.Color;

import javax.swing.JButton;
/**
 * Represents a square button in the Battleship game.
 */
class Square extends JButton
	{
		
		private static final long serialVersionUID = 1L;
		private int x;
		private int y;
		private boolean comp;
		/**
	     * Constructs a square button with the specified coordinates (x, y).
	     *
	     * @param x The x-coordinate of the square.
	     * @param y The y-coordinate of the square.
	     */
		public Square(int x,int y)
		{
			this.x=x;
			this.y=y;
			this.setBackground(new Color(0x7400b8));
			
			
		}
		/**
	     * Constructs a square button with the specified coordinates (x, y) and attaches the specified controller to handle events.
	     *
	     * @param x          The x-coordinate of the square.
	     * @param y          The y-coordinate of the square.
	     * @param controller The controller to handle events.
	     */
		public Square(int x,int y,Controller controller)
		{
			
			this(x,y);
			this.addActionListener(controller);
			
			
		}
		/**
	     * Constructs a square button with the specified coordinates (x, y), attaches the specified controller to handle events, and indicates if it belongs to the computer.
	     *
	     * @param x          The x-coordinate of the square.
	     * @param y          The y-coordinate of the square.
	     * @param controller The controller to handle events.
	     * @param comp       Indicates if the square belongs to the computer.
	     */
		
		public Square(int x,int y,Controller controller,boolean comp)
		{
			
			this(x,y,controller);
			this.comp=comp;
			
			
			
		}
		@Override
		/**
	     * Returns a string representation of the square in the format "Player x,y" or "Computer x,y".
	     *
	     * @return The string representation of the square.
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
			return text+" "+(x)+","+(y);
			
		}
	}