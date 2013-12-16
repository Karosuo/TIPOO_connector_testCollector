import java.io.*;
import java.net.*;
public class netTest2
{
    public static void main(String[] args) throws Exception
    {
        String cadena;
        Socket s=new Socket("internic.net",43);
        BufferedReader in=new BufferedReader(new
        InputStreamReader(s.getInputStream()));
        PrintStream out = new PrintStream(s.getOutputStream());
        String str=(args.length==0?"osborne.com":args[0])+"\n";
        out.print(str);
        while((cadena=in.readLine())!=null)
        System.out.println(cadena);
    }
}