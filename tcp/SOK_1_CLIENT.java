
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class SOK_1_CLIENT {

	public static void main(String[] args) throws Exception
	{
		SOK_1_CLIENT CLIENT=new SOK_1_CLIENT();
		CLIENT.run();
	}
	
	public void run() throws Exception
	{
		Socket SOCK =new Socket("localhost",1244);
		PrintStream PS=new PrintStream(SOCK.getOutputStream());
		Scanner scanner = new Scanner( System.in );
		System.out.println("Please input a string:");
		String keyboardinput=scanner.nextLine();
		PS.println(keyboardinput);
		
		InputStreamReader IR=new InputStreamReader(SOCK.getInputStream());
		BufferedReader BR=new BufferedReader(IR);
		
		String MESSAGE=BR.readLine();
		System.out.println(MESSAGE);
		
		
	}
}
