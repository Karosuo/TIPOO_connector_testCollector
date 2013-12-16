package TIPOOconnector;

import java.net.*; //Encoder
import java.io.*; //UnsupportedEncodingException


public class NetUtils
{
	public static String urlEncode(String nuevaURL)
	{
		try
		{
			String encoded_url = URLEncoder.encode(nuevaURL, "UTF-8");
			return encoded_url;
		}
		catch(UnsupportedEncodingException unsupported_enc_exep)
		{
			ErrorLog.addLog(" UnsupportedEncodingException catched.-\nSpecified info:\n");
			unsupported_enc_exep.printStackTrace();
		}

		return null;
	}
}