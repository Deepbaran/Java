package socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class SocClient {

	public static void main(String[] args) throws Exception {
		//Throwing the Exception to the topmost hierarchy which is JVM
		//If the port number is already in use.
		String ip = "localhost"; //Server ip address | localhost -> Same machine
		int port = 9999; //0 to 65535 -> 0-1023 reserved | 
		//Tomcat -> 8080
		//mySQL -> 3306
		//React - 3000
		//Setting up connection for TCP before sending the data.
		Socket s = new Socket(ip, port); //IP Adress, Port number 
		
		String str = "Deep";
		//Converting the String to a stream format
		OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream()); //Outport of the socket
		PrintWriter out = new PrintWriter(os);
		//Now whenever we print something with out, it will send the data to os
		//Then os will convert the data into a output stream and send that data to the socket output stream.

		//os.write(str); //str will be sent to the server and server will process it.
		//Whenever we send the data, the network has a buffer size of approax 512 bytes.
		os.flush(); //Forcefully send the data
		//OR
		out.println(str);
		out.flush();
		
		//Up till this point we were doing a one way connection where the client a request and data to the server
		//From now we will be doing a two way connection where the server will also send a respond
		
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		String str1 = br.readLine();
		
		System.out.println("C : Data from Server " + str1);
		
		s.close(); //Closing the socket
		//If socket is not closed in client then a ScoketException will get thrown as the connection will get reset
		//When we are using out.println() instead of os.write(), a \n character is getting at the end
		//which will stop the BufferedReader in the Server from reading the inputstream.
		//This will prevent from a SocketException from happening.
		//But putting a s.close() is a good practice.
	}

}

/*
Writing in the stream of the Server-Client / Send something:
	OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream());
	PrintWriter out = new PrintWriter(os);
	out.println(str1);
	out.flush();

Reading from the stream of the Server-Client / Receiving something:
	BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
	String str = br.readLine();
 */

/*
Servers have unique IP address to differentiate them.
There can be multiple applications / processes in a server. To differentiate them we use port numbers.
So, IP address with port number define a unique application in a particular server.

Every Client will have a socket to communicate with the server.
A Server will have multiple sockets to communicate with multiple clients (For each client it will need one socket).
*/