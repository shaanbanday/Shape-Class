package shapes;
import java.util.Scanner;

public class ShapeMain {

	final static int PERIMETER = 1;
	final static int AREA = 2;
	final static int DRAW = 3;
	final static int QUIT = 4;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		Shape theShape;  //the shape we will make
		
		char shape = getShapeFromUser(input);  //call method to grab shape from user

		//make the appropriate shape
		switch(shape) {
		case 'c':
			theShape = new Circle();
			break;
		case 't':
			theShape = new Triangle();
			break;
		case 'r':
			theShape = new Rectangle();
			break;
		case 's':
			theShape = new Square();
			break;
		default:
			theShape = null;  //annoying user mistake, just quit
			System.exit(-1);
			
		}

		int selection = selectOption(input);  //get the selection of what to do with shape

		//perform correct operation based on user choice
		while(selection != QUIT)
		{
			if(selection == 1)
			{
				System.out.println("The Perimeter is: " + theShape.getPerimeter());
			}else if (selection == 2)
			{
				System.out.println("The Area is:  " + theShape.getArea());
			}else if (selection == 3)
			{
				theShape.draw();
			}

			Thread.sleep(1600);
			selection = selectOption(input);
		}
		System.out.println("BYE");
	}

	//This method takes a Scanner as input. Uses the scanner to determine what shape 
	//the user would like to make. Returns a character that represents the shape 
	private static char getShapeFromUser(Scanner in)
	{

		System.out.println("Welcome to the SHAPE Program!!\n"
				+"What type of shape would you like to make?");

		System.out.println();
		System.out.println("Hit: ");
		System.out.println("[c] for circle");
		System.out.println("[t] for triangle");
		System.out.println("[r] for rectangle");
		System.out.println("[s] for square");

		return (in.nextLine().charAt(0));

	}

	//This method displays a menu to get a user choice for what to do with the shape
	//returns the integer choice. See contants above
	private static int selectOption(Scanner in)
	{
		System.out.println("What would you like to do?");
		System.out.println("Select [1] for calculate perimeter");
		System.out.println("Select [2] to calculate area");
		System.out.println("Select [3] to draw the shape");
		System.out.println("Select [4] to QUIT");

		return (in.nextInt());

	}
}
