/*
Java™ Project: ICS4U
Package: shapes
Class: Circle
Programmer: Shaan Banday

Date Created: Monday, May 16th, 2022.
Date Completed: Tuesday, May 17th, 2022.

Description: This Circle class inherits from Shape, meaning it has access to all the methods of the shape class, with the ability to override them 
if necessary. Unlike the Shape, the Circle has a constructor and is not abstract, meaning it CAN be created by another GUI or main method. The
constructor prints to the console, to prompt the user to input a radius, and uses a Scanner to take the input.
*/

package shapes; //Launch the class from this package named "shapes"

//Import graphical elements
import java.awt.Color; //Import the Colour class
import java.awt.Graphics; //Import the Graphics class
import java.util.InputMismatchException; //Import the an Exception class
import java.util.Scanner; //Import the Scanner Class

public class Circle extends Shape //The class inherits from Shape
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -115168443603076203L;
	
	//Declare variable attribute of the class. It is private since only this class has access to them
	private double radius; //Double to hold the radius of the circle
	
	public Circle() //Constructor for the Circle, which is called to create a Circle Object in the ShapeMain class
	{
		//Declare all variables
		boolean breakCircleLoop = false; //Boolean to break the loop
		
		//Loops
		while(!breakCircleLoop) //While breakCircleLoop is false
		{
			//Declare all objects
			Scanner takeCircleInput = new Scanner (System.in); //Initialise the scanner to take input through console
			
			//Print message to console
			System.out.println("\nPlease enter a radius for the circle, in pixels:"); //Prompt user for the radius in pixels
			
			breakCircleLoop = this.checkIfValid(takeCircleInput, breakCircleLoop); //Call extension method to take the radius
		}
	}
	
	private boolean checkIfValid(Scanner takeInput, boolean isValid) //Method which takes the radius from the user and checks if it is valid
	{	
		//Try and Catch statement
		try //Try to take the radius
		{
			this.radius = takeInput.nextDouble(); //Use the scanner to take the radius from the user
			
			isValid = !(this.checkIfNegative(isValid)); //Check to see if the radius input is negative, which would make it invalid
		}
		
		catch (InputMismatchException c) //Catch an InputMismatchException, if the user does not type a proper double
		{
			//Print Message
			System.out.println("Error! Make sure the radius is a valid number and that it contains no characters."
					+ " Let's try again."); //Inform user of error
			
			takeInput.next(); //Flush all other inputs
		}
		
		return isValid; //Return whether or not the the loop should break
	}
	
	private boolean checkIfNegative(boolean isNegative) //Method to check if the radius is negative, or too big to draw
	{
		//Decisions
		if (this.radius < 0) //If the radius is less than 0
		{
			System.out.println("Error! The radius cannot be negative. Let's try again."); //Print error message to user
			isNegative = true;
		}
		
		else if (((this.radius * 2) + 56) > Shape.MAX) //If the radius is too big to draw
		{
			System.out.println("Error. The radius is too big to draw. Let's try again."); //Print error message to user
			isNegative = true;
		}
		
		else //Otherwise, if the radius is fine
		{
			isNegative = false; //Set isNegative to false, because it is not negative
		}
		
		return isNegative; //Return back to original method
	}
	
	@Override
	public double getPerimeter() //Method overrided from original class, which gets the perimeter of a circle
	{
		//Use 2·π·r formula for perimeter
		return (2 * this.radius * Math.PI); //Return as double
	}

	@Override
	public double getArea() //Method overrided from original class, which gets the perimeter of a circle
	{
		//Use π·r² formula for area
		return (((Math.pow(this.radius, 2))) * Math.PI); //Return as double
	}
	
	@Override
	public void draw() //Method overrided from original class, which creates the GUI for the Circle
	{
		super.draw(); //Call the parent classes (super) draw method
	}

	@Override
	public void paint(Graphics g) //Method overrided from original class, which actually paints the circle on the screen
	{
		super.paint(g); //Call the parent classes (super) draw method
		g.setColor(Color.BLACK); //Set the painting colour to black
		
		int diameter = (int) Math.round(this.radius * 2); //Set the diameter for the circle (2·r)
		
		//Draw Circle
		g.fillOval(28, 40, diameter, diameter); //Draw an oval of the same dimensions, making it a circle
	}
}