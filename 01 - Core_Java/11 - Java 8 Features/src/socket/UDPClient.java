package socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.net.InetAddress;

public class UDPClient {
	public static void main(String[] args) throws Exception {
		//For UDP as connection is not there so every packet should know the ip and port where it is going
		//The socket does not know the IP and port. It is the packet that knows about it
		//For UDP we use DatagramSocket
		DatagramSocket ds = new DatagramSocket();
		
		int i = 8;
		byte[] b = String.valueOf(i).getBytes();
		byte[] b1 = new byte[1024];
		InetAddress ia = InetAddress.getLocalHost();
		
		//Send the data to the Server in UDP
		DatagramPacket dp = new DatagramPacket(b, b.length, ia, 9999);
		//Data to send (in byte array format), Data length, IP Address, Port number
		ds.send(dp);
		
		//Accept the data from server in UDP
		DatagramPacket dp1 = new DatagramPacket(b1, b1.length); //While receiving we do not need to give ip and port
		ds.receive(dp1);
		
		String str = new String(dp1.getData(), 0, dp1.getLength());
		System.out.println("result is " + str);
	}
}

/*
In TCP we first create the connection and then send the data.
In UDP we don't have a connection. So, every packet should know where it is going.
*/