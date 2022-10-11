/*
Java™ Project: ICS4U
Package: shapes
Class: Shape
Programmer: Shaan Banday

Date Created: Monday, May 16th, 2022.
Date Completed: Tuesday, May 17th, 2022.

Description: This abstract Shape class inherits from JFrame, meaning it displays a graphical window and has a paint method it can use. The shape only
has 2 static attributes: a JPanel for the JFrame, and a constant dimension for said JPanel, set to 500 pixels. Regardless, this Shape class acts as 
a template for the Circle, Triangle, Rectangle, and Square classes that inherit from it. It is abstract, and not an interface  because while some 
methods are abstract and undefined, others like draw() and paint() have a body and are the same regardless of the type of Shape as the child class. 
The other methods though, are all abstract, meaning only the name, parameters, and return type is defined, whereas any class that inherits from Shape
MUST define those classes.
*/

package shapes; //Launch the class from this package named "shapes"

//Import graphical elements
import java.awt.Color; //Import the Colour Class
import java.awt.Graphics; //Import the Graphics Class
import javax.swing.BorderFactory; //Import the BorderFacotry Class
import javax.swing.JFrame; //Import the JFrame Class
import javax.swing.JPanel; //Import the JPanel Class

public abstract class Shape extends JFrame //The class inherits from JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8309416857390531740L;
	
	//Declare variable attributes of the class. They are private since only this class has access to them
	private static JPanel shapePanel; //JPanel to hold everything
	
	//Declare constant attribute of the class
	protected static final short MAX = 500; //Short for the dimensions of the JFrame
	//It is protected so the child classes can have access to them
	
	protected abstract double getPerimeter(); //Abstract method that sub-classes can see, for the method to get the perimeter of a shape
	
	protected abstract double getArea(); //Abstract method that sub-classes can see, for the method to get the area of a shape
	
	protected void draw() //Method to Create a JFrame and draw a shape
	{
		//GUI Initialisations
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Terminate the program, and close the window if the close button is hit
        this.setSize(MAX, MAX); //Set the size of the window (JFrame) in pixels to the constants initialised outside the constructor
        this.setResizable(false); //Window is unable to be resized.
        this.setVisible(true); //Everything in the JFrame is visible, unless otherwise specified  
		this.setFocusable(true); //Make it the focal point if it is used
		
		//Initialise JPanel
		shapePanel = (JPanel)this.getContentPane(); //Create a JPanel to organise contents in the JFrame/Window  
		shapePanel.setLayout(null); //Assign no layout (null) to the JPanel
        
		shapePanel.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.BLACK)); //Set a cyan border for the JPanel
		shapePanel.setBackground(Color.CYAN); //Set the colour of the background
		
		this.repaint(); //Call the paint method and update the screen
	}
	
	@Override
	public void paint (Graphics g) //Method to paint the individual shapes. The specific shapes have their own code for this method
	{
		super.paint(g); //Call the parent classes (super) draw method
	}
}