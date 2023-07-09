package battleship;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JMenuItem;



/**
 * The Controller class is responsible for handling user actions and updating the model and view accordingly.
 * It implements the ActionListener interface to listen for user events such as button clicks and combobox selections.
 * @author abhip
*/
public class Controller implements ActionListener
	{
	 /**
	 * Executes the everySecond method repeatedly at a one-second interval.
	 * This method is invoked by a separate timer thread.
	 */
	 
	private void everySecond() {
		// System.out.println("test");
		 window.second();
	 }
	
	/**
	 * @author abhip
	 * The Timer class implements the Runnable interface to create a timer that runs in a separate thread.
	 * It allows starting and stopping the timer and repeatedly executes the everySecond method.
	 */
	public class Timer implements Runnable
	{
		boolean start=true;
		/**
		 * Stops the timer by setting the start flag to false.
		 */
		public void stopTimer()
		{
			start=false;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
			while(start)
			{
				everySecond();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	    Model model;
		View window;
		Timer timer;
		Thread timerThread;
		
		/**
		 * @param window
		 * Constructs a Controller object with the specified view window.
	     * Initializes the timer and starts the timer thread.
	     * @param window The view window associated with the controller.
		 */
		Controller(View window)
		{
			this.window=window;
			timer=new Timer();
			timerThread=new Thread(timer);
			timerThread.start();
			
		}
/**
 *Sets the model associated with the controller.
 * @param model The model to be set.
 */
public void setModel(Model model)
{
	this.model=model;
}
          
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println(e.getSource().getClass());
			if(e.getSource() instanceof Square)
			{
				// Handle Square button action events
				System.out.println("Design:  "+model.getDesign());
				if(model.getPlaying()||model.getDesign())
				{
					
				
				Square button=(Square)e.getSource();
			    System.out.println(button);
			    window.write("User Pressed "+button.toString());
			    String[] string=button.toString().split(" ");
			    System.out.println("*"+string[0]+"*");
			    String [] string2=string[1].split(",");
		    	int x=Integer.parseInt(string2[0]);
		    	int y=Integer.parseInt(string2[1]);
			    if(model.getPlaying()&&string[0].equals("computer"))
			    {
			    	
			    	window.write("computer");
			    	
			    	int select=model.selectComputer(x,y);
			    	if(select!=0)
			    	{
			    		model.computerMakesMove();
			    	}
			    	
			    }
			    else if(model.getDesign()&&string[0].equals("User")) {
			    	window.write("User");
			    	
			    	int select=window.placeShip(x,y);
			    	if(select!=0)
			    	{
			    		//model.computerMakesMove();
			    	}
			    }
			   
				}   
			}
			else if(e.getSource() instanceof JButton)
			{
			   JButton button=(JButton)e.getSource();
			   System.out.println(button.getActionCommand());
			   String text=button.getActionCommand();
			   if(button.getActionCommand()=="About")
			   {
				   System.out.println("About");
				   window.showAbout();
				  
				   
			   }
			   else if(text.equals("Design"))
					   {
				           window.reset();
		                   model.setDesign(true);
		                   window.write("User is Placing ships");
				           window.design();
					   }
			   else if(text.equals("Rand"))
			   {
				   window.write("ships are being Place by computers randomly.");
				   window.randomPlayerBoard();
			   }
			   else if(text.equals("Reset"))
			   {
				   window.write("Resetting the game.");
				   window.reset();
			   }
			   else if(text.equals("Play"))
			   {
				   
				   if(model.getReadyToPlay())
				   {
					   window.write("Starting the game.");
					   model.startGame();
					   
				   }
				   
				   
			   }
			   
			   
			}
			else if(e.getSource() instanceof JMenuItem) {
				JMenuItem button=(JMenuItem)e.getSource();
				   System.out.println(button.getActionCommand());
				   String text=button.getActionCommand();
				   if(text=="New")
				   {
					   window.write("Starting the game.");
					   window.reset();
					   window.randomPlayerBoard();
					   model.startGame();
				   }
				   else if (text=="Solution")
				   {
					   window.showSolution();
				   }
				   else if(text=="Exit")
				   {
					   System.exit(0);
				   }
				   
				   else if (text=="About")
				   {
					   window.showAbout();
				   }
				   else if(text=="Colors")
				   {
					   window.showColorMenu();
				   }
				   else if(text=="Load")
				   {
					   File file=window.displayLoadChooser();
					   Scanner scanner;
					   try {
							scanner = new Scanner(file);
							model.loadBoard(scanner);
							scanner.close();
							window.drawPlayerBoard();
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							//e1.printStackTrace();
						}
				   }
				   else if(text=="Save")
				   {
					   //File file=new File("test.board");
					   File file=window.displayChooser();
					   PrintWriter printWriter;
					try {
						printWriter = new PrintWriter(file);
						model.savePlayerBoard(printWriter);
						printWriter.close();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					   
				   }
				  
			}
			else if(e.getSource()instanceof JComboBox<?>) {
				// Handle JComboBox action events
				JComboBox <Integer>button=(JComboBox <Integer>)e.getSource();
				String name=button.getActionCommand();
				if(name=="Dimensions")
				{
					window.resize((Integer)button.getSelectedItem());
				}
				else if(name=="Languages")
				{
					window.write("Language: "+(String)button.getSelectedItem());
					window.updateLables();
				}
				
			}
			
		}
		
	}