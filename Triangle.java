/*
Java™ Project: ICS4U
Package: shapes
Class: Triangle
Programmer: Shaan Banday

Date Created: Monday, May 16th, 2022.
Date Completed: Tuesday, May 17th, 2022.

Description: This Triangle class inherits from Shape, meaning it has access to all the methods of the shape class, with the ability to override
them if necessary. Unlike the Shape, the Triangle has a constructor and is not abstract, meaning it CAN be created by another GUI or main method.
The constructor prints to the console, to prompt the user to input three side lengths, and uses a Scanner to take the inputs.
*/

package shapes; //Launch the class from this package named "shapes"

//Import graphical elements
import java.awt.Color; //Import the Colour class
import java.awt.Graphics; //Import the Graphics class
import java.awt.Point; //Import the Point class
import java.awt.Polygon; //Import the Polygon class
import java.util.InputMismatchException; //Import the an Exception class
import java.util.Scanner; //Import the Scanner Class

public class Triangle extends Shape //The class inherits from Shape
{
	/**
	 *
	 */
	private static final long serialVersionUID = 58755038718144050L;
	
	//Declare variable attributes of the class. They are private since only this class has access to them
	private double sideA, sideB, sideC; //Doubles to hold the three side lengths of the Triangle
	
	public Triangle() //Constructor for the Triangle, which is called to create a Triangle Object in the ShapeMain class
	{
		//Declare all variables
		boolean breakTriangleLoop = false; //Boolean to break the loop
		
		//Loops
		while (!breakTriangleLoop) //While breakTriangleLoop is false
		{
			//Declare all objects
			Scanner takeTriangleInput = new Scanner (System.in); //Initialise the scanner to take input through console
			
			//Set the three side lengths by taking it from the user as input through the console
			this.sideA = takeSide(takeTriangleInput, (byte) 1); //Call takeSide and pass it 1 for the first side
			this.sideB = takeSide(takeTriangleInput, (byte) 2); //Call takeSide and pass it 2 for the second side
			this.sideC = takeSide(takeTriangleInput, (byte) 3); //Call takeSide and pass it 3 for the third side
			
			breakTriangleLoop = this.checkIfTriangle(); //Check to see if the triangle is even possible or not. If not, ask user for new sides
		}
	}
	
	private static double takeSide(Scanner takeInput, byte sideNum) //Method to take a side, and check if it is valid
	{
		//Declare all variables
		boolean breakSidesLoop = false; //Boolean to break the loop
		double side = 0; //Double side to be returned and set as the length for one of sides. Initialise it to 0
		String sideAsString = ""; //String for the messages to the console
		
		//Decisions
		switch (sideNum) //Switch statement based on what side number is being referenced
		{
			case 1: //If the first side is being referenced
				sideAsString = "first"; //Set the string accordingly
				break;
				
			case 2: //Otherwise, the second side is being referenced
				sideAsString = "second"; //Set the string accordingly
				break;
				
			case 3: //Otherwise, the third side is being referenced
				sideAsString = "third"; //Set the string accordingly
				break;
		}
		
		//Loops
		while(!breakSidesLoop) //While breakSidesLoop is false
		{
			//Print message to the console
			System.out.println("\nPlease enter the " + sideAsString + " side length for the triangle, in pixels:"); //Prompt user for the side
			
			//Try and Catch Statement
			try //Try to take the side
			{
				side = takeInput.nextDouble(); //Use the scanner to take the side from the user
				
				if (side < 0) //If the side is less than 0
				{
					//Print message to the console
					System.out.println("Error! The " + sideAsString + " side cannot be negative. Let's try again."); //Inform user of error
				}
				
				else if ((side + 40) > Shape.MAX) //If the side is too big to draw
				{
					//Print message to the console
					System.out.println("Error. The " + sideAsString + " side of the triangle is too big to draw."); //Inform user of error
				}
				
				else //Otherwise, if the side is fine
				{
					breakSidesLoop = true; //Break the loop
				}
			}
			
			catch (InputMismatchException c) //Catch an InputMismatchException, if the user does not type a proper double
			{
				//Print Message
				System.out.println("Error! Make sure the side is a valid number and that it contains no characters."
						+ " Let's try again."); //Inform user of error
				
				takeInput.next(); //Flush all other inputs
			}
		}
		
		return side; //Return the side length
	}
	
	private boolean checkIfTriangle() //Method to check if the combination of he three side lengths is impossible to form a triangle
	{	
		//Declare all variables
		String impossibleMessage = "Error! The sum of the lengths of any two sides must be greater than the length of the third side. "
				+ "\nLet's try again from the start and enter three new side lengths."; //Error message if the triangle is impossible
		
		boolean isPossible; //Boolean to be returned
		
		if (this.sideA >= (this.sideB + this.sideC)) //If side a is bigger than side b and c combined
		{
			//Print Message
			System.out.println(impossibleMessage); //Display error to user
			isPossible = false; //Triangle is impossible, so set boolean to be returned accordingly
		}
		
		else if (this.sideB >= (this.sideA + this.sideC))
		{
			//Print Message
			System.out.println(impossibleMessage); //Display error to user
			isPossible = false; //Triangle is impossible, so set boolean to be returned accordingly
		}
		
		else if (this.sideC >= (this.sideA + this.sideB))
		{
			//Print Message
			System.out.println(impossibleMessage); //Display error to user
			isPossible = false; //Triangle is impossible, so set boolean to be returned accordingly
		}
			
		else
		{
			isPossible = true; //Triangle IS possible, so set boolean to be returned accordingly
		}
		
		return isPossible; //Return whether the triangle is possible or not
	}
	
	@Override
	public double getPerimeter() //Method overrided from original class, which gets the perimeter of a Triangle
	{
		//Just add all the sides for the perimeter 
		return this.sideA + this.sideB + this.sideC; //Return the sum of the three sides as a double
	}

	@Override
	public double getArea() //Method overrided from original class, which gets the area of a Triangle
	{
		//Declare all variables
		double semiPerimeter = (this.getPerimeter() / 2); //Find the semi-perimeter (half of the perimeter)
		
		//Use Heron's formula to calculate the area of a triangle given three side lengths
		return Math.sqrt(semiPerimeter * (semiPerimeter - this.sideA) * (semiPerimeter - this.sideB) * (semiPerimeter - this.sideC)); 
	}

	@Override
	public void draw() //Method overrided from original class, which creates the GUI for the Triangle
	{
		super.draw(); //Call the parent classes (super) draw method
	}

	@Override
	public void paint(Graphics g) //Method overrided from original class, which actually paints the Triangle on the screen
	{
		super.paint(g); //Call the parent classes (super) draw method
		g.setColor(Color.BLACK); //Set the painting colour to black
		
		//Find the angle for point c
		double angleC = Math.acos(((this.sideA*this.sideA) + (this.sideB*this.sideB) - (this.sideC*this.sideC)) / (2*this.sideA*this.sideB));
		
		//Declare points by rounding all doubles, and then casting to an int, since pixel amounts must be in whole numbers
		Point A = new Point(20, 480); //Set x and y-coordinates for point A on screen (every other point is established with reference to A)
		Point B = new Point(A.x + (int) Math.round(this.sideA), A.y); //Point B is at the same y value, but sideA pixels left
		Point C = new Point(A.x + (int) (Math.round((this.sideB * Math.cos(angleC)))), A.y - (int) (Math.round((this.sideB * Math.sin(angleC))))); 
		//Point C is horizontal component of sideC in pixels to the left of point A and the vertical component of sideC in pixels up from point A
		
		//Put points into int arrays
		int [] xPoints = {A.x, B.x, C.x}; //X-coordinates of the points
		int [] yPoints = {A.y, B.y, C.y}; //Y-coordinates of the points
		
		//Draw Triangle
		g.fillPolygon(new Polygon(xPoints, yPoints, 3)); //Paint a 3-sided shape (Triangle) with these points
	}
}