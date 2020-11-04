package start;

public class Decimal2BinaryConversion {
	public static void main(String[] args)
	{
		int[] testData = {7, 10, 15, 12345};
		int number2Convert;
		for(int k = 0; k<testData.length; k++)
		{
			String result = "";
			number2Convert = testData[k];
			while(number2Convert > 0)
			{
				int reminder = number2Convert % 2;
				result += reminder;
				number2Convert = number2Convert / 2;
			}
			System.out.println(testData[k] + " ==> " + result);
		}
	}
}