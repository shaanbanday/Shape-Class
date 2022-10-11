/*
Java™ Project: ICS4U
Package: shapes
Class: Square
Programmer: Shaan Banday

Date Created: Monday, May 16th, 2022.
Date Completed: Tuesday, May 17th, 2022.

Description: This Square class inherits from Shape, meaning it has access to all the methods of the shape class, with the ability to override
them if necessary. Unlike the Shape, the Square has a constructor and is not abstract, meaning it CAN be created by another GUI or main method.
The constructor prints to the console, to prompt the user to input a singular side length, and uses a Scanner to take the inputs.
*/

package shapes; //Launch the class from this package named "shapes"

//Import graphical elements
import java.awt.Color; //Import the Colour class
import java.awt.Graphics; //Import the Graphics class
import java.util.InputMismatchException; //Import the an Exception class
import java.util.Scanner; //Import the Scanner Class

public class Square extends Shape //The class inherits from Shape
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6781391067444756671L;
	
	//Declare variable attribute of the class. It is private since only this class has access to them
	private double side; //Double to hold the singular side length of the square
	
	public Square() //Constructor for the Square, which is called to create a Square Object in the ShapeMain class
	{
		//Declare all objects
		Scanner takeSquareInput = new Scanner (System.in); //Initialise the scanner to take input through console
		
		//Set the side length by taking it from the user as input through the console
		this.side = takeSide(takeSquareInput); //Call takeSide and pass it the scanner to take it
	}
	
	public static double takeSide(Scanner takeInput) //Method to take the singular side, and check if it is valid or not
	{
		//Declare all variables
		boolean breakSquareLoop = false; //Boolean to break the loop
		double side = 0; //Double side to be returned and set as either the length or width. Initialise it to 0
		
		//Loops
		while(!breakSquareLoop) //While breakSquareLoop is false
		{
			//Print message to the console
			System.out.println("\nPlease enter the side length for the square, in pixels:"); //Prompt user for side
			
			//Try and Catch Statement
			try //Try to take the side
			{
				side = takeInput.nextDouble(); //Use the scanner to take the side from the user
				
				if (side < 0) //If the side is less than 0
				{
					//Print message to the console
					System.out.println("Error! The side length cannot be negative. Let's try again."); //Inform user of error
				}
				
				else if ((side + 60) > Shape.MAX) //If the side is too big to draw
				{
					//Print message to the console
					System.out.println("Error. The side length is too big to draw. Let's try again."); //Inform user of error
				}
				

				else //Otherwise, if the side is fine
				{
					breakSquareLoop = true; //Break the loop
				}
			}
			
			catch (InputMismatchException s) //Catch an InputMismatchException, if the user does not type a proper double
			{
				//Print Message
				System.out.println("Error! Make sure the side length is a valid number and that it contains no characters. "
						+ "Let's try again."); //Inform user of error
				
				takeInput.next(); //Flush all other inputs
			}
		}
		
		return side; //Return the side length
	}
	
	@Override
	public double getPerimeter() //Method overrided from original class, which gets the perimeter of a Square
	{
		//Find the sum of the 4 sides (4·s)
		return (this.side * 4); //Return as double
	}

	@Override
	public double getArea() //Method overrided from original class, which gets the area of a Square
	{
		//Square the side (s²)
		return Math.pow(this.side, 2); //Return as double
	}
	
	@Override
	public void draw() //Method overrided from original class, which creates the GUI for the Square
	{
		super.draw(); //Call the parent classes (super) draw method
	}
	
	@Override
	public void paint(Graphics g) //Method overrided from original class, which actually paints the Square on the screen
	{
		super.paint(g); //Call the parent classes (super) draw method
		g.setColor(Color.BLACK); //Set the painting colour to black
		
		//Draw Square
		g.fillRect(20, 40, (int) (Math.round(this.side)), (int) (Math.round(this.side))); //Set starting points and cast dimensions to integers
	}
}