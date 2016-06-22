
import java.io.*;
import java.net.*;


public class SOK_1_SERVER {
	
	public static void main(String[] args) throws Exception
	{
		SOK_1_SERVER SERVER;
		SERVER= new SOK_1_SERVER();
		SERVER.run();
	}

	public void run() throws Exception{
		ServerSocket SRVSOCK =new ServerSocket(1244);
		Socket SOCK=SRVSOCK.accept();
		InputStreamReader IR=new InputStreamReader(SOCK.getInputStream());
		BufferedReader BR=new BufferedReader(IR);
		
		String MESSAGEFROMCLIENT=BR.readLine();
		
		String result=MESSAGEFROMCLIENT.toUpperCase();
		System.out.println(result+"I will deliver this modified message to the client!");
		
		if(MESSAGEFROMCLIENT !=null)
		{
			PrintStream PS=new PrintStream(SOCK.getOutputStream());
			PS.println(result);
			
		}
		
	}
}
