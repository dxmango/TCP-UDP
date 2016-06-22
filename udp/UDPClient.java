

import java.io.*;
import java.net.*;

class UDPClient
{
   public static void main(String args[]) throws Exception
   { 
	   while(true)
	   {
	   byte[] receiveData = new byte[1024];
      BufferedReader inFromUser =
         new BufferedReader(new InputStreamReader(System.in));
      
      
      
            DatagramSocket clientSocket = new DatagramSocket();
      //construct a packet
      InetAddress IPAddress = InetAddress.getByName("localhost");
      byte[] sendData = new byte[1024];
      System.out.println("Please input  a string:");
      String sentence = inFromUser.readLine();
      sendData = sentence.getBytes();
      DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 1028);
      

      clientSocket.send(sendPacket);
      
      
      DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
      clientSocket.receive(receivePacket);
      String modifiedSentence = new String(receivePacket.getData());
      System.out.println("FROM SERVER:" + modifiedSentence);
      clientSocket.close();
	   }
   }
}