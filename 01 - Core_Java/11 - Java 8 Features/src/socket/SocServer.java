package socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocServer {

	public static void main(String[] args) throws Exception {
		//Exception will be thrown if the port is already in use.
		//In server side we require two sockets.
		//1. One bigger socket which will accept all the requests.
		//2. Second socket will be for one client.
		//For one client we will need one socket and for multiple clients we will need multiple sockets. 
		
		System.out.println("S : Server has started");
		ServerSocket ss = new ServerSocket(9999); //port number
		System.out.println("S : Server is waiting for client request");
		
		//For every request of the client, we will require we will need a new socket.
		//Create the Socket Object whenever a client sends the request
		//Connectiong established for TCP and now we can receive and send data
		Socket s = ss.accept(); //If the server socket accepts any request, it will create a new socket
		System.out.println("S : Client Connected");
		//Fetch the data from the socket.
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		String str = br.readLine(); 
		//readLine() constantly reads until it has received \n or \r or 
		//if the given InputStream returns less than zero in read
		
		System.out.println("S : Client Data : " + str);
		
		//Server sending back a response for a two way connection
		String str1 = str.substring(0, 3);
		
		OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream());
		PrintWriter out = new PrintWriter(os);
		out.println(str1); //This will a \n at the end so the br.readLine() at the Client will stop reading the stream
		out.flush(); //forcefully send the data
		System.out.println("S : Data sent from Server to Client");
	}

}
