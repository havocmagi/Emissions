import java.util.Scanner;
public class EmissionsLab5
{
	public static void main( String [] args )
	{
		// Declare ALL your variables here:
		int pollutantNumber;
		int actualMileage;
		int firstMileageLimit = 50000;
		int secondMileageLimit = 100000;
		double actualGrams;
		double firstGramLimit = .31;
		double secondGramLimit = 4.2;
		
		Scanner console = new Scanner(System.in);
		
		// display the 4 pollutant choices: CO, HC, NO, other
		System.out.println( "Four pollutant choices:1. CO, 2. HC, 3. NO, 4. Other" );
		
		// Prompt for the three inputs: pollutant #, grams, mileage
		System.out.print("Enter pollutant # (from 1 to 4): ");
		pollutantNumber = console.nextInt();
		System.out.print("Enter grams emitted/mile: \n");
		actualGrams = console.nextDouble();
		System.out.print("Enter odometer reading: \n");
		actualMileage = console.nextInt();

		// Create a switch
		switch (pollutantNumber)
		{
		case 1:
			firstGramLimit = 3.4;
			secondGramLimit = 4.2;
		break;
		case 2:
			firstGramLimit = .31;
			secondGramLimit = .39;
		break;
		case 3:
			firstGramLimit = .4;
			secondGramLimit = .5;
		break;
		case 4:
			firstGramLimit = .25;
			secondGramLimit = .31;
		break;
		default:
			System.out.println("Wrong #. Must enter value from 1-4.");
		break;
		}
		
		boolean result = mileageGramsLogic(actualMileage,firstMileageLimit,secondMileageLimit,actualGrams,firstGramLimit,secondGramLimit);
		
		if (result == false)
			System.out.println("Emissions exceed the permitted level");
		else
			System.out.println("Emissions are within the permitted level");
	}
	public static boolean mileageGramsLogic(int actualMil, int firstMilLim, int secondMilLim, double actualGrams, 
			double firstGramLim, double secondGramLim)
	{ // use a nested-if control structure and separate the logic for mileage and pollutant grams.
		
		if(actualMil >=0 && actualMil<= firstMilLim )
		{
			if(actualGrams >=0 && actualGrams <= firstGramLim)
				return true;
			else
				return false;
		}
		else if(actualMil > firstMilLim && actualMil <= secondMilLim)
		{
			if(actualGrams >= firstGramLim && actualGrams <= secondGramLim)
				return true;
			else
				return false;
		}
		else
			//No emission limit for over 100000 miles
			return true;
	}
}