package _01_Intro_To_Sockets.client;

import java.net.*;
import java.io.*;
import java.io.ObjectInputStream.GetField;

public class ClientGreeter {

   public static void main(String [] args) {
	  //1. Create a String for the ip address of the server. 
	   String ipAddress = "192.168.7.123";
	  // If you don't know how to find a computer's ip address, ask about ifconfig on linux/mac and ipconfig on windows.
      
      //2. Create an integer for the server's port number
      int portNum=8080;
      //3. Surround steps 4-9 in a try-catch block that catches any IOExceptions.
    try {
		Socket s=new Socket(ipAddress,portNum);
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());
		dos.writeUTF("hello");
		DataInputStream dis = new DataInputStream(s.getInputStream());
		System.out.println(dis.readUTF());
		s.close();
	} catch (IOException e) {
		// TODO: handle exception
	}
    	 //4. Create an object of the Socket class. When initializing the object, pass in the ip address and the port number
 
         //5. Create a DataOutputStream object. When initializing it, use the Socket object you created in step 4 to call the getOutputStream() method.
         
         //6. Use the DataOutputStream object to send a message to the server using the writeUTF(String message) method
         
         //7. Create a DataInputStream object. When initializing it, use the Socket object you created in step 4 to call the getInputStream() method.
         
         //8. Use the DataInputStream object to print a message from the server using the readUTF() method.
         
         //9. Close the client's server object

   }
}
