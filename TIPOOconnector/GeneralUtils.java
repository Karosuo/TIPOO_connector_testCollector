package TIPOOconnector;


public class GeneralUtils
{
	public static int stringToInt(String str_number)
	{
		int int_number;
		try
		{
			int_number = Integer.parseInt(str_number);
			return int_number;
		}
		catch(NumberFormatException number_format_exep)
		{
			ErrorLog.addLog(" NumberFormatException catched .-\nNo number in the string\nDetailed info: ");
			number_format_exep.printStackTrace();
		}

		return -1;
	}
}