/*
Java™ Project: ICS4U
Package: shapes
Class: Rectangle
Programmer: Shaan Banday

Date Created: Monday, May 16th, 2022.
Date Completed: Tuesday, May 17th, 2022.

Description: This Rectangle class inherits from Shape, meaning it has access to all the methods of the shape class, with the ability to override
them if necessary. Unlike the Shape, the Rectangle has a constructor and is not abstract, meaning it CAN be created by another GUI or main method.
The constructor prints to the console, to prompt the user to input a length and a height, and uses a Scanner to take the inputs.
*/

package shapes; //Launch the class from this package named "shapes"

//Import graphical elements
import java.awt.Color; //Import the Colour class
import java.awt.Graphics; //Import the Graphics class
import java.util.InputMismatchException; //Import the an Exception class
import java.util.Scanner; //Import the Scanner Class

public class Rectangle extends Shape //The class inherits from Shape
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2934292614650763622L;
	
	//Declare variable attributes of the class. They are private since only this class has access to them
	private double length, height; //Double to hold the length and the height of the Rectangle
	
	public Rectangle() //Constructor for the Rectangle, which is called to create a Rectangle Object in the ShapeMain class
	{
		//Declare all objects
		Scanner takeRecInput = new Scanner (System.in); //Initialise the scanner to take input through console
		
		//Set the length and the height by taking it from the user as input through the console
		this.length = takeSide(takeRecInput, true); //Call takeSide and pass it true for the length
		this.height = takeSide(takeRecInput, false); //Call takeSide and pass it false for the height
	}
	
	private static double takeSide(Scanner takeInput, boolean isLength) //Method to take a side, and check if it is valid
	{
		//Declare all variables
		boolean breakRecLoop = false; //Boolean to break the loop
		double side = 0; //Double side to be returned and set as either the length or width. Initialise it to 0
		String sideAsString = ""; //String for the messages to the console
		
		//Decisions
		if (isLength) //If the length is being referenced
		{
			sideAsString = "length (horizontal side)"; //Set the string accordingly
		}
		
		else //If the height is being referenced
		{
			sideAsString = "height (vertical side)"; //Set the string accordingly
		}
		
		//Loops
		while(!breakRecLoop) //While breakRecLoop is false
		{
			//Print message to the console
			System.out.println("\nPlease enter the " + sideAsString + " for the rectangle, in pixels:"); //Prompt user for the side
			
			//Try and Catch Statement
			try //Try to take the side
			{
				side = takeInput.nextDouble(); //Use the scanner to take the side from the user
				
				if (side < 0) //If the side is less than 0
				{
					//Print message to the console
					System.out.println("Error! The " + sideAsString + " side cannot be negative. Let's try again."); //Inform user of error
				}
				
				else if ((side + 60) > Shape.MAX) //If the side is too big to draw
				{
					//Print message to the console
					System.out.println("Error. The " + sideAsString + " side of the triangle is too big to draw."); //Inform user of error
				}
				
				else //Otherwise, if the side is fine
				{
					breakRecLoop = true; //Break the loop
				}
			}
			
			catch (InputMismatchException r) //Catch an InputMismatchException, if the user does not type a proper double
			{
				//Print Message
				System.out.println("Error! Make sure the " + sideAsString + " is a valid number and that it contains no characters. "
						+ "Let's try again."); //Inform user of error
				
				takeInput.next(); //Flush all other inputs
			}
		}
		
		return side; //Return the side length
	}
	
	@Override
	public double getPerimeter() //Method overrided from original class, which gets the perimeter of a Rectangle
	{
		//Find the sum of double the length and double the height (2·l + 2·h)
		return (2 * this.length) + (2 * this.height); //Return as double
	}

	@Override
	public double getArea() //Method overrided from original class, which gets the area of a Rectangle
	{
		//Find do the product of the length and height (l·h)
		return (this.length * this.height); //Return as double
	}
	
	@Override
	public void draw() //Method overrided from original class, which creates the GUI for the Rectangle
	{
		super.draw(); //Call the parent classes (super) draw method
	}

	@Override
	public void paint(Graphics g) //Method overrided from original class, which actually paints the Rectangle on the screen
	{
		super.paint(g); //Call the parent classes (super) draw method
		g.setColor(Color.BLACK); //Set the painting colour to black
		
		//Draw Rectangle
		g.fillRect(20, 40, (int) (Math.round(this.length)), (int) (Math.round(this.height))); //Set starting points and cast dimensions to integers
	}
}